import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//원본파일의 경로
		//String srcPath= "D:/files/aaa.txt";
		String srcPath= "";
		if(args.length!=0) srcPath= args[0];
		
		//String 파일경로로 곧바로 스트림 생성 가능함.
		try {
			FileInputStream fis= new FileInputStream(srcPath);
			
			//읽어들인 데이터를 저장할 파일의 경로와 파일명지정
			File dstPath= new File("D:/copy"); //경로만 먼저 지정
			if( !dstPath.isDirectory() ) dstPath.mkdirs();
			
			//여기까지 오면 무조건 copy폴더가 있다고 확신할 수 있음.
			//파일명을 포함한 full경로 File객체 생성
			File dstFile= new File(dstPath, "bbb.txt");//경로 + 파일명 
			//만들어진 목적지파일까지 연결하는 Stream객체 생성
			FileOutputStream fos= new FileOutputStream(dstFile);
			
			
			//읽어온 파일의 데이터(1byte씩)를 곧바로 dstFile에 저장!!
			while(true) {
				byte b= (byte)fis.read();//1바이트씩 읽기
				if(b == -1) break;
				
				//읽어들인 1바이트를 바로 목적지파일에 저장
				fos.write(b);//1바이트씩 쓰기				
			}
			
			fos.flush();
			
			//복사가 끝났다...
			fis.close();
			fos.close();
			
			System.out.println("복사 완료되었습니다.");
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("복사 중 오류가 발생하였습니다.");
		}

	}

}





