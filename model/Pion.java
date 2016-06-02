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
		boolean bool =false;
		if (Math.abs(yFinal - this.getY()) == 1 && xFinal == this.getX()) { //On avance d'une case
			bool = true;
		} else if(Math.abs(yFinal - this.getY()) == 2 && xFinal == this.getX()){ //Deplacement de deux cases 
			if(!this.hasMoved){//Si le pion n'a pas bouger de sa position de depart
				bool = true;
			}else
				bool = false;
		} 
		return bool;
	}

	
	public boolean move(int xFinal, int yFinal) { //Juste pour mettre le flag hasMoved a true
		if(super.move(xFinal, yFinal))
			this.hasMoved = true;
		return true;
	}
}
