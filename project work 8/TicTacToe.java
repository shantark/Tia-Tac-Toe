import javax.swing.*;
import java.awt.*;
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
        setLayout(new CardLayout());


        homePanel = new JPanel();
        homePanel.setBackground(new Color(20, 30, 60));
        homePanel.setLayout(null);

        titleLabel = new JLabel("TIC TAC TOE");
        titleLabel.setBounds(180, 40, 400, 50);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.CYAN);
        homePanel.add(titleLabel);

        JLabel imageLabel = new JLabel("GAME IMAGE");
        imageLabel.setBounds(180, 120, 300, 220);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setBorder(
            BorderFactory.createLineBorder(Color.WHITE, 2)
        );
        imageLabel.setForeground(Color.WHITE);
        imageLabel.setFont(new Font("Arial", Font.BOLD, 22));
        homePanel.add(imageLabel);

        startButton = new JButton("START GAME");
        startButton.setBounds(230, 390, 200, 50);
        startButton.setFont(new Font("Arial", Font.BOLD, 22));
        startButton.addActionListener(this);
        homePanel.add(startButton);

        gamePanel = new JPanel(new BorderLayout());

        turnLabel = new JLabel(
            "Player X Turn",
            SwingConstants.CENTER
        );

        turnLabel.setFont(new Font("Arial", Font.BOLD, 24));
        turnLabel.setOpaque(true);
        turnLabel.setBackground(new Color(30, 30, 30));
        turnLabel.setForeground(Color.WHITE);

        gamePanel.add(turnLabel, BorderLayout.NORTH);

        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3));

        Font font = new Font("Arial", Font.BOLD, 70);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                buttons[i][j] = new JButton("");

                buttons[i][j].setFont(font);
                buttons[i][j].setFocusable(false);
                buttons[i][j].addActionListener(this);

                boardPanel.add(buttons[i][j]);
            }
        }

        gamePanel.add(boardPanel, BorderLayout.CENTER);


        add(homePanel, "HOME");
        add(gamePanel, "GAME");

        CardLayout cl =
            (CardLayout) getContentPane().getLayout();

        cl.show(getContentPane(), "HOME");

        setVisible(true);
    }
    //WEEK 7 

    @Override
    public void actionPerformed(ActionEvent e) {

        CardLayout cl =
            (CardLayout) getContentPane().getLayout();


        if (e.getSource() == startButton) {

            cl.show(getContentPane(), "GAME");

            gameStarted = true;

            currentPlayer = 'X';

            turnLabel.setText("Player X Turn");

            return;
        }


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (e.getSource() == buttons[i][j]) {

                    if (!buttons[i][j].getText().equals("")) {
                        return;
                    }

                    buttons[i][j].setText(
                        String.valueOf(currentPlayer)
                    );
    //WEEK 8

                    if (checkWinner()) {

                        JOptionPane.showMessageDialog(
                            this,
                            "Player " + currentPlayer + " Wins!"
                        );

                        disableBoard();

                        return;
                    }

                    if (isBoardFull()) {

                        JOptionPane.showMessageDialog(
                            this,
                            "Match Draw!"
                        );

                        return;
                    }

                    if (currentPlayer == 'X') {
                        currentPlayer = 'O';
                    } else {
                        currentPlayer = 'X';
                    }

                    turnLabel.setText(
                        "Player " + currentPlayer + " Turn"
                    );
                }
            }
        }
    }
    private boolean checkWinner() {


        for (int i = 0; i < 3; i++) {

            if (!buttons[i][0].getText().equals("") &&
                buttons[i][0].getText().equals(
                    buttons[i][1].getText()
                ) &&
                buttons[i][1].getText().equals(
                    buttons[i][2].getText()
                )) {

                return true;
            }
        }


        for (int i = 0; i < 3; i++) {

            if (!buttons[0][i].getText().equals("") &&
                buttons[0][i].getText().equals(
                    buttons[1][i].getText()
                ) &&
                buttons[1][i].getText().equals(
                    buttons[2][i].getText()
                )) {

                return true;
            }
        }


        if (!buttons[0][0].getText().equals("") &&
            buttons[0][0].getText().equals(
                buttons[1][1].getText()
            ) &&
            buttons[1][1].getText().equals(
                buttons[2][2].getText()
            )) {

            return true;
        }

        if (!buttons[0][2].getText().equals("") &&
            buttons[0][2].getText().equals(
                buttons[1][1].getText()
            ) &&
            buttons[1][1].getText().equals(
                buttons[2][0].getText()
            )) {

            return true;
        }


        return false;
    }

    private boolean isBoardFull() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (buttons[i][j].getText().equals("")) {
                    return false;
                }
            }
        }

        return true;
    }

    private void disableBoard() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                buttons[i][j].setEnabled(false);
            }
        }
    }


    public static void main(String[] args) {
        new TicTacToe();
    }
}