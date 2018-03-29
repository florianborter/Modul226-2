package Grafikeditor;
import java.awt.*;
import java.util.Arrays;

public class Polygon extends Figur{

    private int[] xPoints;
    private int[] yPoints;

    public Polygon(int x, int y, Color color, int[] xPoints, int[] yPoints) {
        super(x, y, color);
        this.xPoints = xPoints;
        this.yPoints = yPoints;
    }

    public int[] getxPoints() {
        return xPoints;
    }

    public void setxPoints(int[] xPoints) {
        this.xPoints = xPoints;
    }

    public int[] getyPoints() {
        return yPoints;
    }

    public void setyPoints(int[] yPoints) {
        this.yPoints = yPoints;
    }

    @Override
    public void zeichne(Graphics g) {
        g.drawPolygon(xPoints, yPoints, xPoints.length);
        g.setColor(getColor());
        g.fillPolygon(xPoints, yPoints, xPoints.length);
    }

    @Override
    public String prepapreToSave() {
        StringBuilder sb = new StringBuilder();
        sb.append(FigurArten.POLYGON.toString() + ";" + getX() + ";" + getY() + ";" + getColor().getRGB() + ";");
        for(int i = 0; i < xPoints.length; i++) {
            if (i < xPoints.length - 1) {
                sb.append(xPoints[i] + ",");
            } else {
                sb.append(xPoints[i]);
            }
        }
        sb.append(";");
        for(int i = 0; i < yPoints.length; i++) {
            if (i < yPoints.length - 1) {
                sb.append(yPoints[i] + ",");
            } else {
                sb.append(yPoints[i]);
            }
        }
        return sb.toString();
    }
}
