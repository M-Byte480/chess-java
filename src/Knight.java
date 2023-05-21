import java.util.ArrayList;

public class Knight extends Piece{
    public Knight(String colour, int file, int rank){
        super(colour);
        position = new Position(file, rank);
    }
    @Override
    public String toString() {
        return colour.substring(0, 1) + "N";
    }

    @Override
    public ArrayList<Position> legalMoves(Board board) {
        return null;
    }
}
