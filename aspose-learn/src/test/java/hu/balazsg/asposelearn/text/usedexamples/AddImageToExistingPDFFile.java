package hu.balazsg.asposelearn.text.usedexamples;

import com.aspose.pdf.*;
import hu.balazsg.asposelearn.util.LicenseUtil;

import java.io.*;

public class AddImageToExistingPDFFile {

    public static void main(String[] args) {
        LicenseUtil.getLicenseFromSrcRoot();
        addImageToExistingPDFFile();
    }

    public static void addImageToExistingPDFFile() {
        // Open a document
        Document pdfDocument1 = new Document("input.pdf");
        // Set coordinates
        int lowerLeftX = 100;
        int lowerLeftY = 100;
        int upperRightX = 200;
        int upperRightY = 200;
        // Get the page you want to add the image to
        Page page = pdfDocument1.getPages().get_Item(1);
        // Load image into stream
        java.io.FileInputStream imageStream = null;
        try {
            imageStream = new java.io.FileInputStream(new java.io.File("Aspose-logo.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Add an image to the Images collection of the page resources
        page.getResources().getImages().add(imageStream);
        // Using the GSave operator: this operator saves current graphics state
        page.getContents().add(new Operator.GSave());
        // Create Rectangle and Matrix objects
        Rectangle rectangle = new Rectangle(lowerLeftX, lowerLeftY, upperRightX, upperRightY);
        Matrix matrix = new Matrix(new double[]{rectangle.getURX() - rectangle.getLLX(), 0, 0, rectangle.getURY() - rectangle.getLLY(), rectangle.getLLX(), rectangle.getLLY()});
        // Using ConcatenateMatrix (concatenate matrix) operator: defines how
        // image must be placed
        page.getContents().add(new Operator.ConcatenateMatrix(matrix));
        XImage ximage = page.getResources().getImages().get_Item(page.getResources().getImages().size());
        // Using Do operator: this operator draws image
        page.getContents().add(new Operator.Do(ximage.getName()));
        // Using GRestore operator: this operator restores graphics state
        page.getContents().add(new Operator.GRestore());
        // Save the new PDF
        pdfDocument1.save("outputWithImage.pdf");
        // Close image stream
        try {
            imageStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
