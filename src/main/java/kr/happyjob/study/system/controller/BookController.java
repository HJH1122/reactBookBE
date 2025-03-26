package kr.happyjob.study.system.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import jakarta.servlet.http.HttpSession;
import kr.happyjob.study.system.service.BookService;
import kr.happyjob.study.system.vo.BookVo;




@Controller
@RequestMapping("/")
public class BookController {
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	
	@Autowired
	private BookService service;
	
	// 북 리스트 출력
	@GetMapping("books")
	@ResponseBody
	public Map<String, Object> bookList(@RequestParam Map<String, Object> paramMap) throws Exception {

        logger.info("   - paramMap : " + paramMap);


        int currentPage = Integer.parseInt((String) paramMap.get("currentPage")); // 현재페이지
        int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));
        int pageIndex = (currentPage - 1) * pageSize;

        paramMap.put("pageIndex", pageIndex);
        paramMap.put("pageSize", pageSize);
        //paramMap.put("title", title);

        // 책 목록 조회 (selectBookList 메소드 사용)
        List<BookVo> bookList = service.selectBookList(paramMap);
        // 책 목록 수 추출해서 보내기
        int bookCnt = service.selectBookCnt(paramMap);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("bookList", bookList); // 책 리스트 담기
        resultMap.put("bookCnt", bookCnt); // 리턴 값 해쉬맵에 담기
        resultMap.put("pageSize", pageSize);
        resultMap.put("currentPage", currentPage);

        return resultMap;

	}
	
	
	/** 
	 * 북 상세
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/books/{id}")
	@ResponseBody
	public Map<String, Object> bookDetail(@PathVariable("id") String bookNo) throws Exception {
		logger.info("bookDetail start");
		logger.info("   - bookNo : " + bookNo);
	
		Map<String, Object> resultMap = new HashMap<>();
		try {
			// 책 상세 조회
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("bookNo", bookNo);
			BookVo bookDetail = service.selectBookDetail(paramMap);
			
			resultMap.put("result", bookDetail);
			if (bookDetail != null && bookDetail.getBookNo() > 0) {
				resultMap.put("resultMsg", "SUCCESS");
			} else {
				resultMap.put("resultMsg", "ERROR");
			}
		} catch (Exception e) {
			logger.error("Error in bookDetail: ", e);
			resultMap.put("resultMsg", "ERROR");
		}
	
		return resultMap;
	}

	/** 
	 * 북 신규저장
	 * @param paramMap
	 * @throws Exception
	 */
	@PostMapping("books")
	@ResponseBody
	public void bookInsert(@RequestParam Map<String, Object> paramMap, HttpSession session) throws Exception {
		logger.info("bookInsert start");
		logger.info("   - paramMap : " + paramMap);
		

		service.insertBook(paramMap);
		
	}

	/**
	 * 북 재고 수정
	 * @param paramMap
	 * @param session
	 * @throws Exception
	 */
	@PutMapping("books")
	@ResponseBody
	public void bookUpdate(@RequestParam Map<String, Object> paramMap) throws Exception {
		logger.info("noticeBook start");
		logger.info("   - paramMap : " + paramMap);

		service.updateBook(paramMap);
		
	}

	/**
	 * 북 삭제
	 * @param paramMap
	 * @throws Exception
	 */
	@DeleteMapping("books")
	@ResponseBody
	public void bookDelete(@RequestParam Map<String, Object> paramMap) throws Exception {
		logger.info("bookDelete start");
		logger.info("   - paramMap : " + paramMap);
		
		service.deleteBook(paramMap);
		
	}

}
