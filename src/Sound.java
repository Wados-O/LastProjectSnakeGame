import java.io.File;
import javax.sound.sampled.*;

public class Sound {
  private Clip clip;

  public void load(String filename) throws Exception {
    AudioInputStream ais = AudioSystem.getAudioInputStream(
        new File(filename));
    clip = AudioSystem.getClip();
    clip.open(ais);
  }



  public void play() {
    clip.setFramePosition(0);
    clip.start();
  }

  public Clip getClip() {
    return clip;
  }
}
