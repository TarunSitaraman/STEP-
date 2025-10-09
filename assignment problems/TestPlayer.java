// Define interface
interface Playable {
    void play();
    void pause();
}

// MusicPlayer implements Playable
class MusicPlayer implements Playable {
    @Override
    public void play() {
        System.out.println("Playing music...");
    }

    @Override
    public void pause() {
        System.out.println("Music paused.");
    }
}

// VideoPlayer implements Playable
class VideoPlayer implements Playable {
    @Override
    public void play() {
        System.out.println("Playing video...");
    }

    @Override
    public void pause() {
        System.out.println("Video paused.");
    }
}

// Test class
public class TestPlayer {
    public static void main(String[] args) {
        Playable ref;

        ref = new MusicPlayer();
        ref.play();
        ref.pause();

        System.out.println("---");

        ref = new VideoPlayer();
        ref.play();
        ref.pause();
    }
}
