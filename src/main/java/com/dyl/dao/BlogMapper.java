package com.dyl.dao;

import com.dyl.domain.Blog;

/**
 * 定义接口，实现mybatis的动态绑定
 * @author Administrator
 */
public interface BlogMapper {

	//方法名和mapper.xml中定义的id名保持一致
	Blog getBlogById(Integer id);
	
	Blog selectBlogWithAuthor(Integer id);
	
	Blog selectCollection(Integer id);
}
