package Testing;

import Game.Board;
import Game.Cord;
import Game.Rook;
import org.junit.Test;
import static org.junit.Assert.*;

public class RookTest {


        Board board;
        @Test
        public void linearTest() {
            board = new Board();
            Rook r1 = new Rook(1, board,new Cord(3, 3));
            board.setPiece(r1,3,3);
            assertTrue("Move success", r1.linearMove(3,3,3, 5));
            assertFalse("Move fail", r1.linearMove(3,3,5, 4));


        }

        @Test
        public void linearOverlapTest() {

            board = new Board();
            Rook r1 = new Rook(1, board,new Cord(3, 3));

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


}
