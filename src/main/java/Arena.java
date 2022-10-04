import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private int width;
    private int height;

    private List<Wall> walls;



    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }


    public void setWidth(int x){
        width = x;
    }
    public void setHeight(int y){
        height = y;
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private final Hero hero;

    public Arena(int x , int y){
        width = x;
        height = y;
        hero = new Hero(x / 2 , y / 2);
        this.walls = createWalls();
    }

    private boolean canHeroMove(Position position){
        if(position.getX() < 0 ) return false;
        if(position.getY() < 0) return false;
        if(position.getX() > width - 1) return false;
        if(position.getY() > height - 1) return false;
        for(Wall wall : walls){
            if(wall.getPosition().equals(position)) return false;
        }
        return true;
    }

    public void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }

    public void processKey(KeyStroke key) {
        if(key.getKeyType() == KeyType.ArrowUp)     moveHero(hero.moveUp());
        if(key.getKeyType() == KeyType.ArrowDown)   moveHero(hero.moveDown());
        if(key.getKeyType() == KeyType.ArrowLeft)   moveHero(hero.moveLeft());
        if(key.getKeyType() == KeyType.ArrowRight)  moveHero(hero.moveRight());
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);
        for (Wall wall : walls)
            wall.draw(graphics);
    }
}
