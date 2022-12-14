package com.tyss.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Superheroes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5379650263430551954L;
	
	private Integer id;
	
	private String name;
	
	private String realName;

}
