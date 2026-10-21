# Console RPG Java

A console-based Role Playing Game built entirely in pure Java.

## 🎯 Project Overview
The primary goal of this project is to deeply explore Object-Oriented Programming (OOP) principles, design patterns, clean architecture, and the Java Core library (Collections, Streams, I/O) without relying on external frameworks. The game features a turn-based combat system, inventory management, equipment scaling, and exploration mechanics.

## 🛠 Tech Stack
* **Language:** Java 21
* **Build Tool:** Maven
* **Version Control:** Git & GitHub

## 🏗 Core Architecture
This project strictly follows the **Single Responsibility Principle (SRP)** and favors **Composition over Inheritance** where appropriate.

### Domain Entities
* `Unit` (Abstract) — The base class for all living entities. Generates a unique `UUID` upon instantiation and handles core state (health, base damage).
    * `Hero` — The playable character.
    * `Enemy` — The opponent.

### Component-Based Design
Instead of making `Unit` a "God Object", its capabilities are modularized:
* `Inventory` — A container class managing a `List<Item>` that the `Unit` carries.
* `Equipment` — Manages equipped items (weapons, armor) and calculates dynamic stats (e.g., total damage).

### Item System
* `Item` (Abstract) — Base entity for objects, featuring a unique `UUID` and `Rarity` enum.
    * `Weapon`, `Potion` — Concrete item implementations.

### Core Systems
* `BattleManager` — Handles the interactive game loop and turn-based combat logic between a `Hero` and an `Enemy`.

## 🗺 Roadmap / Backlog

- [x] **Epic 1: Game Loop & Combat System** (Base entities, `BattleManager`, interactive I/O via Scanner).
- [ ] **Epic 2: Items & Inventory** (Item hierarchy, `Inventory` logic, slot-based `Equipment`, Loot Table). *(Currently In Progress)*
- [ ] **Epic 3: Magic & Classes** (Interfaces, Polymorphism, magic casting, Hero classes like Warrior/Mage).
- [ ] **Epic 4: World & Navigation** (Graphs, Locations, random encounters).
- [ ] **Epic 5: Game Save System** (I/O Streams, custom Exceptions, state serialization).
- [ ] **Epic 6: Polish & Patterns** (Design patterns like Factory, Stream API for filtering, advanced balancing).