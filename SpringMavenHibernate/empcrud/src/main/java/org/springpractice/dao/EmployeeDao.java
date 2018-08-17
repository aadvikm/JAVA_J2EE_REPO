package org.springpractice.dao;

import java.util.List;
import org.springpractice.domain.Department;
import org.springpractice.domain.EmployeeDetail;
import org.springpractice.domain.EmployeeEntity;
import org.springpractice.domain.Manager;

public abstract interface EmployeeDao
{
  public abstract EmployeeEntity getEmployeeEntity(Long paramLong)
    throws Exception;
  
  public abstract EmployeeEntity saveEmployeeEntity(EmployeeEntity paramEmployeeEntity)
    throws Exception;
  
  public abstract EmployeeEntity updateEmployeeEntity(EmployeeEntity paramEmployeeEntity)
    throws Exception;
  
  public abstract void deleteEmployeeEntity(EmployeeEntity paramEmployeeEntity)
    throws Exception;
  
  public abstract EmployeeDetail getEmpDetail(Long paramLong)
    throws Exception;
  
  public abstract List<Manager> getManagerList()
    throws Exception;
  
  public abstract List<Department> getDeptList()
    throws Exception;
  
  public abstract List<EmployeeDetail> getEmployees()
    throws Exception;
}