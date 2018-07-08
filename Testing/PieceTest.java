package Testing;

import Game.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class PieceTest {


    Board board;
    @Test
    public void BoundaryTest() {
        board = new Board();

        Rook r1 = new Rook(1, board,new Cord(3, 3));
        board.setPiece(r1,3,3);

        assertFalse("Move fail", r1.move(8, 3));
        assertFalse("Move fail", r1.move(3, 8));
    }

    @Test
    public void EmptyTest() {
        board = new Board();

        Piece testPiece = board.getPiece(5,5);
        assertNull("Piece is null", testPiece);

    }

    @Test
    public void updateTest(){

        board = new Board();

        Bishop b1 = new Bishop(1, board,new Cord(3, 3));
        board.setPiece(b1,3,3);

        assertTrue("Move success", b1.move(5, 5));
        board.updateCord(b1,5,5);



        int curRank = b1.getCrd().getRank();
        int curFile = b1.getCrd().getFile();
        //System.out.print(curRank);
        //System.out.print(curFile);

        assertTrue("coordinates match",curRank==5);
        assertTrue("coordinates match",curFile==5);
    }


}
