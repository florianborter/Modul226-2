package Grafikeditor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

final class EditorControl {
  private List<Figur> figuren = new ArrayList<>();
  private Zeichnung zeichnung = new Zeichnung(figuren);
  private char figurTyp;
  private Point ersterPunkt;

  public void allesNeuZeichnen(Graphics g) {
    zeichnung = new Zeichnung(figuren);
    zeichnung.zeichneFiguren(g);
  }

  public void setFigurTyp(char figurTyp) {
    this.figurTyp = figurTyp;
    System.out.println(figurTyp);
  }

  public void setErsterPunkt(Point ersterPunkt) {
    this.ersterPunkt = ersterPunkt;
    System.out.println("erster Punkt : " + ersterPunkt.getX() + " , " + ersterPunkt.getY());
  }

  public void erzeugeFigurMitZweitemPunkt(Point zweiterPunkt) {
    //TODO: Erg�nzen
    System.out.println("zweiter Punkt : " + zweiterPunkt.getX() + " , " + zweiterPunkt.getY());
    switch (figurTyp){
      case 'r':
        figuren.add(createRechteck(zweiterPunkt));
        break;
      case 'l':
        figuren.add(createLinie(zweiterPunkt));
        break;
      case 'k':
        figuren.add(createLinie(zweiterPunkt));
        break;
    }


  }

  private Rechteck createRechteck(Point zweiterPunkt){
    int smallerX;
    int smallerY;
    int biggerX;
    int biggerY;

    if (ersterPunkt.getX() < zweiterPunkt.getX()) {
      smallerX = (int)ersterPunkt.getX();
      biggerX = (int)zweiterPunkt.getX();
    } else {
      smallerX = (int)zweiterPunkt.getX();
      biggerX = (int)ersterPunkt.getX();
    }

    if (ersterPunkt.getY() < zweiterPunkt.getY()) {
      smallerY = (int)ersterPunkt.getY();
      biggerY = (int)zweiterPunkt.getY();
    } else {
      smallerY = (int)zweiterPunkt.getY();
      biggerY = (int)ersterPunkt.getY();
    }

    return new Rechteck(smallerX, smallerY, Color.BLACK, biggerX - smallerX, biggerY - smallerY);
  }

  private Linie createLinie(Point zweiterPunkt){
    return new Linie((int)ersterPunkt.getX(), (int)ersterPunkt.getY(), Color.PINK, (int)zweiterPunkt.getX(), (int)zweiterPunkt.getY());
  }

  private Kreis createKreis(Point zweiterPunkt){
    return new Kreis((int)ersterPunkt.getX(), (int)zweiterPunkt.getY(), Color.ORANGE, (int)zweiterPunkt.getX()-(int)ersterPunkt.getX());
  }
}
