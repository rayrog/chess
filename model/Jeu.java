package model;
import java.util.List;

import tools.*;

public class Jeu 
	{
	List<Pieces> piecesBlanche;
	List<Pieces> piecesNoir;
	
	public Jeu(Couleur couleur){
		this.piecesNoir=ChessPiecesFactory.newPieces(Couleur.NOIR);
		this.piecesBlanche=ChessPiecesFactory.newPieces(Couleur.BLANC);
	}
	
	public boolean isPieceHere(int x,int y){

		
		return true;
	}

	public boolean isMoveOk(int xInit,int yInit,int xFinal,int yFinal,boolean isCatchOk,boolean isCastlingPossible){
		return true;

	}
	
	public boolean move(int xInit,int yInit,int xFinal,int yFinal)
		{
		return false;
		}
	
	
	public void setPossibleCapture(){}
	
	
	public boolean capture(int xCatch,int yCatch){
		return false;}

	
	public java.lang.String toString(){
		return null;}
	
	public Couleur getPieceColor(int x,int y){
		return null;}
		
	public java.lang.String getPieceName(int x,int y){
		return null;}
	
	public Couleur getCouleur(){
		return null;}
	
	public void setCastling(){}
	
	public java.util.List<PieceIHMs> getPiecesIHM(){
		return null;
		
	}

	public static void main(java.lang.String[] args){}
}