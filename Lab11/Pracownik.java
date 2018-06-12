package Lab11;

import java.util.Objects;

class Pracownik extends Osoba {
    String Stanowisko;
    private int Pensja;

    public Pracownik() {
    }

    public Pracownik(String name, String surname) {
        super(name, surname);
    }

    public Pracownik(String name, String surname, String stanowisko, int pensja) {
        super(name, surname);
        Stanowisko = stanowisko;
        Pensja = pensja;
    }

    public String getStanowisko() {
        return Stanowisko;
    }

    public int getPensja() {
        return Pensja;
    }

    public void setStanowisko(String stanowisko) {
        Stanowisko = stanowisko;
    }

    public void setPensja(int pensja) {
        this.Pensja = pensja;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Surname, Stanowisko, Pensja);
    }

    @Override
    public String toString() {
        return super.Name + " " + super.Surname + " Stanowisko: " + Stanowisko + " Pensja: " + Pensja;
    }
}
