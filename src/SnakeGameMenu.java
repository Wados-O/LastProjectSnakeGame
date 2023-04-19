import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SnakeGameMenu extends JPanel {
  public SnakeGameMenu(){

    setLayout(new BorderLayout());
    setBackground(Color.BLACK);

    // Создание кнопок для главного меню
    JButton startButton = new JButton("Start the GAME");
    JButton exitButton = new JButton("Exit");

    // Добавление кнопок на панель
    JPanel buttonPanel =new JPanel();
    buttonPanel.setLayout(new GridLayout(2, 1));
    buttonPanel.add(startButton);
    buttonPanel.add(exitButton);
    add(buttonPanel, BorderLayout.CENTER);



  }










  public static void main(String[] args) {
    System.out.println("Hello world!");


  }
}