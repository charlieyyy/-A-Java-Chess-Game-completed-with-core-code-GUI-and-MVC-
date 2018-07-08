package Testing;


import Game.*;
import Game.Pawn;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class KnightTest {

    Board board;

    @Test
    public void shapeLmove(){
        board = new Board();
        Knight k1 = new Knight(1,board, new Cord(2,2));
        board.setPiece(k1,2,2);

        assertTrue("Move success", k1.move(3, 4));
        assertTrue("Move success", k1.move(1, 4));
        assertFalse("Move fail", k1.move(2, 2));
        assertFalse("Move fail", k1.move(1, 2));
    }

}

