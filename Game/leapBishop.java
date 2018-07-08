package Game;

public class leapBishop extends Piece {

    public leapBishop(int plr, Board brd, Cord crd) {
        super(plr, brd, crd);
    }


    @Override
    public boolean move(int rows, int cols) {
        /*
        two condition: boundary, move diagonally
         */
        int curRank = this.getCrd().getRank();
        int curFile = this.getCrd().getFile();

        return boundary(rows, cols) && diagonallyMove(curRank, curFile, rows, cols);

    }
}
