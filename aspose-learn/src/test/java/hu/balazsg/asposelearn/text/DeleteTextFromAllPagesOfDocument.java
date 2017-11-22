package hu.balazsg.asposelearn.text;

import com.aspose.pdf.Document;
import hu.balazsg.asposelearn.wrapped.text.ReplaceTextUtil;
import hu.balazsg.asposelearn.util.LicenseUtil;

import static hu.balazsg.asposelearn.util.ConstantUtil.*;

public class DeleteTextFromAllPagesOfDocument {

    private static final String TEXT_TO_DELETE = "DOCUMENT";

    public static void main(String[] args) {
        LicenseUtil.getLicenseFromSrcRoot();
        deleteTextFromAllPagesOfDocument();
    }

    private static void deleteTextFromAllPagesOfDocument(){
        Document pdfDocument = new Document(INPUT_PDF);
        ReplaceTextUtil.RemoveTextOnAllPages(pdfDocument, TEXT_TO_DELETE);
        pdfDocument.save(OUTPUT_TEXT_TO_DELETE);
    }
}
