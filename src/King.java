public class King extends Piece{
    public King(String colour){
        super(colour);
    }

    @Override
    public String toString() {
        return super.toString() + "K";
    }
}
