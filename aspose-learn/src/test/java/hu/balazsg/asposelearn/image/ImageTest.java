package hu.balazsg.asposelearn.image;

import com.aspose.pdf.*;
import hu.balazsg.asposelearn.util.LicenseHelper;
import hu.balazsg.asposelearn.wrapped.image.ImagePlacement;
import org.junit.*;

import static hu.balazsg.asposelearn.util.ConstantUtil.*;

public class ImageTest {

    private static Document pdfDocument = new Document(INPUT);
    private static Position bottomLeftOfPage = new Position(0, 0);
    private static Position middleOfPage = new Position(250, 375);
    private static Position upperRightOfPage = new Position(420, 575);
    private static ImagePlacement imagePlacement = new ImagePlacement(pdfDocument);

    @BeforeClass
    public static void init() {
        LicenseHelper.getLicenseFromSrcRoot();
    }

    @Test
    public void placeMultipleImagesOnPageTest() {
        int width = 40;
        int height = 30;
        imagePlacement.addImageOfWidthToExistingPDFFile(IMAGE, 1, upperRightOfPage, width);
        imagePlacement.addImageOfHeightToExistingPDFFile(IMAGE, 2, bottomLeftOfPage, height);
        imagePlacement.addImageOfSizeToExistingPDFFile(IMAGE, 3, middleOfPage, width, height);
        imagePlacement.saveDocument(OUTPUT_WITH_IMAGE);
    }

}
