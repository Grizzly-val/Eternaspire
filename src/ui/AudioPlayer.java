package ui;

import javax.sound.sampled.*;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;

public class AudioPlayer {

    private static Clip currentClip = null;
    private static String currentPath = null;

    // Stores last playback frame position per file
    private static long lastFrame = 0;

    public static void play(String filePath) {

        TextTyper.typeText("\n\n......\n\n", 90, true);
        String fullPath = "src/resources/background_audio/" + filePath;

        // If it's the same audio and it's paused → resume
        if (currentClip != null && fullPath.equals(currentPath)) {
            currentClip.setFramePosition((int) lastFrame);
            currentClip.start();
            currentClip.loop(Clip.LOOP_CONTINUOUSLY);
            return;
        }

        // New audio → stop previous
        stop();

        try {
            File file = new File(fullPath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

            currentClip = AudioSystem.getClip();
            currentClip.open(audioStream);
            currentPath = fullPath;

            // LOWER VOLUME
            if (currentClip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                FloatControl ctrl = (FloatControl) currentClip.getControl(FloatControl.Type.MASTER_GAIN);
                ctrl.setValue(-27.0f);
            }

            // If returning to this audio, restore position
            currentClip.setFramePosition((int) lastFrame);

            currentClip.start();
            currentClip.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void stop() {
        if (currentClip != null) {

            // Save the last frame WHERE WE STOPPED
            lastFrame = currentClip.getLongFramePosition();

            currentClip.stop();
            currentClip.close();
            currentClip = null;
        }
    }

    public static boolean isPlaying() {
        return currentClip != null && currentClip.isRunning();
    }
}
