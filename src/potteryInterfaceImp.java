//--------------------------------------------------
//	IMPORTS
//--------------------------------------------------
import java.io.*;

//--------------------------------------------------
//
//	CLASS potteryInterfaceImp
//
//--------------------------------------------------
//This class implements the outlined methods in the potteryInterface class
public final class potteryInterfaceImp implements potteryInterface {


	public void Read(File _file){
		try{
			BufferedReader BR = new BufferedReader(new InputStreamReader(new FileInputStream(_file)));
			String line = "";
			while ((line = BR.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	public void Write(File _file, String _data){
		try {
			PrintWriter printWriter = new PrintWriter(new FileWriter(_file, true), true);
			printWriter.println(_data);
			printWriter.close();
		}
		catch(Exception e){System.out.println("Sorry but the file cannot be created for writing to it" + e);}
	}



	public void Remove(File _file, String _data){
		// Creates two files one to read from and another to write to
		File tempFile = new File(_file + ".tmp");
try {
	// Open both files for reading or writing
	BufferedReader reader = new BufferedReader(new FileReader(_file));
	BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

	// Read each line from the original file
	String currentLine;
	while ((currentLine = reader.readLine()) != null) {
		// If the current line does not contain the search string,
		// write it to the temporary file
		if (!currentLine.split(",")[0].equals(_data)) {
			writer.write(currentLine);
			writer.newLine();
		}
	}

	// Close the reader and writer
	reader.close();
	writer.close();
	// Delete the original file and rename the temp file to the original name
	if(_file.delete()){
		System.out.println("File Successfully deleted");
	}else{System.out.println("Error");}
	tempFile.renameTo(_file);
	}catch(Exception e){System.out.println("Sorry, " + e);}
	}
}