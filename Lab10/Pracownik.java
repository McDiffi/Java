class Pracownik extends Osoba {
    String Stanoowisko;
    int pensja;

    public Pracownik() {
    }

    public Pracownik(String name, String surname) {
        super(name, surname);
    }

    public String getStanoowisko() {
        return Stanoowisko;
    }

    public int getPensja() {
        return pensja;
    }

    public void setStanoowisko(String stanoowisko) {
        Stanoowisko = stanoowisko;
    }

    public void setPensja(int pensja) {
        this.pensja = pensja;
    }
}
