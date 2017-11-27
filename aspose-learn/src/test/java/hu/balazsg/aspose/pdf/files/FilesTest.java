package hu.balazsg.aspose.pdf.files;

import hu.balazsg.aspose.pdf.util.*;
import hu.balazsg.aspose.pdf.wrapped.file.Merging;
import org.junit.*;

public class FilesTest {

    @BeforeClass
    public static void init() {
        LicenseHelper.getLicenseFromSrcRoot();
    }

    @Test
    public void testMerge() {
        Merging.mergePdfs(ConstantUtil.OUTPUT_MERGE, ConstantUtil.INPUT, ConstantUtil.INPUT_2, ConstantUtil.INPUT_3, ConstantUtil.INPUT_4);
    }
}
