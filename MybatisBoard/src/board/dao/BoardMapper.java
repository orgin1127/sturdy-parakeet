package board.dao;

import java.util.ArrayList;

import board.vo.Board;

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
	//�� �˻� (�۹�ȣ)
	public ArrayList<Board> findBoardNum();
	//�� �˻� (����)
	public ArrayList<Board> findBoardTitle(String title);
}
