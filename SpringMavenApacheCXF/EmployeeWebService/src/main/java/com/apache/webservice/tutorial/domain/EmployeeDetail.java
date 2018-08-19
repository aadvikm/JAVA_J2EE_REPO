package com.apache.webservice.tutorial.domain;

import java.math.BigDecimal;
import java.util.ArrayList;




public class EmployeeDetail
{
  private Long empId;
  private String firstName;
  private String lastName;
  private Long managerId;
  private BigDecimal salary;
  private String hireDate;
  private Long deptId;
  private ArrayList<Manager> managerList;
  private ArrayList<Department> deptList;
  
  public EmployeeDetail() {}
  
  public EmployeeDetail(Long empId, String firstName, String lastName, Long managerId, BigDecimal salary, String hireDate, Long deptId, ArrayList<Manager> managerList, ArrayList<Department> deptList)
  {
    this.empId = empId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.managerId = managerId;
    this.salary = salary;
    this.hireDate = hireDate;
    this.deptId = deptId;
    this.managerList = managerList;
    this.deptList = deptList;
  }
  
  public EmployeeDetail(Long empId, String firstName)
  {
    this.empId = empId;
    this.firstName = firstName;
  }
  

  public Long getEmpId()
  {
    return empId;
  }
  
  public void setEmpId(Long empId) {
    this.empId = empId;
  }
  
  public String getFirstName() {
    return firstName;
  }
  
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  
  public String getLastName() {
    return lastName;
  }
  
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  public Long getManagerId() {
    return managerId;
  }
  
  public void setManagerId(Long managerId) {
    this.managerId = managerId;
  }
  
  public BigDecimal getSalary() {
    return salary;
  }
  
  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }
  
  public String getHireDate() {
    return hireDate;
  }
  
  public void setHireDate(String hireDate) {
    this.hireDate = hireDate;
  }
  
  public Long getDeptId() {
    return deptId;
  }
  
  public void setDeptId(Long deptId) {
    this.deptId = deptId;
  }
  
  public ArrayList<Manager> getManagerList() {
    return managerList;
  }
  
  public void setManagerList(ArrayList<Manager> managerList) {
    this.managerList = managerList;
  }
  
  public ArrayList<Department> getDeptList() {
    return deptList;
  }
  
  public void setDeptList(ArrayList<Department> deptList) {
    this.deptList = deptList;
  }
  
  public String toString()
  {
    return "EmployeeDetail [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", managerId=" + managerId + ", salary=" + salary + ", hireDate=" + hireDate + ", deptId=" + deptId + ", managerList=" + managerList + ", deptList=" + deptList + "]";
  }
}