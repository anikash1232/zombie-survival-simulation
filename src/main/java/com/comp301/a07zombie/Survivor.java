package com.comp301.a07zombie;

import java.util.Random;

public class Survivor implements ISurvivor {
    private Base base;
    private static boolean flag = false;

    public Survivor(Base base) {
        this.base = base;
    }

    @Override
    public void stop() {
        flag = true;
    }

    @Override
    public void run() {
        while (!flag) {
            try {
                performAction();
            } catch (InterruptedException e) {
                stop();
            }
        }
    }

    protected void performAction() throws InterruptedException {
        Random random = new Random();
        int zeroThruTwo = random.nextInt(3);

        if (zeroThruTwo == 0) {
            rest();
        } else if (zeroThruTwo == 1) {
            scavenge();
        } else if (zeroThruTwo == 2) {
            fortify();
        }
    }

    protected void scavenge() throws InterruptedException {
        Random random = new Random();
        int min = 1000;
        int max = 4000;
        int number = random.nextInt(max - min + 1) + min;
        System.out.println("Survivor is scavenging for supplies!");
        Thread.sleep(number);
        base.addSupplies(2);
    }

    protected void fortify() throws InterruptedException {
        base.useTool("fortification");
        System.out.println("Survivor is fortifying the base!");
        Thread.sleep(2000);
    }

    protected void rest() throws InterruptedException {
        System.out.println("Survivor is resting!");
        Thread.sleep(2000);
    }
}
