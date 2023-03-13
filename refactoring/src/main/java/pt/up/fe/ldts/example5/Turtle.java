package pt.up.fe.ldts.example5;

public class Turtle {
    private final Position position;


    public Turtle(int row, int column, char direction) {
        position = new Position(row, column, direction);
    }

    public int getRow() {
        return position.getRow();
    }

    public int getColumn() {
        return position.getColumn();
    }

    public char getDirection() {
        return position.getDirection();
    }


    public void setDirection(char direction){
        position.setDirection(direction);
    }

    public void execute(char command) {
        if (command == 'L') { // ROTATE LEFT
            setDirection(position.getLeft());
        } else if (command == 'R') { // ROTATE RIGHT
            setDirection(position.getRight());
        } else if (command == 'F'){ // MOVE FORWARD
            position.Forward();
        }
    }
}
