package com.dyl.junit;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dyl.dao.BlogMapper;
import com.dyl.domain.Blog;
import com.dyl.domain.GoodSaleStatus;
import com.dyl.domain.Goods;
import com.dyl.enums.SaleStatus;

/**
 * Mybatis测试程序
 * @author Administrator
 *
 */
public class MybatisTest {

	private final String resource = "mybatis/mybatis-config.xml";
	private SqlSessionFactory factory = null;
	private SqlSession session = null;
	
	@Before
	public void init() throws IOException{
		InputStream inputStream = Resources.getResourceAsStream(resource);
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@After
	public void destroy(){
		if(session!=null){
			session.close();
		}
	}
	//第一个Mybatis
	@Test
	public void testBuilderSessionFactoryFromXMLfile() throws IOException{
		SqlSession session = factory.openSession();
		try {
			/**
			 * statement: 查询语句的唯一标识id，最好使用namespace+sql的id组成
			 * parameter： 预编译注入的参数
			 */
			Goods goods=session.selectOne("com.dyl.domain.GoodsMapper.selectSingleGoods", 1);
			System.out.println(goods);
		} finally {
			//session是一个轻量级对象，每次调用都会被创建，所以需要正常关闭资源
			session.close();
		}
	}
	//测试insert语句
	@Test
	public void testInsertSQL(){
		SqlSession session = factory.openSession();
		Goods goods = new Goods();
		goods.setGoodName("mybatis-insert");
		goods.setGoodPrice(new BigDecimal(100));
		goods.setDescription("测试mybatis的insert语句");
		goods.setGoodNumber("100");
		goods.setMadeCountry("中国广东广州");
		goods.setCreateTime(new Date());
		goods.setUpdateTime(new Date());
		goods.setFlag(1);
		int i = session.insert("com.dyl.domain.GoodsMapper.createGoods", goods);
		session.commit();
		System.out.println(i);
	}
	//update语句,思路：可以先查询再做修改
	@Test
	public void testUpdateSQL(){
		session = factory.openSession();
		Goods goods = new Goods();
		goods.setGoodName("mybatis-update");
		goods.setGoodPrice(new BigDecimal(100));
		goods.setDescription("测试mybatis的insert语句");
		goods.setGoodNumber("100");
		goods.setMadeCountry("中国广东广州");
		goods.setCreateTime(new Date());
		goods.setUpdateTime(new Date());
		goods.setFlag(1);
		goods.setId(17);
		session.update("com.dyl.domain.GoodsMapper.updateGoods", goods);
		session.commit();
	}
	//delete语句
	@Test
	public void testDeleteSQL(){
		session = factory.openSession();
		session.delete("com.dyl.domain.GoodsMapper.deleteGoods", 17);
		session.commit();
	}
	//查询返回集合,思路:在mapper文件中定义resultmap，完成数据表到实体类的映射
	@Test
	public void testSelectListSQL(){
		session = factory.openSession();
		List<Goods> list=session.selectList("com.dyl.domain.GoodsMapper.selectGoodsList");
		System.out.println(list.size());
	}
	
	//测试往数据库插入枚举类型
	@Test
	public void testInsertEnumType() throws IOException{
		SqlSession session = factory.openSession();
		GoodSaleStatus saleStatus = null;
		try {
			saleStatus = new GoodSaleStatus();
			saleStatus.setGoodsId(1);
			saleStatus.setSaleStatus(SaleStatus.saling);
			session.insert("com.dyl.domain.GoodsSaleStatusMapper.insertSql", saleStatus);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	//测试关联查询
	@Test
	public void testAssociationQuery(){
		session = factory.openSession();
		Blog blog = session.selectOne("com.dyl.domain.BlogMapper.selectBlogWithAuthor", 1);
		System.out.println(blog);
	}
	//测试改进后的关联查询:结合日志系统打印出sql就可以看到效果
	@Test
	public void testAssociationQueryPlus(){
		session = factory.openSession();
		Blog blog = session.selectOne("com.dyl.domain.BlogMapper.selectBlogWithAuthorPlus", 1);
		System.out.println(blog);
	}
	//测试含有集合的嵌套属性查询
	@Test
	public void testQueryListOfProperty(){
		session = factory.openSession();
		Blog blog = session.selectOne("com.dyl.domain.BlogMapper.selectCollection", 1);
		System.out.println(blog);
	}
	//测试动态sql的查询,使用if
	@Test
	public void testDynamicSqlQuery(){
		session = factory.openSession();
		List<Blog> list = session.selectList("com.dyl.domain.AuthorMapper.dynamicSqlSelect","%China");
		System.out.println(list.size());
	}
	//测试动态sql查询，使用choose
	@Test
	public void testDynamicSqlQuery2(){
		session = factory.openSession();
		List<Blog> list = session.selectList("com.dyl.domain.AuthorMapper.chooseSQL","%@qq.com");
		System.out.println(list.size());
	}
	//测试动态sql查询，使用where
	@Test
	public void testDynamicWhereSql(){
		//List<Blog> list = whereSQL(null, null);
		//List<Blog> list = whereSQL("%China", null);
		//List<Blog> list = whereSQL(null, "%aaa");
		List<Blog> list = whereSQL("China", "aaa");
		System.out.println(list.size());
	}
	//测试动态sql更新，使用set
	@Test
	public void testDynamicUpdateUseSetTag(){
		updateAuthorUseSetTag(10,null,null,"famale","ChongQin,Sichuan","Hot pot delivery");
	}
	
	public List<Blog> whereSQL(String addr,String eml){
		session = factory.openSession();
		Map<String, Object> map = new HashMap<>();
		if(addr!=null && addr!="")map.put("addr", addr);
		if(eml!=null&&eml!="")map.put("eml", eml);
		if(map.size()>0)
			return session.selectList("com.dyl.domain.AuthorMapper.whereSQL", map);
			//return session.selectList("com.dyl.domain.AuthorMapper.trimSQL", map);
		return session.selectList("com.dyl.domain.AuthorMapper.whereSQL");
	}
	
	public void updateAuthorUseSetTag(Integer id,String name,String email,String gender,String address,String selfDesc){
		session = factory.openSession();
		Map<String , Object> map = new HashMap<>();
		map.put("id", id);
		if(name!=null&&name!="")map.put("name", name);
		if(email!=null&&email!="")map.put("email", email);
		if(gender!=null&&gender!="")map.put("gender", gender);
		if(address!=null&&address!="")map.put("address", address);
		if(selfDesc!=null&&selfDesc!="")map.put("selfDesc", selfDesc);
		session.update("com.dyl.domain.AuthorMapper.setSQL", map);
		session.commit();
	}
	
	//测试带foreach的in
	@Test
	public void testSelectAuthorUseForeacheTag(){
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		List<Blog> result = selectAuthorUseForeacheTag(list);
		System.out.println(result.size());
	}
	
	public List<Blog> selectAuthorUseForeacheTag(List<Integer> list){
		session = factory.openSession();
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		return session.selectList("com.dyl.domain.AuthorMapper.foreachSQL", map);
	}
	
	//测试mybatis的接口与xml动态绑定
	@Test 
	public void testDynamicInterfaceXMLBind(){
		session = factory.openSession();
		BlogMapper mapper = session.getMapper(BlogMapper.class);
		Blog blog = mapper.getBlogById(1);
		Blog blog2 = mapper.selectBlogWithAuthor(1);
		Blog blog3 = mapper.selectCollection(1);
		System.out.println(blog3);
	}
}
