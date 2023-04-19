import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.jar.JarEntry;
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
    loadimage();
  }



  @Override
  public void actionPerformed(ActionEvent e) {

  }
}
