package be.vdab.retrovideo.forms;

public class KlantForm
{
    String Familienaam;

    //CONSTRUCTORS
    public KlantForm(String familienaam) {
        Familienaam = familienaam;
    }

    //GETTERS & SETTERS
    public String getFamilienaam() {
        return Familienaam;
    }

    public void setFamilienaam(String familienaam) {
        Familienaam = familienaam;
    }
}
