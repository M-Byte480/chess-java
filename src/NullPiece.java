import java.util.ArrayList;

public class NullPiece extends Piece{
    public NullPiece(int file, int rank){
        super(file, rank);
    }

    @Override
    public String toString() {
        return " E";
    }

    @Override
    public ArrayList<Position> legalMoves(Board board) {
        return null;
    }
}
