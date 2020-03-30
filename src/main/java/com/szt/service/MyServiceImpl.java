package com.szt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.szt.bean.Columns;
import com.szt.mapper.MyMapper;
@Service
public class MyServiceImpl implements MyService {
	@Autowired
	private MyMapper mm;
	public PageInfo<Columns> list(Columns cl, Integer pageNum) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,3);
		List<Columns> list = mm.list(cl);
		return new PageInfo<Columns>(list);
	}

}
