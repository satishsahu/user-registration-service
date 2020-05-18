package com.techm.banking.user.registration.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User implements Serializable {

	/**
	 * Default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private String address;
	@NotNull
	private String gender;
	@NotNull
	private String email;
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dob;
	@NotNull
	private String phoneNumber;
	@NotNull
	private String userName;
	@NotNull
	private String password;

	public User() {
	}

	public User(long id, @NotNull String firstName, @NotNull String lastName, @NotNull String address,
			@NotNull String gender, @NotNull String email, @NotNull String phoneNumber, @NotNull String userName,
			@NotNull String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
	}
}
