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

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
