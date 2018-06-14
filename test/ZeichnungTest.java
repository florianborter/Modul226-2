import Grafikeditor.Kreis;
import Grafikeditor.Rechteck;
import Grafikeditor.Zeichnung;
import org.junit.Test;

import java.awt.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ZeichnungTest {

    private Graphics g = mock(Graphics.class);

    @Test
    public void zeichneFigurenTest(){
        Zeichnung zeichnung = new Zeichnung();
        zeichnung.addFigur(new Rechteck(10, 20, Color.BLACK, 30, 40));
        zeichnung.addFigur(new Kreis(10, 20, Color.BLACK, 30));

        zeichnung.zeichneFiguren(g);

        verify(g, times(1)).drawRect(10,20, 30, 40);
        verify(g, times(1)).fillOval(10,20, 30, 30);
    }
}
