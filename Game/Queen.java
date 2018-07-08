package Game;

public class Queen extends Piece{

    public Queen(int plr,Board brd,Cord crd){
        super(plr,brd,crd);
    }



    @Override
    /*
    Queen has to satisfy all conditions from bishop and rook
     */
    public boolean move(int rows, int cols) {
        int curRank = this.getCrd().getRank();
        int curFile = this.getCrd().getFile();

        return (boundary(rows, cols) && linearMove(curRank, curFile, rows, cols) && linearOverlap(curRank, curFile, rows, cols))
                || (boundary(rows, cols) && diagonallyMove(curRank, curFile, rows, cols) && diagonalOverlap(curRank, curFile, rows, cols));
    }

}
