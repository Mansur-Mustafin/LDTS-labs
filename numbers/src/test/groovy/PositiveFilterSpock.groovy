import com.aor.numbers.PositiveFilter
import spock.lang.Specification

class PositiveFilterSpock extends Specification{
    def 'test fositive filter'(){
        given:
        def f = new PositiveFilter()
        when:
        def r = f.accept(5)
        then:
        r
    }
    def 'test fositive filter'(){
        given:
        def f = new PositiveFilter()
        when:
        def r = f.accept(-3)
        then:
        r == false
    }
}
