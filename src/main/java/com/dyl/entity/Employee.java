package com.dyl.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Table(name="employee")
@Entity
public class Employee {

	private Integer id;
	private String rName;
	private String lName;
	private String email;
	
	private Date birthDay;
	private Date createTime;
	private Date updateTime;
	private Department department;
	
	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Temporal(TemporalType.DATE)
	//Date的转换
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	@JoinColumn(name="department_id")
	@ManyToOne(fetch=FetchType.LAZY)
	//@ManyToOne
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	public Employee(){}
	public Employee(String rName, String lName, String email,Date birthDay, Date createTime, Date updateTime,
			Department department) {
		this.rName = rName;
		this.lName = lName;
		this.email = email;
		this.birthDay = birthDay;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", rName=" + rName + ", lName=" + lName + ", email=" + email + ", birthDay="
				+ birthDay + ", createTime=" + createTime + ", updateTime=" + updateTime + ", department=" + department
				+ "]";
	}
	
}
