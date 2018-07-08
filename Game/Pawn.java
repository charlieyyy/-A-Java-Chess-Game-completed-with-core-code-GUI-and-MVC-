package Game;

public class Pawn extends Piece{

    public Pawn(int plr,Board brd,Cord crd){
        super(plr,brd,crd);
    }

    /*
    separate this function as it may be reused later in checkmate
     */

    public void captureUpdate(Piece p, int curRank, int curFile, int rows, int cols){

        p.getBrd().removePiece(curRank,curFile);
        p.getBrd().removePiece(rows,cols);

        Cord newCrd = new Cord(rows,cols);
        p.setCrd(newCrd);
    }


    public boolean captureP1(int rows, int cols) {
        int curRank = this.getCrd().getRank();
        int curFile = this.getCrd().getFile();

        /*
        player side
         */
        Piece leftPiece = this.getBrd().getPiece(curRank + 1, curFile - 1);
        Piece rightPiece = this.getBrd().getPiece(curRank + 1, curFile +1);

        boolean leftP1 = ( leftPiece!= null) && (leftPiece.getPlr() == 2);
        boolean rightP1 = ( rightPiece!= null) && (rightPiece.getPlr()== 2);

        /*
        if will be false only when there is no opponent piece at these two locations when try to perform action on these coorinates.
         Otherwise it will be true.
        */


        if((curFile - cols) == 1 && leftP1){
            captureUpdate(this,curRank,curFile,rows,cols);
            return true;
        }

        if(rightP1 && (cols - curFile) == 1){

            captureUpdate(this,curRank,curFile,rows,cols);
            return true;
        }

        return false;

    }

    public boolean captureP2(int rows, int cols){
        int curRank = this.getCrd().getRank();
        int curFile = this.getCrd().getFile();
        /*
        opponent side
         */

        Piece leftPiece = this.getBrd().getPiece(curRank - 1, curFile - 1);
        Piece rightPiece = this.getBrd().getPiece(curRank - 1, curFile +1);

        boolean leftP2 = ( leftPiece!= null) && (leftPiece.getPlr() == 1);
        boolean rightP2 = ( rightPiece!= null) && (rightPiece.getPlr()== 1);

        if((curFile - cols) == 1 && leftP2){

            captureUpdate(this,curRank,curFile,rows,cols);
            return true;
        }

        if(rightP2 && (cols - curFile) == 1){

            captureUpdate(this,curRank,curFile,rows,cols);
            return true;
        }

        return false;
    }

    @Override
    public boolean move(int rows, int cols) {
        int curRank = this.getCrd().getRank();
        int curFile = this.getCrd().getFile();


        /*
        boundary checking first
         */
        if(rows < 0 || rows > 7 || cols < 0 || cols > 7){
            return false;
        }
        /*
        check for empty one tiles and two tile in front pawn on the player side
         */

        if(this.getPlr()==1) {
            boolean moveOneP1 = (this.getBrd().getPiece(curRank + 1, curFile) == null);
            boolean moveTwoP1 = (this.getBrd().getPiece(curRank + 2, curFile) == null) && moveOneP1;

            if (rows - curRank == 1) {

                if(cols == curFile) {
                    return moveOneP1;
                }

                if(cols -1 ==curFile || cols + 1 ==curFile){
                    return captureP1(rows, cols);
                }
            }

            if (((rows - curRank == 2) && cols == curFile)) {
                return moveTwoP1;
            }

        }

        /*
        opponent side
         */
        if(this.getPlr()==2) {
            boolean moveOneP2 = (this.getBrd().getPiece(curRank - 1, curFile) == null);
            boolean moveTwoP2 = (this.getBrd().getPiece(curRank - 2, curFile) == null) && moveOneP2;

            if (curRank -rows == 1) {

                if(cols == curFile) {
                    return moveOneP2;
                }

                if(cols -1 ==curFile || cols + 1 ==curFile){
                    return captureP2(rows, cols);
                }
            }

            if (((curRank - rows == 2) && cols == curFile)) {
                return moveTwoP2;
            }
        }

        return false;

    }



}
