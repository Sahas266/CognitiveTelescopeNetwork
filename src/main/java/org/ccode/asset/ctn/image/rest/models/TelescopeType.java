package org.ccode.asset.ctn.image.rest.models;

import java.io.Serializable;

public class TelescopeType implements Serializable {
	private int id;
	private String name;
	private int location;
	private int telescopeType;
	private double aperture;
	private double fieldOfView;

	public TelescopeType() {
	}

	public TelescopeType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Telescope{" + "id=" + id + ", name='" + name + '\'' + ", location=" + location + ", telescopeType=" + telescopeType + ", aperture=" + aperture + ", fieldOfView=" + fieldOfView + '}';
	}
}