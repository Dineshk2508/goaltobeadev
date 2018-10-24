package com.htc.corejava.dto;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.htc.corejava.dao.IOfficeServiceProvider;
import com.htc.corejava.exception.ComputerNotFoundException;
import com.htc.corejava.logging.MyLogger;
import com.htc.corejava.util.DBConnector;

public class Office implements Serializable, IOfficeServiceProvider {

	private int officeId;
	private String officeName;
	private List<Computer> computers = new ArrayList<Computer>();

	public Office() {
		super();
		
	}

	public Office(int officeId, String officeName, List<Computer> computers) {
		super();
		this.officeId = officeId;
		this.officeName = officeName;
		this.computers = computers;
	}

	public int getOfficeId() {
		return officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public List<Computer> getComputers() {
		return computers;
	}

	public void setComputers(List<Computer> computers) {
		this.computers = computers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + officeId;
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
		Office other = (Office) obj;
		if (officeId != other.officeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Office [officeId=" + officeId + ", officeName=" + officeName + ", computers=" + computers + "]";
	}
	
	
	
	
	/* Uncomment the below methods for the implementation with ArrayList  */
	
/*
	@Override
	public boolean createComputer(Computer computer) {
		boolean createFlag = false;
		if (!this.getComputers().contains(computer)) {
			this.getComputers().add(computer);
			createFlag = true;
		}
		return createFlag;
	}

	@Override
	public Computer readComputer(int compId) {
		Computer foundComputer = null;
		for (Computer comp : this.getComputers()) {
			if (comp.getComputerId() == compId) {
				foundComputer = comp;
				break;
			}
		}
		return foundComputer;
	}

	@Override
	public List<Computer> readComputers() {

		return this.getComputers();
	}

	@Override
	public boolean updateComputer(int compId, Computer updatedComputer) {
		boolean updateFlag = false;
		if (this.getComputers().contains(updatedComputer)) {
			Computer comp = readComputer(compId);
			comp.setComputerId(updatedComputer.getComputerId());
			comp.setComputerName(updatedComputer.getComputerName());
			comp.setHardDisk(updatedComputer.getHardDisk());
			updateFlag = true;
		}
		return updateFlag;
	}

	@Override
	public boolean deleteComputer(int compId) {
		boolean deleteFlag = false;
		for (Computer comp : this.getComputers()) {
			if (comp.getComputerId() == compId) {
				comp = null;
				deleteFlag = true;
				break;
			}
		}
		return deleteFlag;
	}
*/
	@Override
	public ArrayList<Office> deSerializeOffice() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		// retrieving Logger Object 
		Logger log=MyLogger.getLogger(this);
		
		ArrayList<Office> offices = new ArrayList<>();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Office.txt"));
		 log.info("De-Serialization process Initiated...");
		try {
			while (true) {
				offices.add((Office) ois.readObject());
			}
		} catch (EOFException e) {
			log.warning("Input Stream reached End of file.");
			throw e;
			
		} finally {
			log.info("De-Serialization process completed.");
			log.config("closing Object Input stream...");
			ois.close();
			return offices;	
		}
		

	}

	@Override
	public boolean serializeOffice(Office office) throws FileNotFoundException, IOException {
		// retrieving Logger Object 
		Logger log=MyLogger.getLogger(this);
		boolean serializeFlag = false;
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Office.txt"));
		log.info("Serialization process initiated");
		oos.writeObject(office);
		log.config("Closing file Stream...");
		oos.flush();
		oos.close();
		serializeFlag = true;
		log.info("Serialization completed Successfully");
		return serializeFlag;
	}

	@Override
	public boolean createComputer(Computer computer) throws FileNotFoundException, IOException, SQLException {
		// retrieving Logger Object 
		Logger log=MyLogger.getLogger(this);
		
		Connection con=DBConnector.getPostgreSQLConnection();
		boolean computerFlag=false;
		boolean officeFlag=false;
		boolean HdFlag=false;
		
		PreparedStatement pstmt=con.prepareStatement("select count(hardDiskNo) as count from hardDisk where hardDiskNo=?");
		pstmt.setInt(1, computer.getHardDisk().getHardDiskNo());
		ResultSet rs=pstmt.executeQuery();
		rs.next();
		int hdDuplicateFlag=rs.getInt("count");
		System.out.println("hdDuplicate flag: "+hdDuplicateFlag);
		
		PreparedStatement pstmt1=con.prepareStatement("select count(officeNo) as count from office where officeNo=?");
		pstmt1.setInt(1, this.officeId);
		ResultSet rs1=pstmt1.executeQuery();
		rs1.next();
		int officeDuplicateFlag=rs1.getInt("count");
		System.out.println("officeDuplicate flag: "+officeDuplicateFlag);
		
		HardDisk hd=computer.getHardDisk();
		if(hdDuplicateFlag==0) {
			hdDuplicateFlag=1;
			
		/* Callable statement to insert hard disk details */
		CallableStatement hd_cstmt=con.prepareCall("{?=call createHardDisk(?,?,?,?)}");
		
		log.config("Configuring Callable statement to insert HardDisk details");
		hd_cstmt.registerOutParameter(1, Types.BOOLEAN);
		hd_cstmt.setInt(2, hd.getHardDiskNo());
		hd_cstmt.setString(3, hd.getBrand());
		
		// converting LocalDate to sqlDate
		/*java.util.Date utilDate=java.util.Date.from(hd.getMfgDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		Date sqlDate=new Date(utilDate.getTime());
		*/
		hd_cstmt.setDate(4, java.sql.Date.valueOf(hd.getMfgDate())); 
		hd_cstmt.setString(5, hd.getCapacity());
		log.info("update Count: "+hd_cstmt.execute());
		HdFlag=hd_cstmt.getBoolean(1);
		log.info("HardDisk data persisted...");
		}
		
		if(officeDuplicateFlag==0) {
			officeDuplicateFlag=1;
			/* Callable statement to insert office details*/
		CallableStatement off_cstmt=con.prepareCall("{?=call createOffice(?,?)}");
		log.config("configuring Callable statement to insert office details");
		off_cstmt.registerOutParameter(1, Types.BOOLEAN);
		off_cstmt.setInt(2, this.officeId);
		off_cstmt.setString(3, this.officeName);
		log.info("update Count: "+off_cstmt.execute());
		officeFlag=off_cstmt.getBoolean(1);
		log.info("Office data persisted...");
		}
		
		if((HdFlag && officeFlag)||(hdDuplicateFlag==1 && officeDuplicateFlag==1)) {
			log.info("Validating HardDiskFlag: "+HdFlag);
			log.info("Validating officeFlag: "+officeFlag);
			/* Callable statement to insert computer details */
			CallableStatement comp_cstmt=con.prepareCall("{?=call createComputer(?,?,?,?)}");
			log.config("Configurating callable statement to insert computer data");
			comp_cstmt.registerOutParameter(1, Types.BOOLEAN);
			comp_cstmt.setInt(2, computer.getComputerId());
			comp_cstmt.setString(3, computer.getComputerName());
			comp_cstmt.setInt(4, hd.getHardDiskNo());
			comp_cstmt.setInt(5, this.officeId);
			log.info("update Count: "+comp_cstmt.execute());
			computerFlag=comp_cstmt.getBoolean(1);
			log.info("Computer Data persisted...");
		}
		
		return computerFlag;
	}

	@Override
	public Computer readComputer(int compId) throws FileNotFoundException, IOException, SQLException, ComputerNotFoundException {
		Computer foundComputer=null;
		Connection con=DBConnector.getPostgreSQLConnection();
		CallableStatement cstmt=con.prepareCall("{call readComputer(?,?,?,?,?,?)}");
		cstmt.setInt(1, compId);
		cstmt.registerOutParameter(2, Types.CHAR);
		cstmt.registerOutParameter(3, Types.INTEGER);
		cstmt.registerOutParameter(4, Types.CHAR);
		cstmt.registerOutParameter(5, Types.DATE);
		cstmt.registerOutParameter(6, Types.CHAR);
			
		if(!cstmt.execute())
			foundComputer=new Computer(compId,cstmt.getString(2),new HardDisk(cstmt.getInt(3),cstmt.getString(4),cstmt.getString(6),cstmt.getDate(5).toLocalDate()));
		else
			throw new ComputerNotFoundException();
		return foundComputer;
	}

	@Override
	public List<Computer> readComputers() throws FileNotFoundException, IOException, SQLException {
		ArrayList<Computer> computers=new ArrayList<Computer>();
		Connection con=DBConnector.getPostgreSQLConnection();
		CallableStatement cstmt=con.prepareCall("{call readComputer()}");
		ResultSet rs=cstmt.executeQuery();
		while (rs.next()) {
			computers.add(new Computer(rs.getInt("compNo"),rs.getString("compName"),new HardDisk(rs.getInt("hdNo"),rs.getString("hbrand"),cstmt.getString("size"),rs.getDate("hmfgdate").toLocalDate())));
		}
		
		
		return computers;
	}

	@Override
	public boolean updateComputer(Computer updatedComputer)  throws FileNotFoundException, IOException, SQLException{
		boolean updateFlag=false;
		Connection con=DBConnector.getPostgreSQLConnection();
		CallableStatement cstmt=con.prepareCall("{?=call updateComputer(?,?,?,?)}");
		cstmt.registerOutParameter(1, Types.BOOLEAN);
		cstmt.setInt(2,updatedComputer.getComputerId());
		cstmt.setString(3, updatedComputer.getComputerName());
		cstmt.setInt(4, updatedComputer.getHardDisk().getHardDiskNo());
		cstmt.setInt(5, this.officeId);
		
		cstmt.executeUpdate();
		updateFlag=cstmt.getBoolean(1);
		return updateFlag;
	}

	@Override
	public boolean deleteComputer(int compId) throws FileNotFoundException, IOException, SQLException {
		boolean deleteFlag=false;
		Connection con=DBConnector.getPostgreSQLConnection();
		CallableStatement cstmt=con.prepareCall("{?=call updateComputer(?)}");
		cstmt.registerOutParameter(1, Types.BOOLEAN);
		cstmt.setInt(2, compId);
		cstmt.executeUpdate();
		deleteFlag=cstmt.getBoolean(1);
		return deleteFlag;
	}

}
