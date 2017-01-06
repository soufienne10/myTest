package com.dq.entity;

import com.dq.entity.Constants.Orientation;

public class Tondeuse {
    
	private Coordonnees cTondeuse;
	private Constants.Orientation oTondeuse; 
	
	public Tondeuse() {
		// TODO Auto-generated constructor stub
	}

	public Tondeuse(Coordonnees cTondeuse, Orientation oTondeuse) {
		super();
		this.cTondeuse = cTondeuse;
		this.oTondeuse = oTondeuse;
	}

	public Coordonnees getcTondeuse() {
		return cTondeuse;
	}

	public void setcTondeuse(Coordonnees cTondeuse) {
		this.cTondeuse = cTondeuse;
	}

	public Constants.Orientation getoTondeuse() {
		return oTondeuse;
	}

	public void setoTondeuse(Constants.Orientation oTondeuse) {
		this.oTondeuse = oTondeuse;
	}

	
}
