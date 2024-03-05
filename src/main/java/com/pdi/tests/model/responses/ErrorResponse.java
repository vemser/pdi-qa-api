package com.pdi.tests.model.responses;

import java.util.ArrayList;

public class ErrorResponse {
    public String timestamp;
    public Integer status;
    public String error;
    public ArrayList<String> errors;
    public String path;
    public String message;
}