package com.htc.io.externalize;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

public class Employee implements Externalizable {

	private int empId;
	private String empName;
	private Address address;
	
	public Employee(int empId, String empName, Address address) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.address = address;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", address=" + address + "]";
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		
		empId=in.readInt();
		empName=in.readUTF();
		
		int doorNo=in.readInt();
		String street=in.readUTF();
		String city=in.readUTF();
		address=new Address(doorNo,street,city);
		
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(empId);
		out.writeUTF(empName);
		
		out.writeInt(address.getDoorNo());
		out.writeUTF(address.getStreet());
		out.writeUTF(address.getCity());
		
		
	}
	
	
}
