package kr.happyjob.study.system.service;


import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import kr.happyjob.study.system.repository.BookMapper;
import kr.happyjob.study.system.vo.BookVo;


@Service
public class BookServiceImpl implements BookService{
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	//파일 업로드에 사용될 Property
	//물리경로(상위)
	@Value("${fileUpload.rootPath}")
	private String rootPath;
	
	//상대경로
	@Value("${fileUpload.noticeRelativePath}")
	private String fileRelativePath;
	
	//물리경로(하위)-공지사항 이미지 저장용 폴더
	@Value("${fileUpload.noticePath}")
	private String noticePath;
	
	@Autowired
	private BookMapper mapper;

	@Override
	public List<BookVo> selectBookList(Map<String, Object> params) throws Exception {
		return mapper.selectBookList(params);
	}
	
	@Override
	public int selectBookCnt(Map<String, Object> params)  throws Exception {
		return mapper.selectBookCnt(params);
	}

	@Override
	public BookVo selectBookDetail(Map<String, Object> paramMap)  throws Exception {
		return mapper.selectBookDetail(paramMap);
	}
	
	@Override
	public int insertBook(Map<String, Object> paramMap)  throws Exception {

		
		return mapper.insertBook(paramMap);
	}

	@Override
	public int updateBook(Map<String, Object> paramMap)  throws Exception {
		

			
		return mapper.updateBook(paramMap);
	}

	@Override
	public int deleteBook(Map<String, Object> paramMap)  throws Exception {
		return mapper.deleteBook(paramMap);
	}

}
