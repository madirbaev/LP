// Упражнение 8.1. Создание интерфейса для очереди.

// Класс, реализующий очередь фиксированного размера для хранения символов.
class FixedQueue implements ICharQ {
	private char q[];	// Массив для хранения элементов очереди.
	private int putloc, getloc;	// Индексы размещения и извлечения элементов очереди.
	// создать пустую очередь заданного размера.
	public FixedQueue(int size) {
	q = new char[size];	// выделить память для очереди.
	putloc = getloc = 0;
	}

	// поместить символ в очередь.
	public void put(char ch) {
		if(putloc==q.length) {
			System.out.println(" - Очередь переполнена.");
			return;
		}
		q[putloc++] = ch;
	}

	// извлечь символ из очереди.
	public char get() {
		if(getloc == putloc) {
			System.out.println(" - Очередь пуста.");
			return (char) 0;
		}
		return q[getloc++];
	}
}

// Кольцевая очередь.
class CircularQueue implements ICharQ {
	private char q[];	// Массив для хранения элементов очереди.
	private int putloc, getloc;	// Индексы размещения и извлечения элементов очереди.
	// создать пустую очередь заданного размера.
	public CircularQueue (int size) {
		q = new char[size];	// выделить память для очереди.
		putloc = getloc = 0;
	}

	// поместить символ в очередь.
	public void put(char ch) {
		/* Очередь считается полной, если индекс putloc на единицу меньше индекса getloc или если индекс putloc указывает на конец массива, а индекс getloc - на его начало. */
		if(putloc+1==getloc | ((putloc==q.length-1) & (getloc==0))) {
			System.out.println(" - Очередь переполнена.");
			return;
		}
		q[putloc++] = ch;
		if(putloc==q.length) putloc = 0;	// закольцевать.
	}
	// извлечь символ из очереди.
	public char get() {
		if(getloc == putloc) {
			System.out.println(" - Очередь пуста.");
			return (char) 0;
		}
		char ch = q[getloc++];
		if(getloc==q.length) getloc = 0;	// закольцевать.
		return ch;
	}
}

// Динамическая очередь.
class DynQueue implements ICharQ {
	private char q[];	// Массив для хранения элементов очереди.
	private int putloc, getloc;	// Индексы размещения и извлечения элементов очереди.
	// создать пустую очередь заданного размера.
	public DynQueue(int size) {
		q = new char[size+1]; // выделить память для очереди
		putloc = getloc = 0;
	}

	// поместить символ в очередь.
	public void put(char ch) {
		if(putloc==q.length) {
			// увеличить размер очереди.
			char[] t = new char[q.length * 2];
			// скопировать элементы в новую очередь.
			for(int i=0; i < q.length; i++)
				t[i] = q[i];
			q = t;
		}
		q[putloc++] = ch;
	}
	// извлечь символ из очереди.
	public char get() {
		if(getloc == putloc) {
			System.out.println(" - Очередь пуста.");
			return (char) 0;
		}
		return q[getloc++];
	}
}

// Демонстрация использования интерфейса ICharQ.
class IQDemo {
	public static void main(String[] args) {
		FixedQueue q1 = new FixedQueue(10);
		DynQueue q2 = new DynQueue(5);
		CircularQueue q3 = new CircularQueue(10);

		ICharQ iQ;
		char ch;
		int i;

		iQ = q1;
		// поместить ряд символов в очередь фиксированного размера.
		for(i=0; i < 10; i++)
			iQ.put((char) ('A' + i));
		// отобразить содержимое очереди.
		System.out.print("Содержимое очереди фиксированного размера: ");
		for(i=0; i < 10; i++)   {
			ch = iQ.get();
			System.out.print(ch);
		}
		System.out.println();
		iQ = q2;
		// поместить ряд символов в динамическую очередь.
		for (i=0; i < 10; i++)
			iQ.put((char) ('Z' - i));
		// отобразить содержимое очереди.
		System.out.print("Содержимое динамической очереди: ");
		for(i=0; i < 10; i++) {
			ch = iQ.get();
			System.out.print(ch);
		}
		System.out.println();
		iQ = q3;
		// поместить ряд символов в кольцевую очередь.
		for (i=0; i < 10; i++)
			iQ.put((char) ('A' + i));
		// отобразить содержимое очереди.
		System.out.print("Содержимое кольцевой очереди: ");
		for(i=0; i < 10; i++) {
			ch = iQ.get();
			System.out.print(ch);
		}
		System.out.println();

		// поместить дополнительные символы в кольцевую очередь.
		for(i=10; i < 20; i++)
			iQ.put((char) ('A' + i));
		// отобразить содержимое очереди.
		System.out.print("Содержимое кольцевой очереди: ");
		for(i=0; i < 10; i++)   {
			ch = iQ.get();
			System.out.print(ch);
		}

		System.out.println("\nСохранение и использование элементов в кольцевой очереди.");
		// Сохранение и использование элементов в кольцевой очереди.
		for(i=0; i < 20; i++) {
			iQ.put((char) ('A' + i));
			ch = iQ.get();
			System.out.print(ch);
		}
	}
}