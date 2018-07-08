package Testing;

import Game.Board;
import Game.Cord;
import Game.Pawn;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PawnTest {

    Board board;

    @Test
    public void validPawnPlayer(){

        board = new Board();
        Pawn k1 = new Pawn(1,board, new Cord(2,2));
        board.setPiece(k1,2,2);

        assertTrue("Move success", k1.move(3, 2));
        assertTrue("Move success", k1.move(4, 2));
        assertFalse("Move fail", k1.move(0, 2));
        assertFalse("Move fail", k1.move(1, 2));

    }

    @Test
    public void validPawnOpponent(){

        board = new Board();
        Pawn k1 = new Pawn(2,board, new Cord(2,2));
        board.setPiece(k1,2,2);

        assertTrue("Move success", k1.move(0, 2));
        assertTrue("Move success", k1.move(1, 2));
        assertFalse("Move fail", k1.move(3, 2));
        assertFalse("Move fail", k1.move(4, 2));

    }

    @Test
    public void captureTest_player(){
        board = new Board();
        Pawn k1 = new Pawn(1,board, new Cord(2,2));
        board.setPiece(k1,2,2);

        Pawn k2 = new Pawn(1,board, new Cord(3,3));
        board.setPiece(k2,3,3);

        assertFalse("Move fail", k1.move(3, 3));

        Pawn k3 = new Pawn(2,board, new Cord(3,1));
        board.setPiece(k3,3,1);

        assertTrue("Move success", k1.move(3, 1));
    }

    @Test
    public void captureTest_opponent(){
        board = new Board();
        Pawn k1 = new Pawn(2,board, new Cord(2,2));
        board.setPiece(k1,2,2);

        Pawn k2 = new Pawn(2,board, new Cord(1,3));
        board.setPiece(k2,1,3);

        assertFalse("Move fail", k1.move(1, 3));

        Pawn k3 = new Pawn(1,board, new Cord(1,1));
        board.setPiece(k3,1,1);

        assertTrue("Move success", k1.move(1, 1));
    }

}
