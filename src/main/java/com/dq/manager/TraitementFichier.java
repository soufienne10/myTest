package com.dq.manager;

import java.util.ArrayList;
import java.util.List;

import com.dq.entity.Constants.Action;
import com.dq.entity.Constants;
import com.dq.entity.Constants.Orientation;
import com.dq.entity.Coordonnees;
import com.dq.entity.Pelouse;
import com.dq.entity.Tondeuse;

public class TraitementFichier {

	public TraitementFichier() {

	}

	public static Pelouse traitementLignePelouse(String lignePelouse) {
		Pelouse pelouse = new Pelouse();
		Coordonnees coordonnees = new Coordonnees();
		String[] arg = lignePelouse.split(Constants.ESPACE);
		coordonnees.setX(Integer.valueOf(arg[0]));
		coordonnees.setY(Integer.valueOf(arg[1]));
		pelouse.setCoordonneeSup(coordonnees);

		return pelouse;
	}

	public static Tondeuse traitementLigneTondeuse(String ligneTondeuse) {
		Tondeuse tondeuse = new Tondeuse();
		Coordonnees coordonnees = new Coordonnees();
		String[] arg = ligneTondeuse.split(Constants.ESPACE);
		coordonnees.setX(Integer.valueOf(arg[0]));
		coordonnees.setY(Integer.valueOf(arg[1]));
		Orientation orientation = getOrientation(arg[2].charAt(0));
		tondeuse.setcTondeuse(coordonnees);
		tondeuse.setoTondeuse(orientation);
		return tondeuse;
	}

	public static Orientation getOrientation(char orientationStr) {
		for (Orientation orientation : Orientation.values()) {
			if (orientation.getCode() == orientationStr) {
				return orientation;
			}
		}
		return null;
	}

	public static List<Action> traitementLigneAction(String ligneAction) {
		List<Action> listAction = new ArrayList<Action>();
		for (char actionStr : ligneAction.toCharArray()) {
			listAction.add(getAction(actionStr));
		}
		return listAction;
	}

	public static Action getAction(char actionStr) {
		for (Action action : Action.values()) {
			if (action.getCode() == actionStr) {
				return action;
			}
		}
		return null;
	}
}
