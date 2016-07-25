package model.inter;

import java.util.Vector;

import vo.Section;
import vo.User;

public interface ISection {
	public String addSection(User user, Section section);// 添加板块 如果成功返回true， 如果失败返回返回原因
	public String updateSection(User user, int id, String name, String introduce); //修改板块信息
	public Vector<Section> selectAll();//列出所有板块
	public Section findSectionById(int id);
}
