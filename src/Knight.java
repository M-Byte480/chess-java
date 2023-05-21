public class Knight extends Piece{
    public Knight(String colour){
        super(colour);
    }
    @Override
    public String toString() {
        return colour.substring(0, 1) + "N";
    }
}
