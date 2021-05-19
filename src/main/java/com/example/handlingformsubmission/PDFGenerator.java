package com.example.handlingformsubmission;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
public class PDFGenerator {
	
	public static void generateHTMLFromUserData(FormUA24 formua24) {
		File htmlTemplateFile = new File("src/main/resources/formUA24.html");
		String htmlString = "";
		try {
			htmlString = FileUtils.readFileToString(htmlTemplateFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		htmlString = htmlString.replace("$namesOfTheApplicant", formua24.getNamesOfTheApplicant()!= null ? formua24.getNamesOfTheApplicant() : "");
		htmlString = htmlString.replace("$address", formua24.getAddress()!= null ? formua24.getAddress() : "");
		htmlString = htmlString.replace("$emailId", formua24.getEmailId()!= null ? formua24.getEmailId() : "");
		htmlString = htmlString.replace("$phoneNo", formua24.getPhoneNo()!= null ? formua24.getPhoneNo() : "");
		htmlString = htmlString.replace("$nameOfAuthorityForPendingCase", formua24.getNameOfAuthorityForPendingCase()!= null ? formua24.getNameOfAuthorityForPendingCase() : "");
		htmlString = htmlString.replace("$contraventionOfSections", formua24.getContraventionOfSections()!= null ? formua24.getContraventionOfSections() : "");
		htmlString = htmlString.replace("$briefFactsOfTheCase", formua24.getBriefFactsOfTheCase()!= null ? formua24.getBriefFactsOfTheCase() : "");
		htmlString = htmlString.replace("$anyOtherInfoRelevantToCase", formua24.getAnyOtherInfoRelevantToCase()!= null ? formua24.getAnyOtherInfoRelevantToCase() : "");
		htmlString = htmlString.replace("$prayerOfTheApplicant", formua24.getPrayerOfTheApplicant()!= null ? formua24.getPrayerOfTheApplicant() : "");
		htmlString = htmlString.replace("$feeAndTransactionDetails", formua24.getFeeAndTransactionDetails()!= null ? formua24.getFeeAndTransactionDetails() : "");
		htmlString = htmlString.replace("$attachmentIfAny", formua24.getAttachmentIfAny()!= null ? formua24.getAttachmentIfAny() : "");
		
		
		
		File newHtmlFile = new File("src/main/resources/formUA24_new.html");
		try {
			FileUtils.writeStringToFile(newHtmlFile, htmlString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
