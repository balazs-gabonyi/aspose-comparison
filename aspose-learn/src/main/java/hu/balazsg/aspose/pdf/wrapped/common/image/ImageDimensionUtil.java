package hu.balazsg.aspose.pdf.wrapped.common.image;

import hu.balazsg.aspose.pdf.wrapped.common.file.FileUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageDimensionUtil {

    public static Dimension getDimensionOfImage(String pathToImage) {
        FileInputStream imageStream = FileUtil.getFileStreamSafe(pathToImage);
        Dimension imageDimension = getImageDimension(imageStream);
        FileUtil.closeFileStreamSafe(imageStream);
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
