import java.util.ArrayList;

public class Bishop extends Piece{
    public Bishop(String colour, int file, int rank){
        super(colour);
        position = new Position(file, rank);
    }

    @Override
    public String toString() {
        return super.toString() + "B";
    }

    @Override
    public ArrayList<Position> legalMoves(Board board) {
        return null;
    }
}
