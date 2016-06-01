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
		return "tmp";
	}
	
	@Override
	public int getX() {
		
		return 0;
	}

	@Override
	public int getY() {
		
		return 0;
	}

	@Override
	public Couleur getCouleur() {

		return null;
	}

	@Override
	public String getName() {
	
		return null;
	}

	@Override
	public abstract boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible);

	@Override
	public boolean move(int xFinal, int yFinal) {
		return false;
	}

	@Override
	public boolean capture() {

		return false;
	}
	
	public void main(){
		Pieces maTour = new Tour(Couleur.NOIR, new Coord(0, 0));
	}
	
	
}

