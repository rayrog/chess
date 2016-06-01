package model;

public class Echiquier {
	
	private Jeu equipeNoire, equipeBlanc, joueurCourant ;
	private String message = "";
	

	public Echiquier(Jeu equipe1, Jeu equipe2, Jeu joueurCourant){
		this.equipeNoire = equipe1;
		this.equipeBlanc = equipe2;
		this.joueurCourant = equipe2; // Les blancs commencent ;)
	}
	

	private void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage(){
		return message;
	}

	@Override
	public String toString() {
		return "Echiquier [equipeNoire=" + equipeNoire.toString() + ", \n equipeBlanc=" + equipeBlanc.toString() + "]";
	}
	
	public void switchJoueur(){
		if(this.joueurCourant == equipeNoire ){
			this.joueurCourant = equipeBlanc;
		} else {
			this.joueurCourant = equipeNoire;
		}
	}
	
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal){
		boolean isCatchOk=true, isCastlingPossible=true;
		Coord coord = new Coord(xInit, yInit);
		if (this.joueurCourant.map.containsKey(coord)){
			this.joueurCourant.isMoveOk(xFinal, yFinal, isCatchOk, isCastlingPossible); 
		}
		return true;
	}
	public boolean move (int xInit, int yInit, int xFinal, int yFinal){
		return false;
	}

	/**
	 * @return true si c'est la fin du jeu
	 */
	public boolean isEnd(){
		return true;
	}

	/**
	 * @return la couleur du joueur courant
	 */
	public Couleur getColorCurrentPlayer(){
		return null;
	}
	
	/**
	 * @param x
	 * @param y
	 * @return la couleur de la pièce sélectionnée
	 */
	public Couleur getPieceColor(int x, int y){
		return null;
	}

}

