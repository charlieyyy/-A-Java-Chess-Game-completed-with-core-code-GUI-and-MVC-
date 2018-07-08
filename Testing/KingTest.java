package Testing;

import Game.Board;
import Game.Cord;
import Game.King;
import org.junit.Test;
import static org.junit.Assert.*;

public class KingTest {


        Board board;


        @Test
        public void twoSquareTest() {

            board = new Board();
            King k1 = new King(1,board, new Cord(2,2));
            board.setPiece(k1,2,2);

            assertTrue("Move success", k1.move(3, 3));
            assertTrue("Move success", k1.move(1, 3));
            assertFalse("Move fail", k1.move(2, 4));
            assertFalse("Move fail", k1.move(0, 2));
            assertFalse("Move fail", k1.move(4, 4));
        }

}
