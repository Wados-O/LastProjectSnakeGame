import javax.swing.*;
import java.awt.*;

public class SnakeGameMenu extends JPanel {

  public SnakeGameMenu() {

    setLayout(new BorderLayout());
    setBackground(Color.BLACK);

    // Создание кнопок для главного меню
    JButton startButton = new JButton("Start");
    JButton exitButton = new JButton("Exit");

    // Добавление кнопок на панель
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(2, 1));
    buttonPanel.add(startButton);
    buttonPanel.add(exitButton);
    add(buttonPanel, BorderLayout.CENTER);

    // Добавление заголовка на панель
    JLabel titleLabel = new JLabel("Snake Game", JLabel.CENTER);
    titleLabel.setFont(new Font("PRICEDOWN", Font.BOLD, 80));
    titleLabel.setForeground(Color.WHITE);
    add(titleLabel, BorderLayout.NORTH);

    // Назначение действий для кнопок
    startButton.addActionListener(e -> {
      // Создание игрового поля и добавление его на панель
      GameField gameField = new GameField();
      Sound startGameSound = new Sound();
      try {
        startGameSound.load("Sounds/СsGo.wav");
      } catch (Exception ex) {
        throw new RuntimeException(ex);
      }
      startGameSound.play();
      JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
      parentFrame.getContentPane().removeAll();
      parentFrame.getContentPane().add(gameField);
      parentFrame.getContentPane().revalidate();
      parentFrame.getContentPane().repaint();
      gameField.requestFocusInWindow();
      // Запуск игры
      gameField.initGame();
      gameField.setVisible(true);
    });

    exitButton.addActionListener(e -> {
      System.exit(0);
    });
  }

  // Метод для запуска главного меню
  public static void main(String[] args) throws Exception {
    JFrame frame = new JFrame("Snake Game");
    Sound startMenuSound = new Sound();
    startMenuSound.load("Sounds/xpStart.wav");
    startMenuSound.play();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 630);
    frame.setLocationRelativeTo(null);
    frame.setContentPane(new SnakeGameMenu());
    frame.setVisible(true);
  }
}
