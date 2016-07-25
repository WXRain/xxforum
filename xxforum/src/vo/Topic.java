package vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Topic {
	private int id;
	private int userId; //�����˵�id
	private int sectionId; //��������id
	private int clickCount; //�����
	private int replyCount; //�ظ���
	private String topicName; //��������
	private String topicText; //��������
	private long releaseDate; //��������
	private long lastReplyDate; //���ظ�����
	private int isTop; //�Ƿ��ö� 0 1
	private int isFine; //�Ƿ�Ϊ���� 0 1
	
	public Topic(){
		id = 0;
		userId = 0;
		sectionId = 0;
		clickCount = 0;
		replyCount = 0;
		topicName = null;
		topicText = null;
		releaseDate = System.currentTimeMillis();
		lastReplyDate = System.currentTimeMillis();
		isTop = 0;
		isFine = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public int getClickCount() {
		return clickCount;
	}

	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getTopicText() {
		return topicText;
	}

	public void setTopicText(String topicText) {
		this.topicText = topicText;
	}

	public long getReleaseDate() {
		return releaseDate;
	}
	
	public String getReleaseDateToString() {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(releaseDate));
	}

	public void setReleaseDate(long releaseDate) {
		this.releaseDate = releaseDate;
	}

	public long getLastReplyDate() {
		return lastReplyDate;
	}
	
	public String getLastReplyDateToString() {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(lastReplyDate));
	}

	public void setLastReplyDate(long lastReplyDate) {
		this.lastReplyDate = lastReplyDate;
	}

	public int getIsTop() {
		return isTop;
	}

	public void setIsTop(int isTop) {
		this.isTop = isTop;
	}

	public int getIsFine() {
		return isFine;
	}

	public void setIsFine(int isFine) {
		this.isFine = isFine;
	}
	
	public static void main(String[] args) {
//		Topic t = new Topic();
//		t.setLastReplyDate(System.currentTimeMillis());
//		System.out.println(t.getLastReplyDateToString());
	}
	

}
