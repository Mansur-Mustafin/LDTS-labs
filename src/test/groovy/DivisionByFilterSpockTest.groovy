import com.aor.numbers.DivisibleByFilter
import spock.lang.Specification

class DivisionByFilterSpockTest extends Specification{
    def 'test division by'(){
        given:
        def f = new DivisibleByFilter(2)
        when:
        def r = f.accept(4)
        then:
        r
    }
    def 'test division by 2'(){
        given:
        def f = new DivisibleByFilter(2)
        when:
        def r = f.accept(45)
        then:
        r == false
    }
}
