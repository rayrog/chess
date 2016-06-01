package model;
public class Tour extends AbstractPiece
{	
	private boolean hasMoved = false;

	public Tour(Couleur couleur, Coord coord) {
		super(couleur, coord);
	}

	public boolean isMoveOk(int xFinal,int yFinal,boolean isCatchOk,boolean isCastlingPossible)
	{
		// sait ou elle est , a ses coordonn�, et coordonn� de destination donn�
		if (this.getX() == xFinal || this.getY() == yFinal){
			return true;
		}
		else {
			return false;		
		}
	}
	
	public boolean move(int xFinal, int yFinal) {
		super.move(xFinal, yFinal);
		this.hasMoved = true;
		return true;
	}
	

	public boolean HasMoved() {
		return hasMoved;
	}
}
