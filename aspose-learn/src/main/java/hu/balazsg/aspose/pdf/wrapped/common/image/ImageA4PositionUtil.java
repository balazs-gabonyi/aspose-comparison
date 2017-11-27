package hu.balazsg.aspose.pdf.wrapped.common.image;

import com.aspose.pdf.Position;

import java.awt.*;

public class ImageA4PositionUtil {

    private static final int A4_FULL_SIZE_ASPOSE_PIXEL_WIDTH = 595;
    private static final int A4_FULL_SIZE_ASPOSE_PIXEL_HEIGHT = 842;
    private static final int A4_WIDTH_IN_MILLIMETERS = 210;
    private static final int A4_HEIGHT_IN_MILLIMETERS = 297;

    public static Position getUpperRightDiagonalOffsetForHeight(Dimension imageDimension, int heightMillimeters) {
        double scale = getHeightScaling(imageDimension, heightMillimeters);
        return getUpperRightDiagonalOffset(imageDimension, scale, scale);
    }

    public static Position getUpperRightDiagonalOffsetForWidth(Dimension imageDimension, int widthMillimeters) {
        double scale = getWidthScaling(imageDimension, widthMillimeters);
        return getUpperRightDiagonalOffset(imageDimension, scale, scale);
    }

    public static Position getUpperRightDiagonalOffSetMillis(Dimension dimensionOfImage, int widthInMillimeters, int heightInMillimeters) {
        double widthScaling = getWidthScaling(dimensionOfImage, widthInMillimeters);
        double heightScaling = getHeightScaling(dimensionOfImage, heightInMillimeters);
        double upperRightCornerX = dimensionOfImage.getWidth() * widthScaling;
        double upperRightCornerY = dimensionOfImage.getHeight() * heightScaling;
        return new Position(upperRightCornerX, upperRightCornerY);
    }

    private static Position getUpperRightDiagonalOffset(Dimension imageDimension, double widthScaling, double heightScaling) {
        double upperRightCornerX = imageDimension.getWidth() * widthScaling;
        double upperRightCornerY = imageDimension.getHeight() * heightScaling;
        return new Position(upperRightCornerX, upperRightCornerY);
    }

    private static double getWidthScaling(Dimension dimension, int widthMillimeters) {
        double widthPixels = dimension.getWidth();
        double widthNormalizeFactor = (double) A4_FULL_SIZE_ASPOSE_PIXEL_WIDTH / widthPixels;
        double widtPerFullWidth = (double) widthMillimeters / A4_WIDTH_IN_MILLIMETERS;
        return widthNormalizeFactor * widtPerFullWidth;
    }

    private static double getHeightScaling(Dimension dimension, int heightMillimeters) {
        double heightPixels = dimension.getHeight();
        double heightNormalizingFactor = (double) A4_FULL_SIZE_ASPOSE_PIXEL_HEIGHT / heightPixels;
        double heightPerFullHeight = (double) heightMillimeters / A4_HEIGHT_IN_MILLIMETERS;
        return heightNormalizingFactor * heightPerFullHeight;
    }

}
