package hu.balazsg.asposelearn.files;

import hu.balazsg.asposelearn.util.LicenseUtil;
import hu.balazsg.asposelearn.wrapped.text.MergePDFUtil;

public class MergeMultiplePDFFiles {

    private static final String PDF_1 = "ImageAdded.pdf";
    private static final String PDF_2 = "input.pdf";
    private static final String PDF_3 = "input_form.pdf";
    private static final String PDF_4 = "input_form2.pdf";
    private static final String PDF_5 = "sampleMultipleInstances.pdf";

    public static void main(String[] args) {
        LicenseUtil.getLicenseFromSrcRoot();
        MergePDFUtil.mergePdfs("Merged.pdf", PDF_1, PDF_2, PDF_3, PDF_4, PDF_5);
    }
}
