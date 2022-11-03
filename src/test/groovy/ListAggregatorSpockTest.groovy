import com.aor.numbers.GenericListDeduplicator
import spock.lang.Specification

class ListAggregatorSpockTest extends Specification{

    def 'testing distinct bug 8726'(){
        given:
            def deduplicator = Mock(GenericListDeduplicator)
        deduplicator.deduplicate(_) >>> [Arrays.asList(1, 2, 4), Arrays.asList(6, 7)]
        when:
            def result = deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2))
        then:
            result == Arrays.asList(1,2,4)
    }

}
