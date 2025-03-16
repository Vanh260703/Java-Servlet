package model;

import java.util.Objects;

public class user {
	private String userName;
	private String password;
	private String hoVaTen;

	public user() {

	}

	public user(String userName, String password, String hoVaTen) {
		super();
		this.userName = userName;
		this.password = password;
		this.hoVaTen = hoVaTen;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	@Override
	public String toString() {
		return "user [userName=" + userName + ", password=" + password + ", hoVaTen=" + hoVaTen + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(hoVaTen, password, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		user other = (user) obj;
		return Objects.equals(hoVaTen, other.hoVaTen) && Objects.equals(password, other.password)
				&& Objects.equals(userName, other.userName);
	}

}
