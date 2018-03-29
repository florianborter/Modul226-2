package Grafikeditor;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Util {

    public void saveFigur(Figur f) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:/temp/savedGraphics.txt", true));
            bw.write(f.prepapreToSave() + "\n");
            bw.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Figur> readFigur() {
        try {
            ArrayList<Figur> figuren = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader("C:/temp/savedGraphics.txt"));
            String input;
            while((input = br.readLine()) != null) {
                figuren.add(interpretData(input));
            }
            return figuren;

        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public void clearFile() {
        try {
            BufferedWriter clear = new BufferedWriter(new FileWriter("C:/temp/savedGraphics.txt"));
            clear.write("");
            clear.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Figur interpretData(String line) {
        String[] values = line.split(";");
        Color color = new Color(Integer.parseInt(values[3]));
        int x = Integer.parseInt(values[1]);
        int y = Integer.parseInt(values[2]);
        switch(values[0]) {
            case "RECHTECK":
                Rechteck rechteck = new Rechteck(x, y, color, Integer.parseInt(values[4]), Integer.parseInt(values[5]));
                return rechteck;
            case "LINIE":
                Linie linie = new Linie(x, y, color, Integer.parseInt(values[4]), Integer.parseInt(values[5]));
                return linie;
            case "KREIS":
                Kreis kreis = new Kreis(x, y, color, Integer.parseInt(values[4]));
                return kreis;
            case "POLYGON":
                String[] xPoints = values[4].split(",");
                int[] xNumbers = new int[xPoints.length];
                String[] yPoints = values[5].split(",");
                int[] yNumbers = new int[yPoints.length];
                for(int i = 0; i < xPoints.length; i++) {
                    xNumbers[i] = Integer.parseInt(xPoints[i]);
                    yNumbers[i] = Integer.parseInt(yPoints[i]);
                }
                Polygon polygon = new Polygon(x, y, color, xNumbers, yNumbers);
                return polygon;
        }

        return null;
    }
}
