package searchcsv;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ReadSearchcsv {

	
	
	private static Scanner x;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
String filepath="ass.txt";
String searchtream = null;
Scanner sc=new Scanner(System.in);
System.out.println("enter details");
searchtream=sc.next();
readRecord(searchtream,filepath);
		
	}
	
	public static void readRecord(String searchtream,String filepath)
	{
		boolean found=false;
		String studentId="";  String firstName=""; String LastName="";
		
		
		try {
			x=new Scanner(new File(filepath));
			x.useDelimiter("[,\n]");
			while(x.hasNext() && !found) {
				//studentId=x.next(Integer.parseInt);
				//students.setStudentId(Integer.parseInt(fields[0]));
				firstName=x.next();
				 LastName=x.next();
				 if(firstName.equals(searchtream)) {
					 found=true;
				 }
				 
			}
			 
		
			
			if(found) {
				System.out.println("FirstName:"+firstName+"   "   +"LastName:"+LastName);
			}
			else {
				System.out.println("Record Not Found");
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Error");
			
		}
	}

}
//studentId firstName LastName