package com.project.PDFConvertor.pdfstylesheets;

import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;

import java.awt.*;

public class PDFTitleDesigner {
public static PdfPTable getTitle(String title) {
    Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10);
    titleFont.setColor(Color.WHITE);

    Paragraph titlePara = new Paragraph(title, titleFont);
    titlePara.setAlignment(Element.ALIGN_JUSTIFIED);

    PdfPCell titleCell = new PdfPCell(titlePara);
    titleCell.setBackgroundColor(new Color(255, 0, 0));
    titleCell.setPadding(5);
    titleCell.setHorizontalAlignment(Element.ALIGN_CENTER); // Center the title horizontally
    titleCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

    PdfPTable titleTable = new PdfPTable(1);
    titleTable.setWidthPercentage(100);
    titleTable.setSpacingAfter(10);
    titleTable.addCell(titleCell);
    return titleTable;
}
}
