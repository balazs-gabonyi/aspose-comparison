package hu.balazsg.asposelearn.text.wrapped;

import com.aspose.pdf.*;

import java.util.UUID;

public class FormFieldUtil {


    public static Document addFormFieldOnPosition(Document pdfDocument, Position position, int horizontalSize, int verticalSize, String content) {
        double posX = position.getXIndent();
        double posY = position.getYIndent();
        double rectangleAbsoluteSizeX = posX + horizontalSize;
        double rectangleAbsoluteSizeY = posY + verticalSize;
        return addFormField(pdfDocument, posX, posY, rectangleAbsoluteSizeX, rectangleAbsoluteSizeY, content);
    }

    private static Document addFormField(
            Document pdfDocument,
            double horizontalDistanceFromBottomLeftCorner,
            double verticalDistanceFromBottomLeftCorner,
            double horizontalSize,
            double verticalSize,
            String content
    ) {
        TextBoxField textBoxField1 = new TextBoxField(
                pdfDocument.getPages().get_Item(1),
                new Rectangle(
                        horizontalDistanceFromBottomLeftCorner,
                        verticalDistanceFromBottomLeftCorner,
                        horizontalSize,
                        verticalSize));

        textBoxField1.setPartialName(UUID.randomUUID().toString());
        textBoxField1.setValue(content);
        Border border = new Border(textBoxField1);
        border.setWidth(0);
        border.setDash(new Dash(1, 1));
        textBoxField1.setBorder(border);
        pdfDocument.getForm().add(textBoxField1, 1);
        return pdfDocument;
    }
}

