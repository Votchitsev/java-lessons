class Counter {
  static int total = 0;

  void increment() {
    total += 1;
  }

  void printTotal() {
    System.out.println(total);
  }
}

public class Main {
  public static void main(String[] args) {
    Counter counter1 = new Counter();
    Counter counter2 = new Counter();
    Counter counter3 = new Counter();
    counter1.increment();
    counter2.increment();
    counter3.increment();

    counter2.printTotal();
  }
}
