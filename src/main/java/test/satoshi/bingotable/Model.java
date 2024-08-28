package test.satoshi.bingotable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Model {
    public final int filas;
    public final int columnas;
    public final int rangoCol;
    public final int tableCount;
    public final int cellW;
    public final int cellH;

    public final Font headingFont;
    public final int headingFontSize;
    public final Font numFont;
    public final int numFontSize;

    public List<int[][]> data;

    public Model(int filas, int columnas, int rangoCol, int count, int cellW, int cellH, Font headingFont, Font numFont, int headingFontSize, int numFontSize){
        this.data = new ArrayList<>();
        this.filas = filas;
        this.columnas = columnas;
        this.rangoCol = rangoCol;
        this.tableCount = count;
        this.cellW = cellW;
        this.cellH = cellH;
        this.headingFontSize = headingFontSize;
        this.headingFont = headingFont.deriveFont((float)headingFontSize);
        this.numFontSize = numFontSize;
        this.numFont = numFont.deriveFont((float)numFontSize);
    }
}
