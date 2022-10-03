import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    private Position position = new Position();

    public Hero(int x,int y){
        position.setX(x);
        position.setY(y);
    }

    public int getX() {
        return position.getX();
    }

    public void setX(int x) {
        this.position.setX(x);
    }

    public int getY() {
        return position.getY();
    }

    public void setY(int y) {
        this.position.setY(y);
    }

    public void draw(Screen screen){
        screen.setCharacter(getX(), getY(), TextCharacter.fromCharacter('X')[0]);
    }

    public Position moveUp(){
        return new Position(position.getX(), position.getY() - 1);
    }
    public Position moveDown(){
        return new Position(position.getX(), position.getY() + 1);
    }
    public  Position moveRight(){
        return new Position(position.getX() + 1, position.getY());
    }
    public Position moveLeft(){
        return new Position(position.getX() - 1, position.getY());
    }

    public void setPosition( Position position_new){
        this.position.setY(position_new.getY());
        this.position.setX(position_new.getX());
    }



}
