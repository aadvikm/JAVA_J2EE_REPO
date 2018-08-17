package org.springpractice.service;

import java.util.ArrayList;
import org.springpractice.domain.Department;
import org.springpractice.domain.EmployeeDetail;
import org.springpractice.domain.EmployeeEntity;
import org.springpractice.domain.Manager;
import org.springpractice.exception.EmployeeException;

public abstract interface EmployeeService
{
  public abstract EmployeeEntity saveEmp(EmployeeDetail paramEmployeeDetail)
    throws EmployeeException;
  
  public abstract EmployeeEntity updateEmp(EmployeeDetail paramEmployeeDetail)
    throws EmployeeException;
  
  public abstract void deleteEmp(Long paramLong)
    throws EmployeeException;
  
  public abstract EmployeeDetail getEmployeeDetail(Long paramLong)
    throws EmployeeException;
  
  public abstract ArrayList<EmployeeDetail> getEmployees()
    throws EmployeeException;
  
  public abstract ArrayList<Manager> getManagerList()
    throws EmployeeException;
  
  public abstract ArrayList<Department> getDeptList()
    throws EmployeeException;
  
  public abstract EmployeeDetail getManagerAndDeptDetail()
    throws EmployeeException;
}