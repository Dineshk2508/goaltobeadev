package com.htc.corejava.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.htc.corejava.dto.Computer;
import com.htc.corejava.dto.HardDisk;
import com.htc.corejava.dto.Office;
import com.htc.corejava.exception.ComputerNotFoundException;
import com.htc.corejava.logging.MyLogger;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {

		// retrieving Logger Object 
		Logger log=MyLogger.getLogger(new Main());
				
		
		HardDisk hardDisk=new HardDisk(11,"GigaByte","1TB",LocalDate.of(2018, 8, 02));
		HardDisk hardDisk1=new HardDisk(12,"GigaByte","1TB",LocalDate.of(2017, 4, 13));
		Computer computer=new Computer(101,"IMPC101",hardDisk);
		Computer computer1=new Computer(102,"IMPC102",hardDisk1);
		ArrayList<Computer> computers=new ArrayList<Computer>();
		computers.add(computer);
		computers.add(computer1);
		System.out.println(java.sql.Date.valueOf(hardDisk.getMfgDate()).getClass().getName());
		
		Office office=new Office(1001,"MyOffice",computers);
		try {
			for(Computer comp:office.getComputers()) {
				System.out.println(comp.getComputerId());
				System.out.println(office.createComputer(comp));
			}
		} catch (SQLException e) {
			log.warning("SQL Exception occured...");
			log.info(e.getMessage());
		}
		
		/*
		try {
			System.out.println(office.readComputer(102));
		} catch (SQLException | ComputerNotFoundException e) {
			log.warning("Computer Not Found in the DB");
			e.printStackTrace();
		}
		*/
		
		/* Serialization and De Serialization */
		//System.out.println(office.serializeOffice(office));
		/*for(Office off:office.deSerializeOffice()) {
			System.out.println("office: "+off);
		}*/

	}

}
