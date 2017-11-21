package Game.DAO;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
//�ʵ��н��� �����س��� ������ �ȶ߰� �νĵ�

import Game.VO.Gamer;
import Game.VO.GamerStatus;

//DB���� �۾�
public class GamerDAO {	
	
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // ���̹�Ƽ�� ��ü
	
	public boolean insertGamer(Gamer gamer) {
		SqlSession session = null;
		
		int cnt = 0;
		
		try {
			session = factory.openSession(); //�̶� DB�� �����
			GamerMapper mapper = session.getMapper(GamerMapper.class);//**
			cnt = mapper.insertGamerInfo(gamer);
			session.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("DAOŬ���� ����");
		}
		finally {
			if (session != null) session.close(); //�ϳ��� Ʈ������� ����
		}
		if(cnt == 0) return false;
		else return true;
	}
	
	public Gamer LoginGamer(Gamer gamer) {
		
		SqlSession session = null;		
		Gamer login_gamer = null;
		
		try {
			session = factory.openSession(); //�̶� DB�� �����
			GamerMapper mapper = session.getMapper(GamerMapper.class);//**
			login_gamer = mapper.LoginGamerCheck(gamer);
			session.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("DAOŬ���� ����");
		}
		finally {
			if (session != null) session.close(); //�ϳ��� Ʈ������� ����
		}
		
		return login_gamer;
		
	}
	
	public boolean IDCheckGamer(String id) {
		
		SqlSession session = null;		
		String check = null;
		
		try {
			session = factory.openSession(); //�̶� DB�� �����
			GamerMapper mapper = session.getMapper(GamerMapper.class);//**
			check = mapper.IDCheckGamer(id);
			session.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("DAOŬ���� ����");
		}
		finally {
			if (session != null) session.close(); //�ϳ��� Ʈ������� ����
		}
		
		if(check == null) {
			return true;
		}
		else {
			return false;
		}		
	}
	
	public boolean AddGamerInfo(String id) {
		SqlSession session = null;		
		int cnt = 0;
		
		try {
			session = factory.openSession(); //�̶� DB�� �����
			GamerMapper mapper = session.getMapper(GamerMapper.class);//**
			cnt = mapper.AddGamerInfo(id);
			session.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("DAOŬ���� ����");
		}
		finally {
			if (session != null) session.close(); //�ϳ��� Ʈ������� ����
		}
		if(cnt == 0) return false;
		else return true;
	}
	
	public void win_money(String id, int money) {
		
		SqlSession session = null;
		HashMap<String, Object> map = new HashMap<>();
		int cnt = 0;
		
		try {
			session = factory.openSession(); //�̶� DB�� �����
			GamerMapper mapper = session.getMapper(GamerMapper.class);//**
			map.put("id", id);
			map.put("money", money);
			cnt = mapper.WinMoney(map);
			session.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("DAOŬ���� ����");
		}
		finally {
			if (session != null) session.close(); //�ϳ��� Ʈ������� ����
		}
	
	}
	
	public void lose_money(String id, int money) {
		
		SqlSession session = null;
		HashMap<String, Object> map = new HashMap<>();
		int cnt = 0;
		
		try {
			session = factory.openSession(); //�̶� DB�� �����
			GamerMapper mapper = session.getMapper(GamerMapper.class);//**
			map.put("id", id);
			map.put("money", money);
			cnt = mapper.LoseMoney(map);
			session.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("DAOŬ���� ����");
		}
		finally {
			if (session != null) session.close(); //�ϳ��� Ʈ������� ����
		}
		
	}
	
	public GamerStatus total_status(String id) {
		
		SqlSession session = null;
		GamerStatus status = null;
		
		try {
			session = factory.openSession(); //�̶� DB�� �����
			GamerMapper mapper = session.getMapper(GamerMapper.class);//**
			status = mapper.Total_Status(id);
			session.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("DAOŬ���� ����");
		}
		finally {
			if (session != null) session.close(); //�ϳ��� Ʈ������� ����
		}
		
		return status;
		
	}
	
	public void wins_count(String id) {
		
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = factory.openSession(); //�̶� DB�� �����
			GamerMapper mapper = session.getMapper(GamerMapper.class);//**
			cnt = mapper.Wins_Count(id);
			session.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("DAOŬ���� ����");
		}
		finally {
			if (session != null) session.close(); //�ϳ��� Ʈ������� ����
		}
		
	}
	
	public void loses_count(String id) {
		
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = factory.openSession(); //�̶� DB�� �����
			GamerMapper mapper = session.getMapper(GamerMapper.class);//**
			cnt = mapper.Loses_Count(id);
			session.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("DAOŬ���� ����");
		}
		finally {
			if (session != null) session.close(); //�ϳ��� Ʈ������� ����
		}
		
	}

}
