package com.example.vsii.utils;

import java.io.BufferedReader;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {
	private String value;
	
	public HttpUtil(String value) {
		this.value = value;
	}
	public <T> T toModel(Class<T> tclass) {
		try {
			return new ObjectMapper().readValue(value, tclass);
			// convert chuỗi Json sang object
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public static HttpUtil of (BufferedReader bufferedReader) {
		StringBuilder builder = new StringBuilder();
		try {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				builder.append(line);
			}
		} catch (Exception e) {
			System.out.println("erro");
		}
		return new HttpUtil(builder.toString());
	}
}
