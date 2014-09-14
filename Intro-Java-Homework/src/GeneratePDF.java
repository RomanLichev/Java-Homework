import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Element;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Font;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.Phrase;

public class GeneratePDF {

	public static void main(String[] args) {
		try{	
			Document doc = new Document();
			Rectangle page = new Rectangle(PageSize.A4.rotate());
			BaseFont base = BaseFont.createFont("Symbol", BaseFont.SYMBOL, BaseFont.EMBEDDED);
	        //We have to use two Font because Font:SYMBOL print suit and numbers without letters (J,Q,K,A).
			//And Font:COURIER print numbers and letters (J,Q,K,A)  without suit.
			//We have to use two font (SYMBOL, COURIER) once for the reds and once for the blacks cards.
			Font blackFontCardValue = new Font(Font.FontFamily.COURIER, 18,Font.BOLD, BaseColor.BLACK);
			Font blackFontCardSymbol = new Font(base, 25, 0, BaseColor.BLACK);
			Font redFontCardValue = new Font(Font.FontFamily.COURIER, 18,Font.BOLD, BaseColor.RED);
			Font redFontCardSymbol = new Font(base, 25, 0, BaseColor.RED);
			doc.setPageSize(page);
			PdfWriter.getInstance(doc, new FileOutputStream("cards"));	
			
			doc.open();
			//The table has 26 columns because the cards of the same color
			//are 13 and have 13 empty positions between them.
			PdfPTable table = new PdfPTable(26);
			PdfPCell cell = new PdfPCell();
			String cardValue = "2 3 4 5 6 7 8 9 10 J Q K A";
			String[] str = cardValue.split(" ");
			//The first cycle print four types of cards(clubs,diamond,hearts and spade), 
			//plus three blank lines between them (4 + 3 = 7).
			//
			//The second loop prints the value of the card and its color.
			for (int s = 0; s < 7; s++) {	
				for (int i = 0; i < str.length; i++) {
					table.setWidthPercentage(103);
					if (s == 0) {
						String clubs = "\u2663";
						Paragraph cardVal = new Paragraph(str[i],blackFontCardValue);
						Phrase symbol = new Phrase("\n" + clubs,blackFontCardSymbol);
						cardVal.add(symbol);
						cell =  new PdfPCell(cardVal);
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell.setFixedHeight(70f);
					}
					else if (s == 1 && i == 0) {
						cell =  new PdfPCell();
						cell.setBorder(Rectangle.NO_BORDER);
						cell.setFixedHeight(60f);
					}
					else if (s == 2) {
						String diamands = "\u2666";
						Paragraph cardVal = new Paragraph(str[i],redFontCardValue);
						Phrase symbol = new Phrase("\n" + diamands,redFontCardSymbol);
						cardVal.add(symbol);
						cell =  new PdfPCell(cardVal);
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell.setFixedHeight(70f);
					}
					else if (s == 3 && i == 0) {
						cell =  new PdfPCell();
						cell.setBorder(Rectangle.NO_BORDER);
						cell.setFixedHeight(60f);
					}
					else if (s == 4) {
						String hearts = "\u2665";
						Paragraph cardVal = new Paragraph(str[i],redFontCardValue);
						Phrase symbol = new Phrase("\n" + hearts,redFontCardSymbol);
						cardVal.add(symbol);
						cell =  new PdfPCell(cardVal);
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell.setFixedHeight(70f);
					}
					else if (s == 5 && i == 0) {
						cell =  new PdfPCell();
						cell.setBorder(Rectangle.NO_BORDER);
						cell.setFixedHeight(60f);
					}
					else if (s == 6) {
						String spade = "\u2660";
						Paragraph cardVal = new Paragraph(str[i],blackFontCardValue);
						Phrase symbol = new Phrase("\n" + spade,blackFontCardSymbol);
						cardVal.add(symbol);
						cell =  new PdfPCell(cardVal);
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell.setFixedHeight(70f);
					}
					table.addCell(cell);
					//Empty cell between cards of the same color.
					PdfPCell emptyCell = new PdfPCell();
					emptyCell.setBorder(Rectangle.NO_BORDER);
					table.addCell(emptyCell);
				}
			}
			doc.add(table);
			doc.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
