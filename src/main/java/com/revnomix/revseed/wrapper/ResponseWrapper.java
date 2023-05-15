package com.revnomix.revseed.wrapper;

import org.springframework.http.ResponseEntity;

import com.revnomix.revseed.model.Clients;

import lombok.Data;

@Data
public class ResponseWrapper<T> {

	private Clients  client;
	private Object object;
	private ResponseEntity<T> entity;
}
