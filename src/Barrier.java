import java.awt.Graphics;
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

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Размеры и координаты панели
    int panelWidth = getWidth();
    int panelHeight = getHeight();

    // Рисуем барьеры на краях панели
    g.drawImage(barrierImage, 0, 0, panelWidth, barrierImage.getHeight(), null); // верхняя граница
    g.drawImage(barrierImage, panelWidth - barrierImage.getWidth(), 0, barrierImage.getWidth(),
        panelHeight, null); // правая граница
    g.drawImage(barrierImage, 0, panelHeight - barrierImage.getHeight(), panelWidth,
        barrierImage.getHeight(), null); // нижняя граница
    g.drawImage(barrierImage, 0, 0, barrierImage.getWidth(), panelHeight,
        null);


  }
}
