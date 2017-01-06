package com.dq.manager;

import com.dq.entity.Constants;
import com.dq.entity.Constants.Action;
import com.dq.entity.Coordonnees;
import com.dq.entity.Tondeuse;
import com.dq.entity.Constants.Orientation;

public class ControleTondeuse {

	public ControleTondeuse() {
		// TODO Auto-generated constructor stub
	}

	public static boolean validateAction(Coordonnees tCoordonnees,
			Coordonnees coordonnesSup) {
		boolean res = true;
		if (tCoordonnees.getX() < 0 || tCoordonnees.getY() < 0) {
			res = false;
		} else if (tCoordonnees.getX() > coordonnesSup.getX()
				|| tCoordonnees.getY() > coordonnesSup.getY()) {
			res = false;
		}

		return res;
	}

	public static Coordonnees avancerTondeuse(Tondeuse pTondeuse,
			Coordonnees coordonnesSup) {
		Coordonnees coordonneesTondeuse = null;
		int x=0;
		int y=0;

		if (pTondeuse != null) {
			if (!"".equals(pTondeuse.getoTondeuse())
					&& pTondeuse.getoTondeuse() != null) {
				if (pTondeuse.getoTondeuse().equals(Orientation.NORTH)) {
					x = pTondeuse.getcTondeuse().getX();
					y = pTondeuse.getcTondeuse().getY() + 1;
				} else if (pTondeuse.getoTondeuse().equals(Orientation.EAST)) {
					x = pTondeuse.getcTondeuse().getX() + 1;
					y = pTondeuse.getcTondeuse().getY();
				} else if (pTondeuse.getoTondeuse().equals(Orientation.SOUTH)) {
					x = pTondeuse.getcTondeuse().getX();
					y = pTondeuse.getcTondeuse().getY() - 1;
				} else if (pTondeuse.getoTondeuse().equals(Orientation.WEST)) {
					x = pTondeuse.getcTondeuse().getX() - 1;
					y = pTondeuse.getcTondeuse().getY();
				}
			}
		}
		coordonneesTondeuse = new Coordonnees(x, y);

		if (coordonneesTondeuse != null
				&& validateAction(coordonneesTondeuse, coordonnesSup)) {
			return coordonneesTondeuse;
		} else {
			return pTondeuse.getcTondeuse();
		}
	}

	public static Orientation actionDroite(Orientation orientation) {
		Orientation orientationNext = null;
		if (orientation != null) {
			if (orientation.equals(Orientation.NORTH)) {
				orientationNext = Orientation.EAST;
			} else if (orientation.equals(Orientation.EAST)) {
				orientationNext = Orientation.SOUTH;
			} else if (orientation.equals(Orientation.SOUTH)) {
				orientationNext = Orientation.WEST;
			} else if (orientation.equals(Orientation.WEST)) {
				orientationNext = Orientation.NORTH;
			}
		}
		return orientationNext;
	}

	public static Orientation actionGauche(Orientation orientation) {
		Orientation orientationNext = null;
		if (orientation != null) {
			if (orientation.equals(Orientation.NORTH)) {
				orientationNext = Orientation.WEST;
			} else if (orientation.equals(Orientation.EAST)) {
				orientationNext = Orientation.NORTH;
			} else if (orientation.equals(Orientation.SOUTH)) {
				orientationNext = Orientation.EAST;
			} else if (orientation.equals(Orientation.WEST)) {
				orientationNext = Orientation.SOUTH;
			}
		}
		return orientationNext;
	}

	public static void actionTondeuse(Tondeuse pTondeuse, Action action,
			Coordonnees coordonnesSup) {

		if (action != null) {
			if (action.equals(Action.AVANCER)) {
				pTondeuse.setcTondeuse(ControleTondeuse.avancerTondeuse(
						pTondeuse, coordonnesSup));
			} else if (action.equals(Action.DROITE)) {
				pTondeuse.setoTondeuse(ControleTondeuse.actionDroite(pTondeuse
						.getoTondeuse()));
			} else if (action.equals(Action.GAUCHE)) {
				pTondeuse.setoTondeuse(ControleTondeuse.actionGauche(pTondeuse
						.getoTondeuse()));
			} else {
				// throw new ExceptionTondeuse(Params.INSTRUCTION_INCORRECTE);
			}
		}
	}

}
