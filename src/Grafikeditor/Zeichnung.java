package Grafikeditor;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Zeichnung extends JFrame {

    private List<Figur> figuren = new ArrayList<Figur>();

    public Zeichnung(List<Figur> figuren) {
        this.figuren = figuren;
    }

    public void zeichneFiguren(Graphics g) {
        figuren.forEach(i -> i.zeichne(g));
    }

    public void save() {

    }

    public void load() {

    }
}
