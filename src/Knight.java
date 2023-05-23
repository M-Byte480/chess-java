import java.util.ArrayList;

public class Knight extends Piece{
    public Knight(){
        super();
    }
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
        System.out.println("Knight selected");
        ArrayList<Position> legalMoves = new ArrayList<>();

        int file = this.getFile() - 65;
        int rank = this.getRank();
        int fileToCheck, rankToCheck;
        Piece toCheck;
        for (int i = 0; i < 2; i++) {

            rankToCheck = rank + 2 * ( i % 2 == 0 ? 1 : -1);
            if(rankToCheck * ( i % 2 == 0 ? 1 : -1) <= 7 * ((i + 1) % 2)) {

                for (int j = 0; j < 2; j++) {

                    fileToCheck = file + ( j % 2 == 0 ? 1 : -1);
                    if(fileToCheck * ( j % 2 == 0 ? 1 : -1) <= 7 * ((j + 1) % 2)) {

                        toCheck = board.board[rankToCheck][fileToCheck];

                        if(toCheck instanceof NullPiece || toCheck.getColour().equals(this.opponent())){
                            legalMoves.add(toCheck.getPosition());
                        }
                    }
                }
            }

            fileToCheck = file + 2 * ( i % 2 == 0 ? 1 : -1);
            if(fileToCheck * ( i % 2 == 0 ? 1 : -1) <= 7 * ((i + 1) % 2)){
                for (int j = 0; j < 2; j++) {
                    rankToCheck = rank + ( j % 2 == 0 ? 1 : -1);
                    if(rankToCheck * ( j % 2 == 0 ? 1 : -1) <= 7 * ((j + 1) % 2)) {
                        toCheck = board.board[rankToCheck][fileToCheck];
                        if(toCheck instanceof NullPiece
                                || toCheck.getColour().equals(this.opponent())){
                            legalMoves.add(toCheck.getPosition());
                        }
                    }
                }
            }

        }
        return legalMoves;
    }
}
