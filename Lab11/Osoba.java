package Lab11;

import java.util.Objects;

public class Osoba {
    protected String Name;
    protected String Surname;

    public Osoba() {
    }

    public Osoba(String name, String surname) {
        Name = name;
        Surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Osoba osoba = (Osoba) o;
        return Objects.equals(Name, osoba.Name) && Objects.equals(Surname, osoba.Surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Surname);
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                '}';
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }
}
