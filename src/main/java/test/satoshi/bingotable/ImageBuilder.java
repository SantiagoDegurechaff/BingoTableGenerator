package test.satoshi.bingotable;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageBuilder {
    private final Model model;
    private Graphics2D g;
    private int imgW;
    private int imgH;
    private int headH;

    public ImageBuilder(Model model){
        this.model = model;
    }

    public BufferedImage BuildImage(int[][] data){
        BufferedImage img = initImage();

//        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//
//        paintBackground();
//        paintOutline();
//        paintGrid();
//        paintHeading();
//        paintLetters();
//        paintData(data);

        return img;
    }

    private BufferedImage initImage(){
        imgW = model.cellW * model.columnas;
        imgH = model.headingFontSize + 2 + model.cellH * model.filas;
        headH = model.headingFontSize + 2;

        BufferedImage img = new BufferedImage(imgW, imgH, BufferedImage.TYPE_INT_ARGB);
        g = (Graphics2D) img.getGraphics();

        return img;
    }

    private void paintGrid(){
        int x = 0, y = headH;

        g.setColor(Color.black);

        for(int i=0; i<model.filas; i++){
            y += model.cellH;
            g.drawLine(0, y, imgW, y);
        }

        for(int i=0; i<model.columnas; i++){
            x += model.cellW;
            g.drawLine(x, 0, x, imgH);
        }
    }

    private void paintHeading(){
        g.setColor(Color.black);
        g.drawLine(0, headH, imgW, headH);
    }

    private void paintLetters(){
        g.setColor(Color.black);
        g.setFont(model.headingFont);

        char[] bingo = {'B', 'I', 'N', 'G', 'O'};
        int x = model.cellW / 2;

        FontMetrics fm = g.getFontMetrics(model.headingFont);

        for (char c : bingo) {
            g.drawString(String.valueOf(c), x - fm.charWidth(c) / 2, headH - 2);
            x += model.cellW;
        }

    }

    private void paintBackground(){
        Color colr = new Color(0,0,0,0);
        g.setColor(colr);
        g.fillRect(0,0, imgW, imgH);
        g.setColor(Color.white);
        g.fillRoundRect(0,0, imgW, imgH, 10, 10);
    }

    private void paintOutline(){
        g.setColor(Color.black);
        g.drawRoundRect(0,0, imgW-1, imgH-1, 10,10);
    }
    
    private void paintData(int[][] data){
        g.setColor(Color.black);
        g.setFont(model.numFont);

        int x = model.cellW / 2;
        int y = headH + model.cellH / 2;
        FontMetrics fm = g.getFontMetrics(model.numFont);
        String num;
        int padding;

        for(int i=0; i<model.filas; i++){
            for(int j=0; j<model.columnas; j++){
                num = String.valueOf(data[i][j]);
                padding = fm.charsWidth(num.toCharArray(), 0, num.length());
                g.drawString(num,x - padding / 2, y + fm.getHeight() / 2);
                y += model.cellH;
            }
            x += model.cellW;
            y = headH + model.cellH / 2;
        }
    }
}
