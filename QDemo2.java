/*
	Упражнение 6.2.
	Усовершенствование класса Queue.
*/
// Класс очереди для символов.
class Queue {
	private char[] q;	// массив, хранящий данные очереди
	private int putloc, getloc;	// индексы для позиций помещения и извлечения
	// Конструирует пустой объект Queue на основе заданного размера.
	Queue(int size) {
		q = new char[size];	// выделение памяти под очередь
		putloc = getloc = 0;
	}
	// Конструирует объект Queue на основе объекта Queue.
	Queue(Queue ob) {
		putloc = ob.putloc;
		getloc = ob.getloc;
		q = new char[ob.q.length];
		// Копировать элементы.
		for(int i=getloc; i < putloc; i++)
			q[i] = ob.q[i];
	}
	// Конструирует объект Queue с начальными значениями.
	Queue(char[] a) {
		putloc = 0;
		getloc = 0;
		q = new char[a.length];
		for(int i = 0; i < a.length; i++)
			put(a[i]);
	}
	// Поместить символ в очередь.
	void put(char ch) {
		if(putloc==q.length) {
			System.out.println(" - Очередь переполнена.");
			return;
		}
		q[putloc++] = ch;
	}
	// Извлечь символ из очереди.
	char get() {
		if(getloc == putloc) {
			System.out.println(" - Очередь пуста.");
			return (char) 0;
		}
		return q[getloc++];
	}
}
// Демонстрация использования класса Queue.
class QDemo2 {
	public static void main(String[] args) {
		// Создать пустую очередь из 10 элементов.
		Queue q1 = new Queue(10);
		char[] name = {'Т', 'o', 'm'};

		// Создать очередь из массива.
		Queue q2 = new Queue(name);
		char ch;
		int i;

		// Поместить ряд символов в ql.
		for(i=0; i < 10; i++)
			q1.put((char) ('A' + i));

		// Создать очередь из другой очереди.
		Queue q3 = new Queue(q1);

		// Отобразить содержимое очередей.
		System.out.print("Содержимое q1: ");
		for(i=0; i < 10; i++) {
			ch = q1.get();
			System.out.print(ch);
		}
		System.out.println("\n");
		System.out.print("Содержимое q2: ");
		for(i=0; i < 3; i++) {
			ch = q2.get();
			System.out.print(ch);
		}
		System.out.println("\n");
		System.out.print("Содержимое q3: ");
		for(i=0; i < 10; i++) {
			ch = q3.get();
			System.out.print(ch);
		}
	}
}
