package com.comp301.a07zombie;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Base implements IBase {
  private int SupplyCount;
  private Lock lock;

  public Base(){
    this.SupplyCount = 0;
    lock = new ReentrantLock();
  }

  @Override
  public synchronized void addSupplies(int amount) {
    if (amount <= 0){
      throw new IllegalArgumentException();
    }
    else{
      SupplyCount += amount;
      System.out.println(Thread.currentThread().getName() + "added" + amount + "supplies. Total: " + this.SupplyCount);
    }

  }

  @Override
  public synchronized int getSupplyCount() {
    return this.SupplyCount;
  }

  @Override
  public void useTool(String task) {
    lock.lock();
    try{
      System.out.println("Survivor is using tool for" + task);
      Thread.sleep(1000);
      System.out.println("Survivor is no longer using tool!");
    }
    catch(InterruptedException e){
      System.out.println("oops sum went wrong!");
    }
    finally{
      lock.unlock();
    }




  }
}
