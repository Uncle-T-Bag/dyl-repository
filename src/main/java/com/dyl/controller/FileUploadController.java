package com.dyl.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * SpringMVC文件上传与下载
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {

	private static final String FILE_UPLOAD_ROOT_NAME = "fileupload";
	private String fileRootPath = FILE_UPLOAD_ROOT_NAME;
	
	/*多文件上传*/
	@RequestMapping(value="/upload",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String uploadFile(@RequestParam("file") MultipartFile[] files,HttpServletRequest request,HttpSession session) throws IllegalStateException, IOException{
		ServletContext sc = session.getServletContext();
		//web项目根目录
		String rootPath = sc.getRealPath("/"+this.fileRootPath);
		//多文件处理器 
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(sc);  
        //检查请求中是否有multipart/from-data 
        if(multipartResolver.isMultipart(request)){ 
            if(files!=null&&files.length>0){
            	for (MultipartFile file : files) {
            		//计时
            		int pre = (int) System.currentTimeMillis();  
            		if(file != null){  
                        //文件名
                        String orglName = file.getOriginalFilename();  
                        //完成上传操作
                        if(orglName.trim() !=""){  
	                         System.out.println(orglName);    
	                         String path = rootPath +"/"+ orglName;  
	                         File localFile = new File(path);  
	                         file.transferTo(localFile);  
                        }
                        //结束时间
                        int finaltime = (int) System.currentTimeMillis();  
                        System.out.println(finaltime - pre); 
                    }  
				}
            } 
        } 
        return "文件上传成功";
	}
	
	/*文件下载*/
	@RequestMapping("/download")
	public ResponseEntity<byte[]> downloadFile(@RequestParam(value="fileName",required=true)String fileName,
			HttpSession session) throws IOException{
		//文件下载的思路是将文件读取到byte[]字节中
		byte[] body = null;
		ServletContext sc = session.getServletContext();
		InputStream in = sc.getResourceAsStream("/"+this.fileRootPath+"/"+fileName);
		body = new byte[(in.available())];
		in.read(body);
		
		//头信息
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename="+fileName);
		
		//状态码 HttpStatus.NOT_FOUND 就是著名的404
		HttpStatus status = HttpStatus.OK;
		ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, status);
		return entity;
	}
}
