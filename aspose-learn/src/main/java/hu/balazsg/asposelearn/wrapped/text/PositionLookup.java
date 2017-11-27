package hu.balazsg.asposelearn.wrapped.text;

import com.aspose.pdf.*;

import java.util.*;

public class PositionLookup {

    public static List<Position> getPositionsOfTextOnPage(Document pdfDocument, int pageNumber, String text) {

        List<Position> positions = new LinkedList<>();

        TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber(text);
        pdfDocument.getPages().get_Item(pageNumber).accept(textFragmentAbsorber);
        TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();
        textFragmentCollection.forEach(textFragment -> positions.add(textFragment.getPosition()));
        return positions;
    }

}
