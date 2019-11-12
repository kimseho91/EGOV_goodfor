package com.goodfor.web.pxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.goodfor.web.brd.ArticleMapper;
import com.goodfor.web.cmm.ISupplier;
import lombok.Data;

@Data
@Lazy
@Component("pager")
public class PageProxy extends Proxy{
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
	
}
