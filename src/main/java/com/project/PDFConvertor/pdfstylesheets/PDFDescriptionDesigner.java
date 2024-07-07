package com.project.PDFConvertor.pdfstylesheets;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.project.PDFConvertor.Dtos.RequestDto;

import java.time.Instant;
import java.util.UUID;

public class PDFDescriptionDesigner {

    public static PdfPTable page2Description(RequestDto requestDto, Long refId){
        PdfPTable descTable = new PdfPTable(2);
        descTable.setWidthPercentage(100);
        descTable.setSpacingAfter(10);
        addRowDetails(descTable,"Client",requestDto.getClientName());
        addRowDetails(descTable,"Prepared For",requestDto.getBankName());
        addRowDetails(descTable,"Property Type", requestDto.getPropertyType());
        addRowDetails(descTable,"Property Address", requestDto.getPropertyAddress());
        addRowDetails(descTable,"Plot No.", requestDto.getPlotNo());
        addRowDetails(descTable,"Municipality No.", requestDto.getMunicipalityNo());
        addRowDetails(descTable,"Brief Description", requestDto.getBriefDescription());
        addRowDetails(descTable,"Unit Area", requestDto.getUnitArea());
        addRowDetails(descTable,"View from the unit", requestDto.getViewFromUnit());
        addRowDetails(descTable,"Previous Involvement", requestDto.getPreviousInvolvement());
        addRowDetails(descTable,"Status", requestDto.getStatus());
        return descTable;
    }


    public static PdfPTable page1Description(RequestDto requestDto,Long refId){

        PdfPTable descTable = new PdfPTable(2);
        descTable.setWidthPercentage(100);
        descTable.setSpacingAfter(10);
        addRowDetails(descTable,"Client Name",requestDto.getClientName());
        addRowDetails(descTable,"Address", requestDto.getPropertyAddress());
        addRowDetails(descTable,"Date Of Report", Instant.now().toString());
        addRowDetails(descTable,"Client Reference",refId.toString());
        addRowDetails(descTable,"Prepared For",requestDto.getBankName());
        return descTable;
    }



    private static void addRowDetails(PdfPTable table, String label, String value){
        Font labelFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,10);
        Font valueFont = FontFactory.getFont(FontFactory.HELVETICA,9);

        Paragraph labelPara = new Paragraph(label,labelFont);
        labelPara.setAlignment(Element.ALIGN_JUSTIFIED);

        PdfPCell labelCell = new PdfPCell(labelPara);
        labelCell.setPadding(8);
        labelCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        labelCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        labelCell.setBorder(Rectangle.BOX);
        table.addCell(labelCell);

        Paragraph valuePara = new Paragraph(value,valueFont);
        valuePara.setAlignment(Element.ALIGN_JUSTIFIED);

        PdfPCell valueCell = new PdfPCell(valuePara);
        valueCell.setPadding(8);
        valueCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        valueCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        valueCell.setBorder(Rectangle.BOX);
        table.addCell(valueCell);
    }
}
