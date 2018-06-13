package pl.poznan.put.jipp;

/**
 * Interfejs reprezentujący dowolny pojazd.
 *
 * @author Michał Ciesielczyk
 */
public interface Vehicle {

	/**
	 * Klasa reprezentująca wyjątki zgłaszane podczas poruszania się pojazdu.
	 */
	public static class MoveException extends Exception {

		/**
		 * Konstruktor.
		 *
		 * @param message wiadomość wyjątku.
		 */
		public MoveException(String message) {
			super(message);
		}
	}

	/**
	 * Porusza pojazd na wskazaną odległość (spokojnie, to tylko symulacja - nigdzie tak na
	 * prawdę nie jedziemy). Wartość odległości musi być nieujemna.
	 *
	 * @param distance odległość, którą powinien wykonać pojazd (musi być nieujemna).
	 * @throws pl.poznan.put.jipp.Vehicle.MoveException w przypadku gdy wystąpiła wyjątkowa
	 * sytuacja podczas poruszania się pojazdu.
	 */
	public void move(int distance) throws MoveException;

}
