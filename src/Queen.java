import java.util.ArrayList;

public class Queen extends Piece{

    public Queen(String colour, int file, int rank){
        super(colour);
        position = new Position(file, rank);

    }

    @Override
    public String toString() {
        return super.toString() + "Q";
    }

    @Override
    public ArrayList<Position> legalMoves(Board board) {
        return null;
    }
}
