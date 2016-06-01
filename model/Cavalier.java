package model;

public class Cavalier extends AbstractPiece
{

	public Cavalier(Couleur couleur, Coord coord) {
		super(couleur, coord);
	}

	public boolean isMoveOk(int xFinal,int yFinal,boolean isCatchOk,boolean isCastlingPossible)
	{
		// sait ou elle est , a ses coordonn�, et coordonn� de destination donn�
		if ( (Math.pow((xFinal - this.getX()), 2) + Math.pow((yFinal - this.getY()), 2) == 5) || (xFinal == this.getX() && yFinal == this.getY())){
			return true;
		}
		else {
			return false;		
		}
	}

}