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

        //  WEEK 4 

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


        //  WEEK 5 

        gamePanel = new JPanel(new BorderLayout());

        turnLabel = new JLabel("Player X Turn", SwingConstants.CENTER);
        turnLabel.setFont(new Font("Arial", Font.BOLD, 24));
        turnLabel.setOpaque(true);
        turnLabel.setBackground(new Color(30, 30, 30));
        turnLabel.setForeground(Color.WHITE);

        gamePanel.add(turnLabel, BorderLayout.NORTH);

        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3));

        gamePanel.add(boardPanel, BorderLayout.CENTER);

        add(homePanel, "HOME");
        add(gamePanel, "GAME");

        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "HOME");

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == startButton) {
            CardLayout cl =
                (CardLayout) getContentPane().getLayout();

            cl.show(getContentPane(), "GAME");
            gameStarted = true;
        }
    }


    public static void main(String[] args) {
        new TicTacToe();
    }
}