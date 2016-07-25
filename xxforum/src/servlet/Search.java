package servlet;

import java.util.Vector;


import model.impl.TopicImpl;
import model.inter.ITopic;
import vo.Topic;

public class Search{
	
	private static final String CONTENT_TYPE="text/html; charset=gb2312";
	private int pageSize = 3;
	private int size = 0;
	private int pageNum = 1; 
	public Vector<Topic> topics;
	
	public Search(){}
	
	public Search(String searchText){
		ITopic itopic = new TopicImpl();
		topics = itopic.selectTopicByName(searchText);
		
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
