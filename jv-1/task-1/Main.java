class Car {
  String brand;
  Integer year;

  void printInfo() {
    System.out.println("Марка: " + brand + ", Год: " + year);
  }
}

public class Main {
  public static void main(String[] args) {
    Car car = new Car();
    car.brand = "Toyota";
    car.year = 2022;
    car.printInfo();
  }
}
