package hu.balazsg.asposelearn.files;

import hu.balazsg.asposelearn.util.LicenseHelper;
import hu.balazsg.asposelearn.wrapped.file.Merging;
import org.junit.*;

import static hu.balazsg.asposelearn.util.ConstantUtil.*;

public class FilesTest {

    @BeforeClass
    public static void init() {
        LicenseHelper.getLicenseFromSrcRoot();
    }

    @Test
    public void testMerge() {
        Merging.mergePdfs(OUTPUT_MERGE, INPUT, INPUT_2, INPUT_3, INPUT_4);
    }
}
