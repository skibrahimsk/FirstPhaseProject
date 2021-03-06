package com.lockedme;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileManger 
{
	/**
	 * This method return file names
	 * @param folderpath
	 * @return list<String>
	 */
	public static List<String>  getAllFiles(String folderpath)
	{
	
		//Creating File Object 
		File f1 =new File(folderpath);
		
		//Getting all the files into FileArray
		File[] listofFiles =f1.listFiles();
		
		//Declare a list to store file names
		List<String> fileNames =new ArrayList<String>();
			for(File f:listofFiles)
			{
					fileNames.add(f.getName());
			}
		//return
		return fileNames;
}
	/**
	 * This method is for create content in files
	 * @param folderpath
	 * @param fileName
	 * @param content
	 * @return boolean
	 */
	
	public static boolean createFiles(String folderpath,String fileName,List<String> content)
	{
		//create files in folder
		try
		{
			File fl=new File(folderpath,fileName);
			FileWriter fw=new FileWriter(fl);
			for(String s:content)
			{
				fw.write(s+"\n");
			}	
			fw.close();
			return true;
		}
	//return false if file is not created
		catch(Exception ex)
		{
			return false;
		}
	}
	/**
	 * This Method is for Deleting files 
	 * @param folderpath
	 * @param fileName
	 * @return boolean
	 */
	public static boolean deleteFile(String folderpath,String fileName)
	{
		//create path for deleting file
		File file=new File(folderpath+"\\"+fileName);
		try
		{
			if(file.delete())
				return true;
			else
				return false;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	/**
	 * This Method is for Searching  files 
	 * @param folderpath
	 * @param fileName
	 * @return boolean
	 */
	public static boolean searchFile(String folderpath,String fileName)
	{
		//create file search option and file object
		File file=new File(folderpath+"\\"+fileName);
		if(file.exists())
			return true;
		else
			return false;
	}
}
