CREATE TABLE HardDisk(hardDiskNo INT PRIMARY KEY, 
		      hardDiskBrand CHAR(20),
		      mfgDate Date,
		      capacity CHAR(20));

CREATE TABLE Office(officeNo INT PRIMARY KEY,
		    officeName CHAR(20));

CREATE TABLE COMPUTER(computerNo INT PRIMARY KEY,
		      computerName CHAR(20),
		      hardDiskNo INT REFERENCES HardDisk(hardDiskNo),
		      officeNo INT REFERENCES Office(officeNo));



INSERT INTO HardDisk VALUES(10,'GigaByte','2018-10-08','500GB');
INSERT INTO Office VALUES(1000,'HTC');
INSERT INTO Computer VALUES(100,'IMPC100',10,1000);


SELECT * FROM Office;
SELECT * FROM Computer;
SELECT * FROM HardDisk;

truncate computer,harddisk,office;

------------------------------------------------------------------------------------------
			   
CREATE OR REPLACE FUNCTION createHardDisk(hdNo INT, brand CHAR(20),mfg_date DATE, size CHAR(20))
RETURNS BOOLEAN AS $$
DECLARE
	insertFlag BOOLEAN;
	duplicateFlag INT;
BEGIN

	SELECT COUNT(hdNo) INTO duplicateFlag FROM hardDisk WHERE hardDiskNo=hdNo;
	IF(duplicateFlag=1) THEN
		insertFlag:=false;
	ELSE
		INSERT INTO HardDisk VALUES(hdNo,brand,mfg_date,size);
		insertFlag:=true;
	END IF;
	RETURN insertFlag;
END;
$$ LANGUAGE PLPGSQL;


SELECT createHardDisk(10,'GigaByte','2018-10-08','500GB');

-------------------------------------------------------------------------------------------


CREATE OR REPLACE FUNCTION createOffice(offNo INT, name CHAR(20))
RETURNS BOOLEAN AS $$
DECLARE
	insertFlag BOOLEAN;
	duplicateFlag INT;
BEGIN

	SELECT COUNT(offNo) INTO duplicateFlag FROM office WHERE officeNo=offNo;
	IF(duplicateFlag=1) THEN
		insertFlag:=false;
	ELSE
		INSERT INTO office VALUES(offNo,name);
		insertFlag:=true;
	END IF;
	RETURN insertFlag;
END;
$$ LANGUAGE PLPGSQL;

SELECT createOffice(1000,'HTC');

-----------------------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION createComputer(compNo INT, name CHAR(20),diskno INT, offNo INT)
RETURNS BOOLEAN AS $$
DECLARE
	insertFlag BOOLEAN;
	duplicateFlag INT;
	diskFlag INT;
	officeFlag INT;
BEGIN

	SELECT COUNT(computerNo) INTO duplicateFlag FROM computer WHERE computerNo=compNo;
	IF(duplicateFlag=1) THEN
		insertFlag:=false;
	ELSE
		SELECT COUNT(hardDiskNo) INTO diskFlag FROM HardDisk WHERE hardDiskNo=diskno;
		SELECT COUNT(officeNo) INTO officeFlag FROM office WHERE officeNo=offNo;
		IF(diskFlag=1 AND officeFlag=1) THEN
			INSERT INTO Computer VALUES(compNo,name,diskno,offNo);
			insertFlag:=true;
		END IF;
	END IF;
	RETURN insertFlag;
END;
$$ LANGUAGE PLPGSQL;


SELECT createComputer(102,'IMPC102',12,1001);

-----------------------------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION readComputer(IN compNo INT,OUT compName CHAR(20),OUT hdNo INT,OUT hbrand CHAR(20),OUT hmfgdate DATE,OUT size CHAR(20))
RETURNS RECORD AS $$
DECLARE
		
BEGIN

	SELECT c.computerName,h.hardDiskNo,h.hardDiskBrand,h.mfgDate,h.capacity INTO compName,hdNo,hbrand,hmfgdate,size FROM Computer c INNER JOIN hardDisk h ON c.hardDiskNo=h.hardDiskNo  WHERE c.computerNo=compNo;
	
	RETURN ;
END;
$$ LANGUAGE PLPGSQL;


select * from readComputer(100);

------------------------------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION readComputers()
RETURNS TABLE(compNo INT,compName CHAR(20),hdNo INT,hbrand CHAR(20),hmfgdate DATE,size CHAR(20)) AS $$
DECLARE
		
BEGIN

	RETURN QUERY SELECT c.computerNo,c.computerName,h.hardDiskNo,h.hardDiskBrand,h.mfgDate,h.capacity  FROM Computer c INNER JOIN hardDisk h ON c.hardDiskNo=h.hardDiskNo;

END;
$$ LANGUAGE PLPGSQL;

select * from readComputers();

---------------------------------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION updateComputer(compNo INT,compName CHAR(20),hdNo INT,offNo INT)
RETURNS BOOLEAN AS $$
DECLARE

	updateFlag BOOLEAN;
	duplicateFlag INT;
	diskFlag INT;
	officeFlag INT;
		
BEGIN

	SELECT COUNT(computerNo) INTO duplicateFlag FROM computer WHERE computerNo=compNo;
	IF(duplicateFlag!=1) THEN
		updateFlag:=false;
	ELSE
		SELECT COUNT(hardDiskNo) INTO diskFlag FROM HardDisk WHERE hardDiskNo=hdNo;
		SELECT COUNT(officeNo) INTO officeFlag FROM office WHERE officeNo=offNo;
		IF(diskFlag=1 AND officeFlag=1 AND duplicateFlag=1) THEN
			UPDATE Computer SET computerName=compName,hardDiskNo=hdNo,officeNo=offNo WHERE computerNo=compNo;
			updateFlag:=true;
		END IF;
	END IF;
	
	RETURN updateFlag;
END;
$$ LANGUAGE PLPGSQL;


SELECT updateComputer(100,'newName',10,1000);

-----------------------------------------------------------------------------------------------------------


CREATE OR REPLACE FUNCTION deleteComputer(compNo INT)
RETURNS BOOLEAN AS $$
DECLARE
	deleteFlag BOOLEAN;
	foundFlag INT;
BEGIN

	DELETE FROM computer WHERE computerNo=compNo;
	SELECT computerNo INTO foundFlag FROM Computer WHERE ComputerNo=compNo;
	IF(foundFlag=1) THEN
		deleteFlag=false;
	ELSE
		deleteFlag=true;
	END IF;
	RETURN deleteFlag;

END;
$$ LANGUAGE PLPGSQL;

select deleteComputer(100);
------------------------------------------------------------------------------------------------------------------


