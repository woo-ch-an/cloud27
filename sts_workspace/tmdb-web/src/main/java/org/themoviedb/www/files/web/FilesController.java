package org.themoviedb.www.files.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.themoviedb.www.files.service.FilesService;
import org.themoviedb.www.files.vo.response.DownloadVO;

@Controller
public class FilesController {

	@Autowired
	private FilesService filesService;

	private Map<String, String> mimeTypeMap;
	
	public FilesController() {
		this.mimeTypeMap = new HashMap<>();
		this.mimeTypeMap.put("txt", "text/plain");
		
		this.mimeTypeMap.put("png", "image/png");
		this.mimeTypeMap.put("jpg", "image/jpg");
		this.mimeTypeMap.put("jpeg", "image/jpeg");
		this.mimeTypeMap.put("webp", "image/webp");
		this.mimeTypeMap.put("gif", "image/gif");
		this.mimeTypeMap.put("svg", "image/svg");

		this.mimeTypeMap.put("csv", "text/csv");
		this.mimeTypeMap.put("xls", "application/vnd.ms-excel");
		this.mimeTypeMap.put("xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		this.mimeTypeMap.put("ppt", "application/vnd.ms-powerpoint");
		this.mimeTypeMap.put("pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation");
		

		this.mimeTypeMap.put("zip", "application/zip");
		this.mimeTypeMap.put("pdf", "application/pdf");
		
	}
	
	@GetMapping("/file/{fileGroupId}")
	public ResponseEntity<Resource> doDownloadAction(@PathVariable String fileGroupId){
		DownloadVO downloadVO = this.filesService.findAttachFile(fileGroupId);
		

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + downloadVO.getDisplayName());
		headers.set(HttpHeaders.CONTENT_LENGTH, downloadVO.getFileLength()+"");
		headers.set(HttpHeaders.CONTENT_TYPE, this.mimeTypeMap.getOrDefault(downloadVO.getExtendName().toLowerCase(), "application/octet-stream"));
		
		
		return ResponseEntity.ok().headers(headers).body(downloadVO.getResource());
	}
}
