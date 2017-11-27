package hu.balazsg.aspose.pdf.image;

import com.aspose.pdf.*;
import hu.balazsg.aspose.pdf.util.*;
import hu.balazsg.aspose.pdf.wrapped.image.ImagePlacement;
import org.junit.*;

public class ImageTest {

    private static Document pdfDocument = new Document(ConstantUtil.INPUT);
    private static Position bottomLeftOfPage = new Position(0, 0);
    private static Position middleOfPage = new Position(250, 375);
    private static Position upperRightOfPage = new Position(420, 575);
    private static hu.balazsg.aspose.pdf.wrapped.image.ImagePlacement imagePlacement = new ImagePlacement(pdfDocument);

    @BeforeClass
    public static void init() {
        LicenseHelper.getLicenseFromSrcRoot();
    }

    @Test
    public void placeMultipleImagesOnPageTest() {
        int width = 40;
        int height = 30;
        imagePlacement.addImageOfWidthToExistingPDFFile(ConstantUtil.IMAGE, 1, upperRightOfPage, width);
        imagePlacement.addImageOfHeightToExistingPDFFile(ConstantUtil.IMAGE, 2, bottomLeftOfPage, height);
        imagePlacement.addImageOfSizeToExistingPDFFile(ConstantUtil.IMAGE, 3, middleOfPage, width, height);
        imagePlacement.saveDocument(ConstantUtil.OUTPUT_WITH_IMAGE);
    }

}
