package com.project.PDFConvertor.controllers;

import com.project.PDFConvertor.Dtos.RequestDto;
import com.project.PDFConvertor.mappers.RequestMapper;
import com.project.PDFConvertor.services.PdfService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class PdfController {
    @Autowired
    private PdfService pdfService;



    @GetMapping("/")
    public String showForm() {
        return "upload-form"; // Assuming you have an HTML form named "upload-form.html"
    }

    @PostMapping("/generate-pdf")
    public ResponseEntity<InputStreamResource> generatePdf(
            @RequestParam("clientName") String clientName,
            @RequestParam("bankName") String bankName,
            @RequestParam("propertyType") String propertyType,
            @RequestParam("propertyAddress") String propertyAddress,
            @RequestParam("plotNo") String plotNo,
            @RequestParam("municipalityNo") String municipalityNo,
            @RequestParam("briefDescription") String briefDescription,
            @RequestParam("unitArea") String unitArea,
            @RequestParam("viewFromUnit") String viewFromUnit,
            @RequestParam("previousInvolvement") String previousInvolvement,
            @RequestParam("status") String status,
            @RequestParam MultipartFile image1,
            @RequestParam MultipartFile image2) throws IOException {

        RequestDto request = RequestMapper.requestToRequestDtoConvertor(clientName,bankName,propertyType,propertyAddress,
                             plotNo,municipalityNo,briefDescription,unitArea,viewFromUnit,previousInvolvement,status);

        ByteArrayInputStream input = pdfService.generatePDF(image1,image2,request);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition","attachment; filename=generated.pdf");
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(input));
    }
}
