package com.htc.corejava.util;

import java.util.Comparator;

import com.htc.corejava.dto.Computer;

public class ComputerIdComparator implements Comparator<Computer>{

	@Override
	public int compare(Computer comp1, Computer comp2) {
		
		return comp1.getComputerId()-comp2.getComputerId();
	}

}
