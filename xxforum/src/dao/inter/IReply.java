package dao.inter;

import java.util.Vector;

import vo.*;

public interface IReply {
	public boolean addReply(Reply reply); //��ӻظ�
	public boolean deletReply(int replyId); //ɾ���ظ�
	public Vector<Reply> selectReplyByTopicId(int topicId); //��ѯ���ӵĻظ�
}
