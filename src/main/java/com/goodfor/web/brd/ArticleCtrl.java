package com.goodfor.web.brd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.goodfor.web.cmm.IConsumer;
import com.goodfor.web.cmm.ISupplier;
import com.goodfor.web.pxy.PageProxy;
import com.goodfor.web.pxy.Box;
import com.goodfor.web.utl.Printer;


@RestController
@RequestMapping("/articles")
public class ArticleCtrl {
	private static final Logger logger = LoggerFactory.getLogger(ArticleCtrl.class);
	
	@Autowired Map<String, Object> artMap;
	@Autowired Article art;
	@Autowired Printer printer;
	@Autowired ArticleMapper artMapper;
	@Autowired List<Article> list;
	@Qualifier PageProxy pager;
	@Qualifier Box box ;
	
	@PostMapping("/")
	public Map<?,?> writeArticle(@RequestBody Article param){
		printer.accept("글쓰기 들어옴");
		IConsumer<Article> c = t -> artMapper.insertArticle(param); 
		c.accept(param);
		ISupplier<String> s = ()->artMapper.countArticle();
		box.accept(Arrays.asList("msg","count"), Arrays.asList("SUCCESS", s.get()));
		
		/*Articlemap.clear();
		Articlemap.put("msg","SUCCESS");
		printer.accept("글쓰기 나감"+Articlemap.get("msg"));*/
		
		return box.get();
	}
	
	@GetMapping("/page/{pageNo}/size/{pageSize}")
	public Map<?,?> listArt(@PathVariable String pageNo, @PathVariable String pageSize){
		System.out.println("넘어오는 값 : "+pageNo+" , "+pageSize);
		pager.setPageNum(pager.parseInt(pageNo));
		pager.setPageSize(pager.parseInt(pageSize));
		pager.paging();
		list.clear();
		ISupplier<List<Article>> s = () -> artMapper.selectAll(pager);
		List<Integer> pagelist = new ArrayList<>();
		for( int i=pager.getStartPage(); i<pager.getEndPage()+1 ; i++) {
			pagelist.add(i);
		}
		box.accept(Arrays.asList("articles", "pages", "pxy"),
				   Arrays.asList(s.get(), pagelist, pager)) ;
		return box.get();
	}
	
	@PutMapping("/")
	public Map<?,?> updateArticle(@RequestBody Article param){
		printer.accept("글 수정 요청 : "+param.getArtseq()+", "+param.getTitle()+", "+param.getContent());
		IConsumer<Article> c = t -> artMapper.updateByArtseq(param);
		c.accept(param);
		box.accept(Arrays.asList("msg"), Arrays.asList("SUCCESS"));
		
		/*Articlemap.clear();
		Articlemap.put("msg", "SUCCESS");*/
		
		return box.get();
	}
	
	@DeleteMapping("/")
	public Map<?,?> deleteArticle(@RequestBody Article param){
		printer.accept("글 삭제 요청"+param.getArtseq());
		IConsumer<Article> c = t -> artMapper.deleteById(param);
		c.accept(param);
		box.accept(Arrays.asList("msg"), Arrays.asList("SUCCESS"));
		
		/*Articlemap.clear();
		Articlemap.put("msg", "SUCCESS");*/
		
		return box.get();
	}
	
	@GetMapping("/countArt")
	public Map<?,?> countArt() {
		ISupplier<String> s = () -> artMapper.countArticle();
		
		/*Articlemap.clear();
		Articlemap.put("count", s.get());*/
		
		box.accept(Arrays.asList("count"), Arrays.asList(s.get()));
		return box.get();
	}
		
}
