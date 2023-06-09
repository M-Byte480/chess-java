import java.util.*;

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
    static Map<Character, Piece> pieces = Board.getPieces();
    public Board(){
        board = new Piece[8][8];

        int emptySquares = 2;
        for (int i = 0; i < 8; i += 7) {
            String colour = white;
            if(i != 0) colour = black;

            int pawn = 1;
            if(i != 0) pawn = 6;

            board[i][0] = new Rook(colour, 0, i);
            board[i][1] = new Knight(colour, 1, i);
            board[i][2] = new Bishop(colour, 2, i);
            board[i][3] = new Queen(colour, 3, i);
            board[i][4] = new King(colour, 4, i);
            board[i][6] = new Knight(colour, 6, i);
            board[i][5] = new Bishop(colour, 5 ,i );
            board[i][7] = new Rook(colour, 7 , i);

            for (int j = 0; j < 8; j++) {
                board[pawn][j] = new Pawn(colour, j, pawn);

                board[emptySquares][j] = new NullPiece(j, emptySquares);
                board[emptySquares + 1][j] = new NullPiece(j, emptySquares + 1);
            }
            emptySquares += 2;
        }

    }
    public Board(String[][] state){
        board = new Piece[8][8];
        String colour;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if(state[i][j].charAt(0) == 'w')   colour = white;
                else if(state[i][j].charAt(0) == 'b')   colour = black;
                else colour = "n";

                if(colour.equals("n")){
                    board[i][j] = new NullPiece(j, i);
                }else{
                    char type = state[i][j].charAt(1);
                    Piece p;
                    if(type == 'P') p = new Pawn();
                    else if (type == 'R') p = new Rook();
                    else if (type == 'K') p = new King();
                    else if (type == 'Q') p = new Queen();
                    else if (type == 'B') p = new Bishop();
                    else p = new Knight();

                    p.setColour(colour);
                    p.setPosition(new Position(j, i));
                    board[i][j] = p;
                }
            }
        }
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
            if (validMove(selected, toMove)) {
                if(!(toMove instanceof NullPiece)) {
                    if (toMove.getColour().equals(selected.getColour())) {
                        System.out.println("That is your own piece");
                        continue;
                    }
                }
            }else{
                System.out.println("Move is invalid, try again");
                continue;
            }

            // Otherwise: We move and leave null behind
            selected.setPosition(toMove.getPosition());
            board[newRank][newFile] = selected;
            board[rank][file] = new NullPiece(file, rank);
            validMove = true;
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                sb.append(board[i][j])
                        .append(j == 7 ? " " : ", ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean validMove(Piece piece, Piece toMove) {
        System.out.println(piece.legalMoves(this));
        ArrayList<Position> legal = piece.legalMoves(this);
        Position p = toMove.getPosition();
        if(legal.contains(p)){
            System.out.println("Valid move");
            return true;
        }
        return false;
    }

    static private HashMap<Character, Piece> getPieces(){
        HashMap<Character, Piece> temp = new HashMap<>();
        temp.put('P', new Pawn());
        temp.put('R', new Rook());
        temp.put('K', new King());
        temp.put('Q', new Queen());
        temp.put('N', new Knight());
        temp.put('B', new Bishop());

        return temp;
    }
}
