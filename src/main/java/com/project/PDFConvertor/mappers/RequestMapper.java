package com.project.PDFConvertor.mappers;

import com.project.PDFConvertor.Dtos.RequestDto;
import org.springframework.web.bind.annotation.RequestParam;

public class RequestMapper {
    public static RequestDto requestToRequestDtoConvertor(
            String clientName,
            String bankName,
            String propertyType,
            String propertyAddress,
            String plotNo,
            String municipalityNo,
            String briefDescription,
            String unitArea,
            String viewFromUnit,
            String previousInvolvement,
            String status){
        RequestDto request = new RequestDto();
        request.setClientName(clientName);
        request.setBankName(bankName);
        request.setPropertyType(propertyType);
        request.setPropertyAddress(propertyAddress);
        request.setPlotNo(plotNo);
        request.setMunicipalityNo(municipalityNo);
        request.setBriefDescription(briefDescription);
        request.setUnitArea(unitArea);
        request.setViewFromUnit(viewFromUnit);
        request.setPreviousInvolvement(previousInvolvement);
        request.setStatus(status);
        return request;
    }
}
