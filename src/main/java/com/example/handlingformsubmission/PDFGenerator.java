package com.example.handlingformsubmission;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
public class PDFGenerator {
	
	public static void generatePDFFromHTML(String filename) {
	    Document document = new Document();
	    PdfWriter writer = null;
		try {
			writer = PdfWriter.getInstance(document,
			  new FileOutputStream("src/main/resources/FilledUPFormUA24.pdf"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    document.open();
	    try {
			XMLWorkerHelper.getInstance().parseXHtml(writer, document,
			  new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    document.close();
	}
	
}
