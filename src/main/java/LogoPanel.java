/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author radloff_859936
 */
public class LogoPanel extends javax.swing.JPanel {

    private BufferedImage image;

    public LogoPanel() {
        try {
            image = ImageIO.read(new File("DHIconOr.png"));
        } catch (IOException ex) {
        }
    }

    public void setColor(String color) {
        try {
            switch (color) {
                case "Red":
                    image = ImageIO.read(new File("DHIconRe.png"));
                    break;
                case "Orange":
                    image = ImageIO.read(new File("DHIconOr.png"));
                    break;
            }
            repaint();
        } catch (IOException ex) {
            Logger.getLogger(LogoPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
