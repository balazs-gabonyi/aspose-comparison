package hu.balazsg.asposelearn.image;

import com.aspose.pdf.*;
import hu.balazsg.asposelearn.util.LicenseUtil;
import hu.balazsg.asposelearn.wrapped.image.ImageUtil;

public class PlaceImageOnPositionWithSize {

    private static Document pdfDocument = new Document("input.pdf");
    private static Position bottomRightOfPage = new Position(320, 0);
    private static Position bottomLeftOfPage = new Position(0, 0);
    private static Position middleOfPage = new Position(250, 375);
    private static Position upperRightOfPage = new Position(420, 575);
    private static final String IMAGE_PATH = "aspose595x842i.png";
    private static ImageUtil imageUtil = new ImageUtil(pdfDocument);

    public static void main(String[] args) {
        LicenseUtil.getLicenseFromSrcRoot();
        putImageOfPage(40, 30);
    }

    private static void putImageOfPage( int width, int height){
        imageUtil.addImageOfWidthToExistingPDFFile( IMAGE_PATH,upperRightOfPage, width);
        imageUtil.addImageOfHeightToExistingPDFFile( IMAGE_PATH,bottomLeftOfPage, height);
        imageUtil.addImageOfSizeToExistingPDFFile( IMAGE_PATH,middleOfPage, width, height);
        imageUtil.addImageToExistingPDFFile(IMAGE_PATH,bottomRightOfPage,0.3);
        imageUtil.saveDocument();
    }
}
