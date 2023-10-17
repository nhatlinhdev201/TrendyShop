package entities;

public class AccountLogin {
	private String name;
	private String id;
	private String pathImageAvatar;
	public AccountLogin(String name, String id, String pathImageAvatar) {
		super();
		this.name = name;
		this.id = id;
		this.pathImageAvatar = pathImageAvatar;
	}
	public AccountLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPathImageAvatar() {
		return pathImageAvatar;
	}
	public void setPathImageAvatar(String pathImageAvatar) {
		this.pathImageAvatar = "/images/"+id+"-avt.png";
	}
	@Override
	public String toString() {
		return "AccountLogin [name=" + name + ", id=" + id + ", pathImageAvatar=" + pathImageAvatar + "]";
	}
	
	
}
