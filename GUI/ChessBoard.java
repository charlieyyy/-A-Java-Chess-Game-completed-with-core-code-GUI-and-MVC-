package GUI;

import Game.gamingBoard;
import Game.Piece;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;


public class ChessBoard {


    private final JFrame boardFrame;
    private final JPanel chessPanel;
    private final JPanel scorePanel;
    private List<JButton> tiles;

    public static gamingBoard gamePiece;
    private MouseListener click;
    private JMenuBar menuBar;



    private int score_player;
    private int score_opponent;


    /*
    The GUI constructor
     */

    public ChessBoard() {

        boardFrame = new JFrame("chessBoard");
        chessPanel = new JPanel();
        scorePanel = new JPanel();
        tiles = new ArrayList<JButton>();


        gamePiece = new gamingBoard();

        menuBar = new JMenuBar();
        createMenu(menuBar);
        boardFrame.setJMenuBar(menuBar);

        click = new clickMovement();

        // Color of chess board this you can change accordingly like red or white
        Color blackColor = Color.gray;
        Color whiteColor = Color.WHITE;

        JButton chessButton;

        for (int i = 0; i < 8; i++) {
            // swapping the color when adding the next row

            Color temp = blackColor;
            blackColor = whiteColor;
            whiteColor = temp;

            for ( int j =0; j<8;j++) {

                if (j % 2 == 0) {
                    // Adding color based on the odd and even initially.

                    chessButton = new JButton();

                    chessButton.setContentAreaFilled(false);
                    chessButton.setOpaque(true);
                    chessButton.setBorderPainted(false);

                    chessButton.setBackground(blackColor);
                    if(gamePiece.getPiece(i,j)!=null) {
                        addImage(chessButton, gamePiece.getPiece(7-i, j));
                    }

                    chessButton.addMouseListener(click);
                    chessPanel.add(chessButton);
                    tiles.add(chessButton);
                    chessButton.setVisible(true);

                } else {

                    chessButton = new JButton();

                    chessButton.setContentAreaFilled(false);
                    chessButton.setOpaque(true);
                    chessButton.setBorderPainted(false);

                    chessButton.setBackground(whiteColor);

                    if(gamePiece.getPiece(i,j)!=null) {
                        addImage(chessButton, gamePiece.getPiece(7-i, j));
                    }

                    chessButton.addMouseListener(click);
                    chessPanel.add(chessButton);
                    tiles.add(chessButton);
                    chessButton.setVisible(true);
                }

            }

        }



        chessPanel.setLayout(new GridLayout(8, 18));
        // GridLayout will arrange elements in Grid Manager 8 X 8

        chessPanel.setSize(650, 650);
        scorePanel.setSize(150, 650);

        JLabel player1 = new JLabel("Charlie Score : ");
        JLabel player2 = new JLabel("Dutch Woman Score : ");
        player1.setFont(new Font("Serif", Font.BOLD, 15));
        player2.setFont(new Font("Serif", Font.BOLD, 15));

        scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.PAGE_AXIS));
        scorePanel.add(player1);
        scorePanel.add(Box.createRigidArea(new Dimension(100,500)));
        scorePanel.add(player2);
        scorePanel.setBackground(Color.lightGray);

        boardFrame.setSize(800, 650);
        boardFrame.getContentPane().setLayout(new BorderLayout());
        boardFrame.add(chessPanel,BorderLayout.WEST);
        boardFrame.add(scorePanel,BorderLayout.EAST);

        // Setting the title of board
        boardFrame.setTitle("chessBoard");

        // Size of the chess board
        boardFrame.setVisible(true);

    }

    /*
    add piece image to jbuttons
     */

    public void addImage(JButton button,Piece p){
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

    /*
    create the menu
     */
    public void createMenu(JMenuBar m){
        final JMenu menu = new JMenu("Menu");
        final JMenuItem restart = new JMenuItem("Restart");
        final JMenuItem forfeit = new JMenuItem("Forfeit");
        final JMenuItem undo = new JMenuItem("Undo");
        final JMenuItem specialMode = new JMenuItem("Special Mode");

        menu.add(restart);
        menu.add(forfeit);
        menu.add(undo);
        menu.add(specialMode);

        restart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boardFrame.setVisible(false);
                ChessBoard newGame = new ChessBoard();
            }
        });

        forfeit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boardFrame.setVisible(false);
                ChessBoard newGame = new ChessBoard();
            }
        });

        undo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gamePiece.getBoard().undoMethod();
                clickMovement.lastAdd.setIcon(null);

                addImage(clickMovement.oldButton, gamePiece.getBoard().getLastUpdate());
            }
        });

        specialMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                boardFrame.setVisible(false);

                ChessBoard newGame = new ChessBoard();
                gamePiece.specialMode(gamePiece);

            }
        });


        m.add(menu);
    }



}
