package test.jsp3.dao;

import java.util.ArrayList;

import test.jsp3.vo.Person;

/**
 * Mapper XML의 SQL문 사용 메서드
 */
public interface PersonMapper {
	//Person객체 저장
	public int insertPerson(Person p);
	//Person객체 목록 읽기
	public ArrayList<Person> selectPerson();
	
}
