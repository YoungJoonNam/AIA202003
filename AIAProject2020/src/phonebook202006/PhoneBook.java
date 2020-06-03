package phonebook202006;

public class PhoneBook {

	private String pid;
	private String name;              
	private String phoneNumber;  
	private String address;         
	private String email;             
	private String type;               
	private String major;            
	private int grade;                
	private String company;        
	private String dept;               
	private String rank;              
	private String cafename;       
	private String nickname;       
	 

	public PhoneBook() {
 
	}

	  
	 public PhoneBook(String pid, String name, String phoneNumber, String address, String email, String type,
			String major, int grade, String company, String dept, String rank, String cafename, String nickname) {
		
		this.pid = pid;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		this.type = type;
		this.major = major;
		this.grade = grade;
		this.company = company;
		this.dept = dept;
		this.rank = rank;
		this.cafename = cafename;
		this.nickname = nickname;
	}
	 

	public String getPid() {
		return pid;
	}



	public void setPid(String pid) {
		this.pid = pid;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getMajor() {
		return major;
	}



	public void setMajor(String major) {
		this.major = major;
	}



	public int getGrade() {
		return grade;
	}



	public void setGrade(int grade) {
		this.grade = grade;
	}



	public String getCompany() {
		return company;
	}



	public void setCompany(String company) {
		this.company = company;
	}



	public String getDept() {
		return dept;
	}



	public void setDept(String dept) {
		this.dept = dept;
	}



	public String getRank() {
		return rank;
	}



	public void setRank(String rank) {
		this.rank = rank;
	}



	public String getCafename() {
		return cafename;
	}



	public void setCafename(String cafename) {
		this.cafename = cafename;
	}



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	 
	 
	 
}
