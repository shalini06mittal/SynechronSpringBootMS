package com.ms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.bean.BookOrderBean;
import com.ms.bean.BookResponseBean;
import com.ms.bean.Catalog;
import com.ms.feign.BookOrderServiceFeignClient;
import com.ms.feign.BookServiceFeignClient;

@Service
public class BookCatalogService {

	@Autowired
	private BookOrderServiceFeignClient bookOrderServiceFeignClient;
	
	@Autowired
	private BookServiceFeignClient bookServiceFeignClient;
	
	public Catalog getCatalogForUser(String email) {
		Catalog catalog = new Catalog();
		
		List<BookOrderBean> orderBeans = this.bookOrderServiceFeignClient.getAllOrderedBooks(email);
		
		List<BookResponseBean> bookResponseBeans = new ArrayList();
		for(BookOrderBean bean: orderBeans) {
			BookResponseBean bookResponseBean = this.bookServiceFeignClient.getBookById(bean.getBookid());
			bookResponseBean.setOrderdate(bean.getOrderdate());
			bookResponseBean.setQty(bean.getQty());
			bookResponseBeans.add(bookResponseBean);
		}
		
		catalog.setEmail(email);
		catalog.setBookResponseBeans(bookResponseBeans);
		return catalog;
	}
	
}
