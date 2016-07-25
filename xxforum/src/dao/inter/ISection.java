package dao.inter;

import java.util.Vector;

import vo.*;

public interface ISection {
	public boolean addSection(Section section); //添加板块
	public boolean updateSection(int id, String attribute, String value); //通过板块 属性 和 属性的值修改
	public boolean updateSectionTopicCount(int id, int sign); //调用一次板块的帖子数量加1 sign 为1 加一 为-1 减一
	public Vector<Section> selectAll(); //列出所用板块
	public Section selectById(int id);
}
