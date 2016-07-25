package vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reply {
	private int id;
	private int topicId; //回复的贴的id
	private int toReplyId; //回复其他回复的id
	private int toUserId; //回复其他的人的id
	private long date; //回复日期
	private String text; //回复的内容
	private int userId;//回复人id
	
	public Reply(){
		id = 0;
		topicId = 0;
		toReplyId = 0;
		toUserId = 0;
		date = 0;
		text = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public int getToReplyId() {
		return toReplyId;
	}

	public void setToReplyId(int toReplyId) {
		this.toReplyId = toReplyId;
	}

	public int getToUserId() {
		return toUserId;
	}

	public void setToUserId(int toUserId) {
		this.toUserId = toUserId;
	}

	public long getDate() {
		return date;
	}
	
	public String getDateToString() {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(date));
	}

	public void setDate(long date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
