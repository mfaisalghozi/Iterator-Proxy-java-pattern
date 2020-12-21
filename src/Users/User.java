package Users;

public class User {
	
	private String name;
	private String email;
	private String password;
	private String currentJob;
	private String companyName;
	private String desc;
	private int age;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public void display() {
		System.out.println("Name : " + this.name);
		System.out.println("Email : " + this.email);
		System.out.println("Age : " + this.age);
		if(this.currentJob.equals("-")) {
			System.out.println("Current Job : -");
		}else {
			System.out.println("Current Job : " + this.companyName);
		}
		System.out.println("Description : " );
		System.out.println(this.desc);
	}
	
	public User(String name, String email, String password, String currentJob, String companyName, String desc, int age) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.currentJob = currentJob;
		this.companyName = companyName;
		this.desc = desc;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCurrenJob() {
		return currentJob;
	}

	public void setCurrenJob(String currenJob) {
		this.currentJob = currenJob;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
