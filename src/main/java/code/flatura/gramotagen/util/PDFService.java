package code.flatura.gramotagen.util;

import code.flatura.gramotagen.model.Dto.DiplomaDto;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.istack.NotNull;

import javax.servlet.ServletOutputStream;
import java.io.IOException;

public class PDFService {
    // Fonts and media
    private static final String PHILLIPP_SCRIPT_TTF = "./src/main/resources/PhillippScript.ttf";
    private static final String ROLAND_DECOR_TTF = "./src/main/resources/Roland-Decor.ttf";
    private static final String GRAMOTA_A4_PORTRAIT_JPG = "./src/main/resources/gramotaA4p.jpg";
    private static final String GRAMOTA_A5_LANDSCAPE_JPG = "./src/main/resources/default.jpg";
    // Markup
    //private static final int GAP_BEFORE_TYPE = 1;
    private static final int GAP_BEFORE_TYPE = 0;
    //private static final int GAP_BEFORE_AWARDED = 4;
    private static final int GAP_BEFORE_AWARDED = 2;
    private static final int GAP_BEFORE_PERSONAL_INFO = 0;
    private static final int GAP_BEFORE_COMPETITION_INFO = 0;
    // Sizes
    private static final int HEADER1_SIZE = 30;
    private static final int HEADER2_SIZE = 30;
    private static final int SMALL_TEXT_SIZE = 10;
    private static final int TEXT_SIZE = 15;

    public static void generate(DiplomaDto diplomaDto, ServletOutputStream outputStream) {
        try {
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);
            document.setPageSize(new Rectangle(600,420));
            document.setMargins(22,32,12,22);
            document.open();

            addMetadata(diplomaDto, document);
            addBackgroundImage(writer);
            addContent(diplomaDto, document);

            document.close();
        } catch (IOException ex) {
            throw new RuntimeException("IOError writing file to output stream");
        } catch (DocumentException ex) {
            throw new RuntimeException("iText document error");
        }
    }

    private static void addContent(@NotNull DiplomaDto diplomaDto, Document document) throws DocumentException, IOException {
        // Adding curvy fonts
        BaseFont header1BaseFont = BaseFont.createFont(PHILLIPP_SCRIPT_TTF, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        BaseFont header2BaseFont = BaseFont.createFont(PHILLIPP_SCRIPT_TTF, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        BaseFont text1BaseFont = BaseFont.createFont(PHILLIPP_SCRIPT_TTF, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

        Font header1Font = new Font(header1BaseFont,HEADER1_SIZE, Font.NORMAL);
        Font header2font = new Font(header2BaseFont,HEADER2_SIZE, Font.NORMAL);
        Font text1Font = new Font(text1BaseFont,TEXT_SIZE, Font.NORMAL);
        Font smallTextFont = new Font(text1BaseFont,SMALL_TEXT_SIZE, Font.NORMAL);
        //Font header1 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 24, BaseColor.BLACK);

        //  Adding diploma type
        addEmptyLine(document, GAP_BEFORE_TYPE);
        Paragraph paragraph;
        //paragraph = new Paragraph(diplomaDto.getType(), header1Font);
        paragraph = new Paragraph(" ", header1Font);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);

        addEmptyLine(document, GAP_BEFORE_AWARDED);
        paragraph = new Paragraph("награждается", text1Font);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);

        //  Adding Personal info
        addEmptyLine(document, GAP_BEFORE_PERSONAL_INFO);
        paragraph = new Paragraph(diplomaDto.getPersonSurname(), header2font);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        paragraph.setLeading(0, 0.7F);
        document.add(paragraph);
        paragraph = new Paragraph(diplomaDto.getPersonName() + " " + diplomaDto.getPersonMiddleName(), header2font);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);


        // Adding competition info
        addEmptyLine(document, GAP_BEFORE_COMPETITION_INFO);
        paragraph = new Paragraph(diplomaDto.getStatus(), text1Font);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);
        paragraph = new Paragraph(diplomaDto.getCompetitionTitle() + (diplomaDto.getCompetitionDate() == null ? "" : (" (" + diplomaDto.getCompetitionDate() + ")")), text1Font);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);

        paragraph = new Paragraph(diplomaDto.getDecree(), smallTextFont);
        paragraph.setAlignment(Element.ALIGN_RIGHT);
        document.add(paragraph);

    }

    private static void addBackgroundImage(PdfWriter writer) throws IOException, DocumentException {
        PdfContentByte canvas = writer.getDirectContentUnder();
        //Image image = Image.getInstance(GRAMOTA_A4_PORTRAIT_JPG);
        Image image = Image.getInstance(GRAMOTA_A5_LANDSCAPE_JPG);
        image.scaleAbsolute(PageSize.A5.rotate());
        image.setAbsolutePosition(0, 0);
        canvas.addImage(image);
    }

    private static void addMetadata(DiplomaDto diplomaDto, Document document) {
        //  Adding Metadata
        document.addTitle("Грамота ГБОУ Школа №1507");
        document.addSubject(diplomaDto.getPersonName() + " " + diplomaDto.getPersonSurname());
        document.addKeywords("School1507");
        document.addAuthor("Dmitry Morozov");
        document.addCreator("Dmitry Morozov");
    }

    private static void addEmptyLine(Document document, Integer linesCount) throws DocumentException {
        if (linesCount > 0)
            for (int i = 0; i < linesCount; i++) {
                document.add(Chunk.NEWLINE);
            }
    }
}
