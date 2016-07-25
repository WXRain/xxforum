package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import vo.Topic;
import dao.inter.ITopic;

public class TopicDao implements ITopic{

	public boolean addTopic(Topic topic) {
		// TODO Auto-generated method stub
		
		boolean result = false;
		Connection con = tools.DBUtil.getInstance().getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("insert into topic (userId, sectionId, clickCount, replyCount, topicName, topicText, " +
					"releaseDate, lastReplyDate, isTop, isFine) values ('" + topic.getUserId()
					+ "', '" + topic.getSectionId() + "', '" + topic.getClickCount() + "', '" + topic.getReplyCount()
					+ "', '" + topic.getTopicName() + "', '" + topic.getTopicText() + "', '" + topic.getReleaseDate() 
					+ "', '" + topic.getLastReplyDate() + "', '" + topic.getIsTop() + "', '" + topic.getIsFine() + "')");
			result = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con != null)
				tools.DBUtil.getInstance().release(con);
		}
		return result;
	}

	public boolean deleteTopic(int topicId) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection con = tools.DBUtil.getInstance().getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete from topic where id = '" + topicId + "'");
			result = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con != null)
				tools.DBUtil.getInstance().release(con);
		}
		return result;
	}

	public Vector<Topic> selectTopicByName(String Name) {
		// TODO Auto-generated method stub
		Vector<Topic> topics = new Vector<Topic>();
		Connection con = tools.DBUtil.getInstance().getConnection();
		ResultSet rs;
		try {
			Statement st = con.createStatement();
			rs = st.executeQuery("select * from topic where topicName like '%%" + Name +"%%'");
			while(rs.next()){
				Topic topic = new Topic();
				topic.setId(rs.getInt(1));
				topic.setUserId(rs.getInt(2));
				topic.setSectionId(rs.getInt(3));
				topic.setClickCount(rs.getInt(4));
				topic.setReplyCount(rs.getInt(5));
				topic.setTopicName(rs.getString(6));
				topic.setTopicText(rs.getString(7));
				topic.setReleaseDate(rs.getLong(8));
				topic.setLastReplyDate(rs.getLong(9));
				topic.setIsTop(rs.getInt(10));
				topic.setIsFine(rs.getInt(11));
				topics.add(topic);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con != null)
				tools.DBUtil.getInstance().release(con);
		}
		return topics;
	}

	public Vector<Topic> selectTopicBySection(int sectionId) {
		// TODO Auto-generated method stub
		Vector<Topic> topics = new Vector<Topic>();
		Connection con = tools.DBUtil.getInstance().getConnection();
		ResultSet rs;
		try {
			Statement st = con.createStatement();
			rs = st.executeQuery("select * from topic where sectionId = '" + sectionId + "'");
			while(rs.next()){
				Topic topic = new Topic();
				topic.setId(rs.getInt(1));
				topic.setUserId(rs.getInt(2));
				topic.setSectionId(rs.getInt(3));
				topic.setClickCount(rs.getInt(4));
				topic.setReplyCount(rs.getInt(5));
				topic.setTopicName(rs.getString(6));
				topic.setTopicText(rs.getString(7));
				topic.setReleaseDate(rs.getLong(8));
				topic.setLastReplyDate(rs.getLong(9));
				topic.setIsTop(rs.getInt(10));
				topic.setIsFine(rs.getInt(11));
				topics.add(topic);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con != null)
				tools.DBUtil.getInstance().release(con);
		}
		return topics;
	}

	public Vector<Topic> selectTopicByUser(int userId) {

		// TODO Auto-generated method stub
		Vector<Topic> topics = new Vector<Topic>();
		Connection con = tools.DBUtil.getInstance().getConnection();
		ResultSet rs;
		try {
			Statement st = con.createStatement();
			rs = st.executeQuery("select * from topic where userId = '" + userId + "'");
			while(rs.next()){
				Topic topic = new Topic();
				topic.setId(rs.getInt(1));
				topic.setUserId(rs.getInt(2));
				topic.setSectionId(rs.getInt(3));
				topic.setClickCount(rs.getInt(4));
				topic.setReplyCount(rs.getInt(5));
				topic.setTopicName(rs.getString(6));
				topic.setTopicText(rs.getString(7));
				topic.setReleaseDate(rs.getLong(8));
				topic.setLastReplyDate(rs.getLong(9));
				topic.setIsTop(rs.getInt(10));
				topic.setIsFine(rs.getInt(11));
				topics.add(topic);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con != null)
				tools.DBUtil.getInstance().release(con);
		}
		return topics;
	}

	public Topic selectTopicById(int id) {
		// TODO Auto-generated method stub
		
		Topic topic = new Topic();
		Connection con = tools.DBUtil.getInstance().getConnection();
		ResultSet rs;
		try {
			Statement st = con.createStatement();
			rs = st.executeQuery("select * from topic where id = '" + id + "'");
			if(rs.next()){
				topic.setId(rs.getInt(1));
				topic.setUserId(rs.getInt(2));
				topic.setSectionId(rs.getInt(3));
				topic.setClickCount(rs.getInt(4));
				topic.setReplyCount(rs.getInt(5));
				topic.setTopicName(rs.getString(6));
				topic.setTopicText(rs.getString(7));
				topic.setReleaseDate(rs.getLong(8));
				topic.setLastReplyDate(rs.getLong(9));
				topic.setIsTop(rs.getInt(10));
				topic.setIsFine(rs.getInt(11));
			} else {
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con != null)
				tools.DBUtil.getInstance().release(con);
		}
		return topic;
	}
	
	public boolean updateTopic(int topicId, int isTop, int isFine) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection con = tools.DBUtil.getInstance().getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("update topic set isTop = '" + isTop + "' where id = '" + topicId + "'");
			st.executeUpdate("update topic set isFine = '" + isFine + "' where id = '" + topicId + "'");
			result = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con != null)
				tools.DBUtil.getInstance().release(con);
		}
		return result;
	}

	public boolean updateTopicClickCount(int topicId) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection con = tools.DBUtil.getInstance().getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("update topic set clickCount = clickCount + 1 where id = '" + topicId + "'");
			result = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con != null)
				tools.DBUtil.getInstance().release(con);
		}
		return result;
	}

	public boolean updateTopicLastReplyDate(int topicId, long lastReplyDate) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection con = tools.DBUtil.getInstance().getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("update topic set lastReplyDate = '" + lastReplyDate + "' where id = '" + topicId + "'");
			result = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con != null)
				tools.DBUtil.getInstance().release(con);
		}
		return result;
	}

	public boolean updateTopicReplyCount(int topicId, int sign) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection con = tools.DBUtil.getInstance().getConnection();
		try {
			Statement st = con.createStatement();
			if(sign == 1)
				st.executeUpdate("update topic set replyCount = replyCount + 1 where id = '" + topicId + "'");
			if(sign == -1)
				st.executeUpdate("update topic set replyCount = replyCount - 1 where id = '" + topicId + "'");
			result = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con != null)
				tools.DBUtil.getInstance().release(con);
		}
		return result;
	}

	
	public static void main(String[] args) {
//		Topic t = new Topic();
//		t.setTopicName("tmpTopic");
//		t.setTopicText("this is a test topic");
//		TopicDao td = new TopicDao();
		
		//添加帖子测试
//		System.out.println(t.getReleaseDate());
//		td.addTopic(t);
		
		//删除帖子测试
//		td.deleteTopic(4);
		
		//通过名字模糊查询帖子测试
//		Vector<Topic> ts= td.selectTopicByName("t t");
//		for(int i = 0; i < ts.size(); i++){
//			t = ts.get(i);
//			System.out.println(t.getId() + " " + t.getUserId() + " " + t.getSectionId() + " " + t.getClickCount() + " "
//					 + t.getReplyCount() + " " + t.getTopicName() + " " + t.getTopicText() + " " + t.getReleaseDate() + " "
//					 + t.getLastReplyDate() + " " + t.getIsTop() + " " + t.getIsFine() + " ");
//		}
		
		//通过板块id查询帖子测试
//		Vector<Topic> ts= td.selectTopicBySection(6);
//		for(int i = 0; i < ts.size(); i++){
//			t = ts.get(i);
//			System.out.println(t.getId() + " " + t.getUserId() + " " + t.getSectionId() + " " + t.getClickCount() + " "
//					 + t.getReplyCount() + " " + t.getTopicName() + " " + t.getTopicText() + " " + t.getReleaseDate() + " "
//					 + t.getLastReplyDate() + " " + t.getIsTop() + " " + t.getIsFine() + " ");
//		}
		
		//通过用户id查询帖子测试
//		Vector<Topic> ts= td.selectTopicByUser(1);
//		for(int i = 0; i < ts.size(); i++){
//			t = ts.get(i);
//			System.out.println(t.getId() + " " + t.getUserId() + " " + t.getSectionId() + " " + t.getClickCount() + " "
//					 + t.getReplyCount() + " " + t.getTopicName() + " " + t.getTopicText() + " " + t.getReleaseDate() + " "
//					 + t.getLastReplyDate() + " " + t.getIsTop() + " " + t.getIsFine() + " ");
//		}
		
		//通过帖子id修改是否置顶，是否精华
//		td.updateTopic(3, 0, 1);
		
		//增加点击量测试
//		td.updateTopicClickCount(3);
		
		//修改最后回复日期测试
//		td.updateTopicLastReplyDate(3, 1463456966990L);
		
		//增加回复量测试
//		td.updateTopicReplyCount(3);
		
		//通过id查询帖子测试
//		Topic t = new TopicDao().selectTopicById(1);
//		System.out.println(t.getTopicName());
	}

}
