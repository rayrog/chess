package model;


public class Roi extends AbstractPiece
{
	private boolean hasMoved = false;
	
	public Roi(Couleur couleur, Coord coord) {
		super(couleur, coord);
	}

	public boolean isMoveOk(int xFinal,int yFinal,boolean isCatchOk,boolean isCastlingPossible)
	{
		// sait ou elle est , a ses coordonn�, et coordonn� de destination donn�

		if ((Math.pow((xFinal - this.getX()), 2) == 1 && yFinal - this.getY() == 0) || Math.pow((yFinal - this.getY()), 2) == 1 && xFinal - this.getX() == 0 ){
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
