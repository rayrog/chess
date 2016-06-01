package model;

//import tools.ChessPiecePos;

public class Main{

	public static void main(String[] args) {
		Pieces tourBlanche1 = new Tour(Couleur.BLANC, new Coord(1,1));
		testPiece(tourBlanche1);
		
	}
	
	public static void testPiece(Pieces piece){

		int xFinal = 1, yFinal = 2 ;
		Boolean isCatchOk = true, isCastlingPossible = true;

		
		if(piece.isMoveOk(xFinal, yFinal, isCatchOk, isCastlingPossible)){
			piece.move(xFinal, yFinal);
			System.out.println("Après mouvement " + piece);
		} else {
			System.out.println("Mouvement impossible gros con !");
		}
				
	}

}
