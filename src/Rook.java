import java.util.ArrayList;

public class Rook extends Piece {
    public Rook(){
        super();
    }
    public Rook(String colour, int file, int rank){
        super(colour);
        position = new Position(file, rank);
    }

    @Override
    public String toString() {
        return super.toString() + "R";
    }

    @Override
    public ArrayList<Position> legalMoves(Board board) {
        System.out.println("Rook selected");
        ArrayList<Position> legalMoves = new ArrayList<>();

        int file = this.getFile() - 65;
        int rank = this.getRank();

        int rankToCheck;
        int fileToCheck;
        Piece toCheck;
        for (int i = rank - 1; i > -1; i--) {
            toCheck = board.board[i][file];
            if(toCheck instanceof NullPiece){
                legalMoves.add(toCheck.getPosition());
            }else if(toCheck.getColour().equals(this.colour)){
                break;
            }else if(toCheck.getColour().equals(this.opponent())){
                legalMoves.add(toCheck.getPosition());
                break;
            }
        }
        for (int i = file - 1; i > -1; i--) {
            toCheck = board.board[rank][i];
            if(toCheck instanceof NullPiece){
                legalMoves.add(toCheck.getPosition());
            }else if(toCheck.getColour().equals(this.colour)){
                break;
            }else if(toCheck.getColour().equals(this.opponent())){
                legalMoves.add(toCheck.getPosition());
                break;
            }
        }
        for (int i = 1; i < 8 - rank; i++) {
            toCheck = board.board[rank + i][file];
            if(toCheck instanceof NullPiece){
                legalMoves.add(toCheck.getPosition());
            }else if(toCheck.getColour().equals(this.colour)){
                break;
            }else if(toCheck.getColour().equals(this.opponent())){
                legalMoves.add(toCheck.getPosition());
                break;
            }
        }
        for (int i = 1; i < 8 - file; i++) {
            toCheck = board.board[rank][file + i];
            if(toCheck instanceof NullPiece){
                legalMoves.add(toCheck.getPosition());
            }else if(toCheck.getColour().equals(this.colour)){
                break;
            }else if(toCheck.getColour().equals(this.opponent())){
                legalMoves.add(toCheck.getPosition());
                break;
            }
        }
        return legalMoves;
    }
}
