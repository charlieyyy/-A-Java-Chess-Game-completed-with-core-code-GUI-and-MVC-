package Testing;

import Game.Bishop;
import Game.Board;
import Game.Cord;
import Game.Rook;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class BishopTest {


    Board board;
    @Test
    public void diagonalTest() {
        board = new Board();
        Bishop b1 = new Bishop(1, board,new Cord(3, 3));
        board.setPiece(b1,3,3);
        assertTrue("Move success", b1.diagonallyMove(3,3,5, 5));
        assertTrue("Move success", b1.diagonalOverlap(3,3,5, 5));
        assertTrue("Move success", b1.move(5, 5));
        assertFalse("Move fail", b1.move(3, 4));


    }

    @Test
    public void diagonalOverlapTest() {
        board = new Board();
        Bishop b1 = new Bishop(1, board,new Cord(3, 3));
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