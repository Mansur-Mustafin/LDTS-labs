import com.aor.numbers.ListSorter
import spock.lang.Specification

class ListSorterSpockTest extends Specification{
    def private list

    def setup() {
        list = Arrays.asList(1,2,4,2,5)
    }
    def 'test sorter list'(){
        given:
        def sorter  = new ListSorter()
        when:
        def r = sorter.sort(list)
        then:
        r == [1,2,2,4,5]
    }
}
