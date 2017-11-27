package hu.balazsg.asposelearn.wrapped;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import static hu.balazsg.asposelearn.wrapped.FileUtil.*;

public class ImageDimensionUtil {

    public static Dimension getDimensionOfImage(String pathToImage) {
        FileInputStream imageStream = getFileStreamSafe(pathToImage);
        Dimension imageDimension = getImageDimension(imageStream);
        closeFileStreamSafe(imageStream);
        return imageDimension;
    }

    public static Dimension getImageDimension(FileInputStream imageStream) {
        BufferedImage image;
        Dimension dimensionOfImage = null;
        try {
            image = ImageIO.read(imageStream);
            dimensionOfImage = new Dimension(image.getWidth(), image.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dimensionOfImage;
    }
}
