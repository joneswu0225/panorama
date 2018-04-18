package com.jones.panorama.model;

public class Role
{
  private String roleId;
  private String roleName;
  private String roleTitle;
  private String projectCode;

  public String getRoleId()
  {
    return this.roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  public String getRoleName() {
    return this.roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public String getRoleTitle() {
    return this.roleTitle;
  }

  public void setRoleTitle(String roleTitle) {
    this.roleTitle = roleTitle;
  }

  public String getProjectCode() {
    return this.projectCode;
  }

  public void setProjectCode(String projectCode) {
    this.projectCode = projectCode;
  }
}

