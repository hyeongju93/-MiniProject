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

	public String getName() {			//이름을 가져온다.
		return name;
	}

	public void setName(String name) {	//이름을 새로 설정한다.
		this.name = name;
	}

	public String getHp() {				//핸폰번호를 가져온다.
		return hp;
	}

	public void setHp(String hp) {		//핸폰번호를 설정한다.
		this.hp = hp;
	}

	public String getCompany() {		//집전화를 가져온다.
		return company;
	}

	public void setCompany(String company) {	//집전화를 설정한다.
		this.company = company;
	}
	
	
	public String memo() {						//메모장에 저장할 값들을 반환한다.
		return name+","+hp+","+company;
	}

	public void show()							//출력에서 보여주는 곳
	{
		System.out.printf("1. %s/t/t%s/t/t%s\n",name,hp,company);
	}
	
	

}
