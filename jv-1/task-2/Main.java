class Car {
  private String brand;
  private int year;

  void printInfo() {
    System.out.println(this);
  }

  public void setYear(int newYear) {
    year = newYear;
  }

  void setBrand (String newBrand) {
    brand = newBrand;
  }

  public Car(String brand, int year) {
    this.brand = brand;
    this.year = year;
  }

  @Override
  public String toString() {
    return "Марка: " + brand + ", Год: " + year;
  }
}

public class Main {
  public static void main(String[] args) {
    Car car = new Car("Toyota", 1995);
    car.setBrand("Audi");
    car.setYear(2005);
    car.printInfo();
  }
}
