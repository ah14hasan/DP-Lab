// ===== Target Interface (what the client knows how to use) =====
interface MediaPlayer {
    void play(String audioType, String filename);
}

// ===== Adaptee (an existing class with an INCOMPATIBLE interface) =====
class AdvancedMediaPlayer {
    public void playMp4(String filename) {
        System.out.println("Playing mp4 file: " + filename);
    }
    public void playVlc(String filename) {
        System.out.println("Playing vlc file: " + filename);
    }
}

// ===== Adapter (wraps the Adaptee to match the Target interface) =====
class MediaAdapter implements MediaPlayer {
    private final AdvancedMediaPlayer advancedPlayer = new AdvancedMediaPlayer();

    public void play(String audioType, String filename) {
        if (audioType.equalsIgnoreCase("mp4")) {
            advancedPlayer.playMp4(filename);
        } else if (audioType.equalsIgnoreCase("vlc")) {
            advancedPlayer.playVlc(filename);
        }
    }
}

// ===== Client =====
// Natively supports mp3; delegates other formats to the adapter.
class AudioPlayer implements MediaPlayer {
    public void play(String audioType, String filename) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file: " + filename);
        } else if (audioType.equalsIgnoreCase("mp4") || audioType.equalsIgnoreCase("vlc")) {
            // Use the adapter to make AdvancedMediaPlayer look like a MediaPlayer.
            MediaPlayer adapter = new MediaAdapter();
            adapter.play(audioType, filename);
        } else {
            System.out.println("Format not supported: " + audioType);
        }
    }
}

// ===== Main =====
public class AdapterDemo {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();

        player.play("mp3", "song.mp3");      // handled natively
        player.play("mp4", "movie.mp4");     // handled via adapter
        player.play("vlc", "video.vlc");     // handled via adapter
        player.play("avi", "clip.avi");      // unsupported
    }
}
