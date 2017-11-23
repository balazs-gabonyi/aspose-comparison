package hu.balazsg.asposelearn.image;

import com.aspose.pdf.*;
import hu.balazsg.asposelearn.util.LicenseHelper;
import hu.balazsg.asposelearn.wrapped.image.ImageUtil;
import org.junit.*;

import static hu.balazsg.asposelearn.util.ConstantUtil.TEST_FOLDER_PATH;

public class ImageTest {

    private static Document pdfDocument = new Document(TEST_FOLDER_PATH + "input.pdf");
    private static final String IMAGE_PATH = TEST_FOLDER_PATH + "aspose595x842i.png";
    private static final String OUTPUT_NAME = TEST_FOLDER_PATH + "PageWithImages.pdf";

    private static Position bottomRightOfPage = new Position(320, 0);
    private static Position bottomLeftOfPage = new Position(0, 0);
    private static Position middleOfPage = new Position(250, 375);
    private static Position upperRightOfPage = new Position(420, 575);
    private static ImageUtil imageUtil = new ImageUtil(pdfDocument);

    @BeforeClass
    public static void init() {
        LicenseHelper.getLicenseFromSrcRoot();
    }

    @Test
    public void placeMultipleImagesOnPageTest() {
        int width = 40;
        int height = 30;
        imageUtil.addImageOfWidthToExistingPDFFile(IMAGE_PATH, upperRightOfPage, width);
        imageUtil.addImageOfHeightToExistingPDFFile(IMAGE_PATH, bottomLeftOfPage, height);
        imageUtil.addImageOfSizeToExistingPDFFile(IMAGE_PATH, middleOfPage, width, height);
        imageUtil.addImageToExistingPDFFile(IMAGE_PATH, bottomRightOfPage, 0.3);
        imageUtil.saveDocument(OUTPUT_NAME);
    }

}
