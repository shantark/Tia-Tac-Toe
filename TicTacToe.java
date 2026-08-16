import javax.swing.*;
import java.awt.event.*;

public class TicTacToe extends JFrame implements ActionListener {

    JButton[][] buttons = new JButton[3][3];
    JButton startButton, restartButton;

    JPanel homePanel, gamePanel, boardPanel;

    JLabel titleLabel, turnLabel;

    char currentPlayer = 'X';
    boolean gameStarted = false;

    public TicTacToe() {

        setTitle("Tic Tac Toe");
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}