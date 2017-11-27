package hu.balazsg.aspose.pdf.wrapped.text;

import com.aspose.pdf.*;

public class ReplacingText {

    private static final String EMPTY_STRING = "";

    public static void RemoveTextOnAllPages(Document pdfDocument, String removable) {
        ReplaceTextOnAllPages(pdfDocument, removable, EMPTY_STRING, 1);
    }

    public static void RemoveTextOnPage(Document pdfDocument, int pageNumber, String removable) {
        ReplaceTextOnPage(pdfDocument, pageNumber, removable, EMPTY_STRING, 1);
    }

    public static void ReplaceTextOnAllPages(Document pdfDocument, String original, String replacement, int fontSize) {
        TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber(original);
        for (Page page : pdfDocument.getPages()) {
            pageReplace(textFragmentAbsorber, page, replacement, fontSize, "Verdana");
        }
    }

    public static void ReplaceTextOnPage(Document pdfDocument, int pageNumber, String original, String replacement, int fontSize) {
        TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber(original);
        Page page = pdfDocument.getPages().get_Item(pageNumber);
        pageReplace(textFragmentAbsorber, page, replacement, fontSize, "Verdana");
    }

    private static void pageReplace(TextFragmentAbsorber textFragmentAbsorber, Page page, String replacement, int fontSize, String fontName) {
        page.accept(textFragmentAbsorber);
        TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();
        for (TextFragment textFragment : (Iterable<TextFragment>) textFragmentCollection) {
            textFragment.setText(replacement);
            textFragment.getTextState().setFont(FontRepository.findFont(fontName));
            textFragment.getTextState().setFontSize(fontSize);
            textFragment.getTextState().setForegroundColor(Color.getBlack());
            textFragment.getTextState().setBackgroundColor(Color.getWhite());
        }
    }
}
