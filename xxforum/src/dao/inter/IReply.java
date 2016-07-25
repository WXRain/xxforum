package dao.inter;

import java.util.Vector;

import vo.*;

public interface IReply {
	public boolean addReply(Reply reply); //添加回复
	public boolean deletReply(int replyId); //删除回复
	public Vector<Reply> selectReplyByTopicId(int topicId); //查询帖子的回复
}
