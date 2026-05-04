// Класс для представления очереди символов фиксированного размера, в котором используются исключения.
class FixedQueue implements ICharQ {
	private char[] q;	// массив, в котором хранится очередь.
	private int putloc, getloc;	// индексы для позиций помещения и извлечения.
	
	// Конструктор пустой очереди заданного размера.
	public FixedQueue(int size) {
		q = new char[size];	// выделение памяти под очередь.
		putloc = getloc = 0;
	}
	// Поместить символ в очередь.
	public void put(char ch)
		throws QueueFullException {
		if(putloc==q.length)
			throw new QueueFullException(q.length);
		q[putloc++] = ch;
	}
	// Извлечь символ из очереди.
	public char get()
		throws QueueEmptyException {
		if(getloc == putloc)
			throw new QueueEmptyException();
		return q[getloc++];
	}
}
