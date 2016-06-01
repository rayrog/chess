package model;

import java.util.Scanner;


//import tools.ChessPiecePos;

public class Main{

	public static void main(String[] args) {
		//Pieces tourBlanche1 = new Tour(Couleur.BLANC, new Coord(1,1));
		//testPiece(tourBlanche1);
		
		Pieces reineBlanche = new Reine(Couleur.BLANC, new Coord(3,1));
		testPiece(reineBlanche);
		
	}
	
	public static void testPiece(Pieces piece){
		
		Scanner sc = new Scanner(System.in);
		Boolean isCatchOk = true, isCastlingPossible = true;
		
		int xFinal, yFinal;
		do{
			
		   xFinal = sc.nextInt();
		   yFinal = sc.nextInt();

		if(piece.isMoveOk(xFinal, yFinal, isCatchOk, isCastlingPossible)){
			piece.move(xFinal, yFinal);
			System.out.println("Après mouvement " + piece);
		} else {
			System.out.println("Mouvement impossible gros con ! \n");
		}
		
		}while(xFinal != 99);
		
		
		
		
		
	}

}
