package com.fts.four_seasons;

import com.fts.four_seasons.model.dto.QueryBorrowDto;
import com.fts.four_seasons.model.vo.BorrowVo;
import com.fts.four_seasons.service.BorrowService;
import com.fts.four_seasons.service.impl.BorrowServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

import java.util.List;
import java.util.logging.Logger;
@SpringBootTest(classes = FourSeasonsApplication.class)
class FourSeasonsApplicationTests {
	@Autowired
	private BorrowService borrowService;

	@Test
	void contextLoads() {

	}
	@Test
	public void testBorrow(){
		QueryBorrowDto dto = new QueryBorrowDto();
		dto.setUserId(2);
		System.out.println(dto);
		List<BorrowVo> results =  borrowService.listBorrow(dto);
		System.out.println(results.size());
		for(int i=0;i<results.size();i++){
			System.out.println("测试结果：");
			System.out.println(results.get(i).toString());
		}
	}

}
