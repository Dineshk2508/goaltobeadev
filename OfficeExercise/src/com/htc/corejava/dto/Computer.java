package com.htc.corejava.dto;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.time.LocalDate;

public class Computer implements Externalizable{

	private int computerId;
	private String computerName;
	private HardDisk hardDisk;
	public Computer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Computer(int computerId, String computerName, HardDisk hardDisk) {
		super();
		this.computerId = computerId;
		this.computerName = computerName;
		this.hardDisk = hardDisk;
	}
	public int getComputerId() {
		return computerId;
	}
	public void setComputerId(int computerId) {
		this.computerId = computerId;
	}
	public String getComputerName() {
		return computerName;
	}
	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}
	public HardDisk getHardDisk() {
		return hardDisk;
	}
	public void setHardDisk(HardDisk hardDisk) {
		this.hardDisk = hardDisk;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + computerId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Computer other = (Computer) obj;
		if (computerId != other.computerId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Computer [computerId=" + computerId + ", computerName=" + computerName + ", hardDisk=" + hardDisk + "]";
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.computerId=in.readInt();
		this.computerName=in.readUTF();
		
		HardDisk hardDisk=new HardDisk();
		
		hardDisk.setHardDiskNo(in.readInt());
		hardDisk.setBrand(in.readUTF());
		hardDisk.setCapacity(in.readUTF());
		hardDisk.setMfgDate((LocalDate)in.readObject());
		
		this.hardDisk=hardDisk;
		
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(this.computerId);
		out.writeUTF(computerName);
		
		out.writeInt(this.hardDisk.getHardDiskNo());
		out.writeUTF(this.hardDisk.getBrand());
		out.writeUTF(this.hardDisk.getCapacity());
		out.writeObject(this.hardDisk.getMfgDate());  // Build in classes
		
		
	}
	
	
	
}
