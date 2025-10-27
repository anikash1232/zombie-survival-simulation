package com.comp301.a07zombie;

public class RandomZombieAttacksStrategy implements IDayStrategy {
    @Override
    public void execute(Base base, int milliseconds) throws InterruptedException {
        int attackDuration = milliseconds / 5;
        int restDuration = (milliseconds - 2 * attackDuration) / 3;

        base.startAttack();
        Thread.sleep(attackDuration);
        base.endAttack();

        Thread.sleep(restDuration);

        base.startAttack();
        Thread.sleep(attackDuration);
        base.endAttack();

        Thread.sleep(restDuration);
    }
}
