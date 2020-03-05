package biblio.tests;

import java.time.LocalDate;

import biblio.dao.ExemplaireDao;
import biblio.dao.UtilisateurDao;
import biblio.domain.EmpruntArchive;
import biblio.domain.EmpruntEnCours;
import biblio.domain.EnumStatutExemplaire;
import biblio.domain.Exemplaire;
import biblio.domain.Utilisateur;

public class TestRetour {
	
	//Methode Validation Emprunt
	
		public static void valideEmprunt(EmpruntEnCours ep) {
			Utilisateur u = ep.getEmprunteur();
			Exemplaire e = ep.getExemplaire();
			int nb1 = u.getNbEmpruntsEnCours();
			int nb2;

			u.addEmpruntEnCours(ep);
			nb2 = u.getNbEmpruntsEnCours();

			if (nb2 > nb1) {
				e.setEmpruntEnCours(ep);
				e.setStatutExemplaire(EnumStatutExemplaire.PRETE);
			}
		}

		//Methode Rendre Emprunt
		
		public static EmpruntArchive rendreEmprunt(EmpruntEnCours ep, LocalDate dateRetour) {
			Utilisateur u = ep.getEmprunteur();
			Exemplaire e = ep.getExemplaire();

			EmpruntArchive ar = new EmpruntArchive(ep.getDateEmprunt(), dateRetour);
			e.setStatutExemplaire(EnumStatutExemplaire.DISPONIBLE);
			u.removeEmpruntEnCours(ep);
			ep = null;
			e.setEmpruntEnCours(ep);

			return ar;
		}

	public static void main(String[] args) {
		
		System.out.println("***** 1.6 TEST RETOUR *****");
		System.out.println();
		System.out.println("***** DEUX EXEMPLAIRES PAR ID (10 à 17) *****");
		System.out.println();
		ExemplaireDao exemplaireDao = new ExemplaireDao();
		Exemplaire e1 = exemplaireDao.findByKey(10);
		Exemplaire e2 = exemplaireDao.findByKey(11);
		Exemplaire e3 = exemplaireDao.findByKey(12);
		Exemplaire e4 = exemplaireDao.findByKey(13);
		Exemplaire e5 = exemplaireDao.findByKey(14);
		Exemplaire e6 = exemplaireDao.findByKey(15);
		Exemplaire e7 = exemplaireDao.findByKey(16);
		Exemplaire e8 = exemplaireDao.findByKey(17);
		System.out.println(e1);
		System.out.println(e2);
		System.out.println();
		
		UtilisateurDao utilisateurDao = new UtilisateurDao();		
		System.out.println("***** UN ADHERENT PAR ID (4 à 6) *****");
		System.out.println();
		Utilisateur u1 = utilisateurDao.findByKey(4);
		Utilisateur u3 = utilisateurDao.findByKey(5);
		System.out.println(u1);
		System.out.println();
		
		System.out.println("***** PREMIER EMPRUNT POUR ADHERENT *****");
		System.out.println();
		EmpruntEnCours empruntA1 = new EmpruntEnCours(LocalDate.of(2020, 02, 14), u1, e1);//creation emprunt Adherent
		valideEmprunt(empruntA1);			
		System.out.println(u1);
		System.out.println(e1);
		System.out.println();
		
		System.out.println("***** ADHERENT QUI REND SON EXEMPLAIRE EMPRUNTE *****");
		System.out.println();
		EmpruntArchive retourR1 = new EmpruntArchive();
		retourR1 = rendreEmprunt(empruntA1, LocalDate.of(2020, 03, 04));
		System.out.println(retourR1);
		System.out.println(u1);
		System.out.println(e1);

	}

}
