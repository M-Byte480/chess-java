public abstract class Piece {
    String colour;
    String moveType;
    char file;
    int rank;
    Position position;

    public Piece(String colour){
        this.colour = colour.toLowerCase();
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

    @Override
    public String toString(){
        return colour.substring(0,1);
    }
}
