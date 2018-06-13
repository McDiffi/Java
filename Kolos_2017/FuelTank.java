package pl.poznan.put.jipp;

/**
 * Klasa reprezentująca pojazdy posiadające zbiornik paliwa.
 *
 * @author Michał Ciesielczyk
 */
public interface FuelTank {

	/**
	 * Uzupełnia zbiornik o podaną ilość paliwa. Ilość paliwa musi być nieujemna.
	 *
	 * @param fuelAmount ilość paliwa (musi być nieujemna).
	 */
	public void refuel(int fuelAmount);

	/**
	 * Zwraca aktualną ilość paliwa.
	 *
	 * @return aktualna ilość paliwa.
	 */
	public int getFuelLevel();

	/**
	 * Zwraca zużycie paliwa na jednostkę odległości
	 *
	 * @return zużycie paliwa na jednostkę odległości.
	 */
	public int getFuelConsumption();

}
