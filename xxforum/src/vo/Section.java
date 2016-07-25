package vo;

public class Section {
	private int id;
	private String name; //板块名
	private String introduce; //板块介绍
	private int topicCount; //板块内帖子个数
	
	public Section(){
		id = 0;
		name = null;
		introduce = null;
		topicCount = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public int getTopicCount() {
		return topicCount;
	}

	public void setTopicCount(int topicCount) {
		this.topicCount = topicCount;
	}
	
	
}
