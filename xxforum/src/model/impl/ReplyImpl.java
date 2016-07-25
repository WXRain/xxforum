package model.impl;

import java.util.Vector;

import dao.impl.ReplyDao;
import dao.impl.TopicDao;

import vo.Reply;
import model.inter.IReply;

public class ReplyImpl implements IReply{

	public String addReply(Reply reply) {
		// TODO Auto-generated method stub
		String result = null;
		if(new ReplyDao().addReply(reply)){
			result = "true";
			new TopicDao().updateTopicReplyCount(reply.getTopicId(), 1);
			new TopicDao().updateTopicLastReplyDate(reply.getTopicId(), System.currentTimeMillis());
		} else {
			result = "ReplyDao err";
		}
		return result;
	}

	public String deletReply(Reply reply) {
		// TODO Auto-generated method stub
		String result = null;
		if(new ReplyDao().deletReply(reply.getId())){
			result = "true";
			new TopicDao().updateTopicReplyCount(reply.getTopicId(), -1);
		} else {
			result = "ReplyDao err";
		}
		return result;
	}

	public Vector<Reply> selectReplyByTopicId(int topicId) {
		// TODO Auto-generated method stub
		return new ReplyDao().selectReplyByTopicId(topicId);
	}
	
	public static void main(String[] args) {
		Reply r = new Reply();
		r.setText("this is testTI");
		r.setUserId(2);
		r.setTopicId(1);
//		System.out.println(new ReplyImpl().addReply(r));
		r.setId(8);
		System.out.println(new ReplyImpl().deletReply(r));
	}
}
