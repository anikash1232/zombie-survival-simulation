package com.comp301.a07zombie;

public class ZombieApocalypse {
  protected static Base base;
  protected static Survivor[] survivors;
  protected static Thread[] survivorThreads;

  public static void main(String[] args) throws InterruptedException {
    IDayStrategy strategy = new QuietDayStrategy();
    startSimulation(5);
    simulateDayNightCycle(20000, strategy);
    endSimulation();
  }

  public static void startSimulation(int numSurvivors) {
    base = new Base();
    survivors = new Survivor[numSurvivors];
    survivorThreads = new Thread[numSurvivors];

    for (int i = 0; i < numSurvivors; i++) {
      survivors[i] = new Survivor(base);
      survivorThreads[i] = new Thread(survivors[i], "Survivor-" + (i + 1));
      survivorThreads[i].start();
    }
  }

  public static void simulateDayNightCycle(int milliseconds, IDayStrategy events)
          throws InterruptedException {
    events.execute(base, milliseconds);
  }

  public static void endSimulation() throws InterruptedException {
    System.out.println("Simulation ending...");
    for (Survivor s : survivors) {
      s.stop();
    }
    for (Thread t : survivorThreads) {
      t.join();
    }
    System.out.println("All survivors have stopped. Simulation over.");
  }
}
