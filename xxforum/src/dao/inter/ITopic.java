package dao.inter;

import java.util.Vector;

import vo.*;

public interface ITopic {
	public boolean addTopic(Topic topic); //�������
	public boolean deleteTopic(int topicId); //ͨ��idɾ������
	public boolean updateTopic(int topicId, int isTop, int isFine); //�޸����ӵ��ö��;���
	public boolean updateTopicLastReplyDate(int topicId, long lastReplyDate); //�޸����ظ�����
	public boolean updateTopicClickCount(int topicId); //�޸ĵ���� ����һ�ε������1
	public boolean updateTopicReplyCount(int topicId, int sign); //�޸Ļظ��� ����һ�λظ�����1
	public Vector<Topic> selectTopicByName(String Name); //ͨ���������ֲ�ѯ����
	public Vector<Topic> selectTopicBySection(int sectionId); //ͨ������ѯ����
	public Vector<Topic> selectTopicByUser(int userId); //��ѯ���û�����������
	public Topic selectTopicById(int id); //ͨ��id���ظ�����
}
