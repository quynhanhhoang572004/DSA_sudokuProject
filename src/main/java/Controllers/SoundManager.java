package Controllers;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class SoundManager {
    private final Map<String, Clip> soundMap;

    public SoundManager() {
        soundMap = new HashMap<>();
        loadSounds();
    }

    private void loadSounds() {

        try {
            ClassLoader classLoader = this.getClass().getClassLoader();
            File soundFile = new File(classLoader.getResource("Sound/trap-pianos-200371.wav").getFile());
            AudioInputStream audioInputStream1 = AudioSystem.getAudioInputStream(soundFile);
            Clip clip1 = AudioSystem.getClip();
            clip1.open(audioInputStream1);

            soundMap.put("sound1", clip1);

//            File soundFile2 = new File("/Sound/pianos-by-jtwayne-7-174717.mp3");
//            AudioInputStream audioInputStream2 = AudioSystem.getAudioInputStream(soundFile2);
//            Clip clip2 = AudioSystem.getClip();
//            clip2.open(audioInputStream2);
//            soundMap.put("sound2", clip2);


        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void playSound(String soundKey) {
        Clip clip = soundMap.get(soundKey);
        if (clip != null) {
            clip.setFramePosition(0); // Rewind to the beginning
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        }
    }

    public void stopSound(String soundKey) {
        Clip clip = soundMap.get(soundKey);
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}
