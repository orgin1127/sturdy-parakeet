package com.sesec.web2.Controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sesec.web2.vo.ProductVO;

@Controller
public class CartController {
	
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@RequestMapping(value="/goCart", method = RequestMethod.GET)
	public String goCart() {
		return "./JSP/cartPage";
	}
	
	//상품 담기
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(String name, int cnt, HttpSession session) {
		//상품 정보 생성하여 세션에 저장
		
		int num = 0;
		int price = 0;
		String cartList = "아메리카노";
		if (session.getAttribute("cartList") == null) {
			switch (name) {
				case "아메리카노":
					price = 4500;
					num = 1;
					break;
				case "카페라떼":
					price = 5500;
					num = 2;
					break;
				case "자바칩 프라푸치노":
					price = 6600;
					num = 3;
					break;
				case "콜드브루":
					price = 5300;
					num = 4;
					break;
				case "핸드드립":
					price = 7000;
					num = 5;
					break;
				default:
					break;
			}
			ProductVO vo = new ProductVO(num, name, price, cnt);
			ArrayList<ProductVO> list = new ArrayList<>();
			list.add(vo);
			session.setAttribute("cartList", list);
		}
		
		else {
			ArrayList<ProductVO> list = (ArrayList<ProductVO>) session.getAttribute("cartList");
			switch (name) {
			case "아메리카노":
				price = 4500;
				num = 1;
				break;
			case "카페라떼":
				price = 5500;
				num = 2;
				break;
			case "자바칩 프라푸치노":
				price = 6600;
				num = 3;
				break;
			case "콜드브루":
				price = 5300;
				num = 4;
				break;
			case "핸드드립":
				price = 7000;
				num = 5;
				break;
			default:
				break;
			}
			
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getName().equals(name)) {
					list.get(i).setCnt(list.get(i).getCnt()+cnt);
					return "./JSP/cartPage";
				}
			}
			
			ProductVO vo = new ProductVO(num, name, price, cnt);
			list.add(vo);
		
			session.setAttribute("cartList", list);
		}
		
		return "./JSP/cartPage";
	}
	
	//장바구니 보기
	@RequestMapping(value="/cart", method = RequestMethod.GET)
	public String cart() {
		//JSP로 포워딩하여 세션의 장바구니 정보 모두 출력
		return "./JSP/cartPage";
	}
}
