package com.expertpia.test.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test_categories")
public class Category{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "category_id")
	private Long cateId;
	
	@Column(name = "category_name")
	private String cateName;

	public Long getCateId() {
		return cateId;
	}

	public void setCateId(Long cateId) {
		this.cateId = cateId;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

//	@Override
//	public String toString() {
//		return "Category [cateId=" 
//				+ cateId 
//				+ ", cateName=" 
//				+ cateName 
//				+ "]";
//	}

}
