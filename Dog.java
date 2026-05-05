// Создаём статичный класс Собаки
class Dog extends Animal {
  String breed;
  Dog(String b, int y) {
    super("Dog", y, true);
    breed = b;
  }
  String voice() {
    return "Woof";
  }
}
