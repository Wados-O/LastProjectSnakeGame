import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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

  @Test
  public void testStartButton() {
    SnakeGameMenu menu = new SnakeGameMenu();
    Component[] components = menu.getComponents();
    for (Component component : components) {
      if (component instanceof JPanel) {
        JPanel panel = (JPanel) component;
        Component[] panelComponents = panel.getComponents();
        for (Component panelComponent : panelComponents) {
          if (panelComponent instanceof JButton) {
            JButton button = (JButton) panelComponent;
            if (button.getText().equals("START")) {
              assertTrue(button.isEnabled());
              assertTrue(button.isVisible());
              return;
            }
          }
        }
      }
    }
    fail("Button not found.");
  }
  @Test
  public void testExitButton(){
    SnakeGameMenu menu = new SnakeGameMenu();
    JButton exitButton = getMenuExitButton(menu);
    assertNotNull(exitButton);
    assertTrue(exitButton.isEnabled());
    assertTrue(exitButton.isVisible());
  }

  private JButton getMenuExitButton(Container container) {
    Component[] components = container.getComponents();
    for (Component component : components) {
      if (component instanceof JPanel) {
        JPanel panel = (JPanel) component;
        Component[] panelComponents = panel.getComponents();
        for (Component panelComponent : panelComponents) {
          if (panelComponent instanceof JButton && ((JButton) panelComponent).getText().equals("EXIT")) {
            return (JButton) panelComponent;
          }
        }
      }
    }
    return null;
  }

}

