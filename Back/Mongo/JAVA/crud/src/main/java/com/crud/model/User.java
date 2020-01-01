package com.crud.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import javax.validation.constraints.NotNull;

@Document(collection = "user")
public class User implements Serializable{
	private static final long serialVersionUID = -7788619177798333712L;
	@Id
	@NotNull
	private String Id;
	@NotNull
	private String name;
	@NotNull
	private String email;
	@NotNull
	private String pwd;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(@NotNull String id, @NotNull String name, @NotNull String email, @NotNull String pwd) {
		super();
		Id = id;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
	}

	public String getId() {
		return Id;
	}

	public void setId(String Id) {
		this.Id = Id;
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}