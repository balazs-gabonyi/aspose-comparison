package hu.balazsg.asposelearn.text.usedexamples;

import com.aspose.pdf.*;

public class ModifyFormFieldInPDFDocument {

    public static void main(String[] args) {
        // Open a document
        Document pdfDocument = new Document("input.pdf");
        // Get a field
        TextBoxField textBoxField = (TextBoxField) pdfDocument.getForm().get("textbox1");
        // Modify the field value
        textBoxField.setValue("Updated Value");
        // Set the field as read only
        textBoxField.setReadOnly(true);
        // Save the updated document
        pdfDocument.save("output.pdf");
    }
}
