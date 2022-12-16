import com.googlecode.lanterna.SGR
import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.TextColor
import com.googlecode.lanterna.graphics.TextGraphics
import com.googlecode.lanterna.input.KeyType
import com.googlecode.lanterna.screen.TerminalScreen
import com.mansur.hero.Arena
import com.mansur.hero.Position
import spock.lang.Specification

import javax.swing.KeyStroke

class ArenaTest extends Specification{


    private def arena
    private def posX
    private def posY
    private def screen
    private def key

    def setup(){
        arena = new Arena(10,10)
        posX = arena.getHero().getX();
        posY = arena.getHero().getY();
        screen = Mock(TerminalScreen.class)
        key = Mock(com.googlecode.lanterna.input.KeyStroke.class)
    }


    def 'test draw'(){
        given:
        def gr = Mock(TextGraphics.class)
        when:
        arena.draw(gr)
        then:
        1 * gr.setBackgroundColor(_);
        1 * gr.fillRectangle(_,_,_)
        1 * gr.setForegroundColor(TextColor.Factory.fromString("#564C89"));
        1 * gr.enableModifiers(SGR.BOLD);
        1 * gr.putString(_, "X")
        5 * gr.setForegroundColor(TextColor.Factory.fromString("#FFF700"));
        5 * gr.putString(_, "C");
        36 * gr.setForegroundColor(TextColor.Factory.fromString("#000000"));
        36 * gr.putString(_, "@");
    }

    def'test canHeroMove'(){
        expect:
        !arena.canHeroMove(new Position(-10,10))
        !arena.canHeroMove(new Position(10,-10))
        !arena.canHeroMove(new Position(10,5))
        !arena.canHeroMove(new Position(5,10))
        !arena.canHeroMove(new Position(0,7))
        arena.canHeroMove(new Position(2,7))
    }
    def'test canMonsterMove'(){
        expect:
        !arena.canMonsterMove(new Position(-10,10))
        !arena.canMonsterMove(new Position(10,-10))
        !arena.canMonsterMove(new Position(10,5))
        !arena.canMonsterMove(new Position(5,10))
        !arena.canMonsterMove(new Position(0,7))
        arena.canMonsterMove(new Position(2,7))
    }

    def'test canMoveHero'(){
        when:
        arena.moveHero(new Position(1,1), screen)
        then:
        posX != arena.getHero().getX()
        posY != arena.getHero().getY()
        arena.getHero().getX() == 1
        arena.getHero().getY() == 1
    }

    def'test processKey Up'(){
        given:
        key.getKeyType() >> KeyType.ArrowUp

        when:
        arena.processKey(key,screen)

        then:
        posX == arena.getHero().getX()
        posY == arena.getHero().getY() + 1
    }

    def'test processKey Down'(){
        given:
        key.getKeyType() >> KeyType.ArrowDown

        when:
        arena.processKey(key,screen)

        then:
        posX == arena.getHero().getX()
        posY == arena.getHero().getY() - 1
    }
    def'test processKey Right'(){
        given:
        key.getKeyType() >> KeyType.ArrowRight

        when:
        arena.processKey(key,screen)

        then:
        posX == arena.getHero().getX() - 1
        posY == arena.getHero().getY()
    }
    def'test processKey Left'(){
        given:

        key.getKeyType() >> KeyType.ArrowLeft

        when:
        arena.processKey(key,screen)

        then:
        posX == arena.getHero().getX() + 1
        posY == arena.getHero().getY()
    }

}
