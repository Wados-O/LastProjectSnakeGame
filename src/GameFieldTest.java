import static org.junit.Assert.*;

import org.junit.Test;

public class GameFieldTest {

  @Test
  public void testMoveLeft() {
    // Создаем змею
    GameField snake = new GameField();
    snake.left = true;
    snake.dots = 3;
    snake.x[0] = 80;
    snake.y[0] = 100;
    snake.x[1] = 90;
    snake.y[1] = 100;
    snake.x[2] = 100;
    snake.y[2] = 100;

    snake.move();

    assertEquals(80, snake.x[0]);
    assertEquals(100, snake.y[0]);
    assertEquals(80, snake.x[1]);
    assertEquals(100, snake.y[1]);
    assertEquals(90, snake.x[2]);
    assertEquals(100, snake.y[2]);


  }
  @Test
  public void testLoadHeadImage() {
    GameField snake = new GameField();
    snake.loadImages();
    assertNotNull(snake.head);
  }

  @Test
  public void testLoadAppleImage() {
    GameField snake = new GameField();
    snake.loadImages();
    assertNotNull(snake.apple);
  }

  @Test
  public void testLoadDotImage() {
    GameField snake = new GameField();
    snake.loadImages();
    assertNotNull(snake.dot);
  }

  @Test
  public void testLoadBarrierImage() {
    GameField snake = new GameField();
    snake.loadImages();
    assertNotNull(snake.barrier);
  }

  @Test
  public void testLoadBananaImage() {
    GameField snake = new GameField();
    snake.loadImages();
    assertNotNull(snake.banana);
  }

  @Test
  public void testLoadGrapeImage() {
    GameField snake = new GameField();
    snake.loadImages();
    assertNotNull(snake.grape);
  }
}