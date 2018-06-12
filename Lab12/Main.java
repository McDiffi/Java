package Lab12;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Main {
    static class ValueComparator implements Comparator<String>{

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        public ValueComparator(HashMap<String, Integer> map){
            this.map.putAll(map);
        }

        @Override
        public int compare(String s1, String s2) {
            if(map.get(s1) >= map.get(s2)){
                return -1;
            }else{
                return 1;
            }
        }
    }

    public static TreeMap<String, Integer> sortMapByValue(HashMap<String, Integer> map){
        Comparator<String> comparator = new ValueComparator(map);
        //TreeMap is a map sorted by its keys.
        //The comparator is used to sort the TreeMap by keys.
        TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
        result.putAll(map);
        return result;
    }


    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        int i;

        do {
            System.out.print("Wpisz numer zadania (1-10, 0 - aby wyjść!) \n");
            i = input.nextInt();

            switch (i) {
                case 1: {
                    System.out.print("Zadanie 1: \n");
                    System.out.print("Dla ilu liczb chcesz sprawdzić czasy losowania poszczególnych tablic? : \n");
                    Scanner getn = new Scanner(System.in);
                    int n;
                    n = getn.nextInt();

                    long startTime = System.nanoTime();

                    int [] anArray = new int[n];
                    for(int a = 0; a < n; a++){
                        anArray[a] = ThreadLocalRandom.current().nextInt(0, n+1);
                    }
                    long estimatedTime = System.nanoTime() - startTime;

                    System.out.println("Int Array for " + n + " elemments creation time elapsed: " + estimatedTime + " ns (1 ns = 0.000001 ms)");

                    startTime = System.nanoTime();

                    ArrayList<Integer> listArray = new ArrayList<Integer>();
                    for(int a = 0; a < n; a++){
                        listArray.add(ThreadLocalRandom.current().nextInt(0, n+1));
                    }
                    estimatedTime = System.nanoTime() - startTime;

                    System.out.println("Int ArrayList (with maximum size) for " + n + " elemments creation time elapsed: " + estimatedTime + " ns (1 ns = 0.000001 ms)");

                    startTime = System.nanoTime();

                    ArrayList<Integer> listArray1 = new ArrayList<Integer>(n);
                    for(int a = 0; a < n; a++){
                        listArray1.add(ThreadLocalRandom.current().nextInt(0, n+1));
                    }
                    estimatedTime = System.nanoTime() - startTime;

                    System.out.println("Int ArrayList (without maximum size) for " + n + " elemments creation time elapsed: " + estimatedTime + " ns (1 ns = 0.000001 ms)");

                    startTime = System.nanoTime();

                   LinkedList<Integer> listLinked = new LinkedList<Integer>();
                    for(int a = 0; a < n; a++){
                        listLinked.add(ThreadLocalRandom.current().nextInt(0, n+1));
                    }
                    estimatedTime = System.nanoTime() - startTime;

                    System.out.println("Int Linked list (with maximum size) for " + n + " elemments creation time elapsed: " + estimatedTime + " ns (1 ns = 0.000001 ms)");

                    /*
                    Their main difference is their implementation which causes different performance for different operations.
                    ArrayList is implemented as a resizable array. As more elements are added to ArrayList, its size is increased dynamically.
                    It's elements can be accessed directly by using the get and set methods, since ArrayList is essentially an array.
                    LinkedList is implemented as a double linked list.
                    Its performance on add and remove is better than Arraylist, but worse on get and set methods.
                    Vector is similar with ArrayList, but it is synchronized. ArrayList is a better choice if your program is thread-safe.
                    Vector and ArrayList require space as more elements are added.
                    Vector each time doubles its array size, while ArrayList grow 50% of its size each time.
                    LinkedList, however, also implements Queue interface which adds more methods than ArrayList and Vector, such as offer(), peek(), poll(), etc.
                    Note: The default initial capacity of an ArrayList is pretty small.
                    It is a good habit to construct the ArrayList with a higher initial capacity.
                    This can avoid the resizing cost.
                    */
                    break;
                }
                case 2: {
                    System.out.print("Zadanie 2: \n");
                    System.out.print("Podaj stopień silni do policzenia i zmierzenia jej czasu tworzenia: \n");
                    Scanner getn = new Scanner(System.in);
                    int n;
                    n = getn.nextInt();

                    long startTime = System.nanoTime();

                    BigInteger factorial = new BigInteger("1");
                    for(int a = 2; a <= n; a++){
                        factorial = factorial.multiply(BigInteger.valueOf(a));
                    }
                    long estimatedTime = System.nanoTime() - startTime;

                    System.out.println("Silnia dla n = " + n + " wynosi: " + factorial.toString() + " Execution time: " + estimatedTime + " ns (1 ns = 0.000001 ms).");
                    break;
                }
                case 3: {
                    System.out.print("Zadanie 3: \n");
                    List<String> lines = Files.readAllLines(new File("macbeth.txt").toPath());
                    int slowa = 0;
                    HashSet<String> words_set = new HashSet<String>();
                    for(String line : lines){
                        String[] words = line.toLowerCase().split("\\W+");
                        for(String word : words){
                            if(!word.isEmpty()){
                                slowa++;
                                words_set.add(word);
                                //System.out.print(word + "...");
                            }
                        }
                    }

                    System.out.print("W pliku macbeth.txt jest " + slowa + " słów \n");
                    System.out.print("oraz " + words_set.size() + " unikalnych słów \n");

                    break;
                }
                case 4: {
                    System.out.print("Zadanie 4: \n");
                    Stream<String> stream = Files.lines(new File("macbeth.txt").toPath());

                    stream = stream.flatMap((line) -> Arrays.stream(line.toLowerCase().split("\\W+")));

                    System.out.print("W pliku macbeth.txt jest" + stream.distinct().count() + " unikalnych słów \n");
                    break;
                }
                case 5: {
                    System.out.print("Zadanie 5: \n");
                    
                    Stream<String> stream = Files.lines(new File("macbeth.txt").toPath());

                    String[] list = stream.flatMap((line) -> Arrays.stream(line.toLowerCase().trim().split("\\W+"))).toArray(size -> new String[size]);

                    HashMap<String, Integer> mapa = new HashMap<String, Integer>();
                    for (int g=0; g<list.length ; g++) {
                        if(list[g].equals("")) continue;
                        else if (mapa.containsKey(list[g])) {
                            int cont = mapa.get(list[g]);
                            mapa.put(list[g], cont + 1);
                        } else {
                            mapa.put(list[g], 1);
                        }
                    }
                    Map sorted = sortMapByValue(mapa);

                    var it = sorted.entrySet().iterator();
                    for(int g = 0; g < 20; g++ ){
                        System.out.println((it.next()));
                    }

                    /*
                    sorted.forEach((key, value) -> {
                        System.out.println(key + " : " + value);
                    });
                    */
                    break;
                }
                case 6: {
                    System.out.print("Zadanie 6: \n");
                    Pracownik Kowalski = new Pracownik("Jan", "Kowalski", Stanowisko.DYREKTOR, 1200);
                    Pracownik Rico = new Pracownik("Rayan", "Rico", Stanowisko.KIEROWNIK, 1200);

                    System.out.println(Kowalski.toString());
                    System.out.println(Rico.toString());
                    break;
                }
                default: {
                    break;
                }
            }
        } while (i != 0);
    }
}

