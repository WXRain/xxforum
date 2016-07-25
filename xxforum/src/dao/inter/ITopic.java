package dao.inter;

import java.util.Vector;

import vo.*;

public interface ITopic {
	public boolean addTopic(Topic topic); //添加帖子
	public boolean deleteTopic(int topicId); //通过id删除帖子
	public boolean updateTopic(int topicId, int isTop, int isFine); //修改帖子的置顶和精华
	public boolean updateTopicLastReplyDate(int topicId, long lastReplyDate); //修改最后回复日期
	public boolean updateTopicClickCount(int topicId); //修改点击量 调用一次点击量加1
	public boolean updateTopicReplyCount(int topicId, int sign); //修改回复量 调用一次回复量加1
	public Vector<Topic> selectTopicByName(String Name); //通过部分名字查询帖子
	public Vector<Topic> selectTopicBySection(int sectionId); //通过板块查询贴子
	public Vector<Topic> selectTopicByUser(int userId); //查询该用户发过的帖子
	public Topic selectTopicById(int id); //通过id返回该贴子
}
