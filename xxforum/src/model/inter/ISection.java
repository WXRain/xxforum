package model.inter;

import java.util.Vector;

import vo.Section;
import vo.User;

public interface ISection {
	public String addSection(User user, Section section);// ��Ӱ�� ����ɹ�����true�� ���ʧ�ܷ��ط���ԭ��
	public String updateSection(User user, int id, String name, String introduce); //�޸İ����Ϣ
	public Vector<Section> selectAll();//�г����а��
	public Section findSectionById(int id);
}
