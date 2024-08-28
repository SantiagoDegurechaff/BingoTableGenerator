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
        Font headingFont = new Font("Arial", Font.PLAIN, 1);
        Font numFont = headingFont;

        model = new Model(5, 5, 15, 1
                , 50, 50, headingFont, numFont, 32, 20);
        generator = new Generator(model);
        builder = new ImageBuilder(model);
        this.frame = frame;

        generator.fillData();

        exportarImagenes();


    }

    public void paint(Graphics g){
        Image img = builder.BuildImage(model.data.get(0));

        g.drawImage(img, 40, 40, frame);
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
