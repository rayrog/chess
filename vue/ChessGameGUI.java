package vue;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

import controler.ChessGameControlers;
import model.Couleur;
import model.PieceIHM;
import tools.ChessImageProvider;

public class ChessGameGUI extends javax.swing.JFrame implements java.awt.event.MouseListener, java.awt.event.MouseMotionListener, java.util.Observer
{
		JLayeredPane layeredPane;
		JPanel chessBoard;
		JLabel chessPiece;
		int xAdjustment;
		int yAdjustment;
		public ChessGameGUI(){
			Dimension boardSize = new Dimension(600, 600);

			//  Use a Layered Pane for this this application
			layeredPane = new JLayeredPane();
			getContentPane().add(layeredPane);
			layeredPane.setPreferredSize(boardSize);
			layeredPane.addMouseListener(this);
			layeredPane.addMouseMotionListener(this);

			//Add a chess board to the Layered Pane 

			chessBoard = new JPanel();
			layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
			chessBoard.setLayout( new GridLayout(8, 8) );
			chessBoard.setPreferredSize( boardSize );
			chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);

			for (int i = 0; i < 64; i++) {
				JPanel square = new JPanel( new BorderLayout() );
				chessBoard.add( square );

				int row = (i / 8) % 2;
				if (row == 0)
					square.setBackground( i % 2 == 0 ? Color.blue : Color.white );
				else
					square.setBackground( i % 2 == 0 ? Color.white : Color.blue );
			}
			

		}
	
	@Override
	public void update(Observable arg0, Object arg1) {

		List<PieceIHM> piecesIHM = (List<PieceIHM>) arg1;

		JLabel newPiece;
				
		// création d'un tableau 2D avec les noms des pièces
		for(PieceIHM p: piecesIHM) {
			int i = p.getY()*8+ p.getX();
			JPanel panel = (JPanel)chessBoard.getComponent(i);
			newPiece = new JLabel( new ImageIcon(ChessImageProvider.getImageFile(p.getNamePiece(), p.getCouleur())));
			panel.add(newPiece);
		}
		
	}

	 public void mousePressed(MouseEvent e){
		  chessPiece = null;
		  Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
		 
		  if (c instanceof JPanel) 
		  return;
		 
		  Point parentLocation = c.getParent().getLocation();
		  xAdjustment = parentLocation.x - e.getX();
		  yAdjustment = parentLocation.y - e.getY();
		  chessPiece = (JLabel)c;
		  chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
		  chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
		  layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
		  }
		 
		  //Move the chess piece around
		  
		  public void mouseDragged(MouseEvent me) {
		  if (chessPiece == null) return;
		 chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
		 }
		 
		  //Drop the chess piece back onto the chess board
		 
		  public void mouseReleased(MouseEvent e) {
		  if(chessPiece == null) return;
		 
		  chessPiece.setVisible(false);
		  Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
		 
		  if (c instanceof JLabel){
		  Container parent = c.getParent();
		  parent.remove(0);
		  parent.add( chessPiece );
		  }
		  else {
		  Container parent = (Container)c;
		  parent.add( chessPiece );
		  }
		 
		  chessPiece.setVisible(true);
		  }
		 
		  public void mouseClicked(MouseEvent e) {
		  
		  }
		  public void mouseMoved(MouseEvent e) {
		 }
		  public void mouseEntered(MouseEvent e){
		  
		  }
		  public void mouseExited(MouseEvent e) {
		  
		  }
}
