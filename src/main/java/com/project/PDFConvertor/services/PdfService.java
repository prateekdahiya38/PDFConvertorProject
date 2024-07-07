package com.project.PDFConvertor.services;

import com.project.PDFConvertor.Dtos.RequestDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

public interface PdfService {
    public ByteArrayInputStream generatePDF(MultipartFile image1,MultipartFile image2,RequestDto request) throws IOException;
}
