package Grafikeditor;

import Grafikeditor.Zeichnung;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

final class EditorControl {
  private List<Figur> figuren = new ArrayList<>();
  private char figurTyp;
  private Point ersterPunkt;


  public void allesNeuZeichnen(Graphics g) {
    //TODO: Erg�nzen

    Zeichnung zeichnung = new Zeichnung(figuren);
    zeichnung.zeichneFiguren(g);
  }

  public void setFigurTyp(char figurTyp) {
    this.figurTyp = figurTyp;
  }

  public void setErsterPunkt(Point ersterPunkt) {
    this.ersterPunkt = ersterPunkt;
  }

  public void erzeugeFigurMitZweitemPunkt(Point zweiterPunkt) {

    switch(figurTyp) {
      case 'r':
        figuren.add(createRechteck(zweiterPunkt));
        break;
      case 'l':
        figuren.add(createLinie(zweiterPunkt));
        break;
      case 'k':
        figuren.add(createKreis(zweiterPunkt));
        break;
    }



  }
  private Rechteck createRechteck(Point zweiterPunkt) {

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

  private Linie createLinie(Point zweiterPunkt) {
    return new Linie((int)ersterPunkt.getX(), (int)ersterPunkt.getY(), Color.BLACK, (int)zweiterPunkt.getX(), (int)zweiterPunkt.getY());
  }

  private Kreis createKreis(Point zweiterPunkt) {

    int biggerX;
    int biggerY;
    int smallerX;
    int smallerY;

    if (ersterPunkt.getX() > zweiterPunkt.getX()) {
      biggerX = (int)ersterPunkt.getX();
      smallerX = (int)zweiterPunkt.getX();
    } else {
      biggerX = (int)zweiterPunkt.getX();
      smallerX = (int)ersterPunkt.getX();
    }

    if (ersterPunkt.getY() > zweiterPunkt.getY()) {
      biggerY = (int)ersterPunkt.getY();
      smallerY = (int)zweiterPunkt.getY();
    } else {
      biggerY = (int)zweiterPunkt.getY();
      smallerY = (int)ersterPunkt.getY();
    }

    return new Kreis(smallerX, smallerY, Color.BLACK, (int)Math.hypot(biggerX - smallerX, biggerY - smallerY));
  }
}
