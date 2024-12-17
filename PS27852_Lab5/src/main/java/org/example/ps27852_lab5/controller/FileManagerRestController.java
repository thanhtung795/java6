package org.example.ps27852_lab5.controller;

import jakarta.websocket.server.PathParam;
import org.example.ps27852_lab5.service.FileManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@CrossOrigin("*")
@RestController
public class FileManagerRestController {
	@Autowired
	FileManagerService fileService;

	@GetMapping("/rest/files/{folder}/{file}")
	public byte[] download(@PathVariable("folder") String folder, @PathVariable("file") String file) {
		return fileService.read(folder, file);
	}

	@PostMapping("/rest/files/{folder}")
	public List<String> upload(@PathVariable("folder") String folder, @PathParam("files") MultipartFile[] files) {
		return fileService.save(folder, files);
	}

	@DeleteMapping("/rest/files/{folder}/{file}")
	public void delete(@PathVariable("folder") String folder, @PathVariable("file") String file) {
		fileService.delete(folder, file);
	}

	@GetMapping("/rest/files/{folder}")
	public List<String> list(@PathVariable("folder") String folder) {
		return fileService.list(folder);
	}
}
