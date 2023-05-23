import java.util.ArrayList;
import java.util.Enumeration;

public class Bishop extends Piece {
    public Bishop(){
        super();
    }
    public Bishop(String colour, int file, int rank) {
        super(colour);
        position = new Position(file, rank);
    }

    @Override
    public String toString() {
        return super.toString() + "B";
    }

    @Override
    public ArrayList<Position> legalMoves(Board board) {
        System.out.println("Bishop selected");
        ArrayList<Position> legalMoves = new ArrayList<>();

        int file;
        int rank;
        int fileToCheck;
        int rankToCheck;

        Piece toCheck;
        boolean pathNotBlocked1 = true, pathNotBlocked2 = true, pathNotBlocked3 = true, pathNotBlocked4 = true;
        for (int i = 1; i < 8; i++) {
            file = this.getFile() - 65;
            rank = this.getRank();

            fileToCheck = file + i;
            rankToCheck = rank + i;
            if (fileToCheck < 8 && rankToCheck < 8 && pathNotBlocked1) {
                toCheck = board.board[rankToCheck][fileToCheck];

                if (toCheck instanceof NullPiece) {
                    legalMoves.add(toCheck.getPosition());
                } else if (toCheck.getColour().equals(this.opponent())) {
                    legalMoves.add(toCheck.getPosition());
                    pathNotBlocked1 = false;
                } else {
                    pathNotBlocked1 = false;
                }
            }

            fileToCheck = file + i;
            rankToCheck = rank - i;
            if (fileToCheck < 8 && rankToCheck > -1 && pathNotBlocked2) {
                toCheck = board.board[rankToCheck][fileToCheck];

                if (toCheck instanceof NullPiece) {
                    legalMoves.add(toCheck.getPosition());
                } else if (toCheck.getColour().equals(this.opponent())) {
                    legalMoves.add(toCheck.getPosition());
                    pathNotBlocked2 = false;
                } else {
                    pathNotBlocked2 = false;
                }
            }

            fileToCheck = file - i;
            rankToCheck = rank + i;
            if (fileToCheck > -1 && rankToCheck < 8 && pathNotBlocked3) {
                toCheck = board.board[rankToCheck][fileToCheck];

                if (toCheck instanceof NullPiece) {
                    legalMoves.add(toCheck.getPosition());
                } else if (toCheck.getColour().equals(this.opponent())) {
                    legalMoves.add(toCheck.getPosition());
                    pathNotBlocked3 = false;
                } else {
                    pathNotBlocked3 = false;
                }
            }


            fileToCheck = file - i;
            rankToCheck = rank - i;
            if (fileToCheck > -1 && rankToCheck > -1 && pathNotBlocked4) {
                toCheck = board.board[rankToCheck][fileToCheck];

                if (toCheck instanceof NullPiece) {
                    legalMoves.add(toCheck.getPosition());
                } else if (toCheck.getColour().equals(this.opponent())) {
                    legalMoves.add(toCheck.getPosition());
                    pathNotBlocked4 = false;
                } else {
                    pathNotBlocked4 = false;
                }
            }
        }
        return legalMoves;
    }
}
