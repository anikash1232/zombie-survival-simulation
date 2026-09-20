# Zombie Survival Simulation

A multithreaded survival simulation in Java where each day plays out under a different
behavioural strategy, swapped at runtime.

## What it does

A base of survivors lives through a sequence of days. What happens on any given day depends
on which strategy is active — a quiet day passes uneventfully, midnight madness brings a
concentrated assault, random attacks strike unpredictably. Each day runs for a real duration
on its own thread, so the simulation unfolds in time rather than resolving instantly.

- Swappable day strategies, selected per day at runtime
- Survivors with individual state, managed by a central base
- Timed day execution on background threads, with interruption handled cleanly
- Strategies operate on the base without knowing about each other

## Architecture

```
IDayStrategy                   void execute(Base, int durationMilliseconds)
  QuietDayStrategy               nothing much happens
  MidnightMadnessStrategy        concentrated late assault
  RandomZombieAttacksStrategy    unpredictable strikes

IBase, Base                    survivor roster and base state
ISurvivor, Survivor            individual survivor state
ZombieApocalypse               drives the simulation, selects strategies
```

Every strategy implements one method and receives the base plus a duration. The simulation
loop never branches on what kind of day it is — it holds an `IDayStrategy` and calls
`execute`. Adding a new kind of day means writing one class and nothing else, and because
`execute` is declared `throws InterruptedException`, strategies that sleep or wait cooperate
properly with thread interruption instead of swallowing it.

## Running it

Requires Java 17+ and Maven.

```bash
mvn clean compile exec:java
```
