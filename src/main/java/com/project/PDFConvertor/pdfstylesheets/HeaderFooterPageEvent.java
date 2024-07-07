package com.project.PDFConvertor.pdfstylesheets;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class HeaderFooterPageEvent extends PdfPageEventHelper {
    private Image logo;
    private String address;
    private Long refId;

    public HeaderFooterPageEvent(InputStream logoStream,String address, Long refId) throws IOException, BadElementException {
        this.logo = Image.getInstance(logoStream.readAllBytes());
        this.logo.scaleToFit(100, 100); // Adjust the size of the logo
        this.address = address;
        this.refId = refId;
    }


    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        PdfContentByte canvas = writer.getDirectContentUnder();
        float x = document.right() - 100; // Adjust the position
        float y = document.top();  // Adjust the position
        logo.setAbsolutePosition(x, y);
        try {
            canvas.addImage(logo);
        } catch (DocumentException e) {
            e.printStackTrace();
        }


        Font footerFont = FontFactory.getFont(FontFactory.HELVETICA,10);

        Phrase footerPhrase = new Phrase();
        footerPhrase.add(new Chunk(address, footerFont));
        footerPhrase.add(new Chunk(", Reference ID: " + refId, footerFont));

        PdfPTable footerTable = new PdfPTable(1);
        footerTable.setTotalWidth(document.right() - document.left());

        PdfPCell addressCell = new PdfPCell(footerPhrase);
        addressCell.setBorder(Rectangle.NO_BORDER);
        addressCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        addressCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

        footerTable.addCell(addressCell);

        footerTable.writeSelectedRows(0, -1, document.leftMargin(), document.bottomMargin(), writer.getDirectContent());
    }
}
