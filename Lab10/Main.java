import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int i;

        do {
            System.out.print("Wpisz numer zadania (1-7, 0 - aby wyjść!) \n");
            i = input.nextInt();

            switch (i) {
                case 1: {
                    System.out.print("Zadanie 1: \n");
                    Osoba jan = new Osoba("Jan", "Kowalski");
                    Osoba jan2 = new Osoba("Jan", "Kowalski");
                    Osoba maria = new Osoba("Maria", "Nowak");

                    System.out.print(jan.toString() + "\n");
                    System.out.print(jan2.toString() + "\n");
                    System.out.print(maria.toString() + "\n");

                    break;
                }
                case 2: {
                    System.out.print("Zadanie 2: \n");

                    Osoba jan = new Osoba("Jan", "Kowalski");
                    Osoba jan2 = new Osoba("Jan", "Kowalski");
                    Osoba maria = new Osoba("Maria", "Nowak");

                    System.out.printf("jan == jan : %b%n", jan == jan);
                    System.out.printf("jan == jan2 : %b%n", jan == jan2);
                    System.out.printf("jan == maria : %b%n", jan == maria);
                    System.out.printf("jan.equals(jan) : %b%n", jan.equals(jan));
                    System.out.printf("jan.equals(jan2) : %b%n", jan.equals(jan2));
                    System.out.printf("jan.equals(maria) : %b%n", jan.equals(maria));

                    break;
                }
                case 3: {
                    System.out.print("Zadanie 3: \n");
                    Pracownik janusz = new Pracownik("Jan", "Kowalski");
                    janusz.setPensja(1600);
                    janusz.setStanoowisko("Customer Service");
                    System.out.print(janusz.toString()+ " Stanowisko: " + janusz.getStanoowisko() + " Pensja: " + janusz.getPensja() + "\n");
                    break;
                }
                case 4: {
                    System.out.print("Zadanie 4: \n");
                    VerboseObject Karyna = new VerboseObject("Karyna");
                    Karyna.sayHello();
                    break;
                }
                case 5: {
                    System.out.print("Zadanie 5: \n");
                    Rectangle Prostokat = new Rectangle("Prostokąt", 10, 12);
                    Square Kwadrat = new Square("Kwadrat", Prostokat.width);

                    Kwadrat.setName("Kwadrat");
                    System.out.print(Prostokat.getName() + " ma pole równe " + Prostokat.area() + " i obwód " + Prostokat.perimeter() + "\n");
                    System.out.print(Kwadrat.getName() + " ma pole równe " + Kwadrat.area() + " i obwód " + Kwadrat.perimeter() + "\n");
                    break;
                }
                case 6: {
                    System.out.print("Zadanie 6: \n");
                    Rectangle Prostokat = new Rectangle("Prostokąt", 10, 12);
                    Square Kwadrat = new Square("Kwadrat", Prostokat.width);
                    ShapeContainer ksztalty = new ShapeContainer();
                    ksztalty.add(Prostokat);
                    ksztalty.add(Kwadrat);
                    ksztalty.add(new Square("Kwadrat2",12));
                    ksztalty.display();
                    break;
                }
                case 7: {
                    System.out.print("Zadanie 7: \n");
                    Rectangle Prostokat = new Rectangle("Prostokąt", 10, 12);
                    Square Kwadrat = new Square("Kwadrat", Prostokat.width);
                    ShapeContainer ksztalty = new ShapeContainer();
                    ksztalty.add(Prostokat);
                    ksztalty.add(Kwadrat);
                    ksztalty.add(new Square("Kwadrat2",12));
                    ksztalty.add(new Circle("Kółko",12));
                    ksztalty.add(new Elipse("Elipsa", 12, 15));
                    ksztalty.display();
                    break;
                }
                default: { break; }
            }
        } while(i!=0);
    }
}
