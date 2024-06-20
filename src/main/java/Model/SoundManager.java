/* Name: Hoang Ngoc Quynh Anh
 Purpose: This game, called Soduku (female edition), includes five levels: easy, medium, hard, expert, and evil.
 The 6x6 sodoku game's easy and medium levels require players to fill in each row and column from 1 to 6.
 This level is intended for novices and features a smaller grid that is simpler to understand and solve.
 If you're new to Sudoku or just want a short and entertaining challenge, this is ideal for you.
 On the other hand, level hard, expert, evil is a 9x9 sodoku game designed for players who want to push their mental
 limits and find it somewhat more difficult to complete the puzzles. Players must fill each row and column from 1 to 9.
*/
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

            File soundFile5 = new File(classLoader.getResource("Sound/trap-pianos-200371.wav").getFile());
            AudioInputStream audioInputStream5 = AudioSystem.getAudioInputStream(soundFile5);
            Clip clip5 = AudioSystem.getClip();
            clip5.open(audioInputStream5);

            soundMap.put("hard", clip5);

            File soundFile6 = new File(classLoader.getResource("Sound/waves-gentle-med-cu-lake-water-ttp-24-96-180618-23154.wav").getFile());
            AudioInputStream audioInputStream6 = AudioSystem.getAudioInputStream(soundFile6);
            Clip clip6 = AudioSystem.getClip();
            clip6.open(audioInputStream6);

            soundMap.put("expert", clip6);

            File soundFile7 = new File(classLoader.getResource("Sound/waves-hitting-the-rocks-16680.wav").getFile());
            AudioInputStream audioInputStream7 = AudioSystem.getAudioInputStream(soundFile7);
            Clip clip7 = AudioSystem.getClip();
            clip7.open(audioInputStream7);

            soundMap.put("evil", clip7);





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
