// Исключение для ошибок, связанных с пустой очередью.
public class QueueEmptyException extends Exception {
	public String toString() {
		return "\nОчередь пуста.";
	}
}
