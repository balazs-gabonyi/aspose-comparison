package hu.balazsg.asposelearn.wrapped.text;

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

    public static Position addPositions (Position... positions){
        double xCoordinateOfResult = 0D;
        double yCoordinateOfResult = 0D;
        for (Position current : positions){
            xCoordinateOfResult += current.getXIndent();
            yCoordinateOfResult += current.getYIndent();
        }
        return new Position(xCoordinateOfResult, yCoordinateOfResult);
    }
}
