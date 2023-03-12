import com.aor.numbers.GenericListSorter
import com.aor.numbers.ListDeduplicator
import spock.lang.Specification

class ListDuplicatorSpockTest extends Specification{
    private def list

    def setup() {
        list = Arrays.asList(1,2,4,2,5)
    }

    def 'test duplicator'(){
        given:
        def sorter = Mock(GenericListSorter)
        sorter.sort(_) >> Arrays.asList(1, 2, 2, 4, 5)
        def duplicator = new ListDeduplicator(sorter)
        when:
        def unic = duplicator.deduplicate(list)
        then:
        unic == [1,2,4,5]
    }
}
