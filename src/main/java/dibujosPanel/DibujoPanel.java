package dibujosPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DibujoPanel extends JPanel {
    private int ancho;
    private int alto;
    public DibujoPanel() {
        super();
        ancho = 400;
        alto = 400;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(ancho,alto);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        dibujarAlgo(g);
    }

    private void dibujarAlgo(Graphics g) {
        g.drawLine(0,0,400,400);
    }

    public void guardarArchivo(String archivo) {
        BufferedImage bi = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();

        dibujarAlgo(g);

        /*
        BufferedImage bi = ImageIO.read(new File("c:\\image\\mypic.jpg"));
  ByteArrayOutputStream baos = new ByteArrayOutputStream();
  ImageIO.write(bi, "jpg", baos);
  byte[] bytes = baos.toByteArray();
         */

        try {
            File f = new File(archivo);
            ImageIO.write(bi, "png", f);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
