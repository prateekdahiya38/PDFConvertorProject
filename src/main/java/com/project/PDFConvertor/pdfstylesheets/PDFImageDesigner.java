package com.project.PDFConvertor.pdfstylesheets;

import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public class PDFImageDesigner {
    public static PdfPTable page1ImageDesigner(MultipartFile image, float titleWidth) throws IOException {
            Image primaryImage = Image.getInstance(image.getBytes());
            primaryImage.scaleAbsolute(titleWidth, 250);

            PdfPCell imageCell = new PdfPCell(primaryImage);
            imageCell.setHorizontalAlignment(Element.ALIGN_CENTER); // Center the title horizontally
            imageCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPTable imageTable = new PdfPTable(1);
            imageTable.setWidthPercentage(100);
            imageTable.setSpacingAfter(10);
            imageTable.addCell(imageCell);

            return imageTable;
    }

    public static PdfPTable page2ImagesDesigner(MultipartFile imageA,MultipartFile imageB,float titleWidth) throws IOException {
        float padding = 5f;
        float imageWidth = (titleWidth / 2) - padding;

        Image image1 = Image.getInstance(imageA.getBytes());
        image1.scaleAbsolute(imageWidth, 200);

        Image image2 = Image.getInstance(imageB.getBytes());
        image2.scaleAbsolute(imageWidth, 200);

        PdfPCell image1Cell = new PdfPCell(image1);
        PdfPCell image2Cell = new PdfPCell(image2);

        image1Cell.setPaddingRight(padding);
        image2Cell.setPaddingLeft(padding);

        image1Cell.setBorder(PdfPCell.NO_BORDER);
        image2Cell.setBorder(PdfPCell.NO_BORDER);

        image1Cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        image1Cell.setVerticalAlignment(Element.ALIGN_LEFT);

        image2Cell.setHorizontalAlignment(Element.ALIGN_RIGHT); // Center the title horizontally
        image2Cell.setVerticalAlignment(Element.ALIGN_RIGHT);

        PdfPTable imageTable = new PdfPTable(2);
        imageTable.setWidthPercentage(100);
        imageTable.setSpacingAfter(10);
        imageTable.addCell(image1Cell);
        imageTable.addCell(image2Cell);

        return imageTable;
    }
}
