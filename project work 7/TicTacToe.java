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
        homePanel.add(startButton)  ;

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


        //  WEEK 6 

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


        //  WEEK 7 

        add(homePanel, "HOME");
        add(gamePanel, "GAME");

        CardLayout cl =
            (CardLayout) getContentPane().getLayout();

        cl.show(getContentPane(), "HOME");

        setVisible(true);
    }


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


    public static void main(String[] args) {
        new TicTacToe();
    }
}