A simple Java-based chess game with a graphical user interface (GUI) built using javax.swing. The game allows users to move pieces on the chessboard by clicking and dragging, with basic chess rules implemented for piece movement.

Features
Graphical User Interface (GUI): A simple 2D chessboard is rendered using Java's Graphics class.
Mouse Interaction: Users can interact with the chess pieces using mouse clicks and drag-and-drop functionality.
Piece Movement: Supports movement of all standard chess pieces including King, Queen, Rook, Bishop, Knight, and Pawn.
Basic Chess Rules: Implements basic chess rules such as piece movement and turn-based gameplay.
Getting Started
Prerequisites
Java Development Kit (JDK) 8 or later.
An Integrated Development Environment (IDE) like IntelliJ IDEA, Eclipse, or NetBeans.
Installation
Clone the repository:

bash
Copy code
git clone https://github.com/yourusername/chessgame.git
Open the project in your preferred IDE.

Download the chess piece images:

Ensure that you have the chess piece images (chess.png) in the specified location or update the path in the code.

plaintext
Copy code
C:\Users\Taatheer\Downloads\chess.png
Run the program:

Execute the main method in the ChessGame class to start the game.

Usage
Moving Pieces:

Click and drag a piece to move it to a different square on the board.
Release the mouse button to place the piece on the desired square.
Piece Selection:

Click on any piece to select it. The piece will follow the mouse until it is placed on a valid square.
Code Structure
ChessGame.java: The main class that handles the GUI setup, event listeners, and piece movement logic.
Pieces.java: A class (not provided in the snippet) that represents individual chess pieces, including their type, position, and movement logic.
Mouse Listeners: Inner classes mouseListener and mouseMotionListener handle mouse events like dragging and dropping pieces.
Contributing
Contributions are welcome! If you have any improvements or bug fixes, feel free to fork the repository and submit a pull request.

Fork the repository
Create a new branch (git checkout -b feature-branch)
Make your changes
Commit your changes (git commit -m 'Add some feature')
Push to the branch (git push origin feature-branch)
Open a Pull Request
License
This project is licensed under the MIT License - see the LICENSE file for details.

Contact
For any questions or suggestions, feel free to reach out to the project author.
