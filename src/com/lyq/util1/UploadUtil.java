package com.lyq.util1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.struts2.ServletActionContext;
public class UploadUtil{

	public static String FILENAME = null;
	public static String SAVEPATH = null;
	public static String FILETYPE = null;
	public static String[] TYPECOLLECTION = { ".jpg", ".png", "gif", ".bmp" };
	public static boolean TYPESINGAL = false;

	public static boolean uploadFile(File file, String fileName, Date date)  throws Exception{

		FILENAME = String.valueOf((new SimpleDateFormat("yyyyMMddHHmmss")
				.format(date)));
		SAVEPATH = ServletActionContext.getRequest().getRealPath("/upload/ProImages");
		System.out.println(SAVEPATH);
		FILETYPE = fileName.substring(fileName.lastIndexOf("."));
		for (String var : TYPECOLLECTION) {
			if (FILETYPE.equals(var)) {
				TYPESINGAL = true;
				break;
			}
		}
		System.out.println("TYPESINGAL:"+TYPESINGAL);
		if (TYPESINGAL) {
			InputStream is = null;
			File destFile = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(file);
				destFile = new File(SAVEPATH, FILENAME + FILETYPE);
				os = new FileOutputStream(destFile);
				byte[] buffer = new byte[1024];
				int length = 0;
				while (-1 != (length = is.read(buffer))) {
					os.write(buffer, 0, length);
				}
				os.flush();
				is.close();
				os.close();
				return true;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

			}
		}
		return false;

	}
	/*
	 * 未验证
	 */
	public static void deleteFile(String fileName,String filePath) throws Exception{
		
		String oldPath=SAVEPATH+"\\"+FILENAME;
		File file=new File(oldPath);
		if (file.exists()) {
			System.out.println("file.exists");
			file.delete();
		}
	}
}
