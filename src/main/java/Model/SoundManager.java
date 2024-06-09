package Model;

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
            File soundFile = new File(classLoader.getResource("Sound/lofi-synth-pattern-29946.wav").getFile());
            AudioInputStream audioInputStream1 = AudioSystem.getAudioInputStream(soundFile);
            Clip clip1 = AudioSystem.getClip();
            clip1.open(audioInputStream1);

            soundMap.put("easy", clip1);


            File soundFile2 = new File(classLoader.getResource("Sound/game-over-31-179699.wav").getFile());
            AudioInputStream audioInputStream2 = AudioSystem.getAudioInputStream(soundFile2);
            Clip clip2 = AudioSystem.getClip();
            clip2.open(audioInputStream2);

            soundMap.put("lose", clip2);

            File soundFile3 = new File(classLoader.getResource("Sound/goodresult-82807.wav").getFile());
            AudioInputStream audioInputStream3 = AudioSystem.getAudioInputStream(soundFile3);
            Clip clip3 = AudioSystem.getClip();
            clip3.open(audioInputStream3);

            soundMap.put("win", clip3);

            File soundFile4 = new File(classLoader.getResource("Sound/trap-pianos-200371.wav").getFile());
            AudioInputStream audioInputStream4 = AudioSystem.getAudioInputStream(soundFile4);
            Clip clip4 = AudioSystem.getClip();
            clip4.open(audioInputStream4);

            soundMap.put("medium", clip4);

            






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
    public void playnormalSound(String soundKey) {
        Clip clip = soundMap.get(soundKey);
        if (clip != null) {
            clip.setFramePosition(0); // Rewind to the beginning
            clip.start();
        }
    }

    public void closeAllClips() {
        for (Clip clip : soundMap.values()) {
            if (clip != null) {
                clip.stop();
                clip.close();
            }
        }
        soundMap.clear();
    }
}
