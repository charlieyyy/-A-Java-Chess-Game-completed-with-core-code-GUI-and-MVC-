package Game;

public class Bishop extends Piece{

    public Bishop(int plr,Board brd,Cord crd){
        super(plr,brd,crd);
    }



    @Override
    public boolean move(int rows, int cols) {
        /*
        three condition: boundary, move diagonally and  diagonally overlap
         */
        int curRank = this.getCrd().getRank();
        int curFile = this.getCrd().getFile();

        return boundary(rows, cols) && diagonallyMove(curRank, curFile, rows, cols) && diagonalOverlap(curRank, curFile, rows, cols);

    }

}
