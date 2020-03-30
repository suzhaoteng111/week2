package com.szt.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.szt.bean.Columns;
import com.szt.mapper.MyMapper;
import com.szt.utils.DateUtil;
import com.szt.utils.IOUtil;
import com.szt.utils.StringUtil;

public class Test0 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		MyMapper mm = ac.getBean(MyMapper.class);
		
		List<Object[]> readFile = IOUtil.readFile("cms附件-机械设备公司年检信息.txt", "\t");
		int i = 1;
		for (Object[] objects : readFile) {
			Columns is = new Columns();
			// 主键 关键字 描述  描述名称 主营产品 地址 注册资本 成立时间      xx  xx 年检状态
			String id = objects[0]+"";
			String name = objects[1]+"";
			String ms = objects[2]+"";
			String work = objects[3]+"";
			String cp = objects[4]+"";
			String address = objects[5]+"";
			String money = objects[6]+"";
			String cdate = objects[7]+"";
			String bz = objects[10]+"";
			//id值要使用isNumber()工具方法判断是不是数字
			if(i==1){
				id = id.substring(1);
			}
			i++;
			if(StringUtil.isNumber(id)){
				is.setId(new Integer(id));
			}
			//name	、ms、公司名称、主营产品、地址要使用 hasText()方法判断有没有值
			if(!StringUtil.isEmpty(name)){
				is.setName(name);
			}
			if(!StringUtil.isEmpty(ms)){
				is.setMs(ms);
			}
			if(!StringUtil.isEmpty(work)){
				is.setWork(work);
			}
			if(!StringUtil.isEmpty(cp)){
				is.setCp(cp);
			}
			if(!StringUtil.isEmpty(address)){
				is.setAddress(address);
			}
			// 注册资本要使用hasText()方法判断有没有值，并使用 isNumber()判断是不是数字
			if(!StringUtil.isEmpty(money)){
				if(StringUtil.isNumber(money)){
					is.setMoney(Double.parseDouble(money));
				}
			}
			
			//d.年检日期为null，在前端必须显示为空，不能显示null（3分）
			
			
//			c. 成立时间要使用hasText()方法判断有没有值,判断是不是日期类型（3分）
			if(!StringUtil.isEmpty(cdate)){
				if(StringUtil.isDate(cdate)){
					is.setCdate(DateUtil.stringToDate(cdate));
				}
			}
			
			
			
		}
	}
}
