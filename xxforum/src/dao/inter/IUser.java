package dao.inter;

import vo.*;

public interface IUser {
	public boolean addUser(User user); //����û�
	public boolean updateUser(String username, String attribute, String value); //ͨ���ṩ���û� ���� �����Ե�ֵ�޸�
	public User selectUser(String attribute, String value); //ͨ�����Ժ����Ե�ֵ��ѯ�û�
}
