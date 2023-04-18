

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SnakeFood {
  public class Food {
    private int x;
    private int y;
    private Image image;
    private final int DOT_SIZE;

    public Food(int dotSize) {
      DOT_SIZE = dotSize;
      loadImage();
      createFood();
    }

    private void loadImage() {
      ImageIcon apple = new ImageIcon("apple.png");
      image = apple.getImage();
      ImageIcon banana = new ImageIcon("Banana.png");
      image = banana.getImage();
      ImageIcon grape = new ImageIcon("grape.png");
      image = grape.getImage();
    }

    public void createFood() {
      x = new Random().nextInt(20) * DOT_SIZE;
      y = new Random().nextInt(20) * DOT_SIZE;
    }

    public Image getImage() {
      return image;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }
  }
}
