package com.javaex.miniproject;

public class Data {
	private String name;
	private String hp;
	private String company;
	
	public Data() { }
	
	public Data(String name,String hp,String company) {
		this.name=name;
		this.hp=hp;
		this.company=company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	
	public String memo() {
		return name+","+hp+","+company;
	}

	public void show()
	{
		System.out.printf("1. %s/t/t%s/t/t%s\n",name,hp,company);
	}
	
	

}
