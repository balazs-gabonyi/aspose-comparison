package hu.balazsg.asposelearn.signature;

import com.aspose.pdf.*;
import hu.balazsg.asposelearn.util.LicenseHelper;
import org.junit.*;

import java.util.Date;

import static hu.balazsg.asposelearn.signature.Signing.*;
import static hu.balazsg.asposelearn.util.ConstantUtil.*;

public class SignatureTest {
    private static Signature signature;

    @BeforeClass
    public static void init() {
        LicenseHelper.getLicenseFromSrcRoot();

        signature = getPKCS1Signature(CERT_FILE, CERT_PASSWORD);
        signature.setContactInfo("Test Contact");
        signature.setDate(new Date());
        signature.setReason("Only for testing");
        signature.setLocation("Test Address 123");
    }

    @Test
    public void testSigning() {
        Position position1 = new Position(300, 500);
        signMillimeterSize(INPUT, OUTPUT_SIGNED, signature, SIGNATURE_IMAGE, 1, position1, 40, 30);
    }

    @Test
    public void testSignatureExtract() {
        Extracting.extractSignatureImageAsposeExample(INPUT, SIGNATURE_EXTRACTED_IMAGE);
    }
}
