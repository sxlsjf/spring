package com.mygroup.sxl;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SxlApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void pageWrite() {
		// build excel writer
	/*	ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
		ExcelWriter excelWriter = EasyExcel.write("E:/easyexcel/testPageWrite.xlsx", User.class).excelType(ExcelTypeEnum.XLSX).build();
		// page write*/
		/*EasyExcelUtils.pageWrite(excelWriter, "数据清单", 2_500_000L,
				(currentPage, pageSize) -> {
					Page<User> page = new Page<>(currentPage, pageSize);
					return userService.selectByPage(page).getRecords();
				});
	}*/
	}
}
