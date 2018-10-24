package com.htc.collections.generic;

import java.lang.reflect.Array;

public class GenericArray<T> {
	private T[] t;
	private static int length;
	static {
		length = 0;
	}

	public int length() {
		return GenericArray.length;
	}

	public T getValue(int index) {
		return t[index];
	}

	public void setValue(T data) {
		this.t[GenericArray.length++] = data;

	}

	public GenericArray(T[] t) {
		super();
		this.t = t;
	}

	public T[] getT() {
		return t;
	}

	public void setT(T[] t) {
		this.t = t;
	}

	public GenericArray(Class<T[]> type) {
		this.t = (T[]) Array.newInstance(type.getComponentType(), 9999);
	}
	
	
	
	
	
	
	
	
	
	
	
}
