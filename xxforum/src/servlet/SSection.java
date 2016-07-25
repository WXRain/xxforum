package servlet;

import java.util.Vector;

import model.impl.TopicImpl;

import vo.Topic;

public class SSection {

	private int pageSize = 3;
	private int size = 0;
	private int pageNum = 1; 
	public Vector<Topic> topics;
	
	public SSection(){};
	
	public SSection(int sectionid){
		topics = new TopicImpl().selectTopicBySection(sectionid);
		if(topics != null){
			size = topics.size();
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
	public Vector<Topic> getTopics(){
		return topics;
	}
}
