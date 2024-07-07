package com.project.PDFConvertor.pdfstylesheets;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;

public class PDFAboutOnTopDesigner {
    public static PdfPTable aboutPDFOnTop(String about, Float titleWidth){
        Font aboutFont = FontFactory.getFont(FontFactory.HELVETICA,10);

        Paragraph aboutPara = new Paragraph(about,aboutFont);

        PdfPCell aboutCell = new PdfPCell(aboutPara);
        aboutCell.setBorder(Rectangle.NO_BORDER);
        aboutCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        aboutCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

        PdfPTable aboutTable = new PdfPTable(1);
        aboutTable.setSpacingAfter(10);
        aboutTable.setWidthPercentage(100);
        aboutTable.setTotalWidth(titleWidth);
        aboutTable.addCell(aboutCell);

        return aboutTable;
    }
}
