package pl.poznan.put.jipp;

/**
 * Interfejs dla kolekcji unikalnych słów.
 *
 * @author Michał Ciesielczyk
 */
public interface UniqueCounter {

	/**
	 * Zwraca liczbę unikalnych słów w przechowywanej kolekcji.
	 *
	 * @return liczba unikalnych słów.
	 */
	public int countWords();

	/**
	 * Zwraca liczbę unikalnych słów w przechowywanej kolekcji rozpoczynających się od podanej
	 * litery.
	 *
	 * @param firstLetter pierwsza litera poszukiwanych wyrazów
	 * @return liczba unikalnych słów rozpoczynających się od podanej litery.
	 */
	public int countWords(String firstLetter);

	/**
	 * Sprawdza czy dane słowo istnieje w przechowywanej kolekcji.
	 *
	 * @param word sprawdzane słowo	 *
	 * @return zwraca {@code true} jeśli dane słowo istnieje w przechowywanej kolekcji oraz
	 * {@code false} w przeciwnym wypadku.
	 */
	public boolean exists(String word);

}
