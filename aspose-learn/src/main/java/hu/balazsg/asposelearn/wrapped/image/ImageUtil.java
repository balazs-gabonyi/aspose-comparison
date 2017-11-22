package hu.balazsg.asposelearn.wrapped.image;

import com.aspose.pdf.*;
import com.aspose.pdf.Rectangle;
import hu.balazsg.asposelearn.wrapped.text.PositionUtil;

import javax.imageio.ImageIO;
import javax.print.Doc;
import java.awt.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageUtil {

    private static final int A4_FULL_SIZE_ASPOSE_PIXEL_WIDTH = 595;
    private static final int A4_FULL_SIZE_ASPOSE_PIXEL_HEIGHT = 842;
    private static final int A4_WIDTH_IN_MILLIMETERS = 210;
    private static final int A4_HEIGHT_IN_MILLIMETERS = 297;

    private Document pdfDocument;

    public ImageUtil(Document pdfDocument){
        this.pdfDocument = pdfDocument;
    }

    public void saveDocument(){
        pdfDocument.save("ImageAdded.pdf");
    }

    public  void addImageOfWidthToExistingPDFFile(
            String pathToImage,
            Position lowerLeftCorner,
            int widthInMillimeters
    ) {
        Dimension dimensionOfImage = getDimensionOfImage(pathToImage);
        Position upperRightCornerOffset = getUpperRightCornerOffsetForWidth(dimensionOfImage, widthInMillimeters);
        Position upperRightCorner = PositionUtil.addPositions(lowerLeftCorner, upperRightCornerOffset);
        placeImageOnPage(pdfDocument, pathToImage, lowerLeftCorner, upperRightCorner);
    }

    public  void addImageOfHeightToExistingPDFFile(
            String pathToImage,
            Position lowerLeftCorner,
            int heightInMillimeters
    ) {
        Dimension dimensionOfImage = getDimensionOfImage(pathToImage);
        Position upperRightCornerOffset = getUpperRightCornerOffsetForHeight(dimensionOfImage, heightInMillimeters);
        Position upperRightCorner = PositionUtil.addPositions(lowerLeftCorner, upperRightCornerOffset);
        placeImageOnPage(pdfDocument, pathToImage, lowerLeftCorner, upperRightCorner);
    }

    public  void addImageOfSizeToExistingPDFFile(
            String pathToImage,
            Position lowerLeftCorner,
            int widthInMillimeters,
            int heightInMillimeters
    ) {
        Dimension dimensionOfImage = getDimensionOfImage(pathToImage);
        double widthScaling = getWidthScaling(dimensionOfImage, widthInMillimeters);
        double heightScaling = getHeightScaling(dimensionOfImage, heightInMillimeters);
        Position upperRightCornerOffset = getUpperRightCornerOffset(dimensionOfImage, widthScaling, heightScaling);
        Position upperRightCorner = PositionUtil.addPositions(lowerLeftCorner, upperRightCornerOffset);
        placeImageOnPage(pdfDocument, pathToImage, lowerLeftCorner, upperRightCorner);
    }

    public  void addImageToExistingPDFFile(String pathToImage, Position lowerLeftCorner, double scale) {
        Dimension dimensionOfImage = getDimensionOfImage(pathToImage);
        Position upperRightCorner = getUpperRightCorner(lowerLeftCorner, dimensionOfImage, scale);
        placeImageOnPage(pdfDocument, pathToImage, lowerLeftCorner, upperRightCorner);
    }

    private static Position getUpperRightCorner(Position lowerLeftCornerOfImage, Dimension dimensionOfImage, double scale) {
        Position upperRightCornerOffset = getUpperRightCornerOffset(dimensionOfImage, scale);
        Position upperRightCorner = PositionUtil.addPositions(lowerLeftCornerOfImage, upperRightCornerOffset);
        return upperRightCorner;
    }

    private static Position getUpperRightCornerOffsetForHeight(Dimension imageDimension, int heightMillimeters) {
        double scale = getHeightScaling(imageDimension, heightMillimeters);
        return getUpperRightCornerOffset(imageDimension, scale, scale);
    }

    private static Position getUpperRightCornerOffsetForWidth(Dimension imageDimension, int widthMillimeters) {
        double scale = getWidthScaling(imageDimension, widthMillimeters);
        return getUpperRightCornerOffset(imageDimension, scale, scale);
    }

    private static Position getUpperRightCornerOffset(Dimension imageDimension, double scale) {
        return getUpperRightCornerOffset(imageDimension, scale, scale);
    }

    private static Position getUpperRightCornerOffset(Dimension imageDimension, double widthScaling, double heightScaling) {
        double scaledWidth = imageDimension.getWidth() * widthScaling;
        double scaledHeight = imageDimension.getHeight() * heightScaling;

        double upperRightCornerX = scaledWidth;
        double upperRightCornerY = scaledHeight;

        Position upperRightCorner = new Position(upperRightCornerX, upperRightCornerY);
        return upperRightCorner;
    }


    private static void placeImageOnPage(Document pdfDocument, String pathToImage, Position lowerLeftCornerOfImage, Position upperRightCornerOfImage) {
        int lowerLeftX = (int) lowerLeftCornerOfImage.getXIndent();
        int lowerLeftY = (int) lowerLeftCornerOfImage.getYIndent();
        int upperRightX = (int) upperRightCornerOfImage.getXIndent();
        int upperRightY = (int) upperRightCornerOfImage.getYIndent();
        FileInputStream imageStream = getImageStream(pathToImage);
        Page page = pdfDocument.getPages().get_Item(1);
        page.getResources().getImages().add(imageStream);
        safeCloseImageStream(imageStream);
        page.getContents().add(new Operator.GSave());
        Rectangle rectangle = new Rectangle(lowerLeftX, lowerLeftY, upperRightX, upperRightY);
        Matrix matrix = new Matrix(
                new double[]{
                        rectangle.getURX() - rectangle.getLLX(), 0, 0,
                        rectangle.getURY() - rectangle.getLLY(), rectangle.getLLX(), rectangle.getLLY()
                });
        page.getContents().add(new Operator.ConcatenateMatrix(matrix));
        XImage ximage = page.getResources().getImages().get_Item(page.getResources().getImages().size());
        page.getContents().add(new Operator.Do(ximage.getName()));
        page.getContents().add(new Operator.GRestore());
    }

    private static Dimension getDimensionOfImage(String pathToImage) {
        FileInputStream imageStream = getImageStream(pathToImage);
        Dimension imageDimension = getImageDimension(imageStream);
        safeCloseImageStream(imageStream);
        return imageDimension;
    }

    private static Dimension getImageDimension(FileInputStream imageStream) {
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

    private static FileInputStream getImageStream(String pathToImage) {
        java.io.FileInputStream imageStream = null;
        try {
            imageStream = new java.io.FileInputStream(new java.io.File(pathToImage));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return imageStream;
    }

    private static void safeCloseImageStream(FileInputStream imageStream) {
        try {
            imageStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double getWidthScaling(Dimension dimension, int millimeters) {
        return getWidthScaling((int) dimension.getWidth(), millimeters);
    }

    private static double getHeightScaling(Dimension dimension, int millimeters) {
        return getHeightScaling((int) dimension.getHeight(), millimeters);
    }

    private static double getWidthScaling(int widthPixels, int widthMillimeters) {
        double widthNormalizeFactor = (double)A4_FULL_SIZE_ASPOSE_PIXEL_WIDTH / widthPixels;
        double widtPerFullWidth = (double)widthMillimeters / A4_WIDTH_IN_MILLIMETERS;
        double widthScaling = widthNormalizeFactor * widtPerFullWidth;
        return widthScaling;
    }

    private static double getHeightScaling(int heightPixels, int heightMillimeters) {
        double heightNormalizingFactor = (double)A4_FULL_SIZE_ASPOSE_PIXEL_HEIGHT / heightPixels;
        double heightPerFullHeight = (double)heightMillimeters / A4_HEIGHT_IN_MILLIMETERS;
        double heightScaling = heightNormalizingFactor * heightPerFullHeight;
        return heightScaling;
    }

}
