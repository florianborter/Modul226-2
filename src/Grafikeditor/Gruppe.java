package Grafikeditor;
import java.util.ArrayList;
import java.util.List;

public class Gruppe {
List<Figur> figuren = new ArrayList<Figur>();

    private String name;

    public Gruppe(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(Figur f) {
        figuren.add(f);
    }

    public List<Figur> getFiguren() {
        return figuren;
    }
}
