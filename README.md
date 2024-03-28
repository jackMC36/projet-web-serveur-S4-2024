# Projet Techno Web Serveur

**Ecran à afficher (page html)**

	- Liste des appartements d'un propriétaire / locataire
	- Liste des immeubles
	- Détail d'un appart / immeuble / syndicat
	- Fiche "Identité" (pour une personne)
	- Page de connexion / inscription
	- Page de contact
	
##Classe Java

	- Immeuble
	- Syndicat
	- Appt
	- Personne (avec héritage)
	
##BDD (table : attributs)

	- Immeuble : syndicId (clé étrangère = FK)
	- Syndicat
	- Appt : immeubleId (FK)
	- Personne
	- Occupation (table de jointure entre Appt et Personne) : personne (FK), statut, n° appt (FK)
	
##Solution technologique

Utilisation de Java

##Rapport

Noté ce qui s'est bien passé et moins bien
