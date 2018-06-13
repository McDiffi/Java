package pl.poznan.put.jipp;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Klasa pomocnicza ułatwiająca odczyt oraz tokenizację plików tekstowych.
 *
 * @author Michał Ciesielczyk
 */
public abstract class FileReader {

	private final String filename;

	/**
	 * Konstruktor.
	 *
	 * @param filename nazwa pliku tekstowego do odczytu
	 */
	public FileReader(String filename) {
		this.filename = filename;
	}

	/**
	 * Otwiera podany w konstruktorze plik i czyta jego zawartość, wywołując metodę
	 * {@link #next(String) next(String)} dla każdego kolejnego wyrazu w tekście.
	 *
	 * @throws IOException w przypadku wystąpienia błędu podczas odczytu pliku.
	 */
	public final void read() throws IOException {
		try (Scanner sc = new Scanner(new File(filename))) {
			while (sc.hasNext()) {
				next(sc.next().toUpperCase().replaceAll("[^\\p{IsAlphabetic}]", ""));
			}
		}
	}

	/**
	 * Metoda wywoływana dla każdego kolejnego wyrazu w tekście. Wszystkie litery w podanym
	 * wyrazie są kapitalizowane.
	 *
	 * Metoda powinna zostać zaimplementowana w klasach dziedziczących.
	 *
	 * @param word aktualnie czytane słowo
	 */
	public abstract void next(String word);

}
