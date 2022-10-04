import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

public class Arena {
    private int width;
    private int height;

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
    }

    private boolean canHeroMove(Position position){
        if(position.getX() < 0 ) return false;
        if(position.getY() < 0) return false;
        if(position.getX() > width - 1) return false;
        if(position.getY() > height - 1) return false;
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

    }


}
