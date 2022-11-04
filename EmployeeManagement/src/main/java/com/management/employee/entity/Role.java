package com.management.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table (name="roles")
public class Role {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="role_id")
	private long id;
	private String roleName;

	public Role(String roleName) {
		this.roleName=roleName;
	}


}
