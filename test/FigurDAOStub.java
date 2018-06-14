import Grafikeditor.FigurDAO;

public class FigurDAOStub implements FigurDAO {

    private int i = 0;
    private String[] testDaten = {
            "Rechteck 50 50 50 50",
            "Rechteck 150 150 10 10"
    };

    @Override
    public String[] readNextFigurData() {
        if(i < testDaten.length){
            String[] figurData = testDaten[i].split("\\s");
            i++;
            return figurData;
        }
        return null;
    }
}
