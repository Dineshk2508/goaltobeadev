package com.htc.oms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.htc.oms.exceptions.EmptyFileException;

// Order management system
public class OrderManagement {

	public static void main(String[] args) throws IOException { // throwing IOException in main to make the code neat.

		// Input File Transaction
		File transactionFile = new File("Transaction.txt");
		// output files Ship and Pending
		File shipFile = new File("Ship.txt");
		File pendingFile = new File("Pending.txt");

		// FileReader for Transaction
		BufferedReader transactionReader = new BufferedReader(new FileReader(transactionFile));
		// FileWriter for Pending and Ship files
		BufferedWriter pendingWriter = new BufferedWriter(new FileWriter(pendingFile, true));
		BufferedWriter shipWriter = new BufferedWriter(new FileWriter(shipFile, true));

		boolean emptyFileExceptionFlag=false;
		if(transactionReader.read()==-1)
			try {
				throw new EmptyFileException("Input File should not be empty"); // exception with custom error message
			} catch (EmptyFileException e) {
				emptyFileExceptionFlag=true;
				System.out.println(e.getMessage());
			}
		
		
		// Counter Variables
		int transactionFileReadCounter=0;
		int productFileReadCounter=0;
		int pendingFileWriteCounter=0;
		int shippingFileWriteCounter=0;
		
		String transactionData = null;
		// Loop to read Transaction file data
		while ((transactionData = transactionReader.readLine()) != null) {
			if(emptyFileExceptionFlag)
				break;
			
			productFileReadCounter=0; // reset product File counter 
			
			transactionFileReadCounter++;  // transaction file Read counter
			String[] tsplitData = transactionData.split("/");
			String tproductId = tsplitData[1];

			// Input file Product
			File productFile = new File("Product.txt");
			// FileReader for Product
			BufferedReader productReader = new BufferedReader(new FileReader(productFile));

			if(productReader.read()==-1)
				try {
					throw new EmptyFileException();  // exception with default message
				} catch (EmptyFileException e) {
					emptyFileExceptionFlag=true;
					System.out.println(e.getMessage());
				}
			
			
			String productData = null;
			boolean foundFlag = false;
			// Loop to read Product file data
			while ((productData = productReader.readLine()) != null) {
				productFileReadCounter++;  // product File read counter
				if(emptyFileExceptionFlag)
					break;
				String[] psplitData = productData.split("/");
				String pproductId = psplitData[0];

				// Condition to check availability of product
				if (tproductId.equals(pproductId)) {
					foundFlag = true;
					// condition to check QuantityOnHand>QuantityOrdered
					if (Integer.parseInt(psplitData[2]) > Integer.parseInt(tsplitData[2])) {
			
						shipWriter.write(tsplitData[0]);
						double total = Integer.parseInt(tsplitData[2]) * Integer.parseInt(psplitData[3]);
						shipWriter.write(" " + total);
						shipWriter.write("\n");
						shippingFileWriteCounter++; // ship file write counter
						shipWriter.flush();

					} else { // else for QOH>QOR
						pendingWriter.write(tsplitData[0]);
						pendingWriter.write(" NS");
						pendingWriter.write("\n");
						pendingFileWriteCounter++; // pending file Write counter
						pendingWriter.flush();
					}

				}

			} // end of While loop reading product file
			productReader.close();  
			if (!foundFlag) { // else for transProdID==productID
				pendingWriter.write(tsplitData[0]);
				pendingWriter.write(" NA");
				pendingWriter.write("\n");
				pendingFileWriteCounter++; // pending file Write counter
				pendingWriter.flush();
				
			}

		} // end of While loop reading transaction file
		
		// closing file Reader and writer objects
		transactionReader.close();
		pendingWriter.close();
		shipWriter.close();
		
		
		System.out.println("Transaction File Read Counter: "+transactionFileReadCounter);
		System.out.println("Product File Read Counter: "+productFileReadCounter);
		System.out.println("Shipping File write Counter: "+shippingFileWriteCounter);
		System.out.println("Pending File write Counter: "+pendingFileWriteCounter);

	}

}
