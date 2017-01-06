package com.dq.manager;

import com.dq.entity.Constants;
import com.dq.entity.InstructionTondeuse;
import java.util.List;


public class TondeuseImpl {

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
}
