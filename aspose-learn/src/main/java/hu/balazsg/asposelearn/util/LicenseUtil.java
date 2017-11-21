package hu.balazsg.asposelearn.util;

import com.aspose.pdf.License;

import java.io.FileInputStream;


public class LicenseUtil {

    private static final String ASPOSE_LICENSE_FILE_NAME = "Aspose.Pdf.lic";
    private static License license = new com.aspose.pdf.License();

    public static License getLicenseFromJarDirectory() {
        try {
            license.setLicense(ASPOSE_LICENSE_FILE_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return license;
    }

    public static License getLicenseFromSrcRoot() {
        FileInputStream licenseFile = null;
        try {
            licenseFile = new FileInputStream(ASPOSE_LICENSE_FILE_NAME);
            license.setLicense(licenseFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return license;
    }

}
