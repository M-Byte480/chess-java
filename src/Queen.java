public class Queen extends Piece{

    public Queen(String colour){
        super(colour);
    }

    @Override
    public String toString() {
        return super.toString() + "Q";
    }
}
