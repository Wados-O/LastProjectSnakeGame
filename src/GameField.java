import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameField extends JPanel implements ActionListener {
  private final int SIZE = 600;
  private final int DOT_SIZE = 16;
  private final int ALL_DOTS = 600;

  public Image barrier;
  public Image dot;
  private int barrierX;
  private int barrierY;
  public Image apple;
  public Image banana;
  public Image grape;
  private int bananaX;
  private int bananaY;
  private int grapeX;
  private int grapeY;
  int appleX;
  public int appleY;
  public int[] x = new int[ALL_DOTS];
  public int[] y = new int[ALL_DOTS];
  public int dots;
  int headX;
  public int headY;
  public Image head;

  public final ArrayList<Point> barriers = new ArrayList<>();
  public boolean left = false;
  public boolean right = true;
  public boolean up = false;
  public boolean down = false;
  public boolean inGame = true;
  public int score = 0;

  private final Sound gameOverSound = new Sound();
  private final Sound fruitSound = new Sound();
  public GameField() {
    try {
      gameOverSound.load("Sounds/game over.wav");
      fruitSound.load("Sounds/fruitSound.wav");
    } catch (Exception e) {
      System.err.println("audio error");
    }
    setBackground(Color.BLACK);
    loadImages();
    initGame();

    addKeyListener(new FieldKeyListener());
    setFocusable(true);
    setPreferredSize(new Dimension(SIZE, SIZE));
  }

  public void initGame() {
    dots = 3;
    for (int i = 0; i < dots; i++) {
      x[i] = 48 - i * DOT_SIZE;
      y[i] = 48;
    }
    Timer timer = new Timer(300, this);
    timer.start();
    createApple();
    createBarrier();
    createBanana();
    createGrape();
    createHead();
  }



  public void createHead() {
    headX = x[0];
    headY = y[0];
  }
  public void createApple() {
    appleX = new Random().nextInt(SIZE / DOT_SIZE) * DOT_SIZE;
    appleY = new Random().nextInt(SIZE / DOT_SIZE) * DOT_SIZE;
  }

  public void createBanana() {
    bananaX = new Random().nextInt(SIZE / DOT_SIZE) * DOT_SIZE;
    bananaY = new Random().nextInt(SIZE / DOT_SIZE) * DOT_SIZE;
  }

  public void createGrape() {
    grapeX = new Random().nextInt(SIZE / DOT_SIZE) * DOT_SIZE;
    grapeY = new Random().nextInt(SIZE / DOT_SIZE) * DOT_SIZE;
  }

  public void createBarrier() {
    int barrierX = new Random().nextInt(SIZE / DOT_SIZE) * DOT_SIZE;
    int barrierY = new Random().nextInt(SIZE / DOT_SIZE) * DOT_SIZE;
    barriers.add(new Point(barrierX, barrierY));

  }

  public void loadImages() {
    ImageIcon iih = new ImageIcon("head.png");
    head = iih.getImage();
    ImageIcon iia = new ImageIcon("apple.png");
    apple = iia.getImage();
    ImageIcon iid = new ImageIcon("dot.png");
    dot = iid.getImage();
    ImageIcon iib = new ImageIcon("boom.png");
    barrier = iib.getImage();
    ImageIcon iic = new ImageIcon("banana.png");
    banana = iic.getImage();
    ImageIcon iig = new ImageIcon("grape.png");
    grape = iig.getImage();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (inGame) {
      g.drawImage(apple, appleX, appleY, this);
      g.drawImage(banana, bananaX, bananaY, this);
      g.drawImage(grape, grapeX, grapeY, this);
      for (Point barrier : barriers) {
        g.drawImage(this.barrier, (int) barrier.getX(), (int) barrier.getY(), this);
      }
      for (int i = 0; i < dots; i++) {
        if (i == 0){
          g.drawImage(head,headX,headY,this);
        } else {
          g.drawImage(dot, x[i], y[i], this);
        }
      }
      g.setColor(Color.white);
      g.setFont(new Font("Terminator Two", Font.BOLD, 16));
      g.drawString("Score: " + score, SIZE - 120, 20);
    } else {
      String str = "Game Over";
      g.setColor(Color.white);
      setFont(new Font("Terminator Two", Font.BOLD, 36));
      g.drawString(str, 180, SIZE / 2);
      g.drawString("Score: " + score, SIZE / 2 - 100, SIZE / 2 + 50);


    }
  }

  public void move() {
    for (int i = dots; i > 0; i--) {
      x[i] = x[i - 1];
      y[i] = y[i - 1];
    }
    if (left) {
      x[0] -= DOT_SIZE;
      headX =x[0];
      head = new ImageIcon("head.png").getImage();
    }
    if (right) {
      x[0] += DOT_SIZE;
      headX = x[0];
      head = new ImageIcon("head.png").getImage();
    }
    if (up) {
      y[0] -= DOT_SIZE;
      headY = y[0];
      head = new ImageIcon("head.png").getImage();
    }
    if (down) {
      y[0] += DOT_SIZE;
      headY = y[0];
      head = new ImageIcon("head.png").getImage();
    }
    if (x[0] == appleX && y[0] == appleY) {
      dots++;
      score += 20;
      createApple();
      createBarrier();
      fruitSound.play();
      score++;
    }
    if (x[0] == bananaX && y[0] == bananaY) {
      dots++;
      score += 5;
      createBanana();
      createBarrier();
      fruitSound.play();
    }
    if (x[0] == grapeX && y[0] == grapeY) {
      dots++;
      score += 10;
      createGrape();
      createBarrier();
      fruitSound.play();
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
    if (inGame) {
      checkApple();
      checkBarrier();
      checkCollisions();
      if (!inGame) {
        gameOverSound.play();
      }
      move();

    }
    repaint();
  }

  class FieldKeyListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
      super.keyPressed(e);
      int key = e.getKeyCode();
      if (key == KeyEvent.VK_LEFT && !right) {
        left = true;
        up = false;
        down = false;
      }
      if (key == KeyEvent.VK_RIGHT && !left) {
        right = true;
        up = false;
        down = false;
      }

      if (key == KeyEvent.VK_UP && !down) {
        right = false;
        up = true;
        left = false;
      }
      if (key == KeyEvent.VK_DOWN && !up) {
        right = false;
        down = true;
        left = false;
      }
    }
  }
}
