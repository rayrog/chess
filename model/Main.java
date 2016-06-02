package model;

import java.util.List;
import java.util.Scanner;


//import tools.ChessPiecePos;

public class Main{

	public static void main(String[] args) {
																					// CREATION DES OBJETS
		/* Création d'échiquier */
		// Conseillé, pratiue si on veut simuler une partie
		Echiquier echiquier1 = new Echiquier();
		
		/* Création de jeu */ 
		//Une équipe suffit
		Jeu equipeNoire = new Jeu(Couleur.NOIR);
		Jeu equipeBlanc = new Jeu(Couleur.BLANC);
		
		/* Création de Piece */ 
		//On crée toutes les pièces à la même position pour faciliter les tests
		Pieces tourBlanche = new Tour(Couleur.BLANC, new Coord(3,3));
		Pieces reineBlanche = new Reine(Couleur.BLANC, new Coord(3,3));
		Pieces roiBlanc= new Roi(Couleur.BLANC, new Coord(3,3));
		Pieces pionBlanc = new Pion(Couleur.BLANC, new Coord(3,6));
		Pieces fouBlanc = new Fou(Couleur.BLANC, new Coord(3,3));
		Pieces chevalBlanc = new Cavalier(Couleur.BLANC, new Coord(3,3));
		
																					// TEST DES CLASSES
		/*  Test Piece
 		
		System.out.println("Test tour :");
		testPiece(tourBlanche1);

		System.out.println("Test Reine :");
		testPiece(reineBlanche);	

		System.out.println("Test Roi :");
		testPiece(roiBlanc);		
		
		System.out.println("Test Pion :");
		testPiece(pionBlanc);

		System.out.println("Test Fou :");
		testPiece(fouBlanc);

		System.out.println("Test Cheval :");
		testPiece(chevalBlanc);	
		
		 */
		
		/* Test Jeu
		System.out.println(equipeNoire);
		equipeNoire.move(5, 1, 5, 2);
		equipeNoire.isPieceHere(5, 2);
		equipeNoire.getPieceColor(7,0);
		System.out.println(equipeNoire.getPieceName(7,1));
		Couleur C1= equipeNoire.getCouleur();
		System.out.println(C1);
		List<PieceIHMs> L1=equipeNoire.getPiecesIHM();
		System.out.println(L1);
		*/
		
		/* Test de Echiquier
		List<PieceIHMs> L1=echiquier1.getPiecesIHM();
		System.out.println(L1);
				
		Couleur C1 = echiquier1.getPieceColor(2,7);
		System.out.println(C1);
		
		
		Couleur C2 =echiquier1.getColorCurrentPlayer();
		System.out.println(C2);
		
		System.out.println(echiquier1.getMessage());
		
		System.out.println(echiquier1);
		
		
		Couleur C2 =echiquier1.getColorCurrentPlayer();
		System.out.println(C2);
		echiquier1.switchJoueur();
		C2 =echiquier1.getColorCurrentPlayer();
		System.out.println(C2);
		
		Boolean a;
		echiquier1.switchJoueur();// switch equipe noir pour faciliter debug
		a=echiquier1.isMoveOk(0,0,1,5);
		System.out.println(a);
		echiquier1.move(0,0,1,5);
		System.out.println(L1);

		*/
		
																										// TEST EN COURS !!!
		System.out.println(pionBlanc.isMoveOk(3, 4, true, true));
		System.out.println(equipeBlanc.isMoveOk(3, 6, 3, 4,true,true));
		//System.out.println(echiquier1.move(0, 6, 0, 4));
		
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
			System.out.println("Mouvement impossible ! \n");
			//xFinal =99;
		}
		
		}while(xFinal != 99);
	}

}
