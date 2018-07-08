package Game;

public class Board {

    /*
    int arrays for each location on the board
     */
    private Piece [][] gameBoard;
    private Piece lastUpdate;

    public Board(){

        gameBoard = new Piece [8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                gameBoard[i][j] = null;
            }
        }

    }


    public Piece[][] getBrd(){
        return gameBoard;
    }

    public Piece getLastUpdate(){
        return lastUpdate;
    }

    /*
    initiate two sides of pieces for each players
     */
    public void setPiece(Piece chessPiece, int rank, int file){
        gameBoard[rank][file]=chessPiece;
    }

    public Piece getPiece(int rank, int file){
        return gameBoard[rank][file];
    }

    public void removePiece(int rank, int file){ gameBoard[rank][file]=null; }


    /*
    Update rank and file after move returns TRUE for piece
     */

    public void updateCord(Piece p, int newRank, int newFile){

        int curRank = p.getCrd().getRank();
        int curFile = p.getCrd().getFile();


            if(p.move(newRank,newFile)){
                lastUpdate = p;

                removePiece(curRank,curFile);
                Cord newCrd = new Cord(newRank,newFile);
                p.setCrd(newCrd);

            }


    }

    public void undoMethod(){
        if(lastUpdate!= null){

            int curRank = lastUpdate.getCrd().getRank();
            int curFile = lastUpdate.getCrd().getFile();

            removePiece(curRank,curFile);

            setPiece(lastUpdate,lastUpdate.getCrd().getRank(),lastUpdate.getCrd().getFile());
        }
    }


}
