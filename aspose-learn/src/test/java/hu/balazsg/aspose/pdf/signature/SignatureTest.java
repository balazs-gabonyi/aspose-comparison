package hu.balazsg.aspose.pdf.signature;

import com.aspose.pdf.*;
import hu.balazsg.aspose.pdf.util.*;
import hu.balazsg.aspose.pdf.wrapped.signature.*;
import org.junit.*;

import java.util.Date;

public class SignatureTest {
    private static Signature signature;

    @BeforeClass
    public static void init() {
        LicenseHelper.getLicenseFromSrcRoot();

        signature = Signing.getPKCS1Signature(ConstantUtil.CERT_FILE, ConstantUtil.CERT_PASSWORD);
        signature.setContactInfo("Test Contact");
        signature.setDate(new Date());
        signature.setReason("Only for testing");
        signature.setLocation("Test Address 123");
    }

    @Test
    public void testSigning() {
        Position position1 = new Position(300, 500);
        Signing.signMillimeterSize(ConstantUtil.INPUT, ConstantUtil.OUTPUT_SIGNED, signature, ConstantUtil.SIGNATURE_IMAGE, 1, position1, 40, 30);
    }

    @Test
    public void testSignatureExtract() {
        Extracting.extractSignatureImageAsposeExample(ConstantUtil.INPUT, ConstantUtil.SIGNATURE_EXTRACTED_IMAGE);
    }
}
