package com.pronaca.osoc.lecturaxml.util;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import com.pronaca.osoc.lecturaxml.model.dto.RespuestaSFTP;


public class FileXmlUtil {
	
		
	public Blob fileToBlob(RespuestaSFTP resp) throws IOException {
		try {
			
			Blob fileBlob = null;
			if(false) {
				byte[] fileBytes = getBytesFromFile(resp);
				fileBlob.truncate(0);
				fileBlob.setBytes(1, fileBytes);
				System.out.println("OK BLOB");
			}
			return fileBlob;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String convertSize(long sizeFile) {
		String size;
		double size_kb = sizeFile /1024;
		double size_mb = size_kb / 1024;
		double size_gb = size_mb / 1024 ;
 
		if (size_gb > 0){
			size = size_gb + " GB";
        }else if(size_mb > 0){
        	size = size_mb + " MB";
        }else{
        	size = size_kb + " KB";
        }
		return size;
	}
	
	private byte[] getBytesFromFile(RespuestaSFTP resp) throws IOException {
	    FileInputStream fis = new FileInputStream(resp.getFileDownload());
	    byte[] bytes = new byte[(int) resp.getFileDownload().length()];
	    int read = 0;
	    int offset = 0;
	    while(offset < bytes.length && (read = fis.read(bytes, offset, bytes.length - offset)) >= 0 ){
	        offset += read;
	    }
	    fis.close();
	    return bytes;
	}
	
	
}
