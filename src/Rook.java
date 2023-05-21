public class Rook extends Piece {
    public Rook(String colour){
        super(colour);
    }

    @Override
    public String toString() {
        return super.toString() + "R";
    }
}
