package be.vdab.retrovideo.domain;

public class Genre
{
    private int id;
    private String naam;

    //CONSTRUCTORS
    public Genre(int id, String naam) {
        this.id = id;
        this.naam = naam;
    }

    //GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }
}
