package com.example.handlingformsubmission;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@Controller
public class FormUA24Controller {


	@GetMapping("formua24")
	public String UA24Form(Model model) {
		model.addAttribute("formua24", new FormUA24());
		return "formUA24";
	}

	@PostMapping("formua24")
	public String greetingSubmit(@ModelAttribute FormUA24 formua24, Model model) {
		model.addAttribute("formua24", formua24);
		PDFGenerator.generateHTMLFromUserData(formua24);
		PDFGenerator.generatePDFFromHTML("src/main/resources/formUA24_new.html");
		return "pdfresult";
	}
	
	@GetMapping("/downloadpdf")
	public StreamingResponseBody downloadPDF(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"FormUA24.pdf\"");
        InputStream inputStream = new FileInputStream(new File("src/main/resources/FilledUPFormUA24.pdf"));
        return outputStream -> {
            int nRead;
            byte[] data = new byte[1024];
            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
                System.out.println("Writing some bytes..");
                outputStream.write(data, 0, nRead);
            }
        };
    }
		
}
