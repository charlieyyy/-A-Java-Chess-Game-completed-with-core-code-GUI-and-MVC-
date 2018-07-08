package Testing;

import Game.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void initTest(){
        Board gameBoard = new Board();

        assertNull("Piece is not null",gameBoard.getPiece(0,4));

        gamingBoard log = new gamingBoard();
        assertNotNull("Piece is not null",log.getPiece(0,4));

        System.out.print("player 1");
        System.out.print(log.getPiece(0,4).getPlr());

        assertTrue("Player 1 ",log.getPiece(0,4).getPlr()==1);
        assertTrue("Player 2 ",log.getPiece(7,4).getPlr()==2);

    }

    @Test
    public void undoTest(){
        Board gameBoard = new Board();


        gamingBoard log = new gamingBoard();
        assertNotNull("Piece is not null",log.getPiece(1,4));

        log.getBoard().updateCord(log.getPiece(1,4),1,5);
        log.getBoard().undoMethod();

        assertNotNull("Piece is not null",log.getPiece(1,4));
    }

    @Test
    public void specialTest(){

        gamingBoard log = new gamingBoard();
        assertNotNull("Piece is not null",log.getPiece(0,7));

        log.specialMode(log);

        System.out.println("    " + log.getPiece(0,7).getClass().getName());

        assertTrue("leapRook ", log.getPiece(0,7).getClass().getSimpleName().equals("leapRook"));


    }
}
