package com.laporan.main.controller;

import java.io.IOException;

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

import com.laporan.main.entity.Kejadian;
import com.laporan.main.service.ModelKejadian;



@Controller
public class KejadianPage {
	
	@Autowired
	ModelKejadian modelKejadian;
	
	@GetMapping("/kejadian/view")
	public String viewIndexKejadian(Model model) {
	
	model.addAttribute("listKejadian",modelKejadian.getAllKejadian());
	model.addAttribute("active",4);
	model.addAttribute("test","Test Aja");
	
	return "view_kejadian";
	}
	
	@GetMapping("/kejadian/add")
	public String viewAddKejadian(Model model) {
		
		// buat penampung data kejadian di halaman htmlnya
		model.addAttribute("kejadian",new Kejadian ());
		
		return "add_kejadian";
	}
	
	@PostMapping("/kejadian/view")
	  public String addKejadian(@ModelAttribute Kejadian kejadian, Model model) throws IOException {
	
		
		this.modelKejadian.addKejadian(kejadian);
		model.addAttribute("listKejadian",modelKejadian.getAllKejadian());
		
		
		return "redirect:/kejadian/view";
	}
	
	@GetMapping("/kejadian/update/{id}")
	public String viewUpdateKejadian(@PathVariable String id, Model model) {
		
		Kejadian Kejadian = modelKejadian.getKejadianById(id);
		// buat penampung data Kejadian di halaman htmlnya
		model.addAttribute("kejadian",Kejadian);
		
		return "add_kejadian";
	}
	
	@GetMapping("/kejadian/delete/{id}")
	public String deleteKejadian(@PathVariable String id, Model model) {
		
		this.modelKejadian.deleteKejadian(id);
		model.addAttribute("listKejadian",modelKejadian.getAllKejadian());
		
		
		return "redirect:/kejadian/view";
	}

}
