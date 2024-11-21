package model;

public class Article {
    private int Id;
    private String Nom;
    private String Description;
    private double Prix;
    private int QuantiteEnStock;

    public Article(int id, String reference, String designation, double prix, int quantite) {
        this.Id = id;
        this.Description = reference;
        this.Description = designation;
        this.Prix = prix;
        this.QuantiteEnStock = quantite;
    }

    // Getters et Setters
    public int getId() { return Id; }
    public String getReference() { return Description; }
    public String getDesignation() { return Description; }
    public double getPrix() { return Prix; }
    public int getQuantite() { return QuantiteEnStock; }
}