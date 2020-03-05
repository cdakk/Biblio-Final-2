package bibliotheque;

import java.time.LocalDate;

public class ExemplaireDao {
	
	private Exemplaire[] exemplaireDB = {
			new Exemplaire(10, LocalDate.of(1959, 10, 29), EnumStatutExemplaire.DISPONIBLE, "ASTERIX"),
			new Exemplaire(11, LocalDate.of(1957, 02, 28), EnumStatutExemplaire.DISPONIBLE, "GASTON LAGAFFE"),
			new Exemplaire(12, LocalDate.of(1946, 12, 07), EnumStatutExemplaire.DISPONIBLE, "LUCKY LUKE"),
			new Exemplaire(13, LocalDate.of(1938, 04, 21), EnumStatutExemplaire.DISPONIBLE, "SPIROU"),
			new Exemplaire(14, LocalDate.of(1959, 12, 24), EnumStatutExemplaire.DISPONIBLE, "BOULE ET BILL"),
			new Exemplaire(15, LocalDate.of(1958, 10, 23), EnumStatutExemplaire.DISPONIBLE, "SCHTROUMPFS"),
			new Exemplaire(16, LocalDate.of(1929, 01, 10), EnumStatutExemplaire.DISPONIBLE, "TINTIN"),
			new Exemplaire(17, LocalDate.of(1947, 12, 01), EnumStatutExemplaire.DISPONIBLE, "PICSOU")
	};
	
	public Exemplaire findByKey(int id) {
		for (Exemplaire exemplaire : exemplaireDB) {
			if (exemplaire.getIdExemplaire() == id)
				return exemplaire;
		}
		return null;
	}
}
