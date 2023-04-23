
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.Clip;


import static org.junit.jupiter.api.Assertions.*;

public class SoundTest {

  @BeforeEach
  public void setUp() throws Exception {
    Sound sound = new Sound();
    sound.load("Sounds/csgo.wav");
  }

  @Test
  public void testLoad()throws Exception{
    Sound sound = new Sound();
    sound.load("Sounds/csgo.wav");
    Clip clip = sound.getClip();
    assertNotNull(clip);
  }
  @Test
  public void testPlay() throws Exception {
    Sound sound = new Sound();
   // URL url = getClass().getResource("Sounds/csgo.wav");
    sound.load("Sounds/csgo.wav");
    sound.play();
    Thread.sleep(5000);
    assertFalse(sound.getClip().isRunning());
  }
}