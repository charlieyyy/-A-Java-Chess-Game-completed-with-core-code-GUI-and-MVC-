package Game;

public class Rook extends Piece{

    public Rook(int plr,Board brd,Cord crd){
        super(plr,brd,crd);
    }


    @Override
    public boolean move(int rows, int cols) {
        int curRank = this.getCrd().getRank();
        int curFile = this.getCrd().getFile();

        /*
        three condition boundary, move linearly and  linearoverlap
         */
        return boundary(rows, cols) && linearMove(curRank, curFile, rows, cols) && linearOverlap(curRank, curFile, rows, cols);
    }

}
