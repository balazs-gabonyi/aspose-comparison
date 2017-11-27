package hu.balazsg.aspose.pdf.wrapped.image;

import com.aspose.pdf.*;
import hu.balazsg.aspose.pdf.wrapped.common.position.PositionUtil;

import java.awt.*;
import java.io.FileInputStream;

import static hu.balazsg.aspose.pdf.wrapped.common.file.FileUtil.*;
import static hu.balazsg.aspose.pdf.wrapped.common.image.ImageA4PositionUtil.*;
import static hu.balazsg.aspose.pdf.wrapped.common.image.ImageDimensionUtil.getDimensionOfImage;
import static hu.balazsg.aspose.pdf.wrapped.common.image.ImageRenderUtil.renderImageToPage;

public class ImagePlacement {

    private Document pdfDocument;

    public ImagePlacement(Document pdfDocument) {
        this.pdfDocument = pdfDocument;
    }

    public void saveDocument(String outputName) {
        pdfDocument.save(outputName);
    }

    public void addImageOfWidthToExistingPDFFile(String pathToImage, int pageNumber, Position lowerLeftCorner, int widthMillimeters) {
        Dimension dimensionOfImage = getDimensionOfImage(pathToImage);
        Position upperRightCornerOffset = getUpperRightDiagonalOffsetForWidth(dimensionOfImage, widthMillimeters);
        Position upperRightCorner = PositionUtil.addPositions(lowerLeftCorner, upperRightCornerOffset);
        placeImageOnPage(pathToImage, pageNumber, lowerLeftCorner, upperRightCorner);
    }

    public void addImageOfHeightToExistingPDFFile(String pathToImage, int pageNumber, Position lowerLeftCorner, int heightMillimeters) {
        Dimension dimensionOfImage = getDimensionOfImage(pathToImage);
        Position upperRightCornerOffset = getUpperRightDiagonalOffsetForHeight(dimensionOfImage, heightMillimeters);
        Position upperRightCorner = PositionUtil.addPositions(lowerLeftCorner, upperRightCornerOffset);
        placeImageOnPage(pathToImage, pageNumber, lowerLeftCorner, upperRightCorner);
    }

    public void addImageOfSizeToExistingPDFFile(String pathToImage, int pageNumber, Position lowerLeftCorner, int widthMillimeters, int heightMillimeters) {
        Dimension dimensionOfImage = getDimensionOfImage(pathToImage);
        Position upperRightCornerOffset = getUpperRightDiagonalOffSetMillis(dimensionOfImage, widthMillimeters, heightMillimeters);
        Position upperRightCorner = PositionUtil.addPositions(lowerLeftCorner, upperRightCornerOffset);
        placeImageOnPage(pathToImage, pageNumber, lowerLeftCorner, upperRightCorner);
    }

    private void placeImageOnPage(String pathToImage, int pageNumber, Position lowerLeftCornerOfImage, Position upperRightCornerOfImage) {
        Page page = addImageStreamToPage(pathToImage, pageNumber);
        renderImageToPage(page, lowerLeftCornerOfImage, upperRightCornerOfImage);
    }

    private Page addImageStreamToPage(String pathToImage, int pageNumber) {
        FileInputStream imageStream = getFileStreamSafe(pathToImage);
        Page page = pdfDocument.getPages().get_Item(pageNumber);
        page.getResources().getImages().add(imageStream);
        closeFileStreamSafe(imageStream);
        page.getContents().add(new Operator.GSave());
        return page;
    }

}
