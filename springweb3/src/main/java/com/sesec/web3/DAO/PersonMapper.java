package com.sesec.web3.DAO;

import java.util.ArrayList;

import com.sesec.web3.vo.Person;

public interface PersonMapper {
	
	//회원정보 저장
	public int insertPerson(Person p);
	
	//회원정보 전체출력
	public ArrayList<Person> showPersonList();
	
	//회원 검색
	public ArrayList<Person> searchPerson(String name);
	
	//회원 삭제
	public int deletePerson(String name);
}
