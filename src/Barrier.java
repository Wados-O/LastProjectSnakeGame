import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Barrier extends JPanel {
  private BufferedImage barrierImage;
  public Barrier() {
    try {
      barrierImage = ImageIO.read(new File("qube.png")); // чтение изображения из файла
    } catch (Exception e) {
      e.printStackTrace();
    }
    setOpaque(false); // прозрачность фона
  }
}
