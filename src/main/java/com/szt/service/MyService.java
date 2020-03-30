package com.szt.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.szt.bean.Columns;

public interface MyService {
	public PageInfo<Columns> list(Columns cl,Integer pageNum);
}
