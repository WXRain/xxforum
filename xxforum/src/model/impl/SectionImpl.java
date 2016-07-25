package model.impl;

import java.util.Vector;

import dao.impl.SectionDao;
import vo.Section;
import vo.User;
import model.inter.*;

public class SectionImpl implements ISection{

	public String addSection(User user, Section section) {
		// TODO Auto-generated method stub
		String result = null;
		if(user.getIsManager() == 0){
			result = "您无添加权限";
		}else if(user.getIsManager() == 1){
			if(new SectionDao().addSection(section)){
				result = "true";
			}else {
				result = "err";
			}
			
		}else {
			result = "err";
		}
		return result;
	}

	public Vector<Section> selectAll() {
		// TODO Auto-generated method stub
		return new SectionDao().selectAll();
	}

	public String updateSection(User user, int id, String name, String introduce) {
		// TODO Auto-generated method stub
		String result = null;
		SectionDao sd = new SectionDao();
		if(user.getIsManager() == 0){
			result = "您无修改权限";
		}else {
			if(sd.updateSection(id, "name", name) && sd.updateSection(id, "introduce", introduce)){
				result = "true";
			}else {
				result = "SectionDao err";
			}
		}
		return result;
	}
	
	public Section findSectionById(int id) {
		// TODO Auto-generated method stub
		return new SectionDao().selectById(id);
	}
	
	public static void main(String[] args) {
//		//测试
//		User u = new User();
//		u.setIsManager(1);
//		Section s = new Section();
//		s.setName("testSection");
//		s.setIntroduce("this is test");
//		System.out.println(new SectionImpl().addSection(u, s));
		
//		System.out.println(new SectionImpl().updateSection(u, 5, "aaa", "i.m test"));
	}


}
