import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
public class Board {
    public static final char A = 'A';
    public static final char B = 'B';
    public static final char C = 'C';
    public static final char D = 'D';
    public static final char E = 'E';
    public static final char F = 'F';
    public static final char G = 'G';
    public static final char H = 'H';

    public static final String black = "black";
    public static final String white = "white";
    public static final String b = black;
    public static final String w = white;
    Piece[][] board;
    public Board(){
//        board= {
//                {"bR", "bN", "bB", "bQ", "bK", "bB", "bN", "bR"},
//                {"bP", "bP", "bP", "bP", "bP", "bP", "bP", "bP"},
//                {" ", " ", " ", " ", " ", " ", " ", " "},
//                {" ", " ", " ", " ", " ", " ", " ", " "},
//                {" ", " ", " ", " ", " ", " ", " ", " "},
//                {" ", " ", " ", " ", " ", " ", " ", " "},
//                {" ", "wP", "wP", "wP", "wP", "wP", "wP", "wP"},
//                {"wR", "wN", "wB", "wQ", "wK", "wB", "wN", "wR"},
//        };
        board = new Piece[8][8];

        for (int i = 0; i < 8; i += 7) {
            String colour = white;
            if(i != 0) colour = black;

            int pawn = 1;
            if(i != 0) pawn = 6;

            board[i][0] = new Rook(colour);
            board[i][1] = new Knight(colour);
            board[i][2] = new Bishop(colour);
            board[i][3] = new Queen(colour);
            board[i][4] = new King(colour);
            board[i][6] = new Knight(colour);
            board[i][5] = new Bishop(colour);
            board[i][7] = new Rook(colour);

            for (int j = 0; j < 8; j++) {
                board[pawn][j] = new Pawn(colour);
            }
        }

    }
    public Board(char[] setup){
        board = new Piece[8][8];
    }

    public void setBoard(Piece[][] board) {
        this.board = board;
    }

    public Piece[][] getBoard() {
        return board;
    }

    public Piece[] threaten(Piece pieceToMove){
        return new Piece[0];
    }

    public void print(){
        System.out.println(this.toString());
    }
    public void makeMove(String colour){
        System.out.println("Player " + colour + "'s Turn");
        boolean validMove = false;
        Scanner in = new Scanner(System.in);
        while(!validMove){
            System.out.println("Enter File and Rank");

            String input = in.nextLine();
            int file = Character.toUpperCase(input.charAt(0)) - 65;
            int rank = Character.getNumericValue(input.charAt(1)) - 1;
            Piece selected = board[rank][file];

//            System.out.println(selected);
            // Check if selected square is our piece
            if(selected.equals(null)){
                System.out.println("That is not a piece");
                continue;
            }else if(selected.getColour() != colour){
                System.out.println("That is not your piece");
                continue;
            }

            System.out.println("Enter Where to move");
            input = in.nextLine();
            int newFile = Character.toUpperCase(input.charAt(0)) - 65;
            int newRank = Character.getNumericValue(input.charAt(1)) - 1;
            Piece toMove = board[newRank][newFile];

            // Same colour piece we attacking?
            if(toMove != null) {
                if (toMove.getColour().equals(selected.getColour())) {
                    System.out.println("That is your own piece");
                    continue;
                }
            }

            // Otherwise: We move and leave null behind
            board[newRank][newFile] = selected;
            board[rank][file] = null;
            validMove = true;
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                sb.append(board[i][j] == null ? " E" : board[i][j].toString()).append(j == 7 ? " " : ", ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
