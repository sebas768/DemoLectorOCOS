package com.pronaca.osoc.lecturaxml.util;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import org.hibernate.engine.jdbc.BlobProxy;

import com.pronaca.osoc.lecturaxml.model.dto.RespuestaSFTP;


public class FileXmlUtil {
	
    /**
     * Generates a BlobImpl proxy using byte data.
     * 
     * @param resp
     * @return
     * @throws Exception
     */
	public Blob fileToBlob(RespuestaSFTP resp) throws Exception {
		Blob fileBlob = BlobProxy.generateProxy(getBytesFromFile(resp)); //The data to be created as a Blob
		if (fileBlob != null) {
			return fileBlob;
		} return null;
		
	}
	
	/**
	 * 
	 * @param sizeFile
	 * @return
	 */
	public String convertSize(long sizeFile) {
		String size;
		double size_kb = sizeFile /1024;
		double size_mb = size_kb / 1024;
		double size_gb = size_mb / 1024 ;
 
		if (size_gb > 1){
			size = Math.round(size_gb*100.00)/100.00 + " GB"; 
        }else if(size_mb > 1){ 
        	size = Math.round(size_mb*100.00)/100.00 + " MB";
        }else{
        	size = Math.round(size_kb*100.00)/100.00 + " KB";
        }
		return size; 
	}
	
	/**
	 * 
	 * @param resp
	 * @return
	 * @throws IOException
	 */
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
