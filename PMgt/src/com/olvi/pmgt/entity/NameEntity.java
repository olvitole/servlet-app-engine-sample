package com.olvi.pmgt.entity;

public class NameEntity {

	private String ip;
	private String name;
	// maybe use id in the future - leave open for now
	private Long id;

	public static final String IP = "ip";
	public static final String NAME = "name";
	public static final String ID = "id";

	
	public NameEntity(String ip, String name, Long id) {
		super();
		this.ip = ip;
		this.name = name;
		this.id = id;
	}

	public NameEntity() {
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "NameEntity [ip=" + ip + ", name=" + name + ", id=" + id + "]";
	}

}
