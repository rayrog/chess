package model;
public class Tour extends AbstractPiece
{	
	private boolean hasMoved = false;

	public Tour(Couleur couleur, Coord coord) {
		super(couleur, coord);
	}

	public boolean isMoveOk(int xFinal,int yFinal,boolean isCatchOk,boolean isCastlingPossible)
	{
		if (this.getX() == xFinal ^ this.getY() == yFinal){ //Si l'on bouge soit selon l'axe x, ou l'axe y
			return true;
		}
		else {
			return false;		
		}
	}
	
	public boolean move(int xFinal, int yFinal) { //Juste pour mettre le flag hasMoved a true
		super.move(xFinal, yFinal);
		this.hasMoved = true;
		return true;
	}
	

	public boolean HasMoved() {
		return hasMoved;
	}
}
