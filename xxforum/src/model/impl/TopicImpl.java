package model.impl;

import java.util.Vector;

import dao.impl.SectionDao;
import dao.impl.TopicDao;

import vo.Topic;
import vo.User;
import model.inter.ITopic;

public class TopicImpl implements ITopic{

	public String addTopic(User user, Topic topic) {
		// TODO Auto-generated method stub
		String result = null;
		TopicDao td = new TopicDao();
		if(td.addTopic(topic)){
			result = "true";
			SectionDao sd = new SectionDao();
			sd.updateSectionTopicCount(topic.getSectionId(), 1);
		}else {
			result = "TopicDao err";
		}
		return result;
	}

	public String deleteTopic(User user, Topic topic) {
		// TODO Auto-generated method stub
		String result = null;
		if(user.getIsManager() != 1 && topic.getUserId() != user.getId()){
			result = "Sorry 您无删除权限";
		} else {
			if(new TopicDao().deleteTopic(topic.getId())){
				result = "true";
				new SectionDao().updateSectionTopicCount(topic.getSectionId(), -1);
			} else {
				result = "TopicDao err";
			}
		}
		return result;
	}

	public Vector<Topic> selectTopicByName(String name) {
		// TODO Auto-generated method stub
		return topicSort(new TopicDao().selectTopicByName(name));
	}

	public Vector<Topic> selectTopicBySection(int sectionId) {
		// TODO Auto-generated method stub
		return new TopicDao().selectTopicBySection(sectionId);
	}

	public Vector<Topic> selectTopicByUser(int userId) {
		// TODO Auto-generated method stub
		return topicSort(new TopicDao().selectTopicByUser(userId));
	}

	public String updateTopic(User user, Topic topic, int isTop, int isFine) {
		// TODO Auto-generated method stub
		String result = null;
		if(user.getIsManager() != 1){
			result = " Sorry 您无修改权限";
		} else {
			if(isTop != -1){
				new TopicDao().updateTopic(topic.getId(), isTop, topic.getIsFine());
			} 
			if(isFine != -1){
				new TopicDao().updateTopic(topic.getId(), topic.getIsTop(), isFine);
			}
			result = "true";
		}
		return result;
	}

	public Topic selectTopicByTopicId(int topicId) {
		// TODO Auto-generated method stub
		return new TopicDao().selectTopicById(topicId);
	}

	public Vector<Topic> topicSort(Vector<Topic> topics){
		Vector<Topic> result = new Vector<Topic>();
		Vector<Topic> tmp = new Vector<Topic>();
		for(int i = 0; i < topics.size(); i++){
			Topic topic = topics.get(i);
			if(topic.getIsTop() == 1){
				if (result.size() == 0) {
					result.add(topic);
					continue;
				}
				for (int j = 0; j < result.size(); j++) {
					if(topic.getLastReplyDate() > result.get(j).getLastReplyDate()){
						result.add(j,topic);
						break;
					}
					if(j == result.size() - 1){
						result.add(topic);
						break;
					}
				}
			} else if (topic.getIsTop() == 0){
				if (tmp.size() == 0) {
					tmp.add(topic);
					continue;
				}
				for (int j = 0; j < tmp.size(); j++) {
					if(topic.getLastReplyDate() > tmp.get(j).getLastReplyDate()){
						tmp.add(j,topic);
						break;
					}
					if(j == tmp.size() - 1){
						tmp.add(topic);
						break;
					}
				}
			}
		}
		
		result.addAll(tmp);
		
		return result;
	}
	
	public static void main(String[] args) {
//		User u = new User();
//		Topic t = new Topic();
//		t.setId(4);
//		t.setUserId(u.getId());
//		t.setSectionId(5);
//		t.setTopicName("this is test");
//		t.setTopicText("this is a test topic");
//		System.out.println(new TopicImpl().addTopic(u, t));
//		System.out.println(new TopicImpl().deleteTopic(u, t));
		
//		Vector<Topic> topics = new Vector<Topic>();
//		Topic t1 = new Topic();
//		t1.setIsTop(0); t1.setTopicName("2"); t1.setLastReplyDate(222);
//		topics.add(t1);
//		Topic t2 = new Topic();
//		t2.setIsTop(0); t2.setTopicName("1"); t2.setLastReplyDate(111);
//		topics.add(t2);
//		Topic t3 = new Topic();
//		t3.setIsTop(1); t3.setTopicName("4"); t3.setLastReplyDate(444);
//		topics.add(t3);
//		Topic t4 = new Topic();
//		t4.setIsTop(0); t4.setTopicName("9"); t4.setLastReplyDate(999);
//		topics.add(t4);
//		Topic t5 = new Topic();
//		t5.setIsTop(1); t5.setTopicName("6"); t5.setLastReplyDate(666);
//		topics.add(t5);
//		Topic t6 = new Topic();
//		t6.setIsTop(1); t6.setTopicName("8"); t6.setLastReplyDate(888);
//		topics.add(t6);
//		Topic t7 = new Topic();
//		t7.setIsTop(0); t7.setTopicName("5"); t7.setLastReplyDate(555);
//		topics.add(t7);
//		Topic t8 = new Topic();
//		t8.setIsTop(0); t8.setTopicName("3"); t8.setLastReplyDate(333);
//		topics.add(t8);
//		
//		
//		for(int i = 0; i < topics.size(); i++){
//			System.out.print(topics.get(i).getTopicName() + " ");
//		}
//		System.out.println();
//		topics = new TopicImpl().topicSort(topics);
//		for(int i = 0; i < topics.size(); i++){
//			System.out.print(topics.get(i).getTopicName() + " ");
//		}
		
//		Vector<Topic> topics = new Vector<Topic>();
//		topics = new TopicImpl().selectTopicByName("d t");
//		for(int i = 0; i < topics.size(); i++){
//			System.out.println(topics.get(i).getTopicName());
//		}
		
//		Topic t = new Topic();
//		User u = new User();
//		u.setIsManager(1);
//		t.setId(1);
//		t.setIsTop(1);
//		t.setIsFine(0);
//		System.out.println(new TopicImpl().updateTopic(u, t, -1, 1));
		
//		Vector<Topic> ts = new TopicImpl().selectTopicBySection(6);
//		for(int i = 0; i < ts.size(); i++){
//			System.out.println(ts.get(i).getTopicName());
//		}
	}
}
