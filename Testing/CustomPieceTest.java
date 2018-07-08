package Testing;

import Game.*;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CustomPieceTest {


    Board board;

    @Test
    public void leapbTest() {
        board = new Board();
        leapBishop b1 = new leapBishop(1, board, new Cord(3, 3));
        board.setPiece(b1, 3, 3);
        assertTrue("Move success", b1.move(5, 5));
        assertFalse("Move fail", b1.move(3, 4));


    }

    /*
        leap over TEST
     */

    @Test
    public void diagonalOverlapTest() {
        board = new Board();
        leapBishop b1 = new leapBishop(1, board,new Cord(3, 3));
        board.setPiece(b1,3,3);
        assertTrue("Move success", b1.move(5, 5));
        board.updateCord(b1,5,5);
        assertFalse("Move fail", b1.move(3, 4));

        /*
            add another piece at its left down side and try to move it
        */

        Rook r2 = new Rook(1, board,new Cord(4, 4));
        board.setPiece(r2,4,4);
        int curRank = b1.getCrd().getRank();
        int curFile = b1.getCrd().getFile();
        System.out.print(curRank);
        System.out.print(curFile);
        assertTrue("Move success", b1.move(3, 3));
    }




    @Test
    public void leaprTest() {
        board = new Board();
        leapRook r1 = new leapRook(1, board,new Cord(3, 3));
        board.setPiece(r1,3,3);
        assertTrue("Move success", r1.move(5, 3));
        assertFalse("Move fail", r1.move(5, 4));

         /*
        leap over TEST
         */


    }
    @Test
    public void linearOverlapTest() {

        board = new Board();
        leapRook r1 = new leapRook(1, board,new Cord(3, 3));

        board.setPiece(r1,3,3);
        assertTrue("Move success", r1.move(3, 5));
        board.updateCord(r1,3,5);


        /*
            add another piece at its right and try to move it
        */

        Rook r2 = new Rook(1, board,new Cord(3, 4));
        board.setPiece(r2,3,4);
        assertTrue("Move success", r1.move(3, 3));
    }

}
