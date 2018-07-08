package Game;

public class leapRook extends Piece {

    public leapRook(int plr, Board brd, Cord crd) {
        super(plr, brd, crd);
    }


    @Override
    public boolean move(int rows, int cols) {
        /*
        two condition: boundary, move linearly
         */
        int curRank = this.getCrd().getRank();
        int curFile = this.getCrd().getFile();


        return boundary(rows, cols) && linearMove(curRank, curFile, rows, cols);

    }
}


