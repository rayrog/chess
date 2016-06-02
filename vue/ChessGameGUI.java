package vue;

import controler.ChessGameControlers;
import controler.controlerLocal.ChessGameControler;
import model.Coord;
import model.Couleur;
import model.PieceIHM;
import tools.ChessImageProvider;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.*;

/**
 * Created by benji on 01/06/2016.
 */
public class ChessGameGUI extends JFrame implements Observer, MouseMotionListener, MouseListener {

    JLayeredPane layeredPane;
    JPanel chessBoard;
    JLabel chessPiece;
    int xAdjustment;
    int yAdjustment;
    Coord pieceCoordInit;

    ChessGameControlers chessGameControlers;

    int dim;
    int decalage;

    public ChessGameGUI(String name, ChessGameControlers chessGameControler, Dimension boardSize) {
        super(name);
        this.setSize(boardSize);
        this.chessGameControlers = chessGameControler;

        createChess();
    }

    public void createChess() {
        Dimension boardSize = new Dimension(700, 700);

        //  Use a Layered Pane for this this application
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(boardSize);
        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);

        //Add a chess board to the Layered Pane

        chessBoard = new JPanel();
        layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        chessBoard.setLayout(new GridLayout(8, 8));
        chessBoard.setPreferredSize(boardSize);
        chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);

        for (int i = 0; i < 64; i++) {
            JPanel square = new JPanel(new BorderLayout());
            chessBoard.add(square);

            int row = (i / 8) % 2;
            if (row == 0)
                square.setBackground(i % 2 == 0 ? Color.black : Color.white);
            else
                square.setBackground(i % 2 == 0 ? Color.white : Color.black);
        }

        //calculer dim et decalage des cases
        dim = (int)(boardSize.getWidth() / 8);
        decalage = (int)((boardSize.getWidth() / 8.0 - dim) * (8 / 2));
    }

    public void mousePressed(MouseEvent e) {

        chessPiece = null;
        Component c = chessBoard.findComponentAt(e.getX(), e.getY());


        if (c instanceof JPanel)
            return;



        Point parentLocation = c.getParent().getLocation();

        if(!chessGameControlers.isPlayerOK(new Coord((parentLocation.x - decalage) / dim, (parentLocation.y - decalage) / dim))){
            return;
        }

        xAdjustment = parentLocation.x - e.getX();
        yAdjustment = parentLocation.y - e.getY();
        chessPiece = (JLabel) c;

        chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
        chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
        layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);


        pieceCoordInit = new Coord((chessPiece.getX() - decalage) / dim, (chessPiece.getY() - decalage) / dim);
    }

    //Move the chess piece around

    public void mouseDragged(MouseEvent me) {
        if (chessPiece == null) return;
        chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
    }

    //Drop the chess piece back onto the chess board

    public void mouseReleased(MouseEvent e) {


        if (chessPiece == null) return;
        Component c = chessBoard.findComponentAt(e.getX(), e.getY());

        //faire le move
        if (c == null || !chessGameControlers.move(pieceCoordInit, new Coord((c.getX() - decalage) / dim, (c.getY() - decalage) / dim))) {
            //si le move n'est pas faisable
            chessPiece.setLocation((pieceCoordInit.x * dim) + decalage, (pieceCoordInit.y * dim) + decalage);
            c = chessBoard.findComponentAt((pieceCoordInit.x * dim) + decalage, (pieceCoordInit.y * dim) + decalage);
        }


        chessPiece.setVisible(false);
        if (c instanceof JLabel) {
            Container parent = c.getParent();
            parent.remove(0);
            parent.add(chessPiece);
        }
        else {
            Container parent = (Container) c;
            parent.add(chessPiece);
        }
        chessPiece.setVisible(true);
}


    @Override
    public void update(Observable o, Object arg) {
        //clear tout
        for (Component c : chessBoard.getComponents()) {
            JPanel a = (JPanel)c;
            a.removeAll();
        }

        //dessiner les pièces
        List<PieceIHM> piecesIHM = (List<PieceIHM>) arg;

        for (PieceIHM pieceIHM : piecesIHM) {
            int componentNumber = pieceIHM.getY() * 8 + pieceIHM.getX();
            JLabel piece = new JLabel(new ImageIcon(ChessImageProvider.getImageFile(pieceIHM.getNamePiece(), pieceIHM.getCouleur())));
            JPanel panel = (JPanel) chessBoard.getComponent(componentNumber);
            panel.add(piece);
        }

        this.revalidate();
        this.repaint();
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }


    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
