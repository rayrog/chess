package model;

import java.util.LinkedList;
import java.util.List;

public class Echiquier {
	
	private Jeu equipeNoire, equipeBlanc, joueurCourant ;
	private String message = "Message par d�faut";
	

	public Echiquier(){
		Jeu equipe1 = new Jeu(Couleur.NOIR);
		Jeu equipe2 = new Jeu(Couleur.BLANC);
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
		
		if (xFinal != xInit || yFinal != yInit){
			this.joueurCourant.isMoveOk(xInit, yInit, xFinal, yFinal, isCatchOk, isCastlingPossible);
			return true;
		} 
		return false;
	}
	public boolean move (int xInit, int yInit, int xFinal, int yFinal){
		if (this.isMoveOk(xInit, yInit, xFinal, yFinal)){
			this.joueurCourant.move(xInit, yInit, xFinal, yFinal);
			return true;
		}
		return false;
	}

	/**
	 * @return true si c'est la fin du jeu
	 */
	public boolean isEnd(){
		return false;
	}

	/**
	 * @return la couleur du joueur courant
	 */
	public Couleur getColorCurrentPlayer(){
		return this.joueurCourant.getCouleur();
	}
	
	/**
	 * @param x
	 * @param y
	 * @return la couleur de la pièce sélectionnée
	 */
	public Couleur getPieceColor(int x, int y){
		Coord coord = new Coord(x, y);
		if(this.equipeNoire.map.containsKey(coord)){
			return this.equipeNoire.map.get(coord).getCouleur();
		}
		else if (this.equipeBlanc.map.containsKey(coord)){
			return this.equipeBlanc.map.get(coord).getCouleur();
		}
		return Couleur.NOIRBLANC;
	}
	
	
	public List<PieceIHMs> getPiecesIHM(){		
		List<PieceIHMs> L1=equipeNoire.getPiecesIHM();
		List<PieceIHMs> L2=equipeBlanc.getPiecesIHM();
		List<PieceIHMs> list = new LinkedList<PieceIHMs>();
		list.addAll(L1);
		list.addAll(L2);
		return list;
	}

}

