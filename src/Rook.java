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

        int file = this.getFile();
        int rank = this.getRank();
        Piece toCheck;
        for (int i = 1; i < rank; i++) {
            toCheck = board.board[this.getRank() - i][file];
            if(toCheck instanceof NullPiece){
                legalMoves.add(new Position(file, i));
            }else{
                break;
            }
        }
        for (int i = 1; i < file; i++) {
            toCheck = board.board[rank][this.getFile() - 65 - i];
            if(toCheck instanceof NullPiece ||
                    toCheck.getColour().equals(this.opponent())){
                legalMoves.add(new Position(i, rank));
            }else{
                break;
            }
        }
        for (int i = 1; i < 7 - rank; i++) {
            toCheck = board.board[this.getRank() + i][file];
            if(toCheck instanceof NullPiece){
                legalMoves.add(new Position(file, i));
            }else{
                break;
            }
        }
        for (int i = 1; i < 7 - file; i++) {
            toCheck = board.board[rank][this.getFile() + i];
            if(toCheck instanceof NullPiece ||
                    toCheck.getColour().equals(this.opponent())){
                legalMoves.add(new Position(i, rank));
            }else{
                break;
            }
        }
        return legalMoves;
    }
}
