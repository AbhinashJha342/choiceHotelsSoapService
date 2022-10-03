package com.soap.choicehotels.ChoiceHotelsSoapService.exception;

import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;

import javax.xml.namespace.QName;

public class GlobalExceptionResolver extends SoapFaultMappingExceptionResolver {

    private static final QName CODE = new QName("statusCode");
    private static final QName MESSAGE = new QName("message");

    @Override
    protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {
        logger.warn("Exception processed ", ex);
        int status = 0;
        String detailMessage = null;
        if (ex instanceof NotFoundException) {
            status = ((NotFoundException) ex).getStatus();
            detailMessage = ((NotFoundException) ex).getErrorDetails();
        } else if(ex instanceof CustomDbDataUpdatedException) {
            status = ((CustomDbDataUpdatedException) ex).getStatus();
            detailMessage = ((CustomDbDataUpdatedException) ex).getErrorDetails();
        }
        SoapFaultDetail detail = fault.addFaultDetail();
        detail.addFaultDetailElement(CODE).addText(String.valueOf(status));
        detail.addFaultDetailElement(MESSAGE).addText(detailMessage);
    }

}
