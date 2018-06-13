package pl.poznan.put.jipp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.*;


public class UniqueWordCounter extends FileReader implements UniqueCounter {
    private ArrayList<String> text = new ArrayList<>();
    private int uniqueWordsCounter = 0;
    LinkedHashMap<String, Integer> uniqueWordList = new LinkedHashMap<>();

    public UniqueWordCounter(String fileName) throws FileNotFoundException {
        super(fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(this);
            String textLine;
            int lines = 0;

            do {
                text.add(textLine = bufferedReader.readLine());
                lines++;
            } while (textLine != null);
            System.out.println("Readed " + lines + " lines!");
            this.uniqueWords();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void display(){
        for(String line: text){
            System.out.println(line);
        }
    }

    public void displayUnique() {
        for(Entry<String, Integer> word: uniqueWordList.entrySet()){
            System.out.println(word.getKey() + " : " + word.getValue());
        }
        System.out.println("There is " + uniqueWordsCounter + " unique words!");
    }

    private void uniqueWords(){
        Map<String, Integer> wordList = new TreeMap<>();
        for(String line : text){
            if(line != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for(String word: words){
                    if(word.length() > 2){
                        if(wordList.containsKey(word)){
                            wordList.replace(word, wordList.get(word) + 1);
                        } else {
                            wordList.put(word, 1);
                            uniqueWordsCounter++;
                        }
                    }
                }
            }
        }

        wordList.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> uniqueWordList.put(x.getKey(), x.getValue()));
    }

    @Override
    public int countWords() {
        return uniqueWordsCounter;
    }

    @Override
    public int countWords(String firstLetter) {
        LinkedHashMap<String,Integer> words = new LinkedHashMap<>();
        uniqueWordList.entrySet().stream().filter(word -> word.getKey().charAt(0) == firstLetter.charAt(0)).forEachOrdered(x -> words.put(x.getKey(), x.getValue()));

        for(Entry<String, Integer> w : words.entrySet()){
            //System.out.println(w.getKey() + " : " + w.getValue());
        }

        return words.entrySet().size();
    }

    @Override
    public boolean exists(String word) {
        if(uniqueWordList.containsKey(word)) return true;
        return false;
    }
}
