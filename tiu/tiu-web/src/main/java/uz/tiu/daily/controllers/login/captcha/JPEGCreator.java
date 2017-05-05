package uz.tiu.daily.controllers.login.captcha;


/**
 * Created by Saidolim on 13.08.14.
 */

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class JPEGCreator {

    private int width = 10;
    private int height = 10;

    public JPEGCreator(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Creates a randomly generated two color JPEG and writes it to a file
     */
    public BufferedImage captcha(String words) {
        Random random = new Random(System.currentTimeMillis());
        //image block size in pixels, 1 is 1px, use smaller values for
        //greater granularity
        int PIX_SIZE = 1;
        //image size in pixel blocks
        BufferedImage bi = new BufferedImage(this.width, this.height, BufferedImage.TYPE_3BYTE_BGR);

        // make image
        Graphics2D g = (Graphics2D) bi.getGraphics();
        // g.setColor(Color.WHITE);
        g.setColor(new Color(53, 53, 53));
        g.fillRect(0, 0, width, height);


        for (int i = 0; i < 750; i++) {

            int r = random.nextInt(3);

            switch (r) {
                case 0:
                    g.setColor(Color.RED);//g.setColor(Color.GRAY);
                    break;
                case 1:
                    g.setColor(Color.BLUE);
                    break;
                case 2:
                    g.setColor(Color.GREEN);
                    break;
                default:
                    g.setColor(Color.RED);

            }

            g.fillRect(random.nextInt(this.width), random.nextInt(this.height), PIX_SIZE, PIX_SIZE);
            // g.setColor(Color.RED);
            g.setColor(new Color(204, 204, 204));
            g.setFont(new Font("Arial", Font.BOLD, 20));

            g.drawString(words, 20, (height / 2)+7);

        }

        g.dispose();
        saveToFile(bi, new File("tert.jpg"));
        return bi;
//        return filename;
    }//end method

    /* Creates a randomly generated two color JPEG and writes it to a file
     *
     */
    public String generate(String prefix) {
        Random random = new Random(System.currentTimeMillis());
        //image block size in pixels, 1 is 1px, use smaller values for
        //greater granularity
        int PIX_SIZE = 2;
        //image size in pixel blocks
        BufferedImage bi = new BufferedImage(this.width, this.height, BufferedImage.TYPE_3BYTE_BGR);

        // make image
        Graphics2D g = (Graphics2D) bi.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);


        String filename = prefix + "img.jpg";

        for (int i = 0; i < 1500; i++) {

            int r = random.nextInt(3);
//            System.out.println(r);
            switch (r) {
                case 0:
                    g.setColor(Color.RED);//g.setColor(Color.GRAY);
                    break;
                case 1:
                    g.setColor(Color.BLUE);
                    break;
                case 2:
                    //g.setColor(Color.GREEN);
                    g.setColor(Color.BLUE);
                    break;
                default:
                    g.setColor(Color.RED);

            }

            g.fillRect(random.nextInt(this.width), random.nextInt(this.height), PIX_SIZE, PIX_SIZE);

        }

        g.dispose();
        saveToFile(bi, new File(filename));
        return filename;
    }//end method

    /**
     * Saves jpeg to file
     */
    public void saveToFile(BufferedImage img, File file) {

        try {
            ImageWriter writer = null;
            java.util.Iterator iter = ImageIO.getImageWritersByFormatName("jpg");
            if (iter.hasNext()) {
                writer = (ImageWriter) iter.next();
            }
            ImageOutputStream ios = ImageIO.createImageOutputStream(file);
            writer.setOutput(ios);
            ImageWriteParam param = new JPEGImageWriteParam(java.util.Locale.getDefault());
            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            param.setCompressionQuality(0.98f);
            writer.write(null, new IIOImage(img, null, null), param);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }//end method
}
