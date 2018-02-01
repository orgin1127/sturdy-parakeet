package com.paser.word.PaserController;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PaserController  {
	Logger logger = LoggerFactory.getLogger(PaserController.class);
	
	@RequestMapping(value="startPaser", method = RequestMethod.GET)
	public String startPaser(Model model) throws Exception {
		
		int[] lastPage = {73, 60,35,24,14};
		int[] levels = {1, 2, 3, 4, 5};
		String output = "";
		
//		for (int i  = 0; i  < levels.length; i ++) {
//			output += levels[i]+ "급";
//			output += System.getProperty("line.separator");
//			for (int y = 1; y <= lastPage[i]; y++) {
//				//페이지 번호를 입력
//				String url = "http://jpdic.naver.com/jlpt/level-" + levels[i] + "/parts-0/p" + y +".nhn"; 
//				Document doc = Jsoup.connect(url).get();
//				String selector = "span.jp";
//				String selector2 = "span.bot_txt";
//				String selector3 = "a";
//				Elements el = doc.select(selector);
//				Elements el2 = doc.select(selector2);
//				
//				for (Element e : el) {
//					output += e.text();
//					output += System.getProperty("line.separator");
//				}
//				for (Element e2 : el2) {
//					output += e2.text();
//					output += System.getProperty("line.separator");
//				}
//			}
//			output += System.getProperty("line.separator");
//		}
		
		model.addAttribute("result", output);
		return "./JSP/pasingResult";
	}
}
