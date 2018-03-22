package com.dyl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dyl.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee getByLName(String lName);
	
	/*@Query支持JPA的jpql查询*/
	@Query("SELECT e.id FROM Employee e where e.id = (SELECT max(id) from Employee)")
	Integer getMaxId();
	/*springdata占位符参数注入*/
	@Query("SELECT e FROM Employee e where lName = ?1 and email = ?2")
	Employee userPlaceHolederBindingParam(String lName,String email);
	/*springdata命名参数注入*/
	@Query("SELECT e FROM Employee e where lName = :lName or email = :email")
	List<Employee> userNameBindingParam(@Param("lName")String lName,@Param("email")String email);
	/*springdata模糊查询*/
	@Query("SELECT e FROM Employee e where lName LIKE %?1% and email LIKE %?2%")
	List<Employee> userPlaceHolederBindingParam2(String lName,String email);
	@Query("SELECT e FROM Employee e where lName LIKE %:lName% or email LIKE %:email%")
	List<Employee> userNameBindingParam2(@Param("lName")String lName,@Param("email")String email);
	/*nativeQuery=true支持原生sql查询*/
	@Query(value="SELECT count(id) FROM employee",nativeQuery=true)
	long totalCount();
	/*@Modifying标识该方法是一个UPDATE或者DELETE操作*/
	@Modifying
	@Query("UPDATE Employee e SET lName = :lName WHERE id = :id")
	void updOrDelMethdo(@Param("lName")String lName,@Param("id")Integer id);
}
