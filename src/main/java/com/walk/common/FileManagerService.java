package com.walk.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FileManagerService {

	// 이미지가 저장 될 경로 지정
	public static final String FILE_UPLOAD_PATH = "D:\\최윤정\\6_spring_project\\walk\\walk_workspace\\images/";

	public String uploadFile(MultipartFile file, String loginId) {
		// 폴더(디렉토리) 생성
		String directoryName = loginId + "_" + System.currentTimeMillis();
		String filePath = FILE_UPLOAD_PATH + directoryName + "/";
		
		// 폴더 생성
		File directory = new File(filePath);
		if (directory.mkdir() == false) {
			return null;
		}
		
		// 파일 업로드
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(filePath + file.getOriginalFilename());
			Files.write(path, bytes);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return "/images/" + directoryName + "/" + file.getOriginalFilename();
	}
}
