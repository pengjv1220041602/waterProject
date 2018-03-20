package com.water.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.water.constant.Constant;

public class FileUtils {
	/**
	 * 上传图片
	 * @param multipartFile
	 * @return
	 * @throws Exception
	 */
	public static String uploadFile(HttpServletRequest request, MultipartFile multipartFile) throws Exception {
		//1.获取完整路径
		String fileStr = multipartFile.getOriginalFilename();
		//2.使用随机生成的字符串+源图片扩展名组成新的图片名称,防止图片重名
		String newfileName =  GetUUIDUtils.getUUID().toString() + fileStr.substring(fileStr.lastIndexOf("."));
		String resultFileName = Constant.PIC_SAVE + newfileName;
		String uploadPath = request.getServletContext().getRealPath(Constant.PIC_SAVE) +File.separator+ newfileName;
		//3. 将图片保存到硬盘
		multipartFile.transferTo(new File(uploadPath));
		//4.返回文件名称
		return resultFileName;
	}
	
	
}
