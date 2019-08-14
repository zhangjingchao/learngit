package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Items;

@Controller
public class Index {
	/**
	 * 测试json的交互
	 * 
	 * @param item
	 * @return
	 */
	@RequestMapping("/testJson.action")
	@ResponseBody
	/* public Items testJson(@RequestBody Items item) { */
	public List<Items> testJson() {
		List<Items> ItemsList = new ArrayList<Items>();
		
		Items itemsTmp = new Items();
		itemsTmp.setId("1");
		itemsTmp.setName("Tom");
		itemsTmp.setAge(19);
		List<String> scores = new ArrayList<String>();
		scores.add("100");
		scores.add("99");
		scores.add("90");
		itemsTmp.setScores(scores);
		
		ItemsList.add(itemsTmp);

		itemsTmp = new Items();
		itemsTmp.setId("2");
		itemsTmp.setName("Jack");
		itemsTmp.setAge(19);
		scores = new ArrayList<String>();
		scores.add("100");
		scores.add("99");
		scores.add("90");
		itemsTmp.setScores(scores);
		
		ItemsList.add(itemsTmp);

		return ItemsList;
	}
}
