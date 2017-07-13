package com.javaex.miniproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
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
		
		
		List<Data> list=new ArrayList<Data>();
		String str;
		int num;
		int flag=0;
		
		PhoneData.read(list);	//메모장을 읽는다.
		
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
				PhoneData.write(list);
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
				PhoneData.remove(list, num);	
				break;
				
			case 4:
				System.out.println("<4.검색>");
				System.out.print(">이름: ");
				str=sc2.nextLine();
				PhoneData.search(list, str);
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
