package csvimp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CsvReader  {
public static void main(String[] args) {
	int orderid;
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the order is");
	orderid=sc.nextInt();
	if(orderid>0 && orderid<=3) {
		String filepath=filePathSelector(orderid);
		readCsv(filepath);
		
		
	}else {
		System.out.println("orderid is mismatch");
	}
	
}

public static String filePathSelector(int orderid)
{
	String filePathSelected=null;
	switch(orderid) {
	case 1:
		filePathSelected="z.txt";
		
		break;
	case 2:
		filePathSelected="ass.txt";
	
		
	break;
	case 3:
		filePathSelected="books.txt";
	
		
	break;
	
	
	}
	
	return filePathSelected;
}

	public static void readCsv(String filepath)  {
		//String searchtream ;
		BufferedReader reader=null;
		try {
			//Set<Student> student=new TreeSet<Student>();
			
			//based on compare to and asce1nding order
			 //HashSet<Student> student=new HashSet<Student>();  //random order
			LinkedHashSet<Student> student=new LinkedHashSet<Student>();  //insertion order
			String line="";
			reader=new BufferedReader(new FileReader(filepath));
			reader.readLine();
			while((line=reader.readLine()) !=null)
{
				String[] fields =line.split(",");
				if(fields.length>0) {
					Student students =new Student();
					students.setStudentId(Integer.parseInt(fields[0]));
					students.setFirstName(fields[1]);
					students.setLastName(fields[2]);
					student.add(students);
				}

}
			for(Student s:student) {
				System.out.printf("studentid=%-10d firstName=%-10s secondName=%-10s\n",s.getStudentId(),s.getFirstName(),s.getLastName());
			}
			
	
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			
		}
	}
	
}

