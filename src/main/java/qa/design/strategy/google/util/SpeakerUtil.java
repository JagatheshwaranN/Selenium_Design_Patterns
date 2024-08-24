package qa.design.strategy.google.util;

import com.sun.speech.freetts.VoiceManager;

public class SpeakerUtil {

    static com.sun.speech.freetts.Voice systemVoice = null;

    public static void allocate() {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        systemVoice = VoiceManager.getInstance().getVoice("kevin");
        systemVoice.allocate();
    }

    public static void speak(String text) {
        systemVoice.speak(text);
    }

    public static void deallocate() {
        systemVoice.deallocate();
    }
}
