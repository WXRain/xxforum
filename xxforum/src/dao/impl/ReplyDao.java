package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import vo.Reply;
import dao.inter.IReply;

public class ReplyDao implements IReply{

	public boolean addReply(Reply reply) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection con = tools.DBUtil.getInstance().getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("insert into reply (topicId, toReplyId, toUserId, date, text, userId) values ('" + reply.getTopicId() + "'," +
					" '" + reply.getToReplyId() + "', '" + reply.getToUserId() + "', '" + reply.getDate() + "', " +
							"'" + reply.getText() + "', '" + reply.getUserId() + "')");
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

	public boolean deletReply(int replyId) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection con = tools.DBUtil.getInstance().getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete from reply where id = '" + replyId + "'");
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

	public Vector<Reply> selectReplyByTopicId(int topicId) {
		// TODO Auto-generated method stub
		Vector<Reply> replys = new Vector<Reply>();
		Connection con = tools.DBUtil.getInstance().getConnection();
		ResultSet rs;
		try {
			Statement st = con.createStatement();
			rs = st.executeQuery("select * from reply where topicId = '" + topicId + "'");
			while(rs.next()){
				Reply reply = new Reply();
				reply.setId(rs.getInt(1));
				reply.setTopicId(rs.getInt(2));
				reply.setToReplyId(rs.getInt(3));
				reply.setToUserId(rs.getInt(4));
				reply.setDate(rs.getLong(5));
				reply.setText(rs.getString(6));
				reply.setUserId(rs.getInt(7));
				replys.add(reply);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con != null)
				tools.DBUtil.getInstance().release(con);
		}
		return replys;
	}
	
	public static void main(String[] args) {
//		Reply r = new Reply();
//		r.setText("this is testUI");
//		r.setUserId(3);
//		ReplyDao rd = new ReplyDao();
		
		//ÃÌº”ªÿ∏¥≤‚ ‘
//		rd.addReply(r);
		
		//…æ≥˝ªÿ∏¥≤‚ ‘
//		rd.deletReply(3);
		
		//Õ®π˝Ã˚◊”id≤È—Øªÿ∏¥≤‚ ‘
//		Vector<Reply> rs = rd.selectReplyByTopicId(5);
//		for(int i = 0; i < rs.size(); i++){
//			r = rs.get(i);
//			System.out.println(r.getId() + " " + r.getTopicId() + " " + r.getToReplyId() + " "
//					 + r.getToUserId() + " " + r.getDate() + " " + r.getText() + " " + r.getUserId());
//		}
	}
}
