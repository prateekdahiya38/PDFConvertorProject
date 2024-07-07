package com.project.PDFConvertor.Dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;

@Getter
@Setter
public class RequestDto {
    private String clientName;
    private String bankName;
    private String propertyType;
    private String propertyAddress;
    private String plotNo;
    private String municipalityNo;
    private String briefDescription;
    private String unitArea;
    private String viewFromUnit;
    private String previousInvolvement;
    private String status;
}
