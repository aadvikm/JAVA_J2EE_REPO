package org.springpractice.domain;


public class Department
{
  private Long deptId;
  private String deptName;
  
  public Department() {}
  
  public Department(Long deptId, String deptName)
  {
    this.deptId = deptId;
    this.deptName = deptName;
  }
  
  public Long getDeptId() {
    return deptId;
  }
  
  public void setDeptId(Long deptId) {
    this.deptId = deptId;
  }
  
  public String getDeptName() {
    return deptName;
  }
  
  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }
  
  public String toString()
  {
    return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
  }
}