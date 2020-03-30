package com.szt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.szt.bean.Columns;
import com.szt.service.MyService;

@Controller
public class MyController {
	@Autowired
	private MyService ms;
	
	@RequestMapping("list")
	public String list(Columns cl,Model model,@RequestParam(defaultValue="1")Integer pageNum){
		PageInfo<Columns> page = ms.list(cl, pageNum);
		model.addAttribute("list",page.getList());
		model.addAttribute("page",page);
		return "list";
	}
}
