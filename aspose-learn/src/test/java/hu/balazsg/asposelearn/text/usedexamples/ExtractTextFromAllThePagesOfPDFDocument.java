package hu.balazsg.asposelearn.text.usedexamples;

import com.aspose.pdf.*;
import hu.balazsg.asposelearn.util.LicenseUtil;

public class ExtractTextFromAllThePagesOfPDFDocument {

    public static void main(String[] args) throws Exception {
        LicenseUtil.getLicenseFromSrcRoot();
        // Open document
        Document pdfDocument = new Document("asposeTest2.pdf");
        // Create TextAbsorber object to extract text
        TextAbsorber textAbsorber = new TextAbsorber();
        // Accept the absorber for all the pages
        pdfDocument.getPages().accept(textAbsorber);
        // Get the extracted text
        String extractedText = textAbsorber.getText();
        // Create a writer and open the file
        java.io.FileWriter writer = new java.io.FileWriter(new java.io.File("Extracted_text.txt"));
        writer.write(extractedText);
        // Write a line of text to the file
        // tw.WriteLine(extractedText);
        // Close the stream
        writer.close();
    }
}