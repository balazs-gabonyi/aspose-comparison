package hu.balazsg.aspose.pdf.wrapped.common.image;

import com.aspose.pdf.*;

import static hu.balazsg.aspose.pdf.wrapped.common.position.PositionUtil.createRectangle;

public class ImageRenderUtil {

    public static void renderImageToPage(Page page, Position lowerLeftCorner, Position upperRightCorner) {
        Rectangle rectangle = createRectangle(lowerLeftCorner, upperRightCorner);
        renderImageToPage(page, rectangle);
    }

    private static void renderImageToPage(Page page, Rectangle rectangle) {
        Matrix matrix = createMatrix(rectangle);
        renderImageToPage(page, matrix);
    }

    private static void renderImageToPage(Page page, Matrix matrix) {
        page.getContents().add(new Operator.ConcatenateMatrix(matrix));
        XImage ximage = page.getResources().getImages().get_Item(page.getResources().getImages().size());
        page.getContents().add(new Operator.Do(ximage.getName()));
        page.getContents().add(new Operator.GRestore());
    }

    public static Matrix createMatrix(Rectangle rectangle) {
        return new Matrix(
                new double[]{
                        rectangle.getURX() - rectangle.getLLX(), 0, 0,
                        rectangle.getURY() - rectangle.getLLY(), rectangle.getLLX(), rectangle.getLLY()
                });
    }

}
