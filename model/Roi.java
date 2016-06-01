package model;


public class Roi extends AbstractPiece
{

	public Roi(Couleur couleur, Coord coord) {
		super(couleur, coord);
	}

	public boolean isMoveOk(int xFinal,int yFinal,boolean isCatchOk,boolean isCastlingPossible)
	{
		// sait ou elle est , a ses coordonn�, et coordonn� de destination donn�
		if ((xFinal <= (this.getX()-1) && xFinal >= (this.getX()+1))||(yFinal <= (this.getY()-1) && yFinal >= (this.getY()+1))){
			return true;
		}
		else {
			return false;		
		}
	}


	
}
