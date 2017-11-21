package hu.balazsg.asposelearn.text;

import com.aspose.pdf.Document;
import hu.balazsg.asposelearn.text.wrapped.TextToFormFieldUtil;
import hu.balazsg.asposelearn.util.LicenseUtil;

import static hu.balazsg.asposelearn.util.ConstantUtil.*;

public class ReplaceTextWithCustomContentTextFormField {

    public static void main(String[] args) {
        LicenseUtil.getLicenseFromSrcRoot();
        replaceTextToFormFields();
    }

    public static void replaceTextToFormFields() {
        Document pdfDocument = new Document(INPUT_PDF);
        TextToFormFieldUtil textToFormFieldUtil = new TextToFormFieldUtil(pdfDocument, 20, 200);
        textToFormFieldUtil.replaceTextWithFormField(TEXT_TO_REMOVE, ARVIZTURO);
        pdfDocument.save(OUTPUT_TEXT_TO_FORMFIELDS);
    }
}
