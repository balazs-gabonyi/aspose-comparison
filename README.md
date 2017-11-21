# POC Tests of Aspose PDF  - Java

## Aspose JAR
This project uses a downloaded aspose.pdf.jar that is placed manually on the classpath.  
In case you'd like to use aspose.pdf as a dependency uncomment the dependencies and repositories in [pom.xml](aspose-learn/pom.xml) of the aspose-learn module, and set the appropriate version.

## License
These POC examples only work properly with a paid or a temporary license.  
Temporary (but free) licenses can be acquired for companies only using [these instructions](http://www.aspose.com/corporate/purchase/temporary-license.aspx).

Copy your license file to the root of the cloned project if you have one.  
Make sure the file is named: Aspose.Pdf.lic
 

## Tested Features

### Text
- [x] [Find the position of a given text](/aspose-learn/src/test/java/hu/balazsg/asposelearn/text/SearchAndGetTextPositionsFromPagesOfPDFDocument.java)
- [x] [Delete text](/aspose-learn/src/test/java/hu/balazsg/asposelearn/text/DeleteTextFromAllPagesOfDocument.java)
- [x] [ReplaceTextWithCustomContentTextFormField](/aspose-learn/src/test/java/hu/balazsg/asposelearn/text/ReplaceTextWithCustomContentTextFormField.java)
### Signature / Image
- [ ] Placing an image on a given position
- [ ] Extract image file from Signature
### File
- [ ] Merge mutliple PDFs

