package com.comp301.a07zombie;

public class MidnightMadnessStrategy implements IDayStrategy {
  @Override
  public void execute(Base base, int durationMilliseconds) throws InterruptedException {
    int segment = durationMilliseconds / 5;

    System.out.println("The survivors settle in as darkness falls...");
    Thread.sleep((int) (segment * 0.8));

    System.out.println("A distant howl echoes through the night. Something is coming!");
    base.startAttack();
    Thread.sleep((int) (segment * 1.1));
    base.endAttack();

    System.out.println("The camp grows eerily quiet. Survivors brace for whatever lurks beyond.");
    Thread.sleep((int) (segment * 0.9));

    System.out.println("Suddenly, zombies burst through the barricades!");
    base.startAttack();
    Thread.sleep(segment);
    base.endAttack();

    System.out.println("The survivors light torches to scare off the last few undead stragglers.");
    Thread.sleep((int) (segment * 0.7));

    System.out.println("Dawn breaks, and the madness fades into uneasy silence...");
  }
}
