package com.mansur.hero;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextImage;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;

public class ArenaTest {
    private TerminalScreen screen;
    private Hero herostub;
    private TextGraphics graphics;

    @BeforeEach
    public void setUp() throws IOException {

        try {
            TerminalSize terminalSize = new TerminalSize(80, 40);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            this.screen = new TerminalScreen(terminal);
            this.screen.setCursorPosition(null); // we don't need a cursor
            this.screen.startScreen(); // screens must be started
            this.screen.doResizeIfNecessary(); // resize screen if necessary
        } catch (IOException e) {
            e.printStackTrace();
        }
        graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#75C6FF"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(80, 80), ' ');

        herostub = Mockito.mock(Hero.class);
        //doNothing().when(herostub).draw(isA(TextGraphics.class));

    }
    @Test
    public void testDraw() throws IOException {

        Arena arena = new Arena(80, 80);

        arena.draw(graphics);

        Mockito.verify(herostub,Mockito.times(0)).draw(graphics);

    }

    @Test
    public void NaoSeiOque() throws IOException {

        TextGraphics g = Mockito.mock(TextGraphics.class);

        Arena arena = new Arena(80, 80);

        arena.draw(g);

        Mockito.verify(g,Mockito.times(0)).drawImage(isA(TerminalPosition.class), isA(TextImage.class));

    }
}
