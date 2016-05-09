package com.taotao.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

public class TestFtp {
	@Test
	public void testFtp(){
		FTPClient ftp = new FTPClient();
		try {
			ftp.connect("115.159.65.146",21);
			boolean b = ftp.login("ftpuser", "ftpuser");
			System.out.println("login->"+b);
			//设置上传文件的类型为二进制类型
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			//设置远程路径
			ftp.changeWorkingDirectory("/home/ftpuser/www/images");
			File file = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\考拉.jpg");
			ftp.storeFile("test.jpg", new FileInputStream(file));
			ftp.logout();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
