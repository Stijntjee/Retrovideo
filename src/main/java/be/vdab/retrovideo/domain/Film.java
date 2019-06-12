package be.vdab.retrovideo.domain;

import java.math.BigDecimal;

public class Film
{
    private int id;
    private int genreid;
    private String titel;
    private int voorraad;
    private int gereserveerd;
    private BigDecimal prijs;

    //CONSTRUCTORS
    public Film(int id, int genreid, String titel, int voorraad, int gereserveerd, BigDecimal prijs)
    {
        this.id = id;
        this.genreid = genreid;
        this.titel = titel;
        this.voorraad = voorraad;
        this.gereserveerd = gereserveerd;
        this.prijs = prijs;
    }


    //GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public int getGenreid() {
        return genreid;
    }

    public String getTitel() {
        return titel;
    }

    public int getVoorraad() {
        return voorraad;
    }

    public int getGereserveerd() {
        return gereserveerd;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }
}
