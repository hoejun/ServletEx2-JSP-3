/*
 * HangulUil 클래스는 8859_1 캐릭터 셋으로 이루어진 문자열을 파라미터로 받은후
 * 캐릭터 셋을 UTF-8로 변경해서 문자열을 리턴 해주는 toKor이라는 메소드를 정의 한 클래스 임
 * 
 */
public class HangulUtil {

	public static String toKor(String name) {
		
		try{
			return new String (name.getBytes("8859_1"),"UTF-8");
		}catch(Exception e){
			return null;
		}
		
	}

}
