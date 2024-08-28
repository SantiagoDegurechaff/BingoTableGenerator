package test.satoshi.bingotable;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    Controller con;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try{
                Main frame = new Main();
                frame.setVisible(true);
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public Main(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        contentPane = new JPanel();
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        setContentPane(contentPane);
//        contentPane.setLayout(null);
        setBounds(100,100,800,600);

        con = new Controller(this);
    }

    public void paint(Graphics g){
        super.paint(g);

        con.paint(g);
    }
}