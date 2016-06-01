package model;
public class Tour extends AbstractPiece
{

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

}
