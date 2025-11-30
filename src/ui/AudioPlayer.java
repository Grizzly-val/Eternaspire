package ui;

import javax.sound.sampled.*;
import java.io.File;

public class AudioPlayer {

    private static Clip currentClip = null;
    private static String currentPath = null;

    // Stores last playback frame position per file
    private static long lastFrame = 0;

    /**
     * Regular play:
     * - If same audio → resume from saved frame
     * - If different → play from start
     */
    public static void play(String filePath) {

        String fullPath = "src/resources/background_audio/" + filePath;

        // Same audio → resume
        if (currentClip != null && fullPath.equals(currentPath)) {
            currentClip.setFramePosition((int) lastFrame);
            currentClip.start();
            currentClip.loop(Clip.LOOP_CONTINUOUSLY);
            return;
        }

        // New audio → reset resume position
        lastFrame = 0;
        startNewClip(fullPath);
    }

    /**
     * Always plays from the very beginning,
     * even if it's the same audio file.
     */
    public static void playFromStart(String filePath) {

        String fullPath = "src/resources/background_audio/" + filePath;

        // Reset resume frame
        lastFrame = 0;

        startNewClip(fullPath);
    }



    public static void playOverlay(String filePath) {
        String fullPath = "src/resources/background_audio/" + filePath;

        try {
            File file = new File(fullPath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

            Clip overlayClip = AudioSystem.getClip();
            overlayClip.open(audioStream);

            // Optional volume lowering for overlay
            if (overlayClip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                FloatControl ctrl = (FloatControl) overlayClip.getControl(FloatControl.Type.MASTER_GAIN);
                ctrl.setValue(-5.0f); // Adjust overlay volume
            }

            overlayClip.start();

            // Auto-close when finished playing (prevents memory leak)
            overlayClip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    overlayClip.close();
                }
            });

        } catch (Exception e) {
            System.out.println("| Cannot load overlay audio: " + fullPath);
        }
    }

    /**
     * Internal helper — opens and plays new file
     */
    private static void startNewClip(String fullPath) {
        stop();

        try {
            File file = new File(fullPath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

            currentClip = AudioSystem.getClip();
            currentClip.open(audioStream);
            currentPath = fullPath;

            // Lower volume
            if (currentClip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                FloatControl ctrl = (FloatControl) currentClip.getControl(FloatControl.Type.MASTER_GAIN);
                ctrl.setValue(-10.0f);
            }

            currentClip.setFramePosition(0);
            currentClip.start();
            currentClip.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (Exception e) {
            System.out.println("| Cannot load audio file: " + fullPath);
        }
    }

    /**
     * Stop the audio — saves the last frame for resume.
     */
    public static void stop() {
        if (currentClip != null) {

            // Save current frame for resume
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
