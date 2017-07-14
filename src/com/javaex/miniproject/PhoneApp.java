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
 1. 버퍼가 비워지지 않아서 여러번 돌릴시 입력도 안했는데 입력이 돼있는 상태가 되어 무한루프에 빠짐
 
 2. 제네렉을 이용해서 만들어 보자(지금 내가 사용하는 것은 static)
 */
public class PhoneApp {

	public static void main(String[] args) throws Exception {
		
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
		
		PhoneData.read(list);	//메모장을 읽는다.	// 사실 안에 리스틀 집어넣는게 의미가 없다 잘못생각함
		
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
				num=sc.nextInt();		//정수를 입력받는다.
				sc.nextLine();			//버퍼를 제거하는 용도
			}
			catch(Exception e)
			{
				System.out.println("숫자를 입력하세요");
				continue;
			}
			System.out.println("");
			
			switch(num) {
			case 1:
				PhoneData.write(list);			//리스트안에 있는 데이터를 출력한다.
				break;
				
			case 2:							//입력을 받고 그 데이터를 리스트안에 집어넣는다.
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
				
			case 3:								//숫자번호에 따라 리스트안에 데이터를 제거한다.
				System.out.println("<3.삭제>");
				System.out.print(">번호: ");
				num=sc.nextInt();
				PhoneData.remove(list, num);	
				break;
				
			case 4:								//문자를 입력받아 리스트안에 있는 데이터를 검색한다.
				System.out.println("<4.검색>");	
				System.out.print(">이름: ");
				str=sc2.nextLine();
				PhoneData.search(list, str);
				break;
				
			case 5:								//종료하는 문구
				flag=1;
				break;
				
			default:							// 다른 숫자가 입력시 다시 입력하게 만드는 문장
				System.out.println("다시 입력해주세요");
				break;
			}		
			
		}
		PhoneData.save(list);					//최종적으로 나온 리스트를 메모장에 저장을 하는 과정
		
		
		/* 결론
		 나의 이런 알고리즘은 데이터가 클 경우 아주 비효율 적이다. 데이터가 작을 경우에는 상관이 없지만
		 데이터가  클 경우 처음부터 다시 써야하기 때문에 보다 효율적인 방법을 찾아야 한다.
		 
		 내가 생각할 때는 지울때 실시간으로 메모장에 있는 데이터를 지우고 추가할때 실시간으로 메모장에 있는 데이터를 추가하는
		 그런과정이 있는 알고리즘이 가장 효율적이라고 생각한다.
		대충 머리로는 알고 있고 위에 있는 알고리즘을 짤 자신이 있으니 짜보지는 않겠다.
		 */
			
		
		
		sc.close();
		sc2.close();
	}

}
