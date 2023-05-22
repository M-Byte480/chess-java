public class Chess {
    private Board board;
    public Chess(){
        boolean endGame = false;
        board = new Board();
        String playerToMove = "white";
        int moveCounter = 0;
        while(!endGame) {
            moveCounter++;
            playerToMove = moveCounter % 2 == 0 ? "black" : "white";
            board.print();
            board.makeMove(playerToMove);
        }
        board.print();
    }
    public Chess(Board board){
        boolean endGame = false;
        String playerToMove = "white";
        int moveCounter = 0;
        while(!endGame) {
            moveCounter++;
            playerToMove = moveCounter % 2 == 0 ? "black" : "white";
            board.print();
            board.makeMove(playerToMove);
        }
        board.print();
    }
    void endState(boolean endGame, boolean whiteMoved){
        // White King Mate
        // Black King Mate
        // Draw?
        // Resignation to be overruled outside of the function
    }
}
