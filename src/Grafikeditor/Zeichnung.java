package Grafikeditor;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Zeichnung extends JFrame {

    private List<Figur> figuren = new ArrayList<Figur>();

    public Zeichnung() {
        this.figuren = new ArrayList<>();
    }

    public Zeichnung(List<Figur> figuren) {
        this.figuren = figuren;
    }

    public void zeichneFiguren(Graphics g) {
        figuren.forEach(i -> i.zeichne(g));
    }


    public void addFigur(Figur f) {
        figuren.add(f);
    }
}
