package com.example.demo.utils;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件操作的工具类
 * @author zhuying
 *
 */
public class FileUtil {
	/**
	 * 根据日期产生一个随机数
	 * @return
	 */
	public static String createRandomFileName(){
		String format = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		return format;
	}
	/**
	 * 将文件写入磁盘
	 * @throws IOException 
	 */
	public static void writeFileToDisc(String fileUrl, MultipartFile file) throws IOException{
		FileOutputStream fos = new FileOutputStream(new File(fileUrl));
		fos.write(file.getBytes());
		fos.flush();
		fos.close();
	}
	
	public static void main(String[] args) {
		System.out.println(FileUtil.createRandomFileName());
	}
	
	/**
	 * 根据path得到图片的base64编码的字符串
	 * @param userFacePath 图片路径
	 * @return base64编码之后的字符串
	 */
	public static String getImageStr(String userFacePath){
		FileInputStream fis = null;
		byte[] buf;
		try {
			fis = new FileInputStream(new File(userFacePath));
			buf = new byte[fis.available()];
			fis.read(buf);
			return Base64.encodeBase64String(buf);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static String convertFileToBase64(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		byte[] buf = new byte[fis.available()];
		fis.read(buf);
		return Base64.encodeBase64String(buf);
	}

	public static File convertFile(MultipartFile file) throws IOException {
		Object empty = "";
		File toFile = null;
		if (file.equals(empty) || file.getSize() <= 0) {
			file = null;
		} else {
			InputStream ins = null;
			ins = file.getInputStream();
			toFile = new File(file.getOriginalFilename());
			inputStreamToFile(ins, toFile);
			ins.close();
		}
		return toFile;
	}

	private static void inputStreamToFile(InputStream ins, File file) {
		try {
			OutputStream os = new FileOutputStream(file);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			os.close();
			ins.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
