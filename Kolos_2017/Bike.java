package pl.poznan.put.jipp;

public class Bike implements Vehicle {

    public Bike() { }

    @Override
    public void move(int distance) throws MoveException {
        try {
            if(distance > 10) throw new MoveException("Dystans większy niż 10! Nie jadę, aż tyle!");
            System.out.println("Rower przejechał " + distance + " km!" );
        } catch (MoveException e){
            System.out.println(e.getMessage());
        }
    }
}
