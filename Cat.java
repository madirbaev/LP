class Cat extends Animal {
  String breed;
  String color:
  Cat(String b, String c, int y) {
    super("Cat", y, true);
    breed = b;
    color = c;
  }
  String voice() {
    return "Meow";
  }
  String getBreed() {
    return breed;
  }
}
