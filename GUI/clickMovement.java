package GUI;

    /*
    catch the action click on the jbuttons on the board
     */

import Game.Piece;
import Game.gamingBoard;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class clickMovement implements MouseListener {

    private int lastMove = 0;
    private int curTurn = 1;

    public static JButton oldButton;

    private boolean first = false;
    private int curRank;
    private int curFile;
    private int newRank;
    private int newFile;

    public static JButton lastAdd;

    @Override
    public void mouseClicked(MouseEvent e) {

        JButton selectedButton = (JButton) e.getSource();
        int x = realX(selectedButton.getX());
        int y = realY(selectedButton.getY());


        // System.out.println(y);
        // System.out.println(x);

        if (ChessBoard.gamePiece.getPiece(y, x) == null && first == false) {

            return;
        }


        if (ChessBoard.gamePiece.getPiece(y, x) != null && e.getClickCount() == 1) {

                turnWarning(ChessBoard.gamePiece.getPiece(y, x).getPlr());

                //System.out.println("single click");

                oldButton = selectedButton;
                curRank = y;
                curFile = x;

                first = true;


        }

        if (e.getClickCount() == 2) {

            //System.out.println("double click");

            newRank = y;
            newFile = x;

            if( (ChessBoard.gamePiece.getPiece(newRank, newFile)!= null)
                    && (ChessBoard.gamePiece.getPiece(curRank, curFile).getClass().getSimpleName()).equals("Pawn") )
            {
                    pawnCapture(curRank,curFile,newRank,newFile,selectedButton);
                    System.out.println("capturing");
                    return;

            }

            if (ChessBoard.gamePiece.getPiece(curRank, curFile).move(newRank, newFile)){

                oldButton.setIcon(null);
                addImage(selectedButton, ChessBoard.gamePiece.getPiece(curRank, curFile));
                lastMove = ChessBoard.gamePiece.getPiece(curRank, curFile).getPlr();

                lastAdd = selectedButton;

                ChessBoard.gamePiece.getBoard().updateCord(ChessBoard.gamePiece.getPiece(curRank, curFile), newRank, newFile);

            }else{
                JOptionPane.showMessageDialog(null, "illegal move");
            }

        }


    }


    /*
    determine the right turn for players. Start with 0 and first sets to 1.
     */

    public int getTurn(int a) {

        if (a == 0) {
            return 1;
        } else if (a == 2) {
            return 1;
        } else {
            return 2;
        }

    }

    /*
    lastmove records last moving piece belongs to which player. It makes sure player take turns.
     */
    public void turnWarning(int clicked ) {

        if(getTurn(lastMove)!= clicked) {
            JOptionPane.showMessageDialog(null, "it is not your piece");
        }

    }

    public void pawnCapture(int curRank,int curFile,int newRank, int newFile,JButton selectedButton){
        System.out.println("capturing");
        boolean cap = ChessBoard.gamePiece.getPiece(curRank, curFile).move(newRank, newFile);

        if (cap) {
            oldButton.setIcon(null);
            selectedButton.setIcon(null);

            addImage(selectedButton, ChessBoard.gamePiece.getPiece(curRank, curFile));

        } else {
            JOptionPane.showMessageDialog(null, "illegal move");
        }
    }
    /*
    Notes:
    file 1/ xcoords: 76 in Jframe
    rank 1/ ycoords: 75 in Jframe
    System.out.println(x);
    System.out.println(y);
     */
    public int realX(int x){
        return x/76;
    }

    public int realY(int y){
        return 7-(y/75);
    }


        /*
    add piece image to jbuttons
     */

    public void addImage(JButton button, Piece p){
        try {
            BufferedImage img = ImageIO.read(getClass().getResource(getImageName(p)));
            button.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /*
    get the filename of the images for different pieces
     */

    public String getImageName(Piece p){

        String pieceType = p.getClass().getSimpleName();
        String prefix = "";

        if (p.getPlr()==1) {
            prefix = "Player";
        }

        if(p.getPlr()==2){
            prefix = "Opponent";
        }

        String ret = "../Images/" + prefix + "_" + pieceType + ".png";

        return ret;
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
