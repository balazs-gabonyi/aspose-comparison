package hu.balazsg.asposelearn.text.usedexamples;

import com.aspose.pdf.*;
import hu.balazsg.asposelearn.util.LicenseUtil;

import static hu.balazsg.asposelearn.util.ConstantUtil.INPUT_PDF;

public class AddTextToExistingPDFFile {

    public static void main(String[] args) {
        License license = LicenseUtil.getLicenseFromJarDirectory();
        // open document
        Document pdfDocument = new Document(INPUT_PDF);
        // get particular page
        Page pdfPage = pdfDocument.getPages().get_Item(1);
        // create text fragment
        TextFragment textFragment = new TextFragment("main text");
        textFragment.setPosition(new Position(100, 600));
        // set text properties
        textFragment.getTextState().setFont(FontRepository.findFont("Verdana"));
        textFragment.getTextState().setFontSize(14);
        textFragment.getTextState().setForegroundColor(Color.getBlue());
        textFragment.getTextState().setBackgroundColor(Color.getGray());
        // create TextBuilder object
        TextBuilder textBuilder = new TextBuilder(pdfPage);
        // append the text fragment to the PDF page
        textBuilder.appendText(textFragment);
        // save updated PDF file
        pdfDocument.save("asposeTest_Updated_Text.pdf");
    }
}
