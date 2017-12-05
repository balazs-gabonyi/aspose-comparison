package hu.balazsg.aspose.pdf.text;

import com.aspose.pdf.*;
import hu.balazsg.aspose.pdf.util.*;
import hu.balazsg.aspose.pdf.wrapped.text.*;
import org.junit.*;

import java.util.*;

import static hu.balazsg.aspose.pdf.util.ConstantUtil.INPUT_WITH_FORM_SIGNATURE;
import static hu.balazsg.aspose.pdf.util.ConstantUtil.OUTPUT_FORM_SIGNATURE;
import static hu.balazsg.aspose.pdf.wrapped.text.PositionLookup.getPositionsOfTextOnPage;

public class TextTest {

    @BeforeClass
    public static void init() {
        LicenseHelper.getLicenseFromSrcRoot();
    }

    private static void printTextPositions(Document pdfDocument, String textToFind) {
        List<Position> positionsOfText = getPositionsOfTextOnPage(pdfDocument, 1, textToFind);
        positionsOfText.forEach(System.out::println);
    }

    @Test
    public void deleteTextFromAllPagesOfDocumentTest() {
        String TEXT_TO_DELETE = "DOG";
        Document pdfDocument = new Document(ConstantUtil.INPUT);
        ReplacingText.RemoveTextOnAllPages(pdfDocument, TEXT_TO_DELETE);
        pdfDocument.save(ConstantUtil.OUTPUT_TEXT_TO_REMOVED);
    }

    @Test
    public void replaceTextToFormFieldsTest() {
        Document pdfDocument = new Document(ConstantUtil.INPUT);
        FormFieldConverter formFieldConverter = new FormFieldConverter(pdfDocument, 12, 200);
        formFieldConverter.replaceTextToFormField("dog.", 1, UUID.randomUUID().toString(), ConstantUtil.ARVIZTURO);
        formFieldConverter.replaceTextToFormField("THE LAZY DOG.", 2, UUID.randomUUID().toString(), "THE HAZY FOG");
        pdfDocument.save(ConstantUtil.OUTPUT_TEXT_TO_FORM_FIELDS);
    }

    @Test
    public void printTextPositionsTest() {
        final String lowerCase_e = "e";
        Document pdfDocument = new Document(ConstantUtil.INPUT);
        System.out.println("Listing Positions with the following String: " + lowerCase_e);
        printTextPositions(pdfDocument, lowerCase_e);
    }

    @Test
    public void fillFormFieldsWithText(){
        final String textToFill = "HELLOTEXT - OTHERSTUFF / ANOTHERSTUFFSTUFF";
        Document pdfDocument = new Document(INPUT_WITH_FORM_SIGNATURE);
        FormField.fillAllFields(pdfDocument,textToFill,OUTPUT_FORM_SIGNATURE);
    }
}

