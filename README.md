# World of Zuul — Java Text Adventure

A small command-line adventure game set around a university campus. Explore rooms by entering text commands and navigate back to your previous room.

## Features

- A connected map of rooms, including the library, lab, theater, pub, office, and cellar.
- Directional movement using `go north`, `go south`, `go east`, `go west`, `go up`, or `go down` where an exit exists.
- A command parser with `go`, `back`, `help`, and `quit`.
- Basic invalid-command and unavailable-exit handling.

## Code structure

| File | Responsibility |
| --- | --- |
| `Game.java` | Initializes rooms and runs the game loop. |
| `Room.java` | Stores each room's description and available exits. |
| `Parser.java` | Reads and interprets player input. |
| `Command.java` / `CommandWords.java` | Represents commands and validates command names. |
| `directions.java` | Additional direction-related code. |

## Running the game

Open the Java files in an IDE, compile the project, and invoke:

```java
new Game().play();
```

**Note:** The repository currently has no standalone `main` method or build configuration, so `java Game` by itself will not launch it. Adding a runner class is a possible next step.

## Example commands

```text
help
go north
go down
back
quit
```

## Implementation notes

The game uses Java classes to separate parsing, commands, and room navigation. Each room keeps its exits in a `Map<String, Room>`, allowing a direction to map to the next room.
