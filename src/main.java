public class main {
    public static void main(String[] args) {
        String[][] state = {
                {"bR", "bN", "bB", "bQ", "bK", "bB", "bN", "bR"},
                {"bP", "bP", "bP", "bP", "bP", "bP", "bP", "bP"},
                {" E", " E", " E", " E", " E", " E", " E", " E"},
                {" E", " E", " E", " E", " E", " E", " E", " E"},
                {" E", " E", " E", " E", " E", " E", " E", " E"},
                {" E", " E", " E", " E", " E", " E", " E", " E"},
                {"wP", "wP", "wP", "wP", "wP", "wP", "wP", "wP"},
                {"wR", "wN", "wB", "wQ", "wK", "wB", "wN", "wR"}
        };

//        state =new String[][]
//               {{"bR", " E", " E", " E", " E", " E", " E", " E"},
//                {" E", " E", " E", " E", " E", " E", " E", " E"},
//                {" E", " E", " E", " E", " E", " E", " E", " E"},
//                {" E", " E", " E", "wN", " E", " E", " E", " E"},
//                {" E", " E", " E", " E", " E", " E", " E", " E"},
//                {" E", " E", " E", " E", " E", " E", " E", " E"},
//                {" E", " E", " E", " E", " E", " E", " E", " E"},
//                {"wR", " E", "wB", " E", " E", "wB", " E", " E"}};

        Board board = new Board(reverse(state));
        Chess chessGame = new Chess(board);
    }

    public static String[][] reverse(String[][] in){
        String[][] input = in.clone();
        String[] temp;
        for (int i = 0; i < 4; i++) {
            temp = input[i];
            input[i] = input[7 - i];
            input[7 - i] = temp;
        }
        return input;
    }
}
