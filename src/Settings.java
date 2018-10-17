
public class Settings {
	private String username="Admin";
	private String pwdu = "Admin";
	public static String pwdb= "Admin";
	
	public Settings() {
	}
	public Settings(String username, String pwdu) {
		super();
		this.username = username;
		this.pwdu = pwdu;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwdu() {
		return pwdu;
	}
	public void setPwdu(String pwdu) {
		this.pwdu = pwdu;
	}
	public String getPwdb() {
		return pwdb;
	}
	public void setPwdb(String pwdb) {
		this.pwdb = pwdb;
	}
	@Override
	public String toString() {
		return String.format("Settings [username=%s, pwdu=%s, pwdb=%s]", username, pwdu, pwdb);
	}
	
	
	
	

}
