import java.util.*;
public class Diary 
{
	public String name;
	public String date;
	public String time;
    public String place;
    public String data;
    public Diary next;
    public Diary(String name,String date,String time,String place,String data)
    {
    	this.name=name;
    	this.date=date;
    	this.time=time;
    	this.place=place;
    	this.data=data;
    }
    public void display()
    {
    	System.out.println(name);
    	System.out.println(date);
    	System.out.println(time);
    	System.out.println(place);
    	System.out.println(data);
    }
    public static boolean isValid(String password) 
    {
        Boolean atleastOneLower=false;
        Boolean atleastOneDigit=false;
        if(password.length()<8) 
        { 
            return false;
        }
        for(int i=0;i<password.length();i++) 
        { 
            if (Character.isLowerCase(password.charAt(i))) 
            {
                atleastOneLower = true;
            }
            else if (Character.isDigit(password.charAt(i))) 
            {
                atleastOneDigit = true;
            }
        }
        return(atleastOneLower&&atleastOneDigit);
    }
    public String toString()
    {
    	return date;
    }
    public static void main(String[] args) 
	{
		String Name;
		String Date=null;
		String Time;
		String Place;
		String Data;
	    String password;
	    String confirm;
		int choice;
		char ch;
		char ch1;
		char ch2;
		char ch3;
		char ch4;
		String str;
		Scanner s=new Scanner(System.in);
		linklist ll=new linklist();
		System.out.println("------PASSWORD PROTECTED PERSONAL DIARY------");
		System.out.println("****SET PASSWORD****");
		System.out.println("....There should be minimum 8 characters and should contains a numeric value too....");
		System.out.print("Please enter password : ");
        password=s.next();
        System.out.print("Please re-enter the password to confirm : ");
        confirm=s.next();
        boolean condition;
        condition=isValid(password);
        while(!password.equals(confirm)&&(!condition)) 
        {
            System.out.println("The password is invalid");
            System.out.println("Please enter the password again : ");
            String Password=s.nextLine();
            System.out.println("Please re-enter the password to confirm : ");
            String Confirm=s.nextLine();
        }
        if (isValid(password)) 
        {
            System.out.println("The password is valid");
        }
	    while(true)
		{
			System.out.println("------PASSWORD PROTECTED PERSONAL DIARY------");
		    System.out.println("Enter Password : ");
		    password=s.next();
		    if (password.equals(confirm)) 
		    {
                System.out.println("Access Granted... Welcome");
                System.out.println("1.ADD RECORD");
    			System.out.println("2.DELETE FIRST RECORD");
    			System.out.println("3.VIEW RECORD");
    			System.out.println("4.SEARCH RECORD");
    			System.out.println("5.DELETE RECORD");
    			System.out.println("-----Enter your choice-----");
    			choice=s.nextInt();
    			switch(choice)
    			{	
    		    case 1:
    			{
    				do
    				{
    					System.out.println("***Enter name***");
        				Name=s.next();
        				System.out.println("***Enter date***");
        				Date=s.next();
        				System.out.println("***Enter time***");
        				Time=s.next();
        				System.out.println("***Enter place***");
        				Place=s.next();
        				System.out.println("***Enter data***");
        				Data=s.nextLine();
        				Data=s.nextLine();
        				ll.insertlink(Name,Date,Time,Place,Data);
        				System.out.println("Do you want to add more records : y/n");
    			        ch4=s.next().charAt(0);
    				}
   			  while(ch4=='y');
			  break;    				
    			}
    			case 2:
    			{
    				System.out.println("***Do you want to remove first record : y/n***");
    				ch3=s.next().charAt(0);
    				if(ch3=='y')
    				{
    				    ll.remove();
    				}
    				System.out.println("RECORD DELETED SUCCESSFULLY...!!!");
    				break;
    			}
    			case 3:
    			{
    				do
    					{
    					    System.out.println("***(a)View whole record***");
    				        System.out.println("***(b)View Record according to date***");
    				        System.out.println("Enter choice : ");
    				        ch1=s.next().charAt(0);
    				        if(ch1=='a')
    				        {
    				            ll.display();
    				        }
    				        else if(ch1=='b')
    				        {
    				            ll.displaydat();
    				        }
    				        System.out.println("Do you want to view more records : y/n");
    				        ch2=s.next().charAt(0);
    					}
    				while(ch2=='y');
    				break;
    			}
    			case 4:
    			{
    				System.out.println("***Search Record according to date***");
    				System.out.println("Enter date : ");
    				Date=s.next();
    				ll.find(Date);
    				System.out.println(Date +" date found");
    				ll.displaydat();
    				break;
    			}
    			case 5:
    			{
    				System.out.println("***Delete Record ccording to date***");
    				System.out.println("Enter date : ");
    				Date=s.next();
    				ll.del(Date);
    				System.out.println("RECORD DELETED SUCCESSFULLY...!!!");
    				break;
    			}
    			default:
    			{
    				System.out.println("Wrong Choice");
    				break;
    			}
    			}
    			System.out.println("do you want to continue : yes/no :");
    			str=s.next();
		    }
		    else 
		    {
		        System.out.println("Invalid Password");
		    }	
			
		}
		/*while(str=="yes");*/
	}
}
class linklist
{
	public Diary start;
	linklist()
	{
		start=null;
	}
	public boolean isEmpty()
	{
		return(start==null);
	}
	public void insertlink(String name,String date,String time,String place,String data)
	{
		Diary temp=new Diary(name,date,time,place,data);
		temp.next=start;
		start=temp;
	}
	public Diary remove()
	{
		Diary temp1=start;
		if(!isEmpty())
		{
			start=start.next;
		}
		else
		{
			System.out.println("empty linked list");
		}
		return temp1;
	}
	public void display()
	{
		Diary temp2=start;
		if(start==null)
		{
			System.out.println("---NO RECORD FOUND---");
		}
		while(temp2!=null)
		{
			temp2.display();
			temp2=temp2.next;
			System.out.println();
		}
	}
	public Diary find(String date)
	{
		Diary temp2=start;
		if(!isEmpty())
		{
			while(temp2.date!=date)
			{
				if(temp2.next==null)
				{
					return null;
				}
				else
				{
					temp2=temp2.next;
				}
			}
		}
		else
		{
			System.out.println("empty linked list");
		}
		return temp2;
	}
	public Diary del(String date)
	{
		Diary currentlink=start;
		Diary prevlink=start;
		while(currentlink.date.equals(date) == false)
		{
			if(currentlink.next==null)
			{
				return null;
			}
			else
			{
				prevlink=currentlink;
				currentlink=currentlink.next;
			}
		}
		if(currentlink==start)
		{
			start=start.next;
		}
		else
		{
			prevlink.next=currentlink.next;
		}
		return currentlink;
	}
	public Diary displaydat()
	{
		String date=null;
		Scanner s1=new Scanner(System.in);
		Diary temp2=start;
		System.out.println("enter date : ");
		date=s1.nextLine();
		if(start==null)
		{
			System.out.println("--NO DATA PRESENT--");
		}
		else
		{
			while(temp2!=null)
			{
				while(temp2.date.equals(date))				
				{
					if(temp2.date.equals(date))
					{	
						System.out.println(temp2.name);
						System.out.println(temp2.date);
						System.out.println(temp2.time);
						System.out.println(temp2.place);
						System.out.println(temp2.data);
					}
					else
					{
						System.out.println("DATE NOT FOUND");
					}
					temp2=temp2.next;
				}
				
				temp2=temp2.next;
				System.out.println();
			}
		}
		
		return temp2;
	}
	
}
   