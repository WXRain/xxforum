package model.inter;

import java.util.Vector;

import vo.Reply;

public interface IReply {
	//toReplyId toUserId ͬʱΪ0 �ظ��ľ��ǻظ�����
	//toReplyId ��Ϊ0�� toUserId Ϊ0 �ظ��ľ���¥��
	//toReplyId toUserId ͬʱ��Ϊ0 �ظ��ľ��Ǹ�¥��User
	
	public String addReply(Reply reply); //��ӻظ� ���ظ���+1��
	public String deletReply(Reply reply); //ɾ���ظ� ���ظ���-1��
	public Vector<Reply> selectReplyByTopicId(int topicId); //��ѯ���ӵĻظ�
	
}
