package hu.balazsg.asposelearn.wrapped.text;

import com.aspose.pdf.*;

public class ReplaceTextUtil {

    private static final String EMPTY_STRING = "";

    public static void RemoveTextOnAllPages(Document pdfDocument, String removable) {
         ReplaceTextOnAllPages(pdfDocument, removable, EMPTY_STRING, 1);
    }

    public static void ReplaceTextOnAllPages(Document pdfDocument, String original, String replacement, int fontSize) {
        TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber(original);

        pdfDocument.getPages().accept(textFragmentAbsorber);
        TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();
        for (TextFragment textFragment : (Iterable<TextFragment>) textFragmentCollection) {
            textFragment.setText(replacement);
            textFragment.getTextState().setFont(FontRepository.findFont("Verdana"));
            textFragment.getTextState().setFontSize(fontSize);
            textFragment.getTextState().setForegroundColor(Color.getBlack());
            textFragment.getTextState().setBackgroundColor(Color.getWhite());
        }
    }
}
