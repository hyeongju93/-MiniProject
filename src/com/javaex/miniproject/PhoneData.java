package com.javaex.miniproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

public class PhoneData {
		
	public static void read(List<Data> list) throws IOException {
		String str;
		Reader rd=new FileReader("phoneDB.txt");
		BufferedReader br=new BufferedReader(rd);
		
		while(true) {
			str=br.readLine();
			if(str==null)
				break;
			String[] st=str.split(",");
			Data db=new Data(st[0],st[1],st[2]);
			list.add(db);			
		}
		
	}
	
	public static void write(List<Data> list) {
		for(int i=0;i<list.size();i++) {
			System.out.printf("%d. %s\t\t%s\t\t%s\n",i+1,list.get(i).getName(),list.get(i).getHp(),list.get(i).getCompany());	
		}
		
	}
	
	public static void remove(List<Data> list,int num) {
		if((num)>=1 && (num)<=list.size()) {
			list.remove(num-1);
		} else
			System.out.println("잘못입력하셨습니다. 메뉴로");	
		
	}
	
	public static void search(List<Data> list,String str) {
		int flag=0;
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<list.get(i).getName().length();j++) {
				if(str.equals(String.valueOf((list.get(i).getName().charAt(j))))) {
					flag=1;
				}					
				if(flag==1) {
					System.out.printf("%d. %s\t\t%s\t\t%s\n",i+1,list.get(i).getName(),list.get(i).getHp(),list.get(i).getCompany());
					flag=0;
				}
			}
		}	
	}

	public static void save(List<Data> list) throws Exception {
		Writer wt=new FileWriter("PhoneDB.txt");
		BufferedWriter bw=new BufferedWriter(wt);
		for(int i=0;i<list.size();i++) {
			bw.write(list.get(i).memo());
			bw.newLine();	// 되도록이면 이걸로 띄어쓰기
			bw.flush();	//flush 필요
			
		}
		
	}

}
