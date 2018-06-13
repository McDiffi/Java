package pl.poznan.put.jipp;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Synchroniczna kolejka o ograniczonym rozmiarze.
 *
 * @author Michał Ciesielczyk
 * @param <E> typ elementu przechowywanego w kolejce
 */
public class SynchronizedQueue<E> {

	private final int maxSize;
	private Queue<E> queue = new LinkedList<>();

	/**
	 * Tworzy kolejkę o ograniczonym rozmiarze.
	 *
	 * @param maxSize maksymalna liczba elementów kolejki.
	 */
	public SynchronizedQueue(int maxSize) {
		this.maxSize = maxSize;
	}

	/**
	 * Dodaje nowy element do kolejki.
	 *
	 * @param e nowy element.
	 * @throws InterruptedException w przypadku przerwania danego wątku.
	 */
	public synchronized void add(E e) throws InterruptedException {
		while (queue.size() >= maxSize) {
			wait();
		}
		queue.add(e);
		notify();
	}

	/**
	 * Zwraca element z początku kolejki jednocześnie go z niej usuwając.
	 *
	 * @return element z początku kolejki.
	 * @throws InterruptedException w przypadku przerwania danego wątku.
	 */
	public synchronized E poll() throws InterruptedException {
		while (queue.isEmpty()) {
			wait();
		}
		E e = queue.poll();
		notify();
		return e;
	}

}
