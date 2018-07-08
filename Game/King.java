package Game;

public class King extends Piece{

    public King(int plr,Board brd,Cord crd){
        super(plr,brd,crd);
    }



    @Override
    public boolean move(int rows, int cols) {
        int curRank = this.getCrd().getRank();
        int curFile = this.getCrd().getFile();

        /*
        check for absolute values to make sure it moves one square at a time
         */
        if (boundary(rows, cols)) {

            if (Math.abs(curRank - rows) <= 1 && Math.abs(curFile - cols) <= 1) {
                return true;
            } else {
                return false;
            }

        }else{
            return false;
        }
    }

}
