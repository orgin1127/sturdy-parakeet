package com.sesec.web3.DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sesec.web3.vo.Person;

@Repository
public class PersonDAO { //PersonDAO personDAO = new PersonDAO(); 와 같다. @Repository어노테이션은 맨 앞을 소문자화 해서
						//객체를 만들어 준비해놓는다
	
	@Autowired
	SqlSession sqlSession;
	
	public void insertPerson(Person p) {
		PersonMapper pm = sqlSession.getMapper(PersonMapper.class);
		pm.insertPerson(p);
	}
	
	public ArrayList<Person> showPersonList() {
		PersonMapper pm = sqlSession.getMapper(PersonMapper.class);
		ArrayList<Person> plist = null;
		plist = pm.showPersonList();
		return plist;
	}
	
	public ArrayList<Person> searchPerson(String name) {
		PersonMapper pm = sqlSession.getMapper(PersonMapper.class);
		ArrayList<Person> searchList = null;
		searchList = pm.searchPerson(name);
		return searchList;
	}
	
	public void deletePerson(String name) {
		PersonMapper pm = sqlSession.getMapper(PersonMapper.class);
		pm.deletePerson(name);
	}
}
