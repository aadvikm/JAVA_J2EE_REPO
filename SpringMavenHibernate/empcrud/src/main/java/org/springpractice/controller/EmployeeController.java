package org.springpractice.controller;

import java.io.Serializable;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springpractice.domain.EmployeeDetail;
import org.springpractice.domain.EmployeeEntity;
import org.springpractice.domain.JsonResponse;
import org.springpractice.exception.EmployeeException;
import org.springpractice.service.EmployeeService;


@Controller
public class EmployeeController
  implements Serializable
{
  private static Logger LOG = Logger.getLogger(EmployeeController.class);
  @Autowired
  private EmployeeService employeeService;
  
  public EmployeeController() {}
  
  @RequestMapping(value={"/"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String empPage() { return "empPage"; }
  
  @RequestMapping(value={"/getemployees"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public JsonResponse getEmployees()
  {
    LOG.info("Inside get Employees controller mapping...");
    try {
      ArrayList<EmployeeDetail> employeeDetailList = employeeService.getEmployees();
      return getJsonResponse(employeeDetailList);
    }
    catch (EmployeeException employeeException) {
      LOG.error("Error occurred in getEmployeeDetail...", employeeException);
      JsonResponse response = new JsonResponse();
      response.setErrorMessage("Error Occurred. Please try again later.");
      return response;
    }
    catch (Exception exception) {
      LOG.error("Error occurred in getEmployeeDetail...", exception);
      JsonResponse response = new JsonResponse();
      response.setErrorMessage("Error Occurred. Please try again later.");
      return response;
    }
  }
  
  @RequestMapping(value={"/getempdetail"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public JsonResponse getEmpDetail(@RequestParam("empId") Long empId) {
    LOG.info("Inside get employee detail controller mapping...");
    try {
      EmployeeDetail employeeDetail = employeeService.getEmployeeDetail(empId);
      return getJsonResponse(employeeDetail);
    }
    catch (EmployeeException employeeException) {
      LOG.error("Error occurred in getempDetail...", employeeException);
      JsonResponse response = new JsonResponse();
      response.setErrorMessage("Error Occurred. Please try again later.");
      return response;
    }
    catch (Exception exception) {
      LOG.error("Error occurred in getEmpDetail...", exception);
      JsonResponse response = new JsonResponse();
      response.setErrorMessage("Error Occurred. Please try again later.");
      return response;
    }
  }
  
  @RequestMapping(value={"/updateemp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public JsonResponse updateEmp(@RequestBody EmployeeDetail employeeDetail)
  {
    LOG.info("Inside update Employee controller mapping...");
    try {
      EmployeeEntity employeeEntity = employeeService.updateEmp(employeeDetail);
      employeeDetail = employeeService.getEmployeeDetail(employeeEntity.getEmpId());
      return getJsonResponse(employeeDetail);
    }
    catch (EmployeeException employeeException) {
      LOG.error("Error occurred in update Employee.", employeeException);
      JsonResponse response = new JsonResponse();
      response.setErrorMessage("Error Occurred. Please try again later.");
      return response;
    }
    catch (Exception exception) {
      LOG.error("Error occurred in update employee..", exception);
      JsonResponse response = new JsonResponse();
      response.setErrorMessage("Error Occurred. Please try again later.");
      return response;
    }
  }
  
  @RequestMapping(value={"/saveemp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public JsonResponse saveDept(@RequestBody EmployeeDetail employeeDetail) {
    LOG.info("Inside save Employee controller mapping...");
    try {
      EmployeeEntity employeeEntity = employeeService.saveEmp(employeeDetail);
      employeeDetail = employeeService.getEmployeeDetail(employeeEntity.getEmpId());
      return getJsonResponse(employeeDetail);
    }
    catch (EmployeeException employeeException) {
      LOG.error("Error occurred in saveEmp...", employeeException);
      JsonResponse response = new JsonResponse();
      response.setErrorMessage("Error Occurred. Please try again later.");
      return response;
    }
    catch (Exception exception) {
      LOG.error("Error occurred in saveEmp...", exception);
      JsonResponse response = new JsonResponse();
      response.setErrorMessage("Error Occurred. Please try again later.");
      return response;
    }
  }
  
  @RequestMapping(value={"/deleteemp/{empId}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public JsonResponse deleteEmp(@PathVariable("empId") Long empId) {
    LOG.info("Inside delete Employee controller mapping...");
    try {
      employeeService.deleteEmp(empId);
      return new JsonResponse();
    }
    catch (EmployeeException employeeException) {
      LOG.error("Error occurred in deleteEmp...", employeeException);
      JsonResponse response = new JsonResponse();
      response.setErrorMessage("Error Occurred. Please try again later.");
      return response;
    }
    catch (Exception exception) {
      LOG.error("Error occurred in deleteEmp...", exception);
      JsonResponse response = new JsonResponse();
      response.setErrorMessage("Error Occurred. Please try again later.");
      return response;
    }
  }
  
  @RequestMapping(value={"/getmanageranddeptdetail"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public JsonResponse getManagerAndDeptDetail() {
    LOG.info("Inside the Manager and Deaprtment Detail..");
    try {
      EmployeeDetail employeeDetail = employeeService.getManagerAndDeptDetail();
      return getJsonResponse(employeeDetail);
    }
    catch (EmployeeException employeeException)
    {
      LOG.error("Error occurred in ManagerAndDept Detail...", employeeException);
      JsonResponse response = new JsonResponse();
      response.setErrorMessage("Error Occurred. Please try again later.");
      return response;
    }
    catch (Exception exception) {
      LOG.error("Error occurred in ManagerAndDept Detail...", exception);
      JsonResponse response = new JsonResponse();
      response.setErrorMessage("Error Occurred. Please try again later.");
      return response;
    }
  }
  
  private JsonResponse getJsonResponse(EmployeeDetail employeeDetail) throws Exception { JsonResponse response = new JsonResponse();
    ObjectMapper objectMapper = new ObjectMapper();
    response.setJsonData(objectMapper.writeValueAsString(employeeDetail));
    return response;
  }
  
  private <T> JsonResponse getJsonResponse(ArrayList<T> list) throws Exception {
    JsonResponse response = new JsonResponse();
    ObjectMapper objectMapper = new ObjectMapper();
    response.setJsonData(objectMapper.writeValueAsString(list));
    return response;
  }
}