package test.satoshi.bingotable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Controller {
    Model model;
    Generator generator;
    ViewBuilder viewBuilder;

    public Controller(JFrame frame){
//        Font headingFont = new Font("Microsoft Sans Serif", Font.PLAIN, 1);
//        Font numFont = headingFont;
//
//        model = new Model(5, 5, 15, 1
//                , 50, 50, headingFont, numFont, 64, 48);

        model = new Model();
        generator = new Generator(model);
        viewBuilder = new ViewBuilder(model, frame);

        generator.fillData();

//        exportarImagenes();
    }

public void paint(Graphics g){
        viewBuilder.paint(g);
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
