package model;

public abstract class AbstractPiece extends java.lang.Object implements Pieces{
	
	private Couleur Couleur;
	private Coord Coord;

	public AbstractPiece(Couleur couleur,Coord coord)
	{
		this.Couleur=couleur;
		this.Coord=coord;
	}
	
	@Override
	public java.lang.String toString(){
		return "Nom= " + getName() + "couleur " + getCouleur() + "Coord : X = " + getX() + ", Y = " + getY() + "]";
	}
	
	@Override
	
	public int getX() {
		return this.Coord.x;
	}

	@Override
	public int getY() {
		return this.Coord.y;
	}

	@Override
	public Couleur getCouleur() {
		return this.Couleur;
	}

	@Override
	public String getName(){
		return this.getClass().getSimpleName();
	}

	@Override
	public abstract boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible);

	@Override
	public boolean move(int xFinal, int yFinal) {
		this.Coord.x=xFinal;
		this.Coord.y=yFinal;
		return true;
	}

	@Override
	public boolean capture() {
		this.Coord.y=-1;
		this.Coord.x=-1;
		return true;
	}
		
}

