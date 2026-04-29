// Добавление конструкторов к TwoDShape.
class TwoDShape {
	private double width;
	private double height;
	// Параметризованный конструктор.
	TwoDShape(double w, double h) {
		width = w;
		height = h;
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
	Triangle(String s, double w, double h) {
		super(w, h); // вызов конструктора суперкласса
		style = s;
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
		Triangle tl = new Triangle("закрашенный", 4.0, 4.0);
		Triangle t2 = new Triangle("контурный", 8.0, 12.0);
		System.out.println("Информация об объекте tl: ");
		tl.showStyle();
		tl.showDim();
		System.out.println("Площадь: " + tl.area());
		System.out.println();
		System.out.println("Информация об объекте t2: ");
		t2.showStyle();
		t2.showDim();
		System.out.println("Площадь: " + t2.area());
	}
}