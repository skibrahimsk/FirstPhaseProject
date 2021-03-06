package com.lockedme;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompanyProject
{
	static final String folderpath="D:\\MyFirstProject\\ProjectFiles";
	public static void main(String[] args) 
	{
		int proceed=1;
		do
			{
				//variable declaration
				Scanner obj =new Scanner(System.in);
				int c;
				
				//Menu
				displayMenu();
				System.out.println("Enter your choice:");
				c=Integer.parseInt(obj.next());
				
				switch(c)
				{
					case 1: getAllFiles();
								break;
					case 2: createFile();
								break;
					case 3:	deleteFile();
								break;
					case 4: searchFile();
								break;
					case 5: System.exit(0);
								break;
					default: System.out.println("Invalid Option");
				}
				//obj.close();
			}
	while(proceed>0);
	}
	

    public static void displayMenu()
    {
    	System.out.println("*******************************************");
		System.out.println("\t\tCompany Locked Pvt.Ltd.");
		System.out.println("*******************************************");
		System.out.println("1.Display all files\n2.Add new File\n3.Delete a File\n4.Search a File\n5.Exit");
		System.out.println("*******************************************");
		
    }
   
	public static void getAllFiles()
	{
		//Getting File Name
		List<String> fileNames=FileManger.getAllFiles(folderpath);
		if(fileNames.size()==0)
		{
			System.out.println("NO Files exists in Directory");
		}
		else
		{
			System.out.println("Files List below :\n");
		for(String f:fileNames)
			System.out.println(f);
		}
	}
	
	public static void createFile()
	{
				//Variable declaration
				Scanner obj=new Scanner(System.in);
				String fileName;
				int linesCount;
				List<String> content =new ArrayList<String>();
				
				//Read file name from user
				System.out.println("ENTER FILE NAME:");
				fileName=obj.nextLine();
				
				//Read number of line from user
				System.out.println("Enter how many line in the files:");
				linesCount=Integer.parseInt(obj.nextLine());
				
				//Read lines from user
				for(int i=1;i<=linesCount;i++)
				{
					System.out.println("ENTER LINE"+i+":");
					content.add(obj.nextLine());
				}
				
				//save the content into the file
				boolean isSaved=FileManger.createFiles(folderpath,fileName,content);
				
				if(isSaved)
					System.out.println("File and data saved succesfully");
				else
					System.out.println("some error occured.Please contact admin@sk.com");
			
				
				
	}
	
	public static void deleteFile()
	{	
				//Deleting file and creating file obj
				String fileName;
				Scanner obj=new Scanner(System.in);
			
				//Read file name from user
				System.out.println("Enter file name to delete:");
				fileName=obj.nextLine();
				
				boolean isDeleted =FileManger.deleteFile(folderpath, fileName);
					
				if(isDeleted)
					System.out.println("file is Deleted Sucessfully");
				else
					System.out.println("file not found ");
		

	}
	
	public static void searchFile()
	{
		//Code for Searching  a file
				String fileName;
				Scanner obj=new Scanner(System.in);
			
				//Read file from user
				System.out.println("Enter file name to search:");
				fileName=obj.nextLine();
				
				boolean isFound =FileManger.searchFile(folderpath, fileName);
					
				if(isFound)
					System.out.println("file is present ");
				else
					System.out.println("file not present ");
				

	}
	

}
