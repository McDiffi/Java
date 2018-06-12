package Lab12;

import java.util.Objects;

;

class Pracownik extends Osoba {
    private int Pensja;
    Stanowisko Stanowisko;

    public Pracownik() {
    }

    public Pracownik(String name, String surname) {
        super(name, surname);
    }

    public Pracownik(String name, String surname, Stanowisko stanowisko, int pensja) {
        super(name, surname);
        Stanowisko = stanowisko;
        Pensja = pensja;
    }

    public Stanowisko getStanowisko() {
        return Stanowisko;
    }

    public int getPensja() {
        return Pensja;
    }

    public void setStanowisko(Stanowisko stanowisko) {
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
