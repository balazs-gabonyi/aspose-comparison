package hu.balazsg.asposelearn.text.usedexamples;

import com.aspose.pdf.*;
import hu.balazsg.asposelearn.util.LicenseUtil;

import static hu.balazsg.asposelearn.util.ConstantUtil.*;

public class ReplaceTextOnAllPagesOfDocument {

    public static void replaceTextOnAllPages() {
        LicenseUtil.getLicenseFromSrcRoot();
        // Open document
        Document pdfDocument = new Document(BALAZS_INPUT_PDF);
        // Open document
        // Create TextAbsorber object to find all instances of the input search phrase
        TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("sample");
        // Accept the absorber for first page of document
        pdfDocument.getPages().accept(textFragmentAbsorber);
        // Get the extracted text fragments into collection
        TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();
        // Loop through the fragments
        for (TextFragment textFragment : (Iterable<TextFragment>) textFragmentCollection) {
            // Update text and other properties
            textFragment.setText("New Pharase");
            textFragment.getTextState().setFont(FontRepository.findFont("Verdana"));
            textFragment.getTextState().setFontSize(22);
            textFragment.getTextState().setForegroundColor(Color.getBlue());
            textFragment.getTextState().setBackgroundColor(Color.getGray());
        }
        // Save the updated PDF file
        pdfDocument.save("asposeTest_Updated_Text.pdf");
    }
}

