package com.dq.entity;

public class Constants {

	public Constants() {
		// TODO Auto-generated constructor stub
	}

	public static enum Orientation {
		NORTH('N', "Nord"),
		EAST('E', "East"),
		WEST('W', "West"),
		SOUTH('S', "South");
		
		private char code;
		private String libelle;
		private Orientation(char code, String libelle) {
			this.code = code;
			this.libelle = libelle;
		}
		public char getCode() {
			return code;
		}
		public void setCode(char code) {
			this.code = code;
		}
		public String getLibelle() {
			return libelle;
		}
		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}				
	}
	
	public static enum Action {
		DROITE('D',"Droite"),
		GAUCHE('G',"Gauche"),
		AVANCER('A',"Avancer");
		
		private char code;
		private String libelle;
		private Action(char code, String libelle) {
			this.code = code;
			this.libelle = libelle;
		}
		public char getCode() {
			return code;
		}
		public void setCode(char code) {
			this.code = code;
		}
		public String getLibelle() {
			return libelle;
		}
		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}
		
	}
	
	public static final String N= "NORTH";
	public static final String E= "EAST";
	public static final String S= "SOUTH";
	public static final String W= "WEST";
	
	public static final String D= "DROITE";
	public static final String G= "GAUCHE";
	public static final String A= "AVANCER";
	
	public static final String ESPACE = " ";

}
