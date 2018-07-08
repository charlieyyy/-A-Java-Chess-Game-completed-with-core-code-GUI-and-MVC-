package Testing;

import Game.Bishop;
import Game.Queen;
import Game.Board;
import Game.Cord;
import Game.Rook;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QueenTest {

    Board board;
    @Test
    public void linearTest() {
        board = new Board();
        Queen r1 = new Queen(1, board,new Cord(3, 3));
        board.setPiece(r1,3,3);
        assertTrue("Move success", r1.linearMove(3,3,3, 5));
        assertFalse("Move fail", r1.linearMove(3,3,5, 4));


    }

    @Test
    public void linearOverlapTest() {

        board = new Board();
        Queen r1 = new Queen(1, board,new Cord(3, 3));

        board.setPiece(r1,3,3);
        assertTrue("Move success", r1.move(3, 5));
        board.updateCord(r1,3,5);


            /*
            add another piece at its right and try to move it
             */

        Rook r2 = new Rook(1, board,new Cord(3, 4));
        board.setPiece(r2,3,4);
        assertFalse("Move fail", r1.move(3, 3));
    }

    @Test
    public void diagonalTest() {
        board = new Board();
        Queen b1 = new Queen(1, board,new Cord(3, 3));
        board.setPiece(b1,3,3);
        assertTrue("Move success", b1.diagonallyMove(3,3,5, 5));
        assertTrue("Move success", b1.diagonalOverlap(3,3,5, 5));
        assertTrue("Move success", b1.move(5, 5));

    }

    @Test
    public void diagonalOverlapTest() {
        board = new Board();
        Queen b1 = new Queen(1, board,new Cord(3, 3));
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
        assertFalse("Move fail", b1.move(3, 3));
    }

}
