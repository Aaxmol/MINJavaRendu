# MINJavaRendu

Veuilliez trouver ci-dessous les commentaires d'avancement de mon tp java

--------------------------------------------------------------------------------------------

Prérequis:

- Installation du framework Srping
- Création des classes et .jsp necessaires
- Package de configuration fait
- Ensemble des dépendances et pluggins installés dans le pom.xml avec une version recente et stable


--------------------------------------------------------------------------------------------

Méthodes fonctionnelles à 100% avec le Sring:

- L'ensemble des méthodes create --> create client + create vehicle + create reservation
- La méthode modifie des clients
- La méthode details des clients
- L'ensemble des méthodes delete --> delete client + delete vehicle + delete reservation
  J'ai déjà eu un bug pour supprimer les premiers client ou vehicle j'ai du reload mais sinon ça fonctionne 
- L'ensemble des méthodes findbyId --> findbyId client + findbyId vehicle
- La méthode finResaByClientId
- La méthode findResaByVehicleId
- L'ensemble des méthodes finAll --> finAll client + finAll vehicle + finAll reservation
- L'ensemble des méthodes count --> count client + count vehicle + count reservation
- La méthode countResaByClientId qui compte le nombre de reservation pour un id client donné:
  afin de mmetre à jour le compteur dans les détails clients
- Toutes les méthodes getInstance faites et fonctionnelles mais mis en commentaire dans les différentes classes

- Dans méthode modifie petit rajout pratique: les inputs sont préremplis avec les infomrations de bases
  du client, vehicle ou reservation à mondifier


--------------------------------------------------------------------------------------------

Méthodes pas totalement fonctionnelles à 100%:

- Fonction modifie vehicle et reservation bug au moment de submit: MESSAGE D'ERREUR
  message Cannot parse null string
  description The server encountered an internal error that prevented it from fulfilling this request.
  --> PROBÈME: 
  	"String idNull = URLDecoder.decode(request.getQueryString(), "UTF-8");
		System.out.println(idNull);

		String idOk = idNull.substring(3);
		System.out.println(idOk);
		
		int id = Integer.parseInt(idOk);"
  --> la solution se trouverai dans la modifcation du substring mais je n'ai pas trouvé après minte recherche
- Dans l'affichage des réservations: ID client et véhicle au lieux de leur nom et marque respective:
  --> Pas fait par manque de temps 


--------------------------------------------------------------------------------------------

Contraintes faites:

- Le nom et le prénom d'un client doivent faire au moins 3 caractères 
- Une voiture doit avoir un nombre de place et un constructeur
- On empêchera la création ou la mise à jour d’un Client si son nom/prenom est vide. Si une telle opération est tentée, on enverra une ServiceException. (fait pour tous les champs)
- On empêchera la création ou la mise à jour d’un Véhicule si son constructeur (manufacturer) est vide. (fait pour tous les champs)
- On s’assurera également que le nombres de places est supérieure à 1. Si de telles opérations sont
tentés, on enverra une ServiceException. une voiture doit avoir un modèle et un constructeur, son nombre de place doit
être compris entre 2 et 9
- Lors de la création ou la mise à jour d’un Client, on fera en sorte
que son nom de famille soit enregistré en MAJUSCULES dans la base

--------------------------------------------------------------------------------------------

Pas fait par manque de temps:

Contraintes :
- Un client n'ayant pas 18ans ne peut pas être créé
- Un client ayant une adresse mail déjà prise ne peut pas être créé
- Une voiture ne peux pas être réservé 2 fois le même jour
- Ue voiture ne peux pas être réservé plus de 7 jours de suite par le même utilisateur
- Ue voiture ne peux pas être réservé 30 jours de suite sans pause
- S un client ou un véhicule est supprimé, alors il faut supprimer les réservations associées

Pour les tests, j'ai eu le temps de créer les fichiers écrire quelques lignes dédans mais aucun tests
en rapport avec le TP n'a été fonctionnel.

--------------------------------------------------------------------------------------------

Merci à vous ;)

Axel MOLINES MIN 1
axel.molines@epfedu.fr
06.65.59.21.16
