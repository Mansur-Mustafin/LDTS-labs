package pt.up.fe.ldts.example5;

public class Position {
    private int row;
    private int column;
    private char direction;
    public Position(int row, int column, char direction){
        this.row = row;
        this.column = column;
        this.direction = direction;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public char getLeft(){
        switch (direction){
            case 'N':
                return 'W';
            case 'W':
                return 'S';
            case 'S':
                return 'E';
            case 'E':
                return 'N';
        }
        return direction;
    }

    public char getRight(){
        switch (direction){
            case 'N':
                return 'E';
            case 'E':
                return 'S';
            case 'S':
                return 'W';
            case 'W':
                return 'N';
        }
        return direction;
    }

    public void Forward(){
        switch (direction){
            case 'N':
                row--;
                break;
            case 'E':
                column++;
                break;
            case 'S':
                row++;
                break;
            case 'W':
                column--;
                break;
        }
    }
}
