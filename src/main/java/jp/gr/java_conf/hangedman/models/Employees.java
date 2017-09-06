package jp.gr.java_conf.hangedman.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Employees implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "emp_no", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empNo;

	@Column(name = "birth_date")
	private Date birthDate;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "gender")
	private String gender;

	@Column(name = "hire_date")
	private Date hireDate;
}
