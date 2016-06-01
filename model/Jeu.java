package model;
import java.util.List;

import tools.*;

public class Jeu implements Game{
	List<Pieces> equipe;
	
	public Jeu(Couleur couleur){
		this.equipe=ChessPiecesFactory.newPieces(couleur);
	}
	
	public boolean isPieceHere(int x,int y){
		boolean result=false;
		for (Pieces p1 : equipe){
			if (p1.getX()==x && p1.getY()==y && this==p1)
			{
				result=true;
			}
		}
		return result;
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

	public static void main(java.lang.String[] args){

	}
}