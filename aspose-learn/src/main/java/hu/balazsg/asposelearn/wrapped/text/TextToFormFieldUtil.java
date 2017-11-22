package hu.balazsg.asposelearn.wrapped.text;

import com.aspose.pdf.*;

import java.util.*;

public class TextToFormFieldUtil {

    private Document pdfDocument;
    private List<Position> replaceableTextPositions;
    private int replaceableFontSize;
    private int formFieldHorizontalSize;

    public TextToFormFieldUtil(Document pdfDocument, int replaceableFontSize, int horizontalSize) {
        this.pdfDocument = pdfDocument;
        this.replaceableFontSize = replaceableFontSize;
        this.formFieldHorizontalSize = horizontalSize;
    }


    public void replaceTextWithFormField(String textToReplace, String formFieldId, String formFieldContent) {
        replaceableTextPositions = PositionUtil.getPositionsOfTextOnPage(pdfDocument, textToReplace);
        ReplaceTextUtil.RemoveTextOnAllPages(pdfDocument, textToReplace);
        replaceableTextPositions.forEach(position -> AddFormFiledOnPosition(position, formFieldId, formFieldContent));
    }


    private void AddFormFiledOnPosition(Position position, String formFieldId, String formFieldContent) {
        FormFieldUtil.addFormFieldOnPosition(pdfDocument, position, formFieldHorizontalSize, replaceableFontSize, formFieldId, formFieldContent);
    }

}
