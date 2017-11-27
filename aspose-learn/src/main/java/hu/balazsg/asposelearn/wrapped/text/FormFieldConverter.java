package hu.balazsg.asposelearn.wrapped.text;

import com.aspose.pdf.*;

import java.util.List;

public class FormFieldConverter {

    private Document pdfDocument;
    private List<Position> replaceableTextPositions;
    private int replaceableFontSize;
    private int formFieldHorizontalSize;

    public FormFieldConverter(Document pdfDocument, int replaceableFontSize, int horizontalSize) {
        this.pdfDocument = pdfDocument;
        this.replaceableFontSize = replaceableFontSize;
        this.formFieldHorizontalSize = horizontalSize;
    }

    public void replaceTextToFormField(String textToReplace, int pageNumber, String formFieldId, String formFieldContent) {
        replaceableTextPositions = PositionLookup.getPositionsOfTextOnPage(pdfDocument, pageNumber, textToReplace);
        ReplacingText.RemoveTextOnPage(pdfDocument, pageNumber, textToReplace);
        replaceableTextPositions.forEach(position -> AddFormFiledOnPosition(position, pageNumber, formFieldId, formFieldContent));
    }

    private void AddFormFiledOnPosition(Position position, int pageNumber, String formFieldId, String formFieldContent) {
        FormField.addFormFieldOnPosition(pdfDocument, pageNumber, position, formFieldHorizontalSize, replaceableFontSize, formFieldId, formFieldContent);
    }

}
