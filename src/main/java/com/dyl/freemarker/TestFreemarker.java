package com.dyl.freemarker;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 测试freemarker程序
 */
public class TestFreemarker {
	
	public static void main(String[] args)throws Exception {
		//创建freemarker配置实例
		Configuration cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
		//创建数据模型
		Map<String, Object> root = new HashMap<>();
		root.put("user", "小邓");
		root.put("num0", 13);
		root.put("html", "<b>粗体<b>");
		root.put("str", "adsaccassdsa");
		root.put("aaa", "AAA");
		root.put("null", "bbb");
		//加载模板
		Template t1 = cfg.getTemplate("a.ftl");
		Writer out = new OutputStreamWriter(System.out);
		t1.process(root, out);
		out.flush();
	}
}
