package model;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tools.*;

public class Jeu implements Game{
	List<Pieces> equipe;
	Map<Coord, Pieces> map = new HashMap<>();
	private Couleur couleur;
	
	public Jeu(Couleur couleur){
		this.equipe=ChessPiecesFactory.newPieces(couleur);
		this.couleur = couleur;
		/* COnvertit ma liste en map pour raccourcir les temps d'accès*/
		for(Pieces p1 : equipe ){
			map.put(new Coord(p1.getX(),p1.getY()),p1);
		}
	}
	
	public boolean isPieceHere(int x,int y){

		Coord coord = new Coord(x, y);		//Conversion des parametres en coordonnées

		if (map.containsKey(coord)){
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isMoveOk(int xInit,int yInit,int xFinal,int yFinal,boolean isCatchOk,boolean isCastlingPossible){
		Coord coord = new Coord(xInit, yInit);
		if (map.containsKey(coord)){
			map.get(coord).isMoveOk(xFinal, yFinal, isCatchOk, isCastlingPossible); //Piece
		}
		return true;
	}
	
	public boolean move(int xInit,int yInit,int xFinal,int yFinal){
		boolean isCatchOk = true, isCastlingPossible = true;
		Coord coord = new Coord(xInit, yInit);
		Pieces piece = map.get(coord);
		if(isMoveOk(xInit,yInit,xFinal,yFinal,isCatchOk,isCastlingPossible)){
			piece.move(xFinal, yFinal);
			map.remove(coord);
			Coord newCoord = new Coord(xFinal, yFinal);
			map.put(newCoord, piece);
			return true;
		}else{
			return false;

		}
	}
	
	
	public void setPossibleCapture(){
		
	}
	
	
	public boolean capture(int xCatch,int yCatch){
		return false;}

	
	@Override
	public String toString() {
		return "Jeu [equipe=" + equipe + "]";
	}
	
	public Couleur getPieceColor(int x,int y){
		Coord coord = new Coord(x, y);
		if (map.containsKey(coord)){
			Pieces piece = map.get(coord);
			return piece.getCouleur();
		}
		else{
			return null;
		}
	}
		
	public java.lang.String getPieceName(int x,int y){
		Coord coord = new Coord(x, y);
		if (map.containsKey(coord)){
			Pieces piece = map.get(coord);
			return piece.getClass().getSimpleName();
		}
		else{
			return null;
		}
	}

	public Couleur getCouleur(){
		return this.couleur;
	}
	
	//Option payante (Voir nos tarifs sur www.tarifs.fr)
	public void setCastling(){
	}
	
	public java.util.List<PieceIHMs> getPiecesIHM(){
		
		return null;
		
	}
}