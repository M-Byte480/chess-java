public class Position {
    static int[] ranks = {1,2,3,4,5,6,7,8};
    static char[] files = {'A','B','C','D','E','F','G','H'};

    char file;
    int rank;

    public Position(char file, int rank){
        this.file = file;
        this.rank = rank;
    }

    public Position(int file, int rank){
        this.file = (char) (65 + file);
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public char getFile() {
        return file;
    }

    @Override
    public String toString() {
        return String.valueOf((char) (file + 65))
                .concat(String.valueOf(rank));
    }
}
