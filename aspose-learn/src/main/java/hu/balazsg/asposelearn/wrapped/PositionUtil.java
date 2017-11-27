package hu.balazsg.asposelearn.wrapped;

import com.aspose.pdf.*;

public class PositionUtil {

    public static Position addPositions(Position... positions) {
        double xCoordinateOfResult = 0D;
        double yCoordinateOfResult = 0D;
        for (Position current : positions) {
            xCoordinateOfResult += current.getXIndent();
            yCoordinateOfResult += current.getYIndent();
        }
        return new Position(xCoordinateOfResult, yCoordinateOfResult);
    }

    public static Rectangle createRectangle(Position lowerLeftCorner, Position upperRightCorner) {
        int lowerLeftX = (int) lowerLeftCorner.getXIndent();
        int lowerLeftY = (int) lowerLeftCorner.getYIndent();
        int upperRightX = (int) upperRightCorner.getXIndent();
        int upperRightY = (int) upperRightCorner.getYIndent();
        return new Rectangle(lowerLeftX, lowerLeftY, upperRightX, upperRightY);
    }
}
