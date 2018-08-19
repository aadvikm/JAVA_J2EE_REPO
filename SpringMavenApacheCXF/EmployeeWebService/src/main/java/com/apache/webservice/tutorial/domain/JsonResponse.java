package com.apache.webservice.tutorial.domain;

public class JsonResponse {
  private String errorMessage;
  private String jsonData;
  
  public JsonResponse() {}
  
  public String getErrorMessage() { return errorMessage; }
  
  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }
  
  public String getJsonData() { return jsonData; }
  
  public void setJsonData(String jsonData) {
    this.jsonData = jsonData;
  }
}