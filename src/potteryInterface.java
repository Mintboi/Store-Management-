//--------------------------------------------------
//
//	INTERFACE potteryInterface
//
//--------------------------------------------------

import java.io.File;

/**
 * This is the main interface for the A03 shop assignment
 */



public interface potteryInterface{
	//---------------------------------------
	//	View
	//---------------------------------------
	/**
	 * This method lets the user view whatever is in the text file at the _filePath endpoint<br>
	 * @param _file - The location of the file to be read.
	 * @return the information in the read file
	 */
	void Read(File _file);
	//---------------------------------------
	//	Write
	//---------------------------------------
	/**
	 * This method Writes the given information string to the file at the filePath
	 * @param _file,- The location of the file to be written.
	 * @param _data - The data to be Written
	 * @return writes to the given file and returns an exception if writing is unavailable
	 */
	public void Write(File _file, String _data);

	//---------------------------------------
	//	Remove
	//---------------------------------------
	/**
	 * This method Writes the given information string to the file at the filePath
	 * @param _file,- The location of the file to be written.
	 * @param _data - The data to be searched for and removed
	 * @return Removes the given line from the text file and then prints from the temp file to the original
	 */
	public void Remove(File _file, String _data);

}