class Car {
  private String brand;
  private int year;

  void printInfo() {
    System.out.println("Марка: " + brand + ", Год: " + year);
  }

  public void setBrand(String newBrand) {
    brand = newBrand;
  }

  public void setYear(int newYear) {
    year = newYear;
  }
}

public class Main {
  public static void main(String[] args) {
    Car car = new Car();
    car.setBrand("Toyota");
    car.setYear(2005);
    car.printInfo();
  }
}
