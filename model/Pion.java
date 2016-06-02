package model;

public class Pion extends AbstractPiece
{
	private boolean hasMoved = false;
	
	public boolean HasMoved() {
		return hasMoved;
	}

	private void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}

	public Pion(Couleur couleur, Coord coord) {
		super(couleur, coord);
	}

	public boolean isMoveOk(int xFinal,int yFinal,boolean isCatchOk,boolean isCastlingPossible)
	{
		// sait ou elle est , a ses coordonn�, et coordonn� de destination donn�
		if (yFinal - this.getY() == 1 && xFinal == this.getX()) { //On avance d'une case
			return true;
		} else if(yFinal - this.getY() == 2 && xFinal == this.getX()){ //Deplacement de deux cases
			if(!this.hasMoved){//Si le pion n'a pas bouger de sa position de depart
				this.setHasMoved(true);
				return true;
			}else
				return false;
		} 
		return false;
	}

	
	public boolean move(int xFinal, int yFinal) { //Juste pour mettre le flag hasMoved a true
		super.move(xFinal, yFinal);
		this.hasMoved = true;
		return true;
	}
}
