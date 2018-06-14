import Grafikeditor.Figur;
import Grafikeditor.FigurDAO;
import Grafikeditor.FigurParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FigurParserTest{
    private FigurDAO dao;
    private FigurParser figurParser;

    @Before
    public void setUp(){
        dao = new FigurDAOStub();
        figurParser = new FigurParser(dao);
    }

    @Test
    public void test(){
        List<Figur> figuren = figurParser.parse();
        Assert.assertEquals(2, figuren.size());
        Assert.assertEquals("x:50y:50", figuren.get(0).toString());
        Assert.assertEquals("x:150y:150", figuren.get(1).toString());
    }
}