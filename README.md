# Biblio-Final-2
Projet de création d'une application de gestion d'une bibliothèque.

Cas étudiés:
Emprunt d'exemplaires de livre;
Gestion des Utilisateurs (Employés/Adhérents)
Gestion des retours et des retards.
Mardi 3 Mars 2020:
1. Structuration du projet via la création sur Eclipse des Pakagdes (DAO, Metier, Test).

2. Création des classes dans le package métier:
- Adherent
- BiblioException
- Employe
- EmpruntArchive
- EmpruntEnCours
- EnumCategorieEmploye (Bibliothécaire; Responsable; Gestionnaire_de_fonds)
- EnumStatusExemplaire (Disponible; Prêté; Supprimé)
- Exemplaire
- Personne (Classe Parent dont hérite: Employé, Adhérent, Utilisateur)
- Utilisateur.

3. Création des "Classes" Dao:
- UtilisateursDao
- EcemplairesDao

Mercredi 4 Mars 2020:
Recettage - Tests: 4.1 TestDeBase:
Demande de deux exemplaires par leur id aux Dao;
Demande d'un Adhérent par son id Dao;
Demande d'un employé par son id aux Dao;
Création d'un emprunt en cours pour un adhéren;
Création d'un emprunt en cours pour un Employé.

4.2 TestAdherentEnReatrd:
- Si un emprunt en retard alors il est impossible d'emprunter pour l'Adhérent.

4.3 TestEmployeEnRetard:
- Si un emprunt en retard alors l'emprunt est possible pour l'Employé.

4.4 TestAdherentTroisEmprints:
- Si trois emprunts alors impossible d'emprunter pour l'Adhérent.

4.5 TestEmployeTroisEmprunts:
- Si trois emprunts alors Employé peut quand même emprunter (pas de restriction).

4.6 TestRetour:
Lorsque l'Exemplaire est rendu:
- Le passer en status DISPONIBLE
- Faire diminuer la collection de l'Utilisateur
- Créer l'Emprunt-Archivé
- GarbageCollecter l'EmpruntEnCours.
