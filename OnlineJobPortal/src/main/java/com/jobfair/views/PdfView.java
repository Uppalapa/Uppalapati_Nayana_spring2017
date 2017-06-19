package com.jobfair.views;

import java.awt.Color;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.jobfair.beans.User;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class PdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {

		User user = (User) model.get("user");
		
		Font headerFont = new Font();
		headerFont.setColor(Color.BLUE);


		doc.add(new Paragraph("Employer Profile Details.", headerFont));

		PdfPTable table = new PdfPTable(2);
		table.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		table.addCell("User Name :");
		table.addCell(user.getUsername());

		table.addCell("Name :");
		table.addCell(user.getName());

		table.addCell("Email :");
		table.addCell(user.getEmail());

		table.addCell("Phone :");
		table.addCell(user.getPhone());

		table.addCell("Address :");
		table.addCell(user.getAddress());

		table.addCell("About Employer :");
		table.addCell(user.getMyself());

		table.addCell("Status :");
		table.addCell(user.getStatus());

		doc.add(table);

	}

}
