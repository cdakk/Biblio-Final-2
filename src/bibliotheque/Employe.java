package bibliotheque;

import java.time.LocalDate;

public class Employe extends Utilisateur {
	
	private String codeMatricule;
	private EnumCategorieEmploye categorieEmploye;
	
	/**
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @param sexe
	 * @param idUtilisateur
	 * @param pwd
	 * @param pseudonyme
	 * @param codeMatricule
	 * @param categorieEmploye
	 */
	public Employe(String nom, String prenom, LocalDate dateNaissance, String sexe, int idUtilisateur, String pwd,
			String pseudonyme, String codeMatricule, EnumCategorieEmploye categorieEmploye) {
		super(nom, prenom, dateNaissance, sexe, idUtilisateur, pwd, pseudonyme);
		this.codeMatricule = codeMatricule;
		this.categorieEmploye = categorieEmploye;
	}

	public String getCodeMatricule() {
		return codeMatricule;
	}

	public void setCodeMatricule(String codeMatricule) {
		this.codeMatricule = codeMatricule;
	}

	public EnumCategorieEmploye getCategorieEmploye() {
		return categorieEmploye;
	}

	public void setCategorieEmploye(EnumCategorieEmploye categorieEmploye) {
		this.categorieEmploye = categorieEmploye;
	}

	@Override
	public String toString() {
		return "Employe"
				+ "["
				+ "nom=" + this.getNom()
				+ ", prenom=" + this.getPrenom()
				+ ", categorieEmploye=" + categorieEmploye
				+ ", codeMatricule=" + codeMatricule
				+ ", nbEmpruntsEnCours=" + this.getNbEmpruntsEnCours()
				+ "]";
	}	
}
