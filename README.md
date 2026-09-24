# Tic Tac Toe

A simple two-player Tic Tac Toe game built with Java Swing. The game runs as a desktop window and lets two players take turns placing `X` and `O` on a 3x3 board.

## Features

- Java Swing graphical user interface
- Two-player local gameplay
- Turn indicator for the current player
- Winner and draw notifications
- Restart button for a new round

## Requirements

- Java Development Kit (JDK) 8 or later
- Git, if you want to download the project using Git

Check whether Java is installed:

```bash
java -version
javac -version
```

If either command is not recognized, install a JDK from [Adoptium](https://adoptium.net/) or [Oracle](https://www.oracle.com/java/technologies/downloads/).

## Download From GitHub

### Option 1: Clone with Git

```bash
git clone https://github.com/shantark/Tia-Tac-Toe.git
cd Tia-Tac-Toe
```

### Option 2: Download as a ZIP file

1. Open the project repository on GitHub.
2. Select the green **Code** button.
3. Select **Download ZIP**.
4. Extract the ZIP file.
5. Open a terminal in the extracted project folder.

## Compile and Run

From the folder containing `TicTacToe.java`, compile the program:

```bash
javac TicTacToe.java
```

Start the game:

```bash
java TicTacToe
```

On Windows PowerShell, the same commands work. If the project is stored in another folder, first move into that folder, for example:

```powershell
cd "C:\path\to\project"
javac TicTacToe.java
java TicTacToe
```

## How to Play

1. Run the program.
2. Click **START GAME**.
3. Player `X` goes first.
4. Click an empty square to place your symbol.
5. Player `O` takes the next turn.
6. Continue taking turns until a player wins or the board is full.
7. Click **Restart Game** to clear the board and begin a new round.

## Rules

- A player wins by placing three matching symbols in a row, column, or diagonal.
- An occupied square cannot be selected again.
- If all nine squares are occupied and nobody has three in a row, the match is a draw.
- After a win, the board is disabled. Use **Restart Game** to play again.

## Project Structure

```text
.
├── README.md
└── TicTacToe.java
```

## Troubleshooting

### `javac` is not recognized

Install a JDK and make sure its `bin` directory is included in your system `PATH`. Close and reopen the terminal after installing Java.

### `Could not find or load main class TicTacToe`

Make sure the terminal is in the folder containing `TicTacToe.class`, then run:

```bash
java TicTacToe
```

Do not include `.java` or `.class` in the run command.

### The window does not open

Run the application on a computer with a graphical desktop environment. This Swing application cannot display its window in a terminal-only or headless environment.

## License

No license has been specified for this project yet.
