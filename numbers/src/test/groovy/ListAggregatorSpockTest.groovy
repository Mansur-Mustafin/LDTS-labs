import com.aor.numbers.GenericListDeduplicator
import com.aor.numbers.ListAggregator
import com.aor.numbers.ListDeduplicator
import com.aor.numbers.ListSorter
import spock.lang.Specification

class ListAggregatorSpockTest extends Specification{

    private def list

    def setup() {
        list = Arrays.asList(1,2,4,2,5)
    }

    def 'Testing: sum'() {
        given:
        def aggregator = new ListAggregator()

        when:
        def sum = aggregator.sum(list);

        then:
        14 == sum
    }

    def 'Testing: max'(){
        given :
        def aggregator = new ListAggregator()
        when:
        def sum = aggregator.max(list);
        then:
        sum == 5
    }
    def 'Testing: min'(){
        given:
        def aggregator = new ListAggregator()
        when:
        def min = aggregator.min(list);
        then:
        min == 1
    }

    def 'Testing: distinct'(){
        given:
        def aggregator = new ListAggregator()
        def deduplicator = new ListDeduplicator(new ListSorter())
        when:
        def distinct = aggregator.distinct(list, deduplicator);

        then:
        4 == distinct
    }

    def 'testing distinct bug 8726'(){
        given:
            def deduplicator = Mock(GenericListDeduplicator)
            deduplicator.deduplicate(_) >>> [Arrays.asList(1, 2, 4), Arrays.asList(6, 7)]
        when:
            def result = deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2))
        then:
            result == Arrays.asList(1,2,4)
    }

    def 'testing distinct bug 8726 new'() {
        given:
        def deduplicator = Mock(GenericListDeduplicator)
        def aggregator = new ListAggregator()
        deduplicator.deduplicate(_) >> Arrays.asList(1, 2, 4)

        when:
        def n_distinct = aggregator.distinct(Arrays.asList(1, 2, 4, 2), deduplicator)
        System.out.println(n_distinct)

        then:
        3 == n_distinct
    }

    def 'testing distinct bug 8726 with expectation'() {
        given:
        def deduplicator = Mock(ListDeduplicator)
        def aggregator = new ListAggregator()
        when:
        def n_distinct = aggregator.distinct(Arrays.asList(1, 2, 4, 2), deduplicator)
        then:
        3 == n_distinct
        1 * deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2)) >> Arrays.asList(1, 2, 4)
    }

    def 'Testing max bug 7263'() {
        given:
        def aggregator = new ListAggregator()

        when:
        def max = aggregator.max(Arrays.asList(-1, -4, -5))

        then:
        -1 == max
    }
}
