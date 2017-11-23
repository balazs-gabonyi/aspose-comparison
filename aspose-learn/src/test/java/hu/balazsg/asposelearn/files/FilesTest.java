package hu.balazsg.asposelearn.files;

import hu.balazsg.asposelearn.util.LicenseHelper;
import hu.balazsg.asposelearn.wrapped.text.MergePDFUtil;
import org.junit.*;

import java.io.*;

import static hu.balazsg.asposelearn.util.ConstantUtil.TEST_FOLDER_PATH;

public class FilesTest {

    private static final String PDF_1 = TEST_FOLDER_PATH + "Pdf1.pdf";
    private static final String PDF_2 = TEST_FOLDER_PATH + "Pdf2.pdf";
    private static final String PDF_3 = TEST_FOLDER_PATH + "Pdf3.pdf";
    private static final String PDF_4 = TEST_FOLDER_PATH + "Pdf4.pdf";
    private static final String PDF_5 = TEST_FOLDER_PATH + "Pdf5.pdf";

    @BeforeClass
    public static void init() throws IOException {
        LicenseHelper.getLicenseFromSrcRoot();
    }

    @Test
    public void testMerge() {
        MergePDFUtil.mergePdfs(TEST_FOLDER_PATH + "Merged.pdf", PDF_1, PDF_2, PDF_3, PDF_4, PDF_5);
    }
}
