import java.util.ArrayList;

public class King extends Piece{
    public King(String colour, int file, int rank){
        super(colour);
        position = new Position(file, rank);
    }

    @Override
    public String toString() {
        return super.toString() + "K";
    }

    @Override
    public ArrayList<Position> legalMoves(Board board) {
        return null;
    }
}
