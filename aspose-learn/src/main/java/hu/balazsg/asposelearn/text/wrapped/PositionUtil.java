package hu.balazsg.asposelearn.text.wrapped;

import com.aspose.pdf.*;

import java.util.*;

public class PositionUtil {

    public static List<Position> getPositionsOfTextOnPage(Document pdfDocument, String text) {

        List<Position> positions = new LinkedList<>();

        TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber(text);
        pdfDocument.getPages().accept(textFragmentAbsorber);
        TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();

        textFragmentCollection.forEach(textFragment -> positions.add(textFragment.getPosition()));
        return positions;
    }
}
