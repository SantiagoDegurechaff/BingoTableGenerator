package test.satoshi.bingotable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ImagePopulater {
    private final Model model;
    private Graphics2D g;

    private int cellW;
    private int cellH;
    private int gridOriginX;
    private int gridOriginY;
    private int gap;

    public ImagePopulater(Model model){
        this.model = model;
    }

    public BufferedImage BuildImage(int[][] data){
        BufferedImage img = initImage();

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        paintLetters();
        paintData(data);

        return img;
    }

    private BufferedImage initImage(){
        BufferedImage img;

        try {
            img = ImageIO.read(Objects.requireNonNull(this.getClass().getResourceAsStream("/model.jpg")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        g = (Graphics2D) img.getGraphics();

        cellW = 85;
        cellH = 82;
        gridOriginX = 67;
        gridOriginY = 303;
        gap = 5;

        return img;
    }

    private void paintLetters(){
        g.setColor(Color.black);
        g.setFont(model.headingFont);

        char[] bingo = {'B', 'I', 'N', 'G', 'O'};
        int x = gridOriginX + cellW / 2;

        FontMetrics fm = g.getFontMetrics(model.headingFont);

        for (char c : bingo) {
            g.drawString(String.valueOf(c), x - fm.charWidth(c) / 2, gridOriginY - 2);
            x += cellW + gap;
        }
    }
    
    private void paintData(int[][] data){
        g.setColor(Color.black);
        g.setFont(model.numFont);

        int x = gridOriginX + cellW / 2;
        int y = gridOriginY + cellH / 2;
        FontMetrics fm = g.getFontMetrics(model.numFont);
        String num;
        int padding;

        for(int i=0; i<model.filas; i++){
            for(int j=0; j<model.columnas; j++){
                num = String.valueOf(data[i][j]);
                padding = fm.charsWidth(num.toCharArray(), 0, num.length());
                g.drawString(num,x - padding / 2, y + fm.getMaxAscent() / 2);
                y += cellH + gap;
            }
            x += cellW + gap;
            y = gridOriginY + cellH / 2;
        }
    }
}
