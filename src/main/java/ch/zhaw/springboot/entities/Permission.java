package ch.zhaw.springboot.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Permission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private Date date;

	private String type;

	@ManyToOne
	private User user;

	@ManyToOne
	private Node node;

	public Permission(Date date) {
		super();
		this.date = date;
	}

	public Permission() {

	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Node getNode() {
		return node;
	}

	public User getUser() {
		return user;
	}

}
