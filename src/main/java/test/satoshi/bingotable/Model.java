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

    public Model(){
        this.data = new ArrayList<>();
        this.filas = 5;
        this.columnas = 5;
        this.rangoCol = 15;
        this.tableCount = 1;
        this.cellW = 50;
        this.cellH = 50;

        this.headingFontSize = 64;
        this.headingFont = new Font("Microsoft Sans Serif", Font.PLAIN, headingFontSize);
        this.numFontSize = 48;
        this.numFont = headingFont.deriveFont((float)numFontSize);
    }

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
