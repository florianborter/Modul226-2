package Grafikeditor;
import java.awt.*;

public class Kreis extends Figur {

    private int radius;

    public Kreis(int x, int y, Color color, int radius) {
        super(x, y, color);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void zeichne(Graphics g) {
        //g.drawOval(getX(), getY(), getRadius(), getRadius());

        g.setColor(getColor());
        g.fillOval(getX(), getY(), radius, radius);
    }

    @Override
    public String prepapreToSave() {
        return FigurArten.KREIS.toString() + ";" + getX() + ";" + getY() + ";" + getColor().getRGB() + ";" + getRadius();
    }
}
