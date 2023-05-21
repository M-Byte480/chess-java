public class Bishop extends Piece{
    public Bishop(String colour){
        super(colour);
    }

    @Override
    public String toString() {
        return super.toString() + "B";
    }
}
