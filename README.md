# StickHero Game

This is a JavaFX-based recreation of the popular Stick Hero game. The player must stretch a stick to bridge the gap between pillars and guide the hero safely across. The project demonstrates event-driven programming, animation, and JavaFX GUI design.

## Features

- Interactive home screen and game screen
- Randomized pillar distances and widths for replayability
- Smooth hero movement and stick animation
- Basic scoring and game-over logic
- Modular, object-oriented code structure using JavaFX

## Getting Started

### Prerequisites

- Java 17+
- Maven
- JavaFX SDK

### How to Run

1. Clone the repository.
2. Navigate to the `AP_Project` directory.
3. Build and run using Maven or your preferred IDE.

```sh
mvn clean javafx:run
```

---

## Code Structure

### Main Classes

#### 1. `Main.java`
- Entry point of the application.
- Initializes JavaFX and launches the home screen via `homeScreenController`.

#### 2. `homeScreenController.java`
- Controls the home/start screen.
- Handles game start and exit actions.
- Implements `basicFunctions` interface.
- Method `Display()` creates and returns the initial stage with the start screen.

#### 3. `gameController.java`
- Core game logic and GUI updates.
- Manages pillars, hero, stick, and main animations.
- Handles transitions (stick growth, rotation, hero movement, pillar movement).
- Detects game-over conditions and score increments.
- Contains utility methods for pillar generation and stick mechanics.

#### 4. `endGameController.java`
- Controls the end game screen.
- Inherits from `gameController` and implements `basicFunctions`.
- Handles high score viewing and exiting the game.

#### 5. `Pillars.java`
- Represents the game’s pillars.
- Randomly generates pillar distances and widths.
- Provides getter/setter methods for pillar properties.

#### 6. `basicFunctions.java`
- Interface defining essential game actions:
  - `startGame(ActionEvent event)`
  - `exitGame(ActionEvent event)`

---

## Class Relationships

- `Main` launches the app, displaying the home screen.
- `homeScreenController` transitions to the game screen (`gameController`) on game start.
- `gameController` manages the game scene, including hero and pillar animations.
- If the hero falls, `gameController` loads the end game screen, managed by `endGameController`.
- All controllers may use pillar objects from `Pillars`.

---

## Customization & Extending

- Add new features (e.g., scoring, collectibles) in `gameController`.
- UI layouts can be edited in FXML files under the `resources` directory.
- Additional game modes or visual effects can be plugged into the animation logic.

---

## Authors

- Snehil Jaiswal

---

## Acknowledgements

Inspired by the classic Stick Hero mobile game.
