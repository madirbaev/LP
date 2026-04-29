// Добавление дополнительных конструкторов к TwoDShape.
class TwoDShape {
	private double width;
	private double height;
	// Стандартный конструктор.
	TwoDShape() {
		width = height = 0.0;
	}
	// Параметризованный конструктор.
	TwoDShape(double w, double h) {
		width = w;
		height = h;
	}
	// Конструктор объекта с одинаковыми шириной и высотой.
	TwoDShape(double х) {
		width = height = х;
	}
	// Методы доступа для width и height.
	double getWidth() { return width; }
	double getHeight() { return height; }
	void setWidth(double w) { width = w; }
	void setHeight(double h) { height = h; }
	void showDim() {
		System.out.println("Ширина и высота: " + width + " и " + height);
	}
}
// Подкласс TwoDShape для представления треугольников.
class Triangle extends TwoDShape {
	private String style;
	// Стандартный конструктор.
	Triangle() {
		super();
		style = "отсутствует";
	}
	// Конструктор.
	Triangle(String s, double w, double h) {
		super(w, h); // вызов конструктора суперкласса
		style = s;
	}
	// Конструктор с одним аргументом.
	Triangle(double х) {
		super(х); // вызов конструктора суперкласса
		style = "закрашенный";
	}
	double area() {
		return getWidth() * getHeight() / 2;
	}
	void showStyle() {
		System.out.println("Стиль треугольника: " + style);
	}
}
class Shapes4 {
	public static void main(String[] args) {
		Triangle tl = new Triangle();
		Triangle t2 = new Triangle("контурный", 8.0, 12.0);
		Triangle t3 = new Triangle(4.0);
		tl = t2;
		System.out.println("Информация об объекте tl: ");
		tl.showStyle();
		tl.showDim();
		System.out.println("Площадь: " + tl.area());
		System.out.println();
		System.out.println("Информация об объекте t2: ");
		t2.showStyle();
		t2.showDim();
		System.out.println("Площадь: " + t2.area());
		System.out.println();
		System.out.println("Информация об объекте t3: ");
		t3.showStyle();
		t3.showDim();
		System.out.println("Площадь: " + t3.area());
		System.out.println();
	}
}
