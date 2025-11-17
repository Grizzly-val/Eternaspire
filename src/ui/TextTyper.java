package ui;

import java.io.IOException;

public class TextTyper {

    private static final int MAX_SKIP_CHECK_DELAY = 100; // Milliseconds to wait before checking for input

    // Private helper method to clear any input buffered by the user
    private static void clearInputBuffer() {
        try {
            // Check if there are bytes available in the input stream (submitted input)
            while (System.in.available() > 0) {
                // Read and discard the byte
                System.in.read();
            }
        } catch (IOException e) {
            // Log the error but don't stop the program
            System.err.println("Error clearing input buffer: " + e.getMessage());
        }
    }

    public static void typeText(String text, int delayMillis, boolean endl) {
        boolean skip = false;
        
        // Clear the buffer BEFORE typing starts to ignore old, irrelevant inputs
        clearInputBuffer(); 

        for (char c : text.toCharArray()) {
            System.out.print(c);
            
            // Flush the output buffer to ensure the character appears immediately
            System.out.flush(); 

            // If the skip flag is set, don't sleep
            if (skip) {
                continue; 
            }

            try {
                // Only pause if a delay is actually requested (delayMillis > 0)
                if (delayMillis > 0) {
                    
                    // --- OPTIMIZATION FOR SKIP CHECK ---
                    // Only check for a skip input if the delay is long enough
                    if (delayMillis >= MAX_SKIP_CHECK_DELAY) {
                        Thread.sleep(delayMillis);
                    } else {
                        // For short delays, sleep only for the requested time
                        Thread.sleep(delayMillis); 
                    }
                }
                
                // Check if the user has typed anything (signaling a desire to skip)
                // We check System.in.available() right after sleep
                if (System.in.available() > 0) {
                    skip = true; // Set the skip flag
                    // Immediately print the rest of the text without further delay
                }

            } catch (InterruptedException e) {
                // If interrupted externally, print the rest of the text instantly
                skip = true;
                // Re-interrupt the thread for upstream code to handle
                Thread.currentThread().interrupt(); 
            } catch (IOException e) {
                // Handle I/O issues during input check
                System.err.println("I/O Error during skip check: " + e.getMessage());
            }
        }
        
        // Final flush to ensure all characters are printed before the endline
        System.out.flush(); 

        // Clear any input submitted during the typing process so it doesn't 
        // accidentally get consumed by the next input prompt.
        clearInputBuffer(); 

        if (endl) {
            System.out.println();
        }
    }
}