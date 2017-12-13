package board.dao;

import java.util.ArrayList;
import java.util.HashMap;

import board.vo.Board;
import board.vo.Reply;

public interface BoardMapper {
	//�� ����
	public int insertBoard(Board board);
	//�� ��� ��ü���
	public ArrayList<Board> showBoard();
	//�� �б�
	public Board readBoard(int i);
	//�� �б� �۵��� ��ȸ�� ������Ʈ
	public int updateHit(int i);
	//�� ����
	public int deleteBoard(int i);
	//�˻�(����SQL ���)
	public ArrayList<Board> search(HashMap<String, Object> map);
	//���� ���
	public ArrayList<Reply> findReply(int number);
	//���� �ۼ�
	public int writeReply(Reply reply);
	
	//���� sql ��� ��
//	//�� �˻� (�۹�ȣ)
//	public ArrayList<Board> findBoardNum(int number);
//	//�� �˻� (����)
//	public ArrayList<Board> findBoardTitle(String title);
//	//�� �˻� (�� ����)
//	public ArrayList<Board> findBoardContent(String content);
//	//�� �˻� (�� �ۼ���)
//	public ArrayList<Board> findBoardWriter(String writer);
}
