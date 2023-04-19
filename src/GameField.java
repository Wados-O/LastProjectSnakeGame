import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.jar.JarEntry;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameField extends JPanel implements ActionListener {
  private final int SIZE = 600;
  private final int DOT_SIZE = 16;
  private final int ALL_DOTS = 600;

  private Image dot;
  private Image barrier;
  private int barrierX;
  private int barrierY;
  private Image apple;
  private int appleX;
  private int appleY;
  private int[] x = new int[ALL_DOTS];
  private int[] y = new int[ALL_DOTS];
  private int dots;
  private Timer timer;

  private ArrayList<Point> barriers = new ArrayList<Point>();
  private boolean left = false;
  private boolean right = true;
  private boolean up = false;
  private boolean down = false;
  private boolean inGame = true;

  public GameField(){
    setBackground(Color.BLACK);
    loadImages();
  }

public void initGame(){
  Barrier barrier = new Barrier();
  add(barrier);
  dots = 3;
  for (int i = 0; i < dots; i++) {
    x[i] = 48 - i * DOT_SIZE;
    y[i] = 48;
  }
  timer = new Timer(250, this);
  timer.start();
  createApple();
  createBarrier();

}
  public void createApple() {
    appleX = new Random().nextInt(20) * DOT_SIZE;
    appleY = new Random().nextInt(20) * DOT_SIZE;
  }
  public void createBarrier() {
    int barrierX = new Random().nextInt(20) * DOT_SIZE;
    int barrierY = new Random().nextInt(20) * DOT_SIZE;
    barriers.add(new Point(barrierX, barrierY));

  }

  public void loadImages() {
    ImageIcon iia = new ImageIcon("apple.png");
    apple = iia.getImage();
    ImageIcon iid = new ImageIcon("dot.png");
    dot = iid.getImage();
    ImageIcon iib = new ImageIcon("barrier.png");
    barrier = iib.getImage();
  }
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (inGame) {
      g.drawImage(apple, appleX, appleY, this);
      for (Point barrier : barriers) {
        g.drawImage(this.barrier, (int) barrier.getX(), (int) barrier.getY(), this);
      }
      for (int i = 0; i < dots; i++) {
        g.drawImage(dot, x[i], y[i], this);
      }
    } else {
      String str = "Game Over";
      g.setColor(Color.white);
      g.drawString(str, 255, SIZE / 2);


    }
  } public void move() {
    for (int i = dots; i > 0; i--) {
      x[i] = x[i - 1];
      y[i] = y[i - 1];
    }
    if (left) {
      x[0] -= DOT_SIZE;
    }
    if (right) {
      x[0] += DOT_SIZE;
    }
    if (up) {
      y[0] -= DOT_SIZE;
    }
    if (down) {
      y[0] += DOT_SIZE;
    }
    if (x[0] == appleX && y[0] == appleY) {
      dots++;
      createApple();
      createBarrier();
    }
  }

  public void checkApple() {
    if (x[0] == appleX && y[0] == appleY) {
      dots++;
      createApple();
    }

  }

  public void checkBarrier() {
    for (Point barrier : barriers) {
      if (x[0] == barrier.getX() && y[0] == barrier.getY()) {
        inGame = false;
        break;
      }
    }
  }

  public void checkCollisions() {
    for (int i = dots; i > 0; i--) {
      if (i > 4 && x[0] == x[i] && y[0] == y[i]) {
        inGame = false;
      }
    }

    if (x[0] > SIZE) {
      inGame = false;
    }
    if (x[0] < 0) {
      inGame = false;
    }
    if (y[0] > SIZE) {
      inGame = false;
    }
    if (y[0] < 0) {
      inGame = false;
    }
    // Проверка на столкновение с барьером
    if (x[0] == barrierX && y[0] == barrierY) {
      inGame = false;
    }
  }
  @Override
  public void actionPerformed(ActionEvent e) {

  }
}
