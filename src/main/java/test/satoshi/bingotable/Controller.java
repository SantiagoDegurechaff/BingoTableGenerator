package test.satoshi.bingotable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Controller {
    JFrame frame;
    Model model;
    ImageBuilder builder;
    Generator generator;

    public Controller(JFrame frame){
        Font headingFont = new Font("Microsoft Sans Serif", Font.PLAIN, 1);
        Font numFont = headingFont;

        model = new Model(5, 5, 15, 1
                , 50, 50, headingFont, numFont, 64, 48);
        generator = new Generator(model);
        builder = new ImageBuilder(model);
        this.frame = frame;

        generator.fillData();

        exportarImagenes();
    }

    public void paint(Graphics g){
//        Image img = builder.BuildImage(model.data.get(0));
//
//        g.drawImage(img, 40, 40, frame);

        Image img = new ImagePopulater(model).BuildImage(model.data.get(0));

        float aspectRatio = (float) img.getWidth(frame) / img.getHeight(frame);
        int dy2 = 500;
        int dx2 = (int) (dy2 * aspectRatio);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.drawImage(img, 40, 40, dx2, dy2, 0, 0, img.getWidth(frame), img.getHeight(frame), frame);
    }

    private void exportarImagenes(){
        BufferedImage img;
        File outputFile;

        for(int i=0; i<model.tableCount; i++){
            img = builder.BuildImage(model.data.get(i));

            outputFile = new File("images\\exported_" + i + ".png");

            try{
                outputFile.mkdirs();
                ImageIO.write(img, "png", outputFile);
            } catch (IOException e) {
                System.out.println("No se pudo exportar la imagen " + i);
            }
        }
    }
}
