package hu.balazsg.asposelearn.text.wrapped;

import com.aspose.pdf.*;

import java.util.*;

import static hu.balazsg.asposelearn.text.wrapped.ReplaceTextUtil.RemoveTextOnAllPages;

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


    public void replaceTextWithFormField(String textToReplace, String formFieldContent) {
        replaceableTextPositions = PositionUtil.getPositionsOfTextOnPage(pdfDocument, textToReplace);
        RemoveTextOnAllPages(pdfDocument, textToReplace);
        replaceableTextPositions.forEach(position -> AddFormFiledOnPosition(position, formFieldContent));
    }


    private void AddFormFiledOnPosition(Position position, String content) {
        FormFieldUtil.addFormFieldOnPosition(pdfDocument, position, formFieldHorizontalSize, replaceableFontSize, content);
    }

}
