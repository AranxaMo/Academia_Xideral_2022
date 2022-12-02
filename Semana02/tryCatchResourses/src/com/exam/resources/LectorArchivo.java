package com.exam.resources;

public class LectorArchivo implements AutoCloseable{
	private String tag;
	
	public LectorArchivo(String tag) {
		this.tag=tag;
	}
	
	@Override
	public void close() {
		System.out.println("Closed: "+tag);
	}

}
