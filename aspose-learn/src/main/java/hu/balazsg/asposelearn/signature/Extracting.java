package hu.balazsg.asposelearn.signature;

import com.aspose.pdf.*;

import java.io.*;

public class Extracting {

    public static void extractSignatureImageAsposeExample(String pdfFilePath, String outputImagePath) {
        Document pdfDocument = new Document(pdfFilePath);
        int i = 0;
        try {
            for (Field field : (Iterable<Field>) pdfDocument.getForm()) {
                SignatureField sf = null;
                try {
                    sf = (SignatureField) field;
                } catch (ClassCastException ce) {
                    ce.printStackTrace();
                }
                if (sf != null) {
                    InputStream tempStream = null;
                    try {
                        tempStream = sf.extractImage();
                        byte[] b = new byte[tempStream.available()];
                        tempStream.read(b);
                        FileOutputStream output = new FileOutputStream(outputImagePath + i + ".jpg");
                        output.write(b);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    i++;
                }
            }
        } finally {
            if (pdfDocument != null) {
                pdfDocument.dispose();
            }
        }
    }
}
