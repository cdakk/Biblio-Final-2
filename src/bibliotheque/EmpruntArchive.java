package bibliotheque;

import java.time.LocalDate;

public class EmpruntArchive {
	
	private LocalDate dateEmprunt;
	private LocalDate dateRestitutionEff;
	
	/**
	 * @param dateEmprunt
	 * @param dateRestitutionEff
	 */
	public EmpruntArchive() {
		super();
	}
	
	public EmpruntArchive(LocalDate dateEmprunt, LocalDate dateRestitutionEff) {
		super();
		this.dateEmprunt = dateEmprunt;
		this.dateRestitutionEff = dateRestitutionEff;
	}

	public LocalDate getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(LocalDate dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public LocalDate getDateRestitutionEff() {
		return dateRestitutionEff;
	}

	public void setDateRestitutionEff(LocalDate dateRestitutionEff) {
		this.dateRestitutionEff = dateRestitutionEff;
	}

	@Override
	public String toString() {
		return "EmpruntArchive"
				+ " ["
				+ "dateEmprunt=" + dateEmprunt
				+ ", dateRestitutionEff=" + dateRestitutionEff
				+ "]";
	}
}
