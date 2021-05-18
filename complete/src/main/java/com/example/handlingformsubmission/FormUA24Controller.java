package com.example.handlingformsubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormUA24Controller {


	@GetMapping("/formua24")
	public String UA24Form(Model model) {
		model.addAttribute("formua24", new FormUA24());
		return "formUA24";
	}

	@PostMapping("/formua24")
	public String greetingSubmit(@ModelAttribute FormUA24 formua24, Model model) {
		model.addAttribute("formua24", formua24);
		return "pdfresult";
	}
}
