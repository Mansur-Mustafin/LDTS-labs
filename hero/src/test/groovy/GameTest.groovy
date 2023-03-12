import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import com.googlecode.lanterna.screen.TerminalScreen
import com.mansur.hero.Arena
import com.mansur.hero.Game
import spock.lang.Specification

class GameTest extends Specification{

    def'test draw function'(){
        given:
        def arena = Mock(Arena.class)
        def screen = Mock(TerminalScreen.class)
        def game = new Game();
        game.setArena(arena);
        game.setScreen(screen);

        when:
        game.draw();

        then:
        1 * screen.clear();
        1 * arena.draw(_);
        1 * screen.refresh();
    }

    def'test run function with EOF'(){
        given:
        def arena = Mock(Arena.class)
        def screen = Mock(TerminalScreen.class)
        def game = new Game();
        game.setArena(arena);
        game.setScreen(screen);
        def key = Mock(KeyStroke.class)
        screen.readInput() >> key
        key.getKeyType() >> KeyType.EOF

        when:
        game.run();

        then:
        1 * screen.clear();
        1 * arena.draw(_);
        1 * screen.refresh();
        0 * arena.processKey(_)
    }

    def'test run function with q'(){
        given:
        def arena = Mock(Arena.class)
        def screen = Mock(TerminalScreen.class)
        def game = new Game();
        game.setArena(arena);
        game.setScreen(screen);
        def key = Mock(KeyStroke.class)
        screen.readInput() >> key
        key.getKeyType() >> KeyType.Character
        key.getCharacter() >> 'q'

        when:
        game.run();

        then:
        1 * screen.clear();
        1 * arena.draw(_);
        1 * screen.refresh();
        1 * screen.close();
        0 * arena.processKey(_, _)
    }

    def'test run function with q 2'(){
        given:
        def arena = Mock(Arena.class)
        def screen = Mock(TerminalScreen.class)
        def game = new Game();
        game.setArena(arena);
        game.setScreen(screen);
        def key = Mock(KeyStroke.class)
        screen.readInput() >> key
        key.getKeyType() >> KeyType.Character
        key.getCharacter() >>> ['a', 'q']

        when:
        game.run();

        then:
        2 * screen.clear();
        2 * arena.draw(_);
        2 * screen.refresh();
        1 * screen.close();
        1 * arena.processKey(_, _)
    }
}
