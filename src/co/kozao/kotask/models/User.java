package co.kozao.kotask.models;

/**
 * 
 * @author Brinda Metiokam <metiokam.brinda@gmail.com>
 * version 1.0
 *
 */
public class User {


	private int idUser;
	private String name;
	private String username;
	private String email;
	private int phoneNumber;
	private Role role;
	private String password;
	private String confirmPassword;

	public User() {
		super();
		
	}

	public User(int idUser, String name, String username, String email, int phoneNumber, Role role,
			String password, String confirmPassword) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.username = username;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUsers) {
		this.idUser = idUsers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "User [/n idUsers=" + idUser + ", name=" + name + ", username=" + username + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", role=" + role + ", password=" + password + ", confirmPassword="
				+ confirmPassword + "]";
	}

}
