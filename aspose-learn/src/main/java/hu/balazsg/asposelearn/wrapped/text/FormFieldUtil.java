package hu.balazsg.asposelearn.wrapped.text;

import com.aspose.pdf.*;

import java.util.UUID;

public class FormFieldUtil {

    private static final String FORM_NAME = "form";


    public static Document addFormFieldOnPosition(Document pdfDocument, Position position, int horizontalSize, int verticalSize, String id, String content) {
        double posX = position.getXIndent();
        double posY = position.getYIndent();
        double rectangleAbsoluteSizeX = posX + horizontalSize;
        double rectangleAbsoluteSizeY = posY + verticalSize;
        return addFormField(pdfDocument, posX, posY, rectangleAbsoluteSizeX, rectangleAbsoluteSizeY, id, content);
    }

    private static Document addFormField(
            Document pdfDocument,
            double horizontalDistanceFromBottomLeftCorner,
            double verticalDistanceFromBottomLeftCorner,
            double horizontalSize,
            double verticalSize,
            String id,
            String content
    ) {
        TextBoxField textBoxField1 = new TextBoxField(
                pdfDocument.getPages().get_Item(1),
                new Rectangle(
                        horizontalDistanceFromBottomLeftCorner,
                        verticalDistanceFromBottomLeftCorner,
                        horizontalSize,
                        verticalSize));

        textBoxField1.setPartialName(id);
        textBoxField1.setValue(content);
        Border border = new Border(textBoxField1);
        border.setWidth(0);
        border.setDash(new Dash(1, 1));
        textBoxField1.setBorder(border);
        pdfDocument.getForm().add(textBoxField1, 1);
        return pdfDocument;
    }
}

