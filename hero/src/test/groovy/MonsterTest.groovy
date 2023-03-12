import com.mansur.hero.Monster
import com.mansur.hero.Position
import spock.lang.Specification

class MonsterTest extends Specification{
    def 'move test'(){
        given:
        def m = new Monster(10,10)
        when:
        m.move(new Position(3,3,))
        then:
        m.getPosition().x == 3
        m.getPosition().y == 3
    }

}
