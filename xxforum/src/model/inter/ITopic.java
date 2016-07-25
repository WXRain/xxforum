package model.inter;

import java.util.Vector;

import vo.Topic;
import vo.User;

public interface ITopic {
	public String addTopic(User user, Topic topic); //发帖 （板块帖子数+1）
	public String updateTopic(User user, Topic topic, int isTop, int isFine);//修改帖子置顶和精华 如果值是-1不修改
	public String deleteTopic(User user, Topic topic);//删除帖子 （板块帖子数-1）
	public Vector<Topic> selectTopicByName(String name); //通过部分名字查询帖子
	public Vector<Topic> selectTopicBySection(int sectionId); //通过板块查询贴子 (我来排序)
	public Vector<Topic> selectTopicByUser(int userId); //查询该用户发过的帖子
	public Topic selectTopicByTopicId(int topicId); //通过id返回Topic对象
}
