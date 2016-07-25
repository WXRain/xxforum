package vo;

public class User {
	private int id;
	private String username; //�û���
	private String password; //����
	private String name; //�ǳ�
	private int sex; //1 �� 2 Ů
	private int level; //�ȼ�
	private int exp; //����
	private int isManager; //����Ȩ�� 0 �û� 1 ����Ա
	
	public User(){
		id = 0;
		username = null;
		password = null;
		name = null;
		sex = 1;
		level = 0;
		exp = 0;
		isManager = 0;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getIsManager() {
		return isManager;
	}

	public void setIsManager(int isManager) {
		this.isManager = isManager;
	}
	
	
}
