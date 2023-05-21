public class Chess {
    private Board board;
    public Chess(){
        board = new Board();
        board.print();
        board.makeMove("white");
        board.print();
    }
}
