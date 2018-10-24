package com.htc.corejava.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.htc.corejava.dto.Computer;
import com.htc.corejava.dto.Office;
import com.htc.corejava.exception.ComputerNotFoundException;

public interface IOfficeServiceProvider {

	public boolean createComputer(Computer computer) throws FileNotFoundException, IOException, SQLException;
	
	public Computer readComputer(int compId) throws FileNotFoundException, IOException, SQLException, ComputerNotFoundException;
	
	public List<Computer> readComputers() throws FileNotFoundException, IOException, SQLException;
	
	public boolean updateComputer(Computer updatedComputer) throws FileNotFoundException, IOException, SQLException;
	
	public boolean deleteComputer(int compId) throws FileNotFoundException, IOException, SQLException;
	
	public ArrayList<Office> deSerializeOffice()throws FileNotFoundException, IOException,  ClassNotFoundException;
	
	public boolean serializeOffice(Office office) throws FileNotFoundException, IOException;
}
