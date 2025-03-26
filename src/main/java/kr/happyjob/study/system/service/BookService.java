package kr.happyjob.study.system.service;

import java.util.List;
import java.util.Map;


import kr.happyjob.study.system.vo.BookVo;


public interface BookService {
	List<BookVo> selectBookList(Map<String, Object> params) throws Exception;
	BookVo selectBookDetail(Map<String, Object> paramMap) throws Exception;
	int selectBookCnt(Map<String, Object> params) throws Exception;
	int insertBook(Map<String, Object> paramMap) throws Exception;
	int updateBook(Map<String, Object> paramMap) throws Exception;
	int deleteBook(Map<String, Object> paramMap) throws Exception;
}
