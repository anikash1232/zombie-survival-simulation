package com.comp301.a07zombie;

public class RandomZombieAttacksStrategy implements IDayStrategy {
  @Override
  public void execute(Base base, int milliseconds) throws InterruptedException {
    int attackDuration = (int) (milliseconds * 0.2);
    int restDuration = (int) (milliseconds * 0.2);

    Thread.sleep(milliseconds - (2 * attackDuration + restDuration));

    base.startAttack();
    Thread.sleep(attackDuration);
    base.endAttack();

    Thread.sleep(restDuration);

    base.startAttack();
    Thread.sleep(attackDuration);
    base.endAttack();

    Thread.sleep(milliseconds - (2 * attackDuration + restDuration));
  }
}
