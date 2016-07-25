package model.inter;

import java.util.Vector;

import vo.Reply;

public interface IReply {
	//toReplyId toUserId 同时为0 回复的就是回复帖子
	//toReplyId 不为0， toUserId 为0 回复的就是楼主
	//toReplyId toUserId 同时不为0 回复的就是该楼的User
	
	public String addReply(Reply reply); //添加回复 （回复量+1）
	public String deletReply(Reply reply); //删除回复 （回复量-1）
	public Vector<Reply> selectReplyByTopicId(int topicId); //查询帖子的回复
	
}
