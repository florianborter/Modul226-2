package AB04;

public class Bibliothek {
    private Medium[] katalog;

    public void showSample(Medium m) {
        if (m instanceof Buch) {
            System.out.println(((Buch) m).getSample());
        } else if (m instanceof CD) {
            Player p = new Player();
            p.playSound(((CD) m).getSample());
        } else if (m instanceof DVD) {
            Player p = new Player();
            p.playVideo(((DVD) m).getSample());
        }
    }
}


abstract class Medium { }

class Buch extends Medium {
    private String sample;

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }
}

class CD extends Medium {
    private Sound sample;

    public Sound getSample() {
        return sample;
    }

    public void setSample(Sound sample) {
        this.sample = sample;
    }
}

class DVD extends Medium {
    private Video sample;

    public Video getSample() {
        return sample;
    }

    public void setSample(Video sample) {
        this.sample = sample;
    }
}

class Sound {  }
class Video {  }

class Player {
    public void playVideo(Video v) {
        // Video anzeigen ...
    }

    public void playSound(Sound s) {
        // Sound spielen ...
    }
}
