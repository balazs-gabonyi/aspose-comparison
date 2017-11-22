package hu.balazsg.asposelearn.text;

import com.aspose.pdf.*;
import hu.balazsg.asposelearn.wrapped.text.PositionUtil;
import hu.balazsg.asposelearn.util.LicenseUtil;

import java.util.List;

import static hu.balazsg.asposelearn.util.ConstantUtil.*;

public class SearchAndGetTextPositionsFromPagesOfPDFDocument {

    private static final String LOWER_CASE_E = "e";

    public static void main(String[] args) {
        LicenseUtil.getLicenseFromSrcRoot();
        Document pdfDocument = new Document(INPUT_PDF);
        System.out.println("Listing Positions with the following String: " + LOWER_CASE_E);
        printTextPositions(pdfDocument, LOWER_CASE_E);
    }

    private static void printTextPositions(Document pdfDocument, String textToFind){
        List<Position> positionsOfText = PositionUtil.getPositionsOfTextOnPage(pdfDocument,textToFind);
        positionsOfText.forEach(System.out::println);
        }
    }

