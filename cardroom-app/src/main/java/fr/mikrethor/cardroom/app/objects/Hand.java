package fr.mikrethor.cardroom.app.objects;

import java.io.Serializable;

public class Hand implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5463306159990289346L;

	private Long id;

	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hand() {
		super();
	}

	public Hand(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Hand [id=" + id + ", name=" + name + "]";
	}

}
