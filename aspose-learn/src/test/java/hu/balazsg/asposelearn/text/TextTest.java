package hu.balazsg.asposelearn.text;

import com.aspose.pdf.*;
import hu.balazsg.asposelearn.util.LicenseHelper;
import hu.balazsg.asposelearn.wrapped.text.*;
import org.junit.*;

import java.util.List;

import static hu.balazsg.asposelearn.util.ConstantUtil.*;

public class TextTest {

    @BeforeClass
    public static void init() {
        LicenseHelper.getLicenseFromSrcRoot();
    }

    @Test
    public void deleteTextFromAllPagesOfDocumentTest(){
        String TEXT_TO_DELETE = "DOCUMENT";
        Document pdfDocument = new Document(INPUT_PDF);
        ReplaceTextUtil.RemoveTextOnAllPages(pdfDocument, TEXT_TO_DELETE);
        pdfDocument.save(OUTPUT_TEXT_TO_DELETE);
    }

    @Test
    public void replaceTextToFormFieldsTest() {
        Document pdfDocument = new Document(INPUT_PDF);
        TextToFormFieldUtil textToFormFieldUtil = new TextToFormFieldUtil(pdfDocument, 20, 200);
        textToFormFieldUtil.replaceTextWithFormField(TEXT_TO_REMOVE,TEXT_TO_REMOVE, ARVIZTURO);
        pdfDocument.save(OUTPUT_TEXT_TO_FORM_FIELDS);
    }

    @Test
    public void printTextPositionsTest() {
        LicenseHelper.getLicenseFromSrcRoot();
        Document pdfDocument = new Document(INPUT_PDF);
        System.out.println("Listing Positions with the following String: " + LOWER_CASE_E);
        printTextPositions(pdfDocument, LOWER_CASE_E);
    }

    private static void printTextPositions(Document pdfDocument, String textToFind){
        List<Position> positionsOfText = PositionUtil.getPositionsOfTextOnPage(pdfDocument,textToFind);
        positionsOfText.forEach(System.out::println);
    }
}

