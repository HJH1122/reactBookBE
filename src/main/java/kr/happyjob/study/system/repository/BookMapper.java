package kr.happyjob.study.system.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.happyjob.study.system.vo.BookVo;

@Mapper
public interface BookMapper {
	List<BookVo> selectBookList(Map<String, Object> params);
	BookVo selectBookDetail(Map<String, Object> paramMap);
	int selectBookCnt(Map<String, Object> params);
	int insertBook(Map<String, Object> paramMap);
	int updateBook(Map<String, Object> paramMap);
	int deleteBook(Map<String, Object> paramMap);

	
}
