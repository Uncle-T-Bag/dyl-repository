package com.dyl.junit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.DeploymentQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 *  测试Activiti相关的API
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-mybatis.xml")
public class ActivitiTest {
	
	@Autowired private ProcessEngine processEngine;
	@Autowired private RepositoryService repositoryService;
	@Autowired private RuntimeService runtimeService;
	@Autowired private TaskService taskService;
	@Autowired private HistoryService historyService;
	@Autowired private FormService formService;
	@Autowired private IdentityService identityService;
	@Autowired private ManagementService managementService;
	
	//测试发布一个流程
	@Test
	public void testDeployement() {
		//获取部署对象
		DeploymentBuilder builder = repositoryService.createDeployment();
		//设置部署参数，如部署文件，部署细节等
		builder.name("我的测试部署1")
		       .addClasspathResource("bpmn/TestProcess.bpmn")
		       .addClasspathResource("bpmn/TestProcess.png");
		//部署
		builder.deploy();
	}
	
	//测试查找一个流程
	@Test
	public void testQuery() {
		//获取查询对象
		DeploymentQuery query = repositoryService.createDeploymentQuery();
		//添加过滤条件，类似于SQL中的条件
		query.processDefinitionKey("myProcess");
		//实行查询
		Deployment result = query.singleResult();
		System.out.println("id:"+result.getId()+";key:"+result.getKey()+";name:"+result.getName()+";time:"+result.getDeploymentTime());
	}
	
	//测试删除一个流程
	@Test
	public void testDelete() {
		//执行删除
		repositoryService.deleteDeployment("1");
		//执行级联删除，删除该部署文件下的所有相关信息
		//repositoryService.deleteDeployment("1", true);
	}
	
	//测试查询流程附件
	@Test
	public void testQueryAttachment() throws Exception{
		//由于附件表中有很多同名的情况，所以需要使用deploymentId进行约束
		List<String> names = repositoryService.getDeploymentResourceNames("2501");
		//查询出流程的图片，同理也可以查询bpmn流程xml文件
		String resourceName = null;
		for (String name : names) {
			if(name.indexOf(".png")>=0) {
				resourceName = name;
			}
		}
		if(resourceName !=null) {
			InputStream in = repositoryService.getResourceAsStream("2501", resourceName);
			//将流程图拷贝到文件目录
			IOUtils.copy(in, new FileOutputStream(new File("e:/activit.png")));
		}
	}
	
	//测试启动一个流程
	@Test
	public void testStartProcess() {
		//获取服务并启动，启动参数多样化
//		runtimeService.startProcessInstanceById(processDefinitionId);
		ProcessInstance instance = runtimeService.startProcessInstanceByKey("myProcess");
		System.out.println(instance);
	}
	//测试查询私有任务
	@Test
	public void testPersonalTask() {
		//获取查询对象
		TaskQuery query = taskService.createTaskQuery();
		//添加过滤条件
		query.processInstanceId("10001").taskAssignee("Dyl");
		//查询结果
		List<Task> list = query.list();
		if(list!=null) {
			System.out.println("id:"+list.get(0).getId()+";name:"+list.get(0).getName()+
					";assignee:"+list.get(0).getAssignee());
		}
	}
	//测试完成一个流程
	@Test
	public void testComplete() {
		taskService.complete("10005");
	}
	//测试查询流程状态
	@Test
	public void testProcessState() {
		//获取流程查询对象
		ProcessInstanceQuery query = runtimeService.createProcessInstanceQuery();
		//添加过滤条件并查询
		ProcessInstance result = query.processInstanceId("10001").singleResult();
		if(result!=null) {
			System.out.println(result.getActivityId());
		}else {
			System.out.println("流程已经结束....");
		}
	}
}
