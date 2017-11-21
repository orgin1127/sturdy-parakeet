package Game.DAO;

import java.util.ArrayList;
import java.util.HashMap;

import Game.VO.Gamer;
import Game.VO.GamerStatus;

public interface GamerMapper {
	
	public int insertGamerInfo(Gamer gamer);
	
	public String IDCheckGamer(String id);
	
	public Gamer LoginGamerCheck(Gamer gamer);
	
	public int AddGamerInfo(String id);
	
	public int WinMoney(HashMap<String, Object> map);
	
	public int LoseMoney(HashMap<String, Object> map);
	
	public GamerStatus Total_Status(String id);
	
	public int Wins_Count(String id);
	
	public int Loses_Count(String id);


}
