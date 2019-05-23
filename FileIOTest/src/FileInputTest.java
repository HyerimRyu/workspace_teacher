import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//읽어올 파일의 파일명을 가지고 있는 File객체생성
		File file= new File("aaa.txt");
		
		//파일과 연결하는 무지개로드(Stream)
		try {
			//파일이 존재하지 않으면 자동생성 안함!! 예외발생!!
			FileInputStream fis= new FileInputStream(file);
			
			//파일의 데이터 읽기
//			byte b= (byte)fis.read(); //파일에서 1바이트를 읽어옴. 반복문 필요..			
//			while(b != -1) { //위에서 read()했을 때 읽어온 데이터가 없으면 -1임.
//				//System.out.println(b);//읽어온값 보여주기..아스키번호로 출력함
//				System.out.print((char)b);
//				b= (byte)fis.read();
//			}
			//위 방식은 영어가 아닌(아스키코드가 아닌) 문자는 올바로 읽어지지 않음.
			
			//바이트배열(데이터덩어리)단위로 읽어들일것임!!
			//읽어들인 데이터를 저장할 빈 바이트배열을 먼저 만들어놔야함.
			byte[] bytes= new byte[100];//좀 크게 빈통 만글기!!
			fis.read(bytes);//파라미터로 전달된 배열안에 읽어온 값들을 넣어줌.
			
			//읽어온 바이트 배열을 String으로 변환
			String s= new String(bytes);
			System.out.println(s);		
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException e) {
			System.out.println("읽기 과정중 오류가 발생했습니다.");
		}
		

	}

}








