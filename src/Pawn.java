public class Pawn extends Piece{
    boolean firstMove = true;
    int direction = 1;
    public Pawn(String colour){
        super(colour);
        if(colour.toLowerCase().equals("black"))
            direction = -1;
    }


    @Override
    public String toString() {
        return super.toString() + "P";
    }
}
