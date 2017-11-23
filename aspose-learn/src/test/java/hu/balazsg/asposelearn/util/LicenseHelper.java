package hu.balazsg.asposelearn.util;

import com.aspose.pdf.License;

import java.io.FileInputStream;

public class LicenseHelper {

    private static final String ASPOSE_LICENSE_FILE_NAME = "Aspose.Pdf.lic";
    private static License license = new com.aspose.pdf.License();

    public static void getLicenceFromResources(){
        FileInputStream licenseFile = null;
        licenseFile = (FileInputStream) LicenseHelper.class.getResourceAsStream(ASPOSE_LICENSE_FILE_NAME);
        try {
            license.setLicense(licenseFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getLicenseFromSrcRoot() {
        FileInputStream licenseFile = null;
        try {
            licenseFile = new FileInputStream(ASPOSE_LICENSE_FILE_NAME);
            license.setLicense(licenseFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
