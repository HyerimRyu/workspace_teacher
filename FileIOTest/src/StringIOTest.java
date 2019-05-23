import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class StringIOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//문자열데이터를 한줄씩 또는 한단어씩 읽거나 쓰려면?? 특히, 읽어들일때..
		//기존 바이트스트림 방식의 InputStream은 몇바이트를 읽어야 할지 파악하기 어려움.
		//그래서 좀 더 편하게 문자열단위로 데이터의 IO를 수행하기위해
		//문자 스트림 방식을 사용.(Reader, Writer)
		
		//사용자 입력을 받아 그 데이터를 파일에 지속적으로 저장하는 프로그램
		
		Scanner scanner= new Scanner(System.in);
		
		while(true) {
			System.out.print("저장할 단어 입력 (no를 입력하면 종료): ");
			String str= scanner.next();
			
			if( str.equalsIgnoreCase("no") ) {//대소문자 상관없이!
				System.out.println("입력이 종료됩니다.");
				break;
			}
			
			//종료되지 않았다면 파일에 저장..
			//목표위치 : "본인프로젝트/files/data.txt"
			File path= new File("files");
			if( !path.exists() ) path.mkdirs();
			
			//경로 + 파일명.확장자 : 파일의 전체경로
			File file= new File(path, "data.da");
			
			//파일과 연결할 스트림(문자스트림)
			//내 데이터를 파일쪽으로 내보내기위한 스트림(OutputStream-->Writer)
			//자바문서와 data.txt문서사이에 무지개로드(FileWriter)객체 생성
			try {
				FileWriter fileWriter= new FileWriter(file, true);//append모드
//				fileWriter.write(str);//저장은 되지만 단어구분이나 특정 Format으로 저장시키는 것을 어려움.
//				fileWriter.flush();
//				fileWriter.close();
				
				//FileWriter를 바로 사용하기 보다 좀 더 익숙한 방법으로 저장시키고 싶음.
				//즉, 콘솔 창 출력하듯이.. 마치..System.out.printn()이렇게 쓰듯이..
				//할 수 있도록 보조 스트림 클래스가 준비되어 있음.
				PrintWriter writer= new PrintWriter(fileWriter);
				writer.println(str);
				writer.flush();
				writer.close();//자동으로 FileWriter는 close()됨.
				
			} catch (IOException e) {
				System.out.println("파일쓰기 실패!!");
			}
			
		}//while문...
		
		System.out.println();
		System.out.println("--------------------------------");		
		System.out.println("저장된 파일의 데이터들을 화면에 출력합니다.");
		System.out.println("--------------------------------");
		System.out.println();
		
		//한줄에 한단어씩 있으니 읽어들인 단어를 ArrayList에 추가시키기..
		ArrayList<String> datas= new ArrayList<String>();
		
		File file= new File("files/data.da");
		//읽어올 파일과 스트림연결 작업 시작!
		try {
			FileReader fr= new FileReader(file);
			
//			int a= fr.read();//한글자씩 읽기: 영어면 1바이트, 한글이면 2~3바이트가 읽어짐. 언어마다 알아서 바이트수 결정
//			System.out.println(a);
//			//위 방법은 반복문이 필요하여 불편하며..일정단위를 끊어서 읽어들이기 불편함.
			
			//그래서 읽어들이기 편하게 보조 문자 스트림 클래스들이 존재함.
			//그중 가장 많이 사용되는 BufferedReader를 사용!
			BufferedReader reader= new BufferedReader(fr);
			//한줄씩 읽어들여..
			String line= reader.readLine();
			while(line!=null) {
				//읽어온 데이터를 ArrayList에 추가
				datas.add(line);
				
				line= reader.readLine();//다음줄 읽어오기
			}
			
			System.out.println("파일 읽기 종료!!");
			
			//ArrayList에 추가된 데이터를 차례로 화면에 출력하기!!
			for(int i=0; i<datas.size(); i++) {
				System.out.println(i +" : "+ datas.get(i));
			}
			
			
			reader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException e) {
			System.out.println("파일읽기 실패!");
		}
		
		
		

	}//main method...

}








