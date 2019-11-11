package com.goodfor.web.pxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import com.goodfor.web.brd.ArticleMapper;
import com.goodfor.web.cmm.IFunction;
import com.goodfor.web.cmm.ISupplier;
import lombok.Data;

@Component
@Data
@Lazy
public class Proxy {
	private int pageNum, pageSize, startRow, endRow, startPage, endPage;
	private boolean existPrev, existNext;
	private final int BLOCK_SIZE = 5;
	private String search;
	@Autowired
	ArticleMapper artMapper;

	@SuppressWarnings("unused")
	public void paging() {
		ISupplier<String> s = () -> artMapper.countArticle();
		int totalCount = Integer.parseInt(s.get());
		int pageCount = (totalCount % pageSize == 0) ? totalCount / pageSize : totalCount / pageSize + 1;
		startRow = (pageNum - 1) * pageSize;
		// endRow = (pageNum == pageCount)? (totalCount % pageSize) : pageSize ;
		endRow = (pageNum == pageCount) ? totalCount - 1 : startRow + pageSize - 1;
		int blockCount = (pageCount % BLOCK_SIZE == 0) ? pageCount / BLOCK_SIZE : (pageCount / BLOCK_SIZE) + 1;
		int blockNum = (pageNum - 1) / BLOCK_SIZE;
		startPage = blockNum * BLOCK_SIZE + 1;
		endPage = (blockCount != (blockNum + 1)) ? startPage + BLOCK_SIZE - 1 : pageCount;
		existPrev = (blockNum != 0);
		existNext = ((blockNum + 1) != blockCount);
	}

	public int parseInt(String param) {
		IFunction<String, Integer> f = s -> Integer.parseInt(s);
		return f.apply(param);
	}

	public List<?> crawl(Map<?, ?> paramMap) {
		List<String> proxyList = new ArrayList<>();
		String url = "http://" + paramMap.get("site") + ".co.kr";
		proxyList.clear();
		try {
			Connection.Response response = Jsoup.connect(url).method(Connection.Method.GET).execute();
			Document document = response.parse();
			String text = document.html();
			System.out.println("크롤링한 텍스트 : " + text);
			proxyList.add(text);
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		return proxyList;
	}

	public int random(int a, int b) {
		BiFunction<Integer, Integer, Integer> f = (x, y) -> (int) (Math.random() * (y - x)) + x;
		return f.apply(a, b);
	}
	public String makeMid(){
		List<String> fid = Arrays.asList("a","b","c","d","e","f","g","h","i",
										 "j","k","l","m","n","o","p","q","r",
										 "s","t","u","v","w","x","y","z","0",
										 "1","2","3","4","5","6","7","8","9");
		List<String> did = Arrays.asList("a","b","c","d","e","f","g","h","i",
										 "j","k","l","m","n","o","p","q","r",
										 "s","t","u","v","w","x","y","z","0",
										 "1","2","3","4","5","6","7","8","9");
		List<String> tid = Arrays.asList("a","b","c","d","e","f","g","h","i",
										 "j","k","l","m","n","o","p","q","r",
										 "s","t","u","v","w","x","y","z","0",
										 "1","2","3","4","5","6","7","8","9");
		List<String> qid = Arrays.asList("a","b","c","d","e","f","g","h","i",
										 "j","k","l","m","n","o","p","q","r",
										 "s","t","u","v","w","x","y","z","0",
										 "1","2","3","4","5","6","7","8","9");
		List<String> pid = Arrays.asList("a","b","c","d","e","f","g","h","i",
										 "j","k","l","m","n","o","p","q","r",
										 "s","t","u","v","w","x","y","z","0",
										 "1","2","3","4","5","6","7","8","9");
		Collections.shuffle(fid);
		Collections.shuffle(did);
		Collections.shuffle(tid);
		Collections.shuffle(qid);
		Collections.shuffle(pid);
		String fullMid = fid.get(0) + did.get(1) + tid.get(2) + qid.get(3) + pid.get(4);
		return fullMid;
	}
	public String makeEmail(){
		List<String> fid = Arrays.asList("a","b","c","d","e","f","g","h","i",
										 "j","k","l","m","n","o","p","q","r",
										 "s","t","u","v","w","x","y","z");
		List<String> did = Arrays.asList("a","b","c","d","e","f","g","h","i",
										 "j","k","l","m","n","o","p","q","r",
										 "s","t","u","v","w","x","y","z","0",
										 "1","2","3","4","5","6","7","8","9");
		List<String> tid = Arrays.asList("a","b","c","d","e","f","g","h","i",
										 "j","k","l","m","n","o","p","q","r",
										 "s","t","u","v","w","x","y","z","0",
										 "1","2","3","4","5","6","7","8","9");
		List<String> qid = Arrays.asList("a","b","c","d","e","f","g","h","i",
										 "j","k","l","m","n","o","p","q","r",
										 "s","t","u","v","w","x","y","z","0",
										 "1","2","3","4","5","6","7","8","9");
		List<String> pid = Arrays.asList("a","b","c","d","e","f","g","h","i",
										 "j","k","l","m","n","o","p","q","r",
										 "s","t","u","v","w","x","y","z","0",
										 "1","2","3","4","5","6","7","8","9");
		List<String> mail = Arrays.asList("@naver.com","@google.com","@daum.net","@nate.com");
		Collections.shuffle(fid);
		Collections.shuffle(did);
		Collections.shuffle(tid);
		Collections.shuffle(qid);
		Collections.shuffle(pid);
		String email = fid.get(0) + did.get(1) + tid.get(2) + qid.get(3) + pid.get(4) + mail.get(5);
		return email;
	}
	public String makeMname(){
		 List<String> fname = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안",
			        "송", "류", "전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "성", "차", "주",
			        "우", "구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강", "현", "함", "변", "염", "양",
			        "변", "여", "추", "노", "도", "소", "신", "석", "선", "설", "마", "길", "주", "연", "방", "위", "표", "명", "기", "반", "왕", "금",
			        "옥", "육", "인", "맹", "제", "모", "장", "남", "탁", "국", "여", "진", "어", "은", "편", "구", "용");
			    List<String> name = Arrays.asList("가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노", "누", "다",
			        "단", "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미", "민", "바", "박",
			        "백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소", "솔", "수", "숙", "순",
			        "숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요", "용", "우", "원", "월", "위",
			        "유", "윤", "율", "으", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전", "정", "제", "조", "종", "주", "준",
			        "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "탐", "태", "택", "판", "하", "한", "해", "혁", "현", "형",
			        "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "부", "림", "봉", "혼", "황", "량", "린", "을", "비",
			        "솜", "공", "면", "탁", "온", "디", "항", "후", "려", "균", "묵", "송", "욱", "휴", "언", "령", "섬", "들", "견", "추", "걸", "삼",
			        "열", "웅", "분", "변", "양", "출", "타", "흥", "겸", "곤", "번", "식", "란", "더", "손", "술", "훔", "반", "빈", "실", "직", "흠",
			        "흔", "악", "람", "뜸", "권", "복", "심", "헌", "엽", "학", "개", "롱", "평", "늘", "늬", "랑", "얀", "향", "울", "련");
			    Collections.shuffle(fname);
			    Collections.shuffle(name);
			    String fullname = fname.get(0) + name.get(0) + name.get(1);
			    return fullname;
	}

}
