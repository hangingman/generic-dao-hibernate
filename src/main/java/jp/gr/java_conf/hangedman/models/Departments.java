package jp.gr.java_conf.hangedman.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "departments")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Departments implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "dept_no", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String deptNo;

	@Column(name = "dept_name")
	private String deptName;
}
