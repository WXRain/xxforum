package model.inter;

import vo.User;

public interface IUser {

	public String login(String username, String password);//�û���¼ ����ɹ�����true�� ���ʧ�ܷ��ط���ԭ��
	public String register(User user);//�û�ע�� 
	public String changePassword(String username, String password, String oldPassword);//�û��޸����� 
	public User findUserByAttribute(String attribute, String value); //ͨ��username����User����
}
