import java.util.ArrayList;

public class Pawn extends Piece{
    boolean firstMove = true;
    int direction = 1;
    public Pawn(){
        super();
    }

    public Pawn(String colour, int file, int rank){
        super(colour);
        position = new Position(file, rank);
        if(colour.toLowerCase().equals("black"))
            direction = -1;
    }


    @Override
    public String toString() {
        return super.toString() + "P";
    }

    @Override
    public ArrayList<Position> legalMoves(Board board) {
        return null;
    }
}
