// Создаём абстракный класс
abstract class Animal {
  string typeAnimal;
  int years;
  boolean sit;
  Animal(String typeA, int y, boolean s) {
    typeAnimal = typeA;
    years = y;
    sit = s;
  }
  abstract String voice();
  boolean sit_down() {
    if (sit) return true;
    else return false;
  }
}
