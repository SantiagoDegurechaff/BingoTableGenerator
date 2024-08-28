package test.satoshi.bingotable;

import javax.swing.*;
import java.awt.*;

public class ViewBuilder {
    private final JFrame frame;
    private final Model model;
    ImageBuilder builder;
    ImagePopulater populater;

    public ViewBuilder(Model model, JFrame frame){
        this.model = model;
        this.frame = frame;
        builder = new ImageBuilder(model);
        populater = new ImagePopulater(model);
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
}
