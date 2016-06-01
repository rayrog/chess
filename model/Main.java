package model;

import java.util.Scanner;


//import tools.ChessPiecePos;

public class Main{

	public static void main(String[] args) {
/* TEST CREATION PIECE + DEPLACEMENTS POSSIBLES
 		
		System.out.println("Test tour :");
		Pieces tourBlanche1 = new Tour(Couleur.BLANC, new Coord(3,3));
		testPiece(tourBlanche1);

		System.out.println("Test Reine :");
		Pieces reineBlanche = new Reine(Couleur.BLANC, new Coord(3,3));
		testPiece(reineBlanche);	

		System.out.println("Test Roi :");
		Pieces roiBlanc= new Roi(Couleur.BLANC, new Coord(3,3));
		testPiece(roiBlanc);		
		System.out.println("Test Pion :");
		Pieces pionBlanc = new Pion(Couleur.BLANC, new Coord(3,1));
		testPiece(pionBlanc);

		System.out.println("Test Fou :");
		Pieces fouBlanc = new Fou(Couleur.BLANC, new Coord(3,1));
		testPiece(fouBlanc);

		System.out.println("Test Cheval :");
		Pieces chevalBlanc = new Cheval(Couleur.BLANC, new Coord(3,1));
		testPiece(chevalBlanc);	
		
*/
		
		Jeu equipeNoire = new Jeu(Couleur.NOIR);
		//System.out.println(equipeNoire);
		//equipeNoire.getPieceColor(7,0);
		System.out.println(equipeNoire.getPieceName(7,1));
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
			xFinal =99;
		}
		
		}while(xFinal != 99);
	}

}
