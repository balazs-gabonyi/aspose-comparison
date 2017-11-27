# POC Tests of Aspose PDF  - Java
***
## Tested Features
#### [Text](/aspose-learn/src/test/java/hu/balazsg/aspose/pdf/text/TextTest.java)
- [x] Find the position of a given text
- [x] Delete text
- [x] Replace given text with a FormField containing custom text
#### [Image](/aspose-learn/src/test/java/hu/balazsg/aspose/pdf/image/ImageTest.java)
- [x] Place an image on a given position
#### [File](/aspose-learn/src/test/java/hu/balazsg/aspose/pdf/files/FilesTest.java)
- [x] Merge multiple PDFs
#### [Signature](/aspose-learn/src/test/java/hu/balazsg/aspose/pdf/signature/SignatureTest.java)
- [x] Sign PDF using a cert and a password
- [ ] Extract image file from Signature (only works for Aspose signatures)  
***
## Output files
The location of used and generated files is: aspose-pdf-poc\aspose-learn\testFiles\
***
## Aspose JAR
This project uses a downloaded aspose.pdf.jar that is placed manually on the classpath.  
In case you'd like to use aspose.pdf as a dependency uncomment the dependencies and repositories in [pom.xml](aspose-learn/pom.xml) of the aspose-learn module, and set the appropriate version.
***
## License
These POC examples only work properly with a paid or a temporary license.  
Temporary (but free) licenses can be acquired for companies only using [these instructions](http://www.aspose.com/corporate/purchase/temporary-license.aspx).

Copy your license file to aspose-pdf-poc\aspose-learn\ if you have one.  
Make sure the file is named: Aspose.Pdf.lic

## .PFX file for Signing
The temp.pfx certificate should be placed in [this folder](/aspose-learn/testFiles/input/) and its corresponding [12345 password should be renamed](/aspose-learn/src/test/java/hu/balazsg/aspose/pdf/util/ConstantUtil.java#L10) to whatever your cert is.

