package com.sesoc.ajax.AjaxController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sesoc.ajax.VO.Person;

@Controller
public class AjaxController {
	
	Logger logger = LoggerFactory.getLogger(AjaxController.class);
	
	//뷰 페이지로 이동
	@RequestMapping(value="Ajax1", method = RequestMethod.GET)
	public String AjaxController1 () {
		return "./Ajax/Ajax1";
	}
	
	//Ajax 요청 받음
	@ResponseBody //ajax 요청 받을 곳에 써야할 annotation
	@RequestMapping(value="ajaxtest1", method = RequestMethod.GET)
	public void ajaxtest1() {
		logger.debug("서버 왔다감");
	}
	
	@ResponseBody
	@RequestMapping(value="ajaxtest2", method = RequestMethod.POST)
	public String ajaxtest2(String str){
		logger.debug("서버에서 ajaxtest2 왔다 감");
		str += ", 가나다라마바사, hijklmnop";
		
		return str;
	}
	
	@ResponseBody
	@RequestMapping(value="ajaxtest3", method = RequestMethod.GET)
	public int ajaxtest3(int input){
		logger.debug("서버에서 ajaxtest3 왔다 감");
		int result = 0;
		for (int i = 1; i <= input; i++) {
			result += i;
		}
		return result;
	}
	
	@RequestMapping(value="Ajax2", method = RequestMethod.GET)
	public String AjaxController2 () {
		return "./Ajax/Ajax2";
	}
	
	@ResponseBody
	@RequestMapping(value="insert1", method = RequestMethod.POST)
	public void ajaxinsert1(String name, String age, String phone){
		logger.debug("이름 : " + name + "나이 : " + age + "전화번호 : " + phone);
		
	}
	@ResponseBody
	@RequestMapping(value="insert2", method = RequestMethod.POST)
	public void ajaxinsert2(Person p){
		logger.debug(p.toString());
		
	}
	@ResponseBody
	@RequestMapping(value="insert3", method = RequestMethod.POST)
	public void ajaxinsert3(Person p){
		logger.debug(p.toString());
		
	}
	
	@ResponseBody
	@RequestMapping(value="output1", method = RequestMethod.GET)
	public Person ajaxoutput1(){
		Person p = new Person("홍길동", "40", "010-1111-1111");
		return p;
	}
	@ResponseBody
	@RequestMapping(value="output2", method = RequestMethod.GET)
	public Person ajaxoutput2(){
		Person p = new Person("홍길동", "40", "010-1111-1111");
		return p;
	}
}
