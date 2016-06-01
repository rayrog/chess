package model;

public class Pion extends AbstractPiece
{

	public Pion(Couleur couleur, Coord coord) {
		super(couleur, coord);
	}

	public boolean isMoveOk(int xFinal,int yFinal,boolean isCatchOk,boolean isCastlingPossible)
	{
		// sait ou elle est , a ses coordonn�, et coordonn� de destination donn�
		if ( ((xFinal - this.getX() == 0 || xFinal - this.getX() == 1 ) && yFinal - this.getY() == 0) || (xFinal == this.getX() && yFinal == this.getY())   ){
			return true;
		}
		else {
			return false;		
		}
	}

}
