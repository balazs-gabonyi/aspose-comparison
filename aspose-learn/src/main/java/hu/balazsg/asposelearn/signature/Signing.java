package hu.balazsg.asposelearn.signature;

import com.aspose.pdf.*;
import com.aspose.pdf.facades.PdfFileSignature;
import hu.balazsg.asposelearn.wrapped.*;

import java.awt.*;
import java.awt.Rectangle;

public class Signing {

    public static Signature getPKCS1Signature(String pfxPath, String password) {
        return new PKCS1(pfxPath, password);
    }

    public static Signature getPKCS7Signature(String pfxPath, String password) {
        return new PKCS7(pfxPath, password);
    }

    public static Signature getPKCS7DetachedSignature(String pfxPath, String password) {
        return new PKCS7Detached(pfxPath, password);
    }

    public static void signMillimeterSize(
            String signablePdfPath,
            String signedPdfPath,
            Signature signature,
            String logoPath,
            int pageNumber,
            Position position,
            int sigWidthMillis,
            int sigHeightMillis
    ) {
        PdfFileSignature pdfSign = new PdfFileSignature();
        pdfSign.bindPdf(signablePdfPath);
        pdfSign.setSignatureAppearance(logoPath);
        Rectangle rectangle = createRectanglForImage(logoPath, position, sigWidthMillis, sigHeightMillis);
        pdfSign.sign(pageNumber, signature.getReason(), signature.getContactInfo(), signature.getLocation(), true, rectangle, signature);
        pdfSign.save(signedPdfPath);
    }

    public static void signDefaultSize(
            String signablePdfPath,
            String signedPdfPath,
            Signature signature,
            String logoPath,
            int pageNumber,
            Position position,
            int width,
            int height
    ) {
        PdfFileSignature pdfSign = new PdfFileSignature();
        pdfSign.bindPdf(signablePdfPath);
        pdfSign.setSignatureAppearance(logoPath);
        Rectangle rectangle = createRectangleAtPosition(position, width, height);
        pdfSign.sign(pageNumber, signature.getReason(), signature.getContactInfo(), signature.getLocation(), true, rectangle, signature);
        pdfSign.save(signedPdfPath);
    }

    private static Rectangle createRectangleAtPosition(Position position, int width, int height) {
        int x = (int) position.getXIndent();
        int y = (int) position.getYIndent();
        return new Rectangle(x, y, width, height);
    }

    private static Rectangle createRectanglForImage(String logoPath, Position position, int widthMillis, int heightMillis) {
        Dimension signatureLogoDimension = ImageDimensionUtil.getDimensionOfImage(logoPath);
        Position offset = ImageA4PositionUtil.getUpperRightDiagonalOffSetMillis(signatureLogoDimension, widthMillis, heightMillis);
        int x = (int) position.getXIndent();
        int y = (int) position.getYIndent();
        return new Rectangle(x, y, (int) offset.getXIndent(), (int) offset.getYIndent());
    }

}
