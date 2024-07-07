package com.project.PDFConvertor.services;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.project.PDFConvertor.Dtos.RequestDto;
import com.project.PDFConvertor.pdfstylesheets.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@Service
public class PDFServiceImpl implements PdfService{
    private Logger logger= LoggerFactory.getLogger(PDFServiceImpl.class);
    @Override
    public ByteArrayInputStream generatePDF(MultipartFile image1,MultipartFile image2, RequestDto request) throws IOException {

        logger.info("Generation of PDF started");
        String title = "EXECUTIVE SUMMARY";
        String title1 = "RESIDENTIAL VALUATION REPORT";
        String about = "The executive summary below is to be used in conjunction with the valuation report which forms part and is subject to " +
                       "the assumptions, caveats and basis of valuation stated herein and should not be read in isolation";
        long refId = Math.abs((long)(Math.random() * 2 * Long. MAX_VALUE - Long. MAX_VALUE));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document,out);


//      logo in header and footer setting
        InputStream logoStream = PDFServiceImpl.class.getResourceAsStream("/static/images/reliant_logo.png");
        HeaderFooterPageEvent event = new HeaderFooterPageEvent(logoStream, request.getPropertyAddress(),refId);
        writer.setPageEvent(event);

//      PDF Content start here
        document.open();
        document.add(new Paragraph("\r"));


//      Title of the page 1 PDF
        PdfPTable titleTable = PDFTitleDesigner.getTitle(title);
        document.add(titleTable);
        float titleWidth = titleTable.getTotalWidth();


//      Image Of Page 1 PDF
        PdfPTable primaryImageTable = PDFImageDesigner.page1ImageDesigner(image1,titleWidth);
        document.add(primaryImageTable);


//      Description and details table of page 1
        PdfPTable descPage1Table = PDFDescriptionDesigner.page1Description(request,refId);
        document.add(descPage1Table);


//---------------------------------------------------------------------------


        document.newPage();
        document.add(new Paragraph("\r"));

//      Title of the page 2 PDF
        PdfPTable titleTable1 = PDFTitleDesigner.getTitle(title1);
        document.add(titleTable1);

//      about Pdf page 2
        PdfPTable aboutTable = PDFAboutOnTopDesigner.aboutPDFOnTop(about,titleWidth);
        document.add(aboutTable);


//      Image Of Page 2 PDF
        PdfPTable page2ImageTable = PDFImageDesigner.page2ImagesDesigner(image1,image2,titleWidth);
        document.add(page2ImageTable);


//      Description and details table
        PdfPTable descPage2Table = PDFDescriptionDesigner.page2Description(request,refId);
        document.add(descPage2Table);


        document.close();

        return new ByteArrayInputStream(out.toByteArray());
    }
}
