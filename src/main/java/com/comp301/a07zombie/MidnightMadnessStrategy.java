package com.comp301.a07zombie;

public class MidnightMadnessStrategy implements IDayStrategy {
  @Override
  public void execute(Base base, int durationMilliseconds) throws InterruptedException {
    int segment = durationMilliseconds / 10;

    System.out.println("The survivors settle in as darkness falls...");
    Thread.sleep(segment);

    System.out.println("A distant howl echoes through the night. Something is coming!");
    base.startAttack();
    Thread.sleep(2 * segment);
    base.endAttack();

    System.out.println("The camp grows eerily quiet. Survivors brace for whatever lurks beyond.");
    Thread.sleep(2 * segment);

    System.out.println("Suddenly, zombies burst through the barricades!");
    base.startAttack();
    Thread.sleep(3 * segment);
    base.endAttack();

    System.out.println("Dawn breaks, and the madness fades into uneasy silence...");
    Thread.sleep(2 * segment);
  }
}
