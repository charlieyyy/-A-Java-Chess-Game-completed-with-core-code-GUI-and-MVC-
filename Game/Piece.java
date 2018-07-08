package Game;
/*
An abstract class piece which will be implemented
by separated subclass such as king and queen etc.
 */



public abstract class Piece {

    private int plr;
    private Board brd;
    private Cord crd;
    private int cordX;
    private int cordY;

    public Piece(int plr,Board brd,Cord crd){
        this.plr=plr;
        this.brd=brd;
        this.crd=crd;
    }



    /*
    getter and setter for private variables
     */
    public Board getBrd(){
        return brd;
    }

    public int getPlr(){
        return plr;
    }

    public void setBrd(Board brd){
        this.brd=brd;
    }

    public void setPlr(int plr){
        this.plr=plr;
    }

    public void setCrd(Cord crd){
        this.crd=crd;
    }

    public Cord getCrd(){
        return crd;
    }
    /*
    abstract move method that each implementation of piece is unique
     */
    public abstract boolean move(int rows, int cols);


   /*
    boundary check for each piece
     */
    public boolean boundary(int x,int y){
        if(x < 0 || x > 7 || y < 0 || y > 7){
            return false;
        }

        return true;
    }

    /*
    move linearly checking and move diagonally checking
     */

    public boolean linearMove(int curRank, int curFile, int newRank, int newFile){
        if(curRank == newRank || curFile == newFile){
            return true;
        }else{
            return false;
        }
    }


    public boolean diagonallyMove(int curRank, int curFile, int newRank, int newFile){
        if(Math.abs(newRank-curRank)==Math.abs(newFile-curFile)){
            return true;
        }else{
            return false;
        }
    }
    /*
    check for overlap piece diagonally. This function is intend to be used by bishop.
     */
    public boolean diagonalOverlap(int curRank, int curFile, int newRank, int newFile){
            //left down
            if(newRank < curRank && newFile < curFile){

                for(int i = curRank-1;i>newRank;i--){
                    for(int j = curFile-1;j>newFile;j--){
                        Piece tempPiece = getBrd().getPiece(i,j);
                        if(tempPiece != null){
                            System.out.print(i);
                            System.out.print(j);

                            return false;
                        }
                    }

                }
            }

            //right up

            if(newRank > curRank && newFile > curFile){

                for(int i = curRank+1;i<newRank;i++){
                    for(int j = curFile+1;j<newFile;j++){
                        Piece tempPiece = getBrd().getPiece(i,j);
                        if(tempPiece != null){
                            return false;
                        }
                    }

                }
            }

            //left up
            if(newRank > curRank && newFile < curFile){

                for(int i = curRank+1;i<newRank;i++){
                    for(int j = curFile-1;j>newFile;j--){
                        Piece tempPiece = getBrd().getPiece(i,j);
                        if(tempPiece != null){
                            return false;
                        }
                    }

                }
            }



            //right down
            if(newRank < curRank && newFile > curFile){

                for(int i = curRank-1;i>newRank;i--){
                    for(int j = curFile+1;j<newFile;j++){
                        Piece tempPiece = getBrd().getPiece(i,j);
                        if(tempPiece != null){
                            return false;
                        }
                    }

                }
            }

            return true;

    }


    /*
      check for overlap piece in same rank and file. This function is intend to be used by rook.
        */
    public boolean linearOverlap(int curRank, int curFile, int newRank, int newFile){

        //move down
        if(newRank < curRank){

            for(int temp = curRank-1; temp > newRank; temp--){
                Piece tempPiece = getBrd().getPiece(temp,curFile);
                if(tempPiece != null){
                    return false;
                }
            }

        }

        //move up
        if(newRank > curRank){

            for(int temp = curRank+1; temp < newRank; temp++){
                Piece tempPiece = getBrd().getPiece(temp,curFile);
                if(tempPiece != null){
                    return false;
                }
            }

        }

        //move left
        if(newFile < curFile){

            for(int temp = curFile-1; temp > newFile; temp--){
                Piece tempPiece = getBrd().getPiece(curRank,temp);
                if(tempPiece != null){
                    return false;
                }
            }

        }

        //move right
        if(newFile > curFile){

            for(int temp = curFile+1; temp < newFile; temp++){
                Piece tempPiece = getBrd().getPiece(curRank,temp);
                if(tempPiece != null){
                    return false;
                }
            }

        }
        return true;
    }

}
