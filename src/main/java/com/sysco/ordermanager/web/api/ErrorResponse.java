package com.sysco.ordermanager.web.api;

public class ErrorResponse {
    private String errorCode;
    private int httpStatusCode;
    private String description;
    private String additionalDetails;

    public ErrorResponse() {
    }

    public ErrorResponse(String errorCode, int httpStatusCode, String description, String additionalDetails) {
        this.errorCode = errorCode;
        this.httpStatusCode = httpStatusCode;
        this.description = description;
        this.additionalDetails = additionalDetails;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdditionalDetails() {
        return additionalDetails;
    }

    public void setAdditionalDetails(String additionalDetails) {
        this.additionalDetails = additionalDetails;
    }
}
