// Исключение для ошибок, связанных с переполненной очередью.
public class QueueFullException extends Exception {
	int size;
	QueueFullException(int s) { size = s; }
	public String toString() {
		return "\nОчередь переполнена. Максимальный размер составляет " + size + " элементов.";
	}
}