package dao.inter;

import java.util.Vector;

import vo.*;

public interface ISection {
	public boolean addSection(Section section); //��Ӱ��
	public boolean updateSection(int id, String attribute, String value); //ͨ����� ���� �� ���Ե�ֵ�޸�
	public boolean updateSectionTopicCount(int id, int sign); //����һ�ΰ�������������1 sign Ϊ1 ��һ Ϊ-1 ��һ
	public Vector<Section> selectAll(); //�г����ð��
	public Section selectById(int id);
}
