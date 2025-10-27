package com.comp301.a07zombie;

public class RandomZombieAttacksStrategy implements IDayStrategy {
  @Override
  public void execute(Base base, int milliseconds) throws InterruptedException {
      long period = milliseconds / 5;

      Thread.sleep(period);

      base.startAttack();
      Thread.sleep(period);
      base.endAttack();

      Thread.sleep(period);

      base.startAttack();
      Thread.sleep(period);
      base.endAttack();

      Thread.sleep(period);
  }
}
