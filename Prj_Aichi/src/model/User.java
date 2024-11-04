package model;

public class User {
    private int id;
    private String nom;
    private String mot_de_passe;
    private String type_acces;

// Constructeurs, getters et setters

public User(int id, String nom, String mot_de_passe, String type_acces) {
    this.id = id;
    this.nom = nom;
    this.mot_de_passe = mot_de_passe;
    this.type_acces = type_acces;
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getNom() {
    return nom;
}

public void setNom(String nom) {
    this.nom = nom;
}

public String getMot_de_passe() {
    return mot_de_passe;
}

public void setMot_de_passe(String mot_de_passe) {
    this.mot_de_passe = mot_de_passe;
}

public String getType_acces() {
    return type_acces;
}

public void setType_acces(String type_acces) {
    this.type_acces = type_acces;
}

private Boolean verifierLogin(String identifiant, String mdp)
{
	//Appel controlleur(identifiant, mdp) -> retourn true si la combinaison est valide
	return false;
}

}