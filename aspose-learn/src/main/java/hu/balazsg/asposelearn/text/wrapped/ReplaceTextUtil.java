package hu.balazsg.asposelearn.text.wrapped;

import com.aspose.pdf.*;
import hu.balazsg.asposelearn.util.LicenseUtil;

public class ReplaceTextUtil {

    public static Document RemoveTextOnAllPages(Document pdfDocument, String original, String replacement) {
        return ReplaceTextOnAllPages(pdfDocument, original, replacement, 1);
    }

    public static Document ReplaceTextOnAllPages(Document pdfDocument, String original, String replacement, int fontSize) {
        LicenseUtil.getLicenseFromSrcRoot();
        TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber(original);
        pdfDocument.getPages().accept(textFragmentAbsorber);
        TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();
        for (TextFragment textFragment : (Iterable<TextFragment>) textFragmentCollection) {
            textFragment.setText(replacement);
            textFragment.getTextState().setFont(FontRepository.findFont("Verdana"));
            textFragment.getTextState().setFontSize(fontSize);
            textFragment.getTextState().setForegroundColor(Color.getWhite());
            textFragment.getTextState().setBackgroundColor(Color.getWhite());
        }
        return pdfDocument;
    }
}
