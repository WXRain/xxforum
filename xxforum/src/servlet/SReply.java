package servlet;

import java.util.Vector;

import model.impl.ReplyImpl;

import vo.Reply;

public class SReply {

	private int pageSize = 3;
	private int size = 0;
	private int pageNum = 1; 
	public Vector<Reply> replys;
	
	public SReply(){};
	
	public SReply(int topicid){
		replys = new ReplyImpl().selectReplyByTopicId(topicid);
		if(replys != null){
			size = replys.size();
		}
		if(size != 0){
			if(size % pageSize == 0){
				pageNum = size/pageSize;
			}
			
			else pageNum = size/pageSize + 1;
		}
	}
	
	public int getPageSize(){
		return pageSize;
	}
	
	public int getPageNum(){
		return pageNum;
	}
	public Vector<Reply> replys(){
		return replys;
	}
}
