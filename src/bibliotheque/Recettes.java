package bibliotheque;

import java.time.LocalDate;

public class Recettes {
	
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
		
		//1.1 Tests de base
		System.out.println("Deux exemplaires par id (10 à 17) :");
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
		System.out.println("Un adherent par id (4 à 6) :");
		Utilisateur u1 = utilisateurDao.findByKey(4);
		Utilisateur u3 = utilisateurDao.findByKey(5);
		System.out.println(u1);
		System.out.println();
		
		System.out.println("Un employé par id (1 à 3) :");
		Utilisateur u2 = utilisateurDao.findByKey(2);
		System.out.println(u2);
		System.out.println();
		
		System.out.println("Premier emprunt pour adherent :");
		EmpruntEnCours empruntA1 = new EmpruntEnCours(LocalDate.of(2020, 02, 14), u1, e1);
		valideEmprunt(empruntA1);			
		System.out.println(u1);
		System.out.println(e1);
		System.out.println();
		
		System.out.println("Premier emprunt pour employe :");
		EmpruntEnCours empruntE1 = new EmpruntEnCours(LocalDate.of(2020, 02, 14), u2, e2);
		valideEmprunt(empruntE1);			
		System.out.println(u2);
		System.out.println(e2);
		System.out.println();
		
		System.out.println("Deuxieme emprunt pour adherent (impossible car retard) :");
		EmpruntEnCours empruntA2 = new EmpruntEnCours(LocalDate.of(2020, 03, 01), u1, e3);
		valideEmprunt(empruntA2);			
		System.out.println(u1);
		System.out.println(e3);
		System.out.println();
		
		System.out.println("Deuxieme emprunt pour employe (possible malgres retard) :");
		EmpruntEnCours empruntE2 = new EmpruntEnCours(LocalDate.of(2020, 03, 01), u2, e3);
		valideEmprunt(empruntE2);			
		System.out.println(u2);
		System.out.println(e3);
		System.out.println();
		
		System.out.println("Premier emprunt pour adherent :");
		EmpruntEnCours empruntA3 = new EmpruntEnCours(LocalDate.of(2020, 02, 21), u3, e4);
		valideEmprunt(empruntA3);			
		System.out.println(u3);
		System.out.println(e4);
		System.out.println();
		
		System.out.println("Deuxieme emprunt pour adherent :");
		EmpruntEnCours empruntA4 = new EmpruntEnCours(LocalDate.of(2020, 02, 22), u3, e5);
		valideEmprunt(empruntA4);			
		System.out.println(u3);
		System.out.println(e5);
		System.out.println();
		
		System.out.println("Troisieme emprunt pour adherent :");
		EmpruntEnCours empruntA5 = new EmpruntEnCours(LocalDate.of(2020, 02, 23), u3, e6);
		valideEmprunt(empruntA5);			
		System.out.println(u3);
		System.out.println(e6);
		System.out.println();
		
		System.out.println("Quatrieme emprunt pour adherent (impossible car déjà 3) :");
		EmpruntEnCours empruntA6 = new EmpruntEnCours(LocalDate.of(2020, 02, 23), u3, e7);
		valideEmprunt(empruntA6);			
		System.out.println(u3);
		System.out.println(e7);
		System.out.println();
		
		System.out.println("Troisieme emprunt pour employe :");
		EmpruntEnCours empruntE3 = new EmpruntEnCours(LocalDate.of(2020, 03, 01), u2, e7);
		valideEmprunt(empruntE3);			
		System.out.println(u2);
		System.out.println(e7);
		System.out.println();
		
		System.out.println("Quatrieme emprunt pour employe (possible malgres déjà 3) :");
		EmpruntEnCours empruntE4 = new EmpruntEnCours(LocalDate.of(2020, 03, 01), u2, e8);
		valideEmprunt(empruntE4);			
		System.out.println(u2);
		System.out.println(e8);
		System.out.println();
		
		System.out.println("Adherent rend emprunt :");
		EmpruntArchive retourR1 = new EmpruntArchive();
		retourR1 = rendreEmprunt(empruntA1, LocalDate.of(2020, 03, 04));
		System.out.println(retourR1);
		System.out.println(u1);
		System.out.println(e1);

	}

}
