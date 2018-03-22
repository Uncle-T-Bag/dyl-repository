package com.dyl.junit;

import java.net.URLClassLoader;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.eclipse.jdt.internal.compiler.batch.Main;
import org.hibernate.ejb.QueryHints;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dyl.entity.Department;
import com.dyl.entity.Employee;
import com.dyl.repository.DepartmentRepository;
import com.dyl.repository.EmployeeRepository;
import com.dyl.services.EmployeeService;

public class JunitTest {

	private ApplicationContext act = null;
	private DepartmentRepository dr = null;
	private EntityManagerFactory emf = null;
	private EmployeeRepository er = null;
	private EmployeeService es = null;
	{
		act = new ClassPathXmlApplicationContext("spring-data-jpa.xml");
		dr = act.getBean(DepartmentRepository.class);
		emf = act.getBean(EntityManagerFactory.class);
		er =act.getBean(EmployeeRepository.class);
		es = act.getBean(EmployeeService.class);
	}
	
	@Test
	public void testUpdOrDelMethod(){
		//er.updOrDelMethdo("dyl-springdata", 3);
		es.updOrDel("dyl-springdata", 3);
	}
	
	@Test
	public void testNativeQuery(){
		long totalCount = er.totalCount();
		System.out.println(totalCount);
	}
	
	@Test
	public void testuserNameBindingParam2(){
		List<Employee> e = er.userNameBindingParam2("aaa", "245252333@qq.com");
		System.out.println(e.size());
	}
	
	@Test
	public void testBindingParam2(){
		List<Employee> e = er.userPlaceHolederBindingParam2("aaa", "245252333@qq.com");
		System.out.println(e.size());
	}
	
	@Test
	public void testuserNameBindingParam(){
		List<Employee> e = er.userNameBindingParam("aaa", "245252333@qq.com");
		System.out.println(e.size());
	}
	
	@Test
	public void testBindingParam(){
		Employee e = er.userPlaceHolederBindingParam("aaa", "245252333@qq.com");
		System.out.println(e);
	}
	
	@Test
	public void testQueryAnnotation(){
		Integer id = er.getMaxId();
		System.out.println(id);
	}
	
	@Test
	public void testEntitymanagerSecondLevelCache(){
		/**
		 * 使用query.setHint(QueryHints.HINT_CACHEABLE, true)来设置JPA的二级缓存
		 */
		String jpql = "From Department";
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery(jpql);
		List<Department> list = query.setHint(QueryHints.HINT_CACHEABLE, true).getResultList();
		em.close();
		
		em = emf.createEntityManager();
		query = em.createQuery(jpql);
		list = query.setHint(QueryHints.HINT_CACHEABLE, true).getResultList();
		em.close();
	}
	
	@Test
	public void testDataSource() throws SQLException{
		DataSource dataSource = act.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}
	
	@Test
	public void testSecondLevelCache(){
		/*List<Department> list = dr.findAll();
		list = dr.findAll();//结果打印了两条sql，证明此时并没有使用到jpa的二级缓存
		*/
		List<Department> list = dr.getAll();
		list=dr.getAll();
	}
	
	@Test
	public void testMethod(){
		String lName="ali";
		Employee employee = er.getByLName(lName);
		if(employee!=null) System.out.println(employee.getlName());
	}
}
