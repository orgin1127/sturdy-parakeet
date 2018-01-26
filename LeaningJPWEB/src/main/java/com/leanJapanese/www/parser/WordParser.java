package com.leanJapanese.www.parser;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WordParser {
	
	public void parser() throws Exception {
		int[] lastPage = {73, 60,35,24,14};
		int[] levels = {1, 2, 3, 4, 5};
		String output = "";
		
		Workbook xlsWb = new HSSFWorkbook();
		//Workbook xlsxWb = new XSSFWorkbook();
		Sheet wordSheet = xlsWb.createSheet("wordSheet");
		Row row = null;
		Cell cell = null;
		
		try {
			File file = new File("D:/wordTest.xls");
			FileOutputStream fileOutput = new FileOutputStream(file);
			
			//단어
			int limit = 0;
			int limit2 = 0;
			int limit3 = 0;
			int limit4 = 0;
			int limit5 = 0;
			
			for (int i  = 0; i  < levels.length; i ++) {
				output += levels[i]+ "급";
				output += System.getProperty("line.separator");
				for (int y = 1; y <= lastPage[i]; y++) {
					
					//페이지 번호를 입력
					String url = "http://jpdic.naver.com/jlpt/level-" + levels[i] + "/parts-0/p" + y +".nhn"; 
					Document doc = Jsoup.connect(url).get();
					String selector = ".jp:eq(0)";
					Elements el = doc.select(selector);
					
					//한자만 추출
					for (Element e : el) {
						row = wordSheet.createRow(limit);
						cell = row.createCell(0);
						output += e.text();
						
						if (e.text().contains("[")) {
							cell.setCellValue(e.text().substring(e.text().indexOf('[')+1, e.text().indexOf(']')));
						}
						else {
							cell.setCellValue(e.text());
						}
						output += System.getProperty("line.separator");
						limit++;
					}
					
					output = "";
					
					//요미가나 추출
					selector = ".jp a[href]";
					el =  doc.select(selector);
					for (Element e : el) {
						row.setRowNum(limit2);
						cell = row.createCell(1);
						cell.setCellValue(e.text());
						output+=e.text();
						limit2++;
					}
					
					//뜻 추출
					selector = "span.bot_txt";
					el = doc.select(selector);
					for (Element e : el) {
						row.setRowNum(limit3);
						cell = row.createCell(2);
						cell.setCellValue(e.text());
						limit3++;
					}
					//링크 추출
					selector = ".jp a[href]";
					el = doc.select(selector);
					for (Element e : el) {
						output="";
						row.setRowNum(limit4);
						cell = row.createCell(3);
						output += e.attributes();
						output = output.split(" onclick")[0];
						cell.setCellValue(output);
						limit4++;
					}
					//단어 레벨링
					for (Element e : el) {
						row.setRowNum(limit5);
						cell = row.createCell(4);
						cell.setCellValue("N"+levels[i]);
						limit5++;
					}
				
				}
				output += System.getProperty("line.separator");
			}
			
			xlsWb.write(fileOutput);
			System.out.println("완료---------");
			System.out.println(output);
			fileOutput.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
