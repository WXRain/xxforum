package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import vo.Section;
import dao.inter.ISection;

public class SectionDao implements ISection{

	public boolean addSection(Section section) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection con = tools.DBUtil.getInstance().getConnection();
		ResultSet rs;
		try {
			Statement st = con.createStatement();
			rs = st.executeQuery("select name from section where name = '" + section.getName() + "'");
			if(!rs.next()){
				st.executeUpdate("insert into section (name, introduce, topicCount) values ('" + section.getName() + "'," +
						" '" + section.getIntroduce() + "', '" + section.getTopicCount() + "')");
				result = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con != null)
				tools.DBUtil.getInstance().release(con);
		}
		return result;
	}

	public Vector<Section> selectAll() {
		// TODO Auto-generated method stub
		Vector<Section> sections = new Vector<Section>();
		Connection con = tools.DBUtil.getInstance().getConnection();
		ResultSet rs;
		
		try {
			Statement st = con.createStatement();
			rs = st.executeQuery("select * from section");
			while(rs.next()){
				Section section = new Section();
				section.setId(rs.getInt(1));
				section.setName(rs.getString(2));
				section.setIntroduce(rs.getString(3));
				section.setTopicCount(rs.getInt(4));
				sections.add(section);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con != null)
				tools.DBUtil.getInstance().release(con);
		}
		return sections;
	}

	public Section selectById(int id) {
		// TODO Auto-generated method stub
		Section section = null;
		Connection con = tools.DBUtil.getInstance().getConnection();
		ResultSet rs;
		
		try {
			Statement st = con.createStatement();
			rs = st.executeQuery("select * from section where id = '" + id + "'");
			while(rs.next()){
				section = new Section();
				section.setId(rs.getInt(1));
				section.setName(rs.getString(2));
				section.setIntroduce(rs.getString(3));
				section.setTopicCount(rs.getInt(4));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con != null)
				tools.DBUtil.getInstance().release(con);
		}
		return section;
	}
	
	public boolean updateSection(int id, String attribute, String value) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection con = tools.DBUtil.getInstance().getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("update section set " + attribute + " = '" + value + "' where id = '" + id + "'");
			result = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con != null){
				tools.DBUtil.getInstance().release(con);
			}
		}
		
		return result;
	}

	public boolean updateSectionTopicCount(int id, int sign) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection con = tools.DBUtil.getInstance().getConnection();
		try {
			Statement st = con.createStatement();
			if(sign == 1)
				st.executeUpdate("update section set topicCount = topicCount + 1 where id = '" + id + "'");
			if(sign == -1)
				st.executeUpdate("update section set topicCount = topicCount - 1 where id = '" + id + "'");
			result = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(con != null){
				tools.DBUtil.getInstance().release(con);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
//		Section s = new Section();
//		s.setName("tmpSection");
//		s.setIntroduce("this is test");
//		s.setTopicCount(0);
//		SectionDao sd = new SectionDao();
		
		//添加板块测试
//		sd.addSection(s);
		
		//查询所有板块测试
//		Vector<Section> ss = sd.selectAll();
//		for(int i = 0; i < ss.size(); i++){
//			System.out.println(ss.get(i).getId() + " " + ss.get(i).getName() + " " 
//					+ ss.get(i).getIntroduce() + " " + ss.get(i).getTopicCount());
//		}

		//修改模块信息测试
//		sd.updateSection(4, "introduce", "test?--");
		
		//增加板块内帖子数量测试
//		sd.updateSectionTopicCount("tmpSection");
		
		//测试通过id获取Section
//		System.out.println(new SectionDao().selectById(1).getIntroduce());
	}
}
