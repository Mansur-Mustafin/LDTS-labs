import com.aor.numbers.GenericListFilter
import com.aor.numbers.ListFilterer
import spock.lang.Specification

class ListFilterSpockTest extends Specification{
    private def list

    def setup() {
        list = Arrays.asList(1,-2,-4,2,5)
    }

    def 'test list filter'(){
        given:
        def filter = Mock(GenericListFilter)
        filter.accept(_) >>> [true, false, false, true, true]
        def f = new ListFilterer(filter)
        when:
        def r = f.filter(list)
        then:
        r == [1,2,5]
    }

}
