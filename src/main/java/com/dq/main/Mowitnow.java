package com.dq.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.dq.entity.InstructionTondeuse;
import com.dq.entity.Pelouse;
import com.dq.entity.Tondeuse;
import com.dq.entity.Constants.Action;
import com.dq.manager.TraitementFichier;

public class Mowitnow {

	public static void main(String[] args) {
		String chaine = "";
		String premiereLigne = "";
		String fichier = "C:\\Users\\Soufienne\\workspaceLuna\\myTestTechniqueV0\\src\\test\\resources\\fichier_TEST.txt";

		// lecture du fichier texte
		try {
			InputStream ips = new FileInputStream(fichier);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			int lingeNbr = 0;
			while ((ligne = br.readLine()) != null) {
				lingeNbr++;
				// System.out.println(ligne);
				if (lingeNbr == 1) {
					premiereLigne = ligne;
				} else {
					if (!"".equals(ligne)) {
						chaine += ligne + "\n";
					}
				}
			}
			br.close();
			// System.out.println("Nombres des lignes :"+lingeNbr);
			// System.out.println("Premiere ligne :"+premiereLigne);
			// System.out.println("Lignes suivantes :"+chaine);
			TraitementFichier traitementFichier = new TraitementFichier();
			Pelouse pelouse = traitementFichier.traitementLignePelouse(premiereLigne);
			traiterLignesSuivantes(pelouse,chaine);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
	

	private static void traiterLignesSuivantes(Pelouse pelouse,String chaineReste) {
		String delimiter = "\n";
		String[] temp = chaineReste.split(delimiter);
//		System.out.println("Nombre lignes suivante sans espace :" + temp.length);

		for (int i = 0; i < temp.length; i++) {			
//			System.out.println(temp[i]);
			TraitementFichier traitementFichier = new TraitementFichier();
			Tondeuse tondeuse = traitementFichier.traitementLigneTondeuse(temp[i]);
			List<Action> actionList = traitementFichier.traitementLigneAction(temp[i+1]);
			InstructionTondeuse instructionTondeuse =new InstructionTondeuse();
			instructionTondeuse.setPelouse(pelouse);
			instructionTondeuse.setTondeuse(tondeuse);
			instructionTondeuse.setActionList(actionList);
			instructionTondeuse.executerAction(instructionTondeuse);
			System.out.println(instructionTondeuse);
//			instructionTondeuse.toString();			
			i = i+1;
		}
	}

}
