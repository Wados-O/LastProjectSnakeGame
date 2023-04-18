
import javax.swing.*;

public class GameScore extends JPanel {
  private JLabel scoreLabel;
  private int score;

  public GameScore() {
    score = 0;
    scoreLabel = new JLabel("Score: " + score);
    add(scoreLabel);
  }

  public void addScore() {
    score++;
    scoreLabel.setText("Score: " + score);
  }

  public void resetScore() {
    score = 0;
    scoreLabel.setText("Score: " + score);
  }
}