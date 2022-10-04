import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall {
    private int x;
    private int y;


    public Wall(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }


    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF34"));
        graphics.putString(new TerminalPosition(getX(),getY()), "%");
    }

}

