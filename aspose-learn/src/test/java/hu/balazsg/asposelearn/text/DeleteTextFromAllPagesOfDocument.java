package hu.balazsg.asposelearn.text;

import com.aspose.pdf.Document;
import hu.balazsg.asposelearn.text.wrapped.ReplaceTextUtil;
import hu.balazsg.asposelearn.util.LicenseUtil;

import static hu.balazsg.asposelearn.util.ConstantUtil.*;

public class DeleteTextFromAllPagesOfDocument {

    public static void main(String[] args) {
        LicenseUtil.getLicenseFromSrcRoot();
        deleteTextFromAllPagesOfDocument();
    }

    private static void deleteTextFromAllPagesOfDocument(){
        Document pdfDocument = new Document(INPUT_PDF);
        Document deletedTextDocument = ReplaceTextUtil.RemoveTextOnAllPages(pdfDocument, "DOCUMENT", "");
        pdfDocument.save(OUTPUT_TEXT_TO_DELETE);
    }
}
