import com.mansur.hero.Arena
import com.mansur.hero.Position
import spock.lang.Specification

class ArenaTest extends Specification{
    def'test canHeroMove'(){
        given:
        def arena = new Arena(10,10)
        expect:
        !arena.canHeroMove(new Position(-10,10))
        !arena.canHeroMove(new Position(10,-10))
        !arena.canHeroMove(new Position(10,5))
        !arena.canHeroMove(new Position(5,10))
    }
}
