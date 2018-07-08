package Game;

public class gamingBoard {

    private Board startBoard = new Board();

    public gamingBoard (){

        /*
        Player has 0 and 1 Rank, Opponent has 6 and 7 rank at the beginning.
         */

            //Pawn Initialization for two players
            for(int i = 0; i < 8; i++){
                startBoard.setPiece(new Pawn(1, startBoard,new Cord(1, i)),1,i);
                startBoard.setPiece(new Pawn(2, startBoard, new Cord(6, i)),6,i);
            }

            //the rest piece of player
            startBoard.setPiece(new King(1,startBoard, new Cord(0, 4)), 0,4);
            startBoard.setPiece(new Queen(1,startBoard, new Cord(0, 3)), 0,3);

            startBoard.setPiece(new Rook(1,startBoard, new Cord(0, 0)),0,0);
            startBoard.setPiece(new Rook(1,startBoard, new Cord(0, 7)), 0,7);

            startBoard.setPiece(new Knight(1,startBoard, new Cord(0, 1)), 0,1);
            startBoard.setPiece(new Knight(1,startBoard, new Cord(0, 6)), 0,6);

            startBoard.setPiece(new Bishop(1,startBoard, new Cord(0, 2)), 0,2);
            startBoard.setPiece(new Bishop(1,startBoard, new Cord(0, 5)), 0,5);



            //the rest piece of opponent
            startBoard.setPiece(new King(2,startBoard, new Cord(7, 4)), 7,4);
            startBoard.setPiece(new Queen(2,startBoard, new Cord(7, 3)),7,3);

            startBoard.setPiece(new Rook(2,startBoard, new Cord(7, 0)), 7,0);
            startBoard.setPiece(new Rook(2,startBoard, new Cord(7, 7)), 7,7);

            startBoard.setPiece(new Knight(2,startBoard, new Cord(7, 1)), 7,1);
            startBoard.setPiece(new Knight(2,startBoard, new Cord(7, 6)), 7,6);

            startBoard.setPiece(new Bishop(2,startBoard, new Cord(7, 2)), 7,2);
            startBoard.setPiece(new Bishop(2,startBoard, new Cord(7, 5)), 7,5);




    }

    public Piece getPiece(int rows, int cols){

        return startBoard.getPiece(rows,cols);

    }

    public Board getBoard(){
        return startBoard;
    }

    public gamingBoard specialMode(gamingBoard speicalBoard){

        speicalBoard.getBoard().removePiece(7,0);
        speicalBoard.getBoard().removePiece(7,7);
        speicalBoard.getBoard().removePiece(7,2);
        speicalBoard.getBoard().removePiece(7,5);

        speicalBoard.getBoard().removePiece(0,0);
        speicalBoard.getBoard().removePiece(0,7);
        speicalBoard.getBoard().removePiece(0,2);
        speicalBoard.getBoard().removePiece(0,5);

        speicalBoard.getBoard().setPiece(new leapBishop(2,startBoard, new Cord(7, 2)), 7,2);
        speicalBoard.getBoard().setPiece(new leapBishop(2,startBoard, new Cord(7, 5)), 7,5);

        speicalBoard.getBoard().setPiece(new leapRook(2,startBoard, new Cord(7, 0)), 7,0);
        speicalBoard.getBoard().setPiece(new leapRook(2,startBoard, new Cord(7, 7)), 7,7);


        speicalBoard.getBoard().setPiece(new leapBishop(1,startBoard, new Cord(0, 2)), 0,2);
        speicalBoard.getBoard().setPiece(new leapBishop(1,startBoard, new Cord(0, 5)), 0,5);

        speicalBoard.getBoard().setPiece(new leapRook(1,startBoard, new Cord(0, 0)), 0,0);
        speicalBoard.getBoard().setPiece(new leapRook(1,startBoard, new Cord(0, 7)), 0,7);

        return speicalBoard;

    }


}
