package Grafikeditor;
import java.awt.*;

public class Linie extends Figur {

    private int endX;
    private int endY;

    public Linie(int x, int y, Color color, int endX, int endY) {
        super(x, y, color);
        this.endX = endX;
        this.endY = endY;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    @Override
    public void zeichne(Graphics g) {
        g.setColor(getColor());
        g.drawLine(getX(), getY(), endX, endY);
    }

    @Override
    public String prepapreToSave() {
        return FigurArten.LINIE.toString() + ";" + getX() + ";" + getY() + ";" + getColor().getRGB() + ";" + getEndX() + ";" + getEndY();
    }
}
