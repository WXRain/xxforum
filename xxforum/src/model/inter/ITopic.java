package model.inter;

import java.util.Vector;

import vo.Topic;
import vo.User;

public interface ITopic {
	public String addTopic(User user, Topic topic); //���� �����������+1��
	public String updateTopic(User user, Topic topic, int isTop, int isFine);//�޸������ö��;��� ���ֵ��-1���޸�
	public String deleteTopic(User user, Topic topic);//ɾ������ �����������-1��
	public Vector<Topic> selectTopicByName(String name); //ͨ���������ֲ�ѯ����
	public Vector<Topic> selectTopicBySection(int sectionId); //ͨ������ѯ���� (��������)
	public Vector<Topic> selectTopicByUser(int userId); //��ѯ���û�����������
	public Topic selectTopicByTopicId(int topicId); //ͨ��id����Topic����
}
