package com.javaex.miniproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.Scanner;
/*
 문제점 
 버퍼가 비워지지 않아서 여러번 돌릴시 입력도 안했는데 입력이 돼있는 상태가 되어 무한루프에 빠짐
 
 */
public class PhoneApp {

	public static void main(String[] args) throws IOException {
		
		System.out.println("****************************************");
		System.out.println("*********    전화번호 관리 프로그램    *********");
		System.out.println("****************************************");
		System.out.println("");
		Scanner sc=new Scanner(System.in);
		Scanner sc2=new Scanner(System.in);
		
		Reader rd=new FileReader("phoneDB.txt");
		BufferedReader br=new BufferedReader(rd);
		LinkedList<Data> list=new LinkedList<Data>();
		String str;
		int num;
		int flag=0;
		while(true) {
			str=br.readLine();
			if(str==null)
				break;
			String[] st=str.split(",");
			Data db=new Data(st[0],st[1],st[2]);
			list.add(db);
			
		}
		
		
		
		
		while(true) {
			if(flag==1) {
				System.out.println("****************************************");
				System.out.println("************    감사합니다.    ************");
				System.out.println("****************************************");
				break;
			}
			
			System.out.println(" ");
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("-------------------------------");
			System.out.print(">메뉴번호:");
			try
			{
				num=sc.nextInt();
			}
			catch(Exception e)
			{
				System.out.println("숫자를 입력하세요");
				System.in.read();
				continue;
			}
			System.out.println("");
			
			switch(num) {
			case 1:
				for(int i=0;i<list.size();i++) {
					System.out.printf("%d. %s\t\t%s\t\t%s\n",i+1,list.get(i).getName(),list.get(i).getHp(),list.get(i).getCompany());	
				}
				break;
				
			case 2:
				Data b=new Data();		
				System.out.println("<2.등록>");
				System.out.print(">이름: ");
				b.setName(sc2.nextLine());
				System.out.print(">휴대전화: ");
				b.setHp(sc2.nextLine());
				System.out.print(">집전화: ");
				b.setCompany(sc2.nextLine());
				list.add(b);
				break;
				
			case 3:
				System.out.println("<3.삭제>");
				System.out.print(">번호: ");
				num=sc.nextInt();
				if((num)>=1 && (num)<=list.size()) {
					list.remove(num-1);
				} else
					System.out.println("잘못입력하셨습니다. 메뉴로");			
				break;
				
			case 4:
				System.out.println("<4.검색>");
				System.out.print(">이름: ");
				str=sc2.nextLine();
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
				break;
				
			case 5:
				flag=1;
				break;
				
			default:
				System.out.println("다시 입력해주세요");
				break;
				
			}
			
								
		}	

		sc.close();
		sc2.close();
	}

}
