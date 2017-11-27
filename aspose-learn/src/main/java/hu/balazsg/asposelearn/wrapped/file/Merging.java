package hu.balazsg.asposelearn.wrapped.file;

import com.aspose.pdf.Document;

import java.util.List;

public class Merging {

    public static void mergePdfs(String outputName, List<String> inputs) {
        Document mergeTarget = new Document(inputs.get(0));
        boolean isFirst = true;
        for (String current : inputs) {
            if (isFirst) {
                isFirst = false;
                continue;
            } else {
                Document merged = new Document(current);
                mergeDocumentToOther(mergeTarget, merged);
            }
        }
        mergeTarget.save(outputName);
    }

    public static void mergePdfs(String outputName, String... inputs) {
        String firstInput = getFirstOfOptionalList(inputs);
        Document mergeTarget = new Document(firstInput);
        boolean isFirst = true;
        for (String current : inputs) {
            if (isFirst) {
                isFirst = false;
                continue;
            } else {
                Document merged = new Document(current);
                mergeDocumentToOther(mergeTarget, merged);
            }
        }
        mergeTarget.save(outputName);
    }

    private static String getFirstOfOptionalList(String... list) {
        String firstElement = null;
        for (String current : list) {
            firstElement = current;
            return current;
        }
        return firstElement;
    }

    private static void mergeDocumentToOther(Document mergeTarget, Document merged) {
        mergeTarget.getPages().add(merged.getPages());
    }
}
