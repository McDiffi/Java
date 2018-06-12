package Lab11;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Collections.*;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int i;

        do {
            System.out.print("Wpisz numer zadania (1-10, 0 - aby wyjść!) \n");
            i = input.nextInt();

            switch (i) {
                case 1: {
                    System.out.print("Zadanie 1: \n");
                    System.out.print("Rownanie a: " + "\n");
                    BinomialSolver a = new BinomialSolver(1,5,3);
                    a.print_func();
                    System.out.print("X1: " + a.getX1() + "\t X1: " + a.getX2() + "\n");
                    System.out.print("Rownanie b: " + "\n");
                    BinomialSolver b = new BinomialSolver(1,2,1);
                    b.print_func();
                    System.out.print("X1: " + b.getX1() + "\t X1: " + b.getX2() + "\n");
                    System.out.print("Rownanie c: " + "\n");
                    BinomialSolver c = new BinomialSolver(6,3,9);
                    c.print_func();
                    System.out.print("X1: " + c.getX1() + "\t X1: " + c.getX2() + "\n");
                    break;
                }
                case 2: {
                    System.out.print("Zadanie 2: \n");
                    Rectangle Prostokat = new Rectangle("Prostokąt", -10, 12);
                    Square Kwadrat = new Square("Kwadrat", Prostokat.width);

                    Kwadrat.setName("Kwadrat");
                    System.out.print(Prostokat.getName() + " ma pole równe " + Prostokat.area() + " i obwód " + Prostokat.perimeter() + "\n");
                    System.out.print(Kwadrat.getName() + " ma pole równe " + Kwadrat.area() + " i obwód " + Kwadrat.perimeter() + "\n");
                    break;
                }
                case 3: {
                    System.out.print("Zadanie 3 i 5: \n");
                    System.out.print("Ile liczb chcesz wylosowac i umieścić w talbicy? :");

                    ArrayList<Integer>  lista = new ArrayList<Integer>();

                    int n;
                    Scanner intInput = new Scanner(System.in);
                    n = intInput.nextInt();

                    for(int a = 0; a < n; a++){
                        lista.add(ThreadLocalRandom.current().nextInt(0,10+1));
                    }

                    System.out.print("Zawartość ArrayList: ");
                    for(int a = 0; a < lista.size(); a++){
                        System.out.print(lista.get(a) + " ");
                    }
                    System.out.print("\n");
                    System.out.println("Element najmniejszy: " + min(lista));
                    System.out.println("Element największy: " + max(lista));

                    System.out.print("Spradź czy lista zawiera element wskazany przez użytkownika? <0,10> :");
                    int findingNumber = intInput.nextInt();
                    if(lista.contains(findingNumber)){
                        System.out.println("Lista ZAWIERA podany numer!");
                    } else {
                        System.out.println("Lista NIE ZAWIERA podanego numeru!");
                    }

                    System.out.print("Który element chcesz usunąć? (Wskaż index) :");
                    findingNumber = intInput.nextInt();
                    lista.remove(findingNumber);

                    System.out.print("Zawartość ArrayList: ");
                    for(var it = lista.listIterator(); it.hasNext();){
                        System.out.print(it.next() + " ");
                    }
                    System.out.print("\n");
                    System.out.println("Element najmniejszy: " + min(lista));
                    System.out.println("Element największy: " + max(lista));

                    break;
                }
                case 4: {
                    System.out.print("Zadanie 4 i 5: \n");
                    System.out.print("Ile liczb chcesz wylosowac i umieścić w talbicy? :");

                    LinkedList<Integer> linkedlist = new LinkedList<Integer>();

                    int n;
                    Scanner intInput = new Scanner(System.in);
                    n = intInput.nextInt();

                    for(int a = 0; a < n; a++){
                        linkedlist.add(ThreadLocalRandom.current().nextInt(0,10+1));
                    }

                    sort(linkedlist);

                    System.out.print("Zawartość LinkedList: ");
                    for(int a = 0; a < linkedlist.size(); a++){
                        System.out.print(linkedlist.get(a) + " ");
                    }
                    System.out.print("\n");
                    System.out.println("Element najmniejszy: " + min(linkedlist));
                    System.out.println("Element największy: " + max(linkedlist));

                    System.out.print("Spradź czy lista zawiera element wskazany przez użytkownika? <0,10> :");
                    int findingNumber = intInput.nextInt();
                    if(linkedlist.contains(findingNumber)){
                        System.out.println("Lista ZAWIERA podany numer!");
                    } else {
                        System.out.println("Lista NIE ZAWIERA podanego numeru!");
                    }

                    System.out.print("Który element chcesz usunąć? (Wskaż index) :");
                    findingNumber = intInput.nextInt();
                    linkedlist.remove(findingNumber);

                    System.out.print("Zawartość LinkedList: ");
                    for(var it = linkedlist.listIterator(); it.hasNext();){
                        System.out.print(it.next() + " ");
                    }
                    System.out.print("\n");
                    System.out.println("Element najmniejszy: " + min(linkedlist));
                    System.out.println("Element największy: " + max(linkedlist));
                    break;
                }
                case 5: {
                    System.out.print("Zadanie 5: \n");
                    System.out.print("Zadanie 5 jest zaimplementowane w zadaniach 3 i 4 \n");
                    break;
                }
                case 6: {
                    System.out.print("Zadanie 6: \n");
                    System.out.print("Zadanie 6 jest zaimplementowane w zadaniach 3 i 4 \n");
                    break;
                }
                case 7: {
                    System.out.print("Zadanie 7: \n");
                    System.out.print("Ile liczb chcesz wylosowac i umieścić w talbicy? :");

                    LinkedList<Integer> linkedlist = new LinkedList<Integer>();

                    int n;
                    Scanner intInput = new Scanner(System.in);
                    n = intInput.nextInt();

                    for(int a = 0; a < n; a++){
                        linkedlist.add(ThreadLocalRandom.current().nextInt(0,10+1));
                    }

                    System.out.print("Zawartość LinkedListy: ");
                    for (Integer number : linkedlist) {
                        System.out.print(number + " ");
                    }
                    System.out.print("\n");

                    HashSet<Integer> setOfNumbers = new HashSet<Integer>(linkedlist);

                    System.out.print("Zawartość HashSet'u: ");
                    for (Integer number : setOfNumbers) {
                        System.out.print(number + " ");
                    }
                    System.out.print("\n");

                    break;
                }
                case 8: {
                    System.out.print("Zadanie 8: \n");
                    System.out.print("Ile liczb chcesz wylosowac i umieścić w talbicy? :");

                    LinkedList<Integer> linkedlist = new LinkedList<Integer>();

                    int n;
                    Scanner intInput = new Scanner(System.in);
                    n = intInput.nextInt();

                    for(int a = 0; a < n; a++){
                        linkedlist.add(ThreadLocalRandom.current().nextInt(0,10+1));
                    }

                    System.out.print("Zawartość LinkedListy: ");
                    for (Integer number : linkedlist) {
                        System.out.print(number + " ");
                    }
                    System.out.print("\n");

                    System.out.print("Jaki zakres liczb chcesz usunąć <0,10> : ");

                    Integer a = intInput.nextInt();
                    Integer b = intInput.nextInt();

                    linkedlist.removeIf((Integer c) -> c >= a && c <= b);

                    System.out.print("Zawartość LinkedListy: ");
                    for (Integer number : linkedlist) {
                        System.out.print(number + " ");
                    }
                    System.out.print("\n");

                    break;
                }
                case 9: {
                    System.out.print("Zadanie 9: \n");
                    Firma politechnikaPoznanska = new Firma();
                    politechnikaPoznanska.add(new Pracownik("Przemysław", "Walkowiak", "Programista", 2000));
                    politechnikaPoznanska.add(new Pracownik("Kamil", "Kowalski", "Matematyk", 1000));
                    politechnikaPoznanska.add(new Pracownik("Krzysztof", "Bucholc", "Wykładowca", 2000));
                    politechnikaPoznanska.add(new Pracownik("Steurat", "Malutki", "Piromanta", 3000));

                    politechnikaPoznanska.display();

                    System.out.println("Politechnika posiada " + politechnikaPoznanska.employessAmount() + " pracowników");

                    if(politechnikaPoznanska.remove("Kamil", "Kowalski")) System.out.println("Usunięto pracownika Kamil Kowalski z listy pracowników");
                    else System.out.println("NIE usunięto pracownika Kamil Kowalski z listy pracowników");

                    if(politechnikaPoznanska.contains("Kamil", "Kowalski")) System.out.println("Politechnika posiada pracownika Kamil Kowalski");
                    else System.out.println("Politechnika nie posiada pracownika Kamil Kowalski");

                    politechnikaPoznanska.display();

                    break;
                }
                case 10: {
                    System.out.print("Zadanie 10: \n");
                    Firma politechnikaPoznanska = new Firma();
                    politechnikaPoznanska.add(new Pracownik("Przemysław", "Walkowiak", "Programista", 2000));
                    politechnikaPoznanska.add(new Pracownik("Kamil", "Kowalski", "Matematyk", 1000));
                    politechnikaPoznanska.add(new Pracownik("Krzysztof", "Bucholc", "Wykładowca", 2000));
                    politechnikaPoznanska.add(new Pracownik("Steurat", "Malutki", "Piromanta", 3000));

                    System.out.println("Spis pracowników: ");
                    for(Pracownik p: politechnikaPoznanska) {
                        System.out.println(p.toString());
                    }
                    break;
                }
                default: {
                    break;
                }
            }
        } while (i != 0);
    }
}

