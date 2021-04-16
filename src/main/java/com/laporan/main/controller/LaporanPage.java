package com.laporan.main.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.laporan.main.entity.Laporan;
import com.laporan.main.service.ModelKejadian;
import com.laporan.main.service.ModelLaporan;
import com.laporan.main.utility.FileUtility;

@Controller
public class LaporanPage {
@Autowired
ModelLaporan modelLaporan;

@Autowired
ModelKejadian modelKejadian;

	@GetMapping("/laporan/view")
	public String viewIndexLaporan(Model model) {
	
	model.addAttribute("listLaporan",modelLaporan.getAllLaporan());
	model.addAttribute("active",2);
	model.addAttribute("test","Test Aja");
	
	return "view_laporan";
	}
	
	@GetMapping("/laporan/add")
	public String viewAddLaporan(Model model) {
		
		// buat penampung data laporan di halaman htmlnya
		model.addAttribute("laporan",new Laporan ());
		model.addAttribute("listKejadian", modelKejadian.getAllKejadian());
		model.addAttribute("active",3);
		
		return "add_laporan";
	}
	
	@PostMapping("/laporan/view")
	  public String addLaporan(@RequestParam(value = "file")MultipartFile file,@ModelAttribute Laporan laporan, Model model) throws IOException {
		  String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		  
	         
	        String uploadDir = "user-photos/" ;
	
	        FileUtility.saveFile(uploadDir, fileName, file);
	 
        laporan.setGambar("/"+uploadDir + fileName);
		
		this.modelLaporan.addLaporan(laporan);
		model.addAttribute("listLaporan",modelLaporan.getAllLaporan());
		
		
		return "redirect:/laporan/add";
	}



	@GetMapping("/laporan/hasil/")
	public String viewLaporan(@PathVariable String id, Model model) {
		List<Laporan> lstLaporan = new ArrayList<Laporan>();
		for (int x = 0 ; x < lstLaporan.size(); x++) {
		}
		return null;
		
	}
}
