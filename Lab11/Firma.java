package Lab11;

import java.util.*;
import java.lang.Iterable;

public class Firma implements Iterable<Pracownik>{
    private LinkedList<Pracownik> pracownicy = new LinkedList<>();

    public boolean contains(String imie, String nazwisko){
        for(Pracownik pracownik : pracownicy){
            if(pracownik.getName() == imie && pracownik.getSurname() == nazwisko) return true;
        }
        return false;
    }

    public void add(Pracownik pracownik){
        try {
            if(pracownicy.contains(pracownik)) throw new IllegalStateException("Pracownik już istnieje w bazie!");
            pracownicy.add(pracownik);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Integer employessAmount (){
        return pracownicy.size();
    }

    public boolean remove(String imie, String nazwisko){
        for(Pracownik pracownik : pracownicy){
            if(pracownik.getName() == imie && pracownik.getSurname() == nazwisko)
                return pracownicy.remove(pracownik);
        }
        return false;
    }

    public void display(){
        System.out.println("Spis pracowników: ");
        for (Pracownik pracownik: pracownicy) {
          System.out.println(pracownik.toString());
        }
    }

    @Override
    public Iterator<Pracownik> iterator() {
        Iterator<Pracownik> it = new Iterator<Pracownik>() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < pracownicy.size() && pracownicy.get(currentIndex) != null;
            }

            @Override
            public Pracownik next() {
                return pracownicy.get(currentIndex++);
            }
        };
        return it;
    }
}
