package com.laporan.main.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
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

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

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
	
	@GetMapping("/laporan/print")
	public String viewReportLaporan(Model model) {
		exportPDF();
		
		return "redirect:/laporan/view";
	}
	public void exportPDF() {
		try {
		File file = ResourceUtils.getFile("classpath:laporan.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		
		List<Laporan> lstlaporan = modelLaporan.getAllLaporan();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lstlaporan);
        
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy","Juaracoding");
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        String path = "D:\\laporan.pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint,path);
        
       
		
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
		
				
	}

}
