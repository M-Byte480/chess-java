public abstract class Piece implements MoveType{
    String colour;
    String moveType;
    char file;
    int rank;
    Position position;

    public Piece(String colour){
        this.colour = colour.toLowerCase();
    }

    public Piece(int file, int rank){
        this.colour = "null";
        position = new Position(file, rank);
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getMoveType() {
        return moveType;
    }

    public void setMoveType(String moveType) {
        this.moveType = moveType;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public char getFile() {
        return file;
    }

    public int getRank() {
        return rank;
    }

    public String opponent(){
        if(this.colour.equals("white")){
            return "black";
        }else{
            return "white";
        }
    }

    @Override
    public String toString(){
        return colour.substring(0,1);
    }
}
