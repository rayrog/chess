package model;

public interface Pieces {
	public int getX();	//Returns:	indice de la colonne ou est positionnée la piece
	public int getY(); //Returns:	indice de la ligne ou est positionnée la piece
	public Couleur getCouleur();//	return couleur de la piece
	public java.lang.String getName(); //le nom de la pièce (Tour, Cavalier, etc.) attention le type ne correspond pas forcément au nom de la classe
	public boolean isMoveOk(int xFinal,int yFinal, boolean isCatchOk,boolean isCastlingPossible);//Returns:	true si déplacement légal en fonction des algo de déplacement spécifique de chaque pièce
	public boolean move(int xFinal,int yFinal);
	public boolean capture();
}