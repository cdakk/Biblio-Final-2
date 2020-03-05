package bibliotheque;

import java.time.LocalDate;

public class UtilisateurDao {
	
	private Utilisateur[] utilisateurDB = {						
			new Employe("Ventura", "Lino", LocalDate.of(1919, 07, 14), "Homme", 1, "Motdepasse", "LV", "M1111", EnumCategorieEmploye.RESPONSABLE),
			new Employe("Blanche", "Francis", LocalDate.of(1921, 07, 20), "Homme", 2, "Motdepasse", "FB", "M2222", EnumCategorieEmploye.GESTIONNAIRE),
			new Employe("Blier", "Bernard", LocalDate.of(1916, 01, 11), "Homme", 3, "Motdepasse", "BB", "M3333", EnumCategorieEmploye.BIBLIOTHECAIRE),
			
			new Adherent("Audiard", "Michel", LocalDate.of(1920, 05, 15), "Homme", 4, "Motdepasse", "MA", "01 20 42 76 32"),
			new Adherent("Lautner", "Georges", LocalDate.of(1926, 01, 24), "Homme", 5, "Motdepasse", "GL", "02 58 86 44 25"),
			new Adherent("Simonin", "Albert", LocalDate.of(1905, 04, 18), "Homme", 6, "Motdepasse", "AS", "03 60 34 23 73")
	};
	
	public Utilisateur findByKey(int id) {
		for (Utilisateur utilisateur : utilisateurDB) {
			if (utilisateur.getIdUtilisateur() == id)
				return utilisateur;
		}
		return null;
	}
}
