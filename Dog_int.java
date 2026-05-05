class Dog_int implements Animals_int {
  int years;
  String breed;
  String typeOfAnimal;
  Dog_int(int y, String b) {
    years = y;
    breed = b;
    typeOfAnimal = "Dog";
  }
  public String voice() {
    return "Woof";
  }
  public String getBreed() {
    return breed;
  }
  public int getInt() {
    return years;
  }
}
