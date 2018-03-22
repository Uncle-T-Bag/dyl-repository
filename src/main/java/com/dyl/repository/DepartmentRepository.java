package com.dyl.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import com.dyl.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	/*使用@QueryHints注解来引入缓存产品org.hibernate.ejb.QueryHints.HINT_CACHEABLE*/
	@QueryHints({@QueryHint(name=org.hibernate.ejb.QueryHints.HINT_CACHEABLE,value="true")})
	@Query("FROM Department d")
	List<Department> getAll();
}
