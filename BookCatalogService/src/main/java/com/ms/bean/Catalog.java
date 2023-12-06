package com.ms.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Catalog {

	private String email;
	private List<BookResponseBean> bookResponseBeans;
	
}
