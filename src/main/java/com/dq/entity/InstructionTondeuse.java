package com.dq.entity;

import java.util.List;

import com.dq.entity.Constants.Action;
import com.dq.manager.ControleTondeuse;

public class InstructionTondeuse {

	private Pelouse pelouse;
	private Tondeuse tondeuse;
	private List<Constants.Action> actionList;

	public InstructionTondeuse() {
		// TODO Auto-generated constructor stub
	}

	public InstructionTondeuse(Pelouse pelouse, Tondeuse tondeuse,
			List<Action> actionList) {
		super();
		this.pelouse = pelouse;
		this.tondeuse = tondeuse;
		this.actionList = actionList;
	}

	public Pelouse getPelouse() {
		return pelouse;
	}

	public void setPelouse(Pelouse pelouse) {
		this.pelouse = pelouse;
	}

	public Tondeuse getTondeuse() {
		return tondeuse;
	}

	public void setTondeuse(Tondeuse tondeuse) {
		this.tondeuse = tondeuse;
	}

	public List<Constants.Action> getActionList() {
		return actionList;
	}

	public void setActionList(List<Constants.Action> actionList) {
		this.actionList = actionList;
	}
	
	public void executerAction(InstructionTondeuse instTondeuse) {
		List<Constants.Action> actionList = instTondeuse.getActionList();
		if (actionList.size() > 0) {
			for (int i = 0; i < actionList.size(); i++) {
				ControleTondeuse.actionTondeuse(instTondeuse.getTondeuse(),
						actionList.get(i), instTondeuse.getPelouse()
								.getCoordonneeSup());
			}
		}
	}

	public String toString() {
		String espace = " ";

		return tondeuse.getcTondeuse().getX() + espace
				+ tondeuse.getcTondeuse().getY() + espace
				+ tondeuse.getoTondeuse().getCode();
	}

}
