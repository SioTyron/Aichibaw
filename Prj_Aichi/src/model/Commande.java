package model;

public class Commande {
    private int id;
    private String date;
    private double total;

    public Commande(int id, String date, double total) {
        this.id = id;
        this.date = date;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public double getTotal() {
        return total;
    }
}