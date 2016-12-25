package com.photoknow.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.photoknow.entity.Illustration;
import com.photoknow.service.IllustrationService;
import com.photoknow.util.ImgThumbnail;
import com.photoknow.util.JsonUtil;

@Controller("illustrationAction")
@Scope("prototype")
public class IllustrationAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, SessionAware{
	
	@Resource
	private IllustrationService illustrationService;
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Map<String, Object> session;
	
	private File imageFile;
	private String fileName;
	
	public void search(){
		JSONObject jsonObject = new JSONObject();
		try {
			String searchCriteria = request.getParameter("searchCriteria");
			List<Illustration> illustrationList = illustrationService.getIllustrationList(searchCriteria);			
			jsonObject.put("dataList", illustrationList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonObject.put("errM", "获取数据失败");
		}
		
		JsonUtil.printJsonObject(response, request.getParameter("jsoncallback"), jsonObject);
	}
	
	public void upload(){
		try{
			UUID uuid = UUID.randomUUID();
			Illustration photo = new Illustration();
			photo.setId(uuid.toString());
			photo.setName(request.getParameter("name"));
			photo.setDescription(request.getParameter("description"));
			photo.setArtworkpath("/photo/"+uuid.toString()+"_artwork.jpg");
			photo.setThumbnailpath("/photo/"+uuid.toString()+"_thumbnail.jpg");
			photo.setCreateAt(new Date());
			photo.setCreateBy("admin");
			illustrationService.update(photo);
			
			uploadImg(uuid.toString());
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	public void uploadImg(String imageName){
		File file = imageFile;
		String savePath = ServletActionContext.getServletContext().getRealPath("")+"/photo/"; 
		
		String artworkFilePath = savePath + imageName +"_artwork.jpg";
		artworkFilePath = artworkFilePath.replace("\\", "/");
		
		String thumbnailFilePath = savePath + imageName +"_thumbnail.jpg";
		thumbnailFilePath = thumbnailFilePath.replace("\\", "/");
		try {
			FileUtils.copyFile(file, new File(artworkFilePath));
			ImgThumbnail.thumbnailHandler(file, thumbnailFilePath, 80, 80, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void detailImg(){
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	public File getImageFile() {
		return imageFile;
	}

	public void setImageFile(File imageFile) {
		this.imageFile = imageFile;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
