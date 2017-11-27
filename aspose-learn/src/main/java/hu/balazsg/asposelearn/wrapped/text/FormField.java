package hu.balazsg.asposelearn.wrapped.text;

import com.aspose.pdf.*;

public class FormField {

    public static void addFormFieldOnPosition(
            Document pdfDocument,
            int pageNumber,
            Position position,
            int horizontalSize,
            int verticalSize,
            String id,
            String content
    ) {
        double posX = position.getXIndent();
        double posY = position.getYIndent();
        double rectangleAbsoluteSizeX = posX + horizontalSize;
        double rectangleAbsoluteSizeY = posY + verticalSize;
        addFormField(pdfDocument, pageNumber, posX, posY, rectangleAbsoluteSizeX, rectangleAbsoluteSizeY, id, content);
    }

    private static void addFormField(
            Document pdfDocument,
            int pageNumber,
            double xCoordOfBottomLeft,
            double yCoordinateOfBottomLeft,
            double width,
            double height,
            String id,
            String content
    ) {
        Rectangle rectangle = new Rectangle(xCoordOfBottomLeft, yCoordinateOfBottomLeft, width, height);
        addFormFieldOnPage(pdfDocument, pageNumber, rectangle, id, content);
    }

    private static void addFormFieldOnPage(Document pdfDocument, int pageNumber, Rectangle rectangle, String id, String content) {
        TextBoxField textBoxField1 = new TextBoxField(pdfDocument.getPages().get_Item(pageNumber), rectangle);
        textBoxField1.setPartialName(id);
        textBoxField1.setValue(content);
        Border border = new Border(textBoxField1);
        border.setWidth(0);
        border.setDash(new Dash(1, 1));
        textBoxField1.setBorder(border);
        pdfDocument.getForm().add(textBoxField1, pageNumber);
    }

}

