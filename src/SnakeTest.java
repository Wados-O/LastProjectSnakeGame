import static org.junit.Assert.*;

import org.junit.Test;

public class SnakeTest {

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

    //ГДЕ ОШИБКА??????
    // нет ошибки )))
  }
//  @Test
//  public void testMoveRight() {
//    GameField snake = new GameField();
//    snake.up = true;
//
//
//    snake.dots = 3;
//    snake.x[0] = 80;
//    snake.y[0] = 100;
//    snake.x[1] = 70;
//    snake.y[1] = 100;
//    snake.x[2] = 60;
//    snake.y[2] = 100;
//
//    snake.move();
//
//    assertEquals(90, snake.x[0]);
//    assertEquals(100, snake.y[0]);
//    assertEquals(80, snake.x[1]);
//    assertEquals(100, snake.y[1]);
//    assertEquals(70, snake.x[2]);
//    assertEquals(100, snake.y[2]);
//  }

}