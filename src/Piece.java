public abstract class Piece implements MoveType{
    String colour;
    String moveType;
    char file;
    int rank;
    Position position;

    public Piece(){
        this.colour = "null";
    }

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
        return this.getPosition().getFile();
    }

    public int getRank() {
        return this.getPosition().getRank();
    }

    public String opponent(){
        if(this.colour.equals("white")){
            return "black";
        }else if(this.colour.equals("black")){
            return "white";
        }else{
            return "null";
        }
    }

    @Override
    public String toString(){
        return colour.substring(0,1);
    }
}
