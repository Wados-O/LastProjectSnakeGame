import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.swing.JFrame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SnakeGameMenuTest {

  @Test
  public void testSnakeGameMenu() {
    SnakeGameMenu menu = new SnakeGameMenu();
    assertNotNull(menu);
  }

  @Test
  public void testMain() throws Exception {
    Thread thread = new Thread(() -> {
      try {
        SnakeGameMenu.main(new String[0]);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    });
    thread.start();
    Thread.sleep(4000);
    assertTrue(JFrame.getFrames().length > 0);
    thread.interrupt();
  }
}
