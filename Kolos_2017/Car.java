package pl.poznan.put.jipp;

public class Car implements Vehicle, FuelTank {
    protected int fuelLevel;
    protected int consumedFuelLevel = 0;

    public Car(int fuel) {
        try {
            if(fuel < 0 ) throw new MoveException("Wartość paliwa mniejsza niż zero! Baku nie wyjmiesz!");
            this.fuelLevel = fuel;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void refuel(int fuelAmount) {
        try {
            if(fuelAmount < 0) throw new Vehicle.MoveException("Nie można zatankować mniej niż 0 l paliwa!");
            this.fuelLevel += fuelAmount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int getFuelLevel() {
        return fuelLevel;
    }

    @Override
    public int getFuelConsumption() {
        return consumedFuelLevel;
    }

    @Override
    public void move(int distance) throws MoveException {
        try {
            if(distance < fuelLevel) throw new Vehicle.MoveException("Za mało paliwa by, aż tyle pojechać!");
            fuelLevel-=distance;
            consumedFuelLevel+=distance;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
