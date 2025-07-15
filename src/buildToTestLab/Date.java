package buildToTestLab;

import java.util.Scanner;

public class Date
{
    private String month;
    private int day;
    private int year; //a four digit number.

    public Date( )
    {
        this("January", 1, 1000);  // Could have used setDate instead
    }

    public Date(int monthInt, int day, int year)
    {
        setDate(monthInt, day, year);
    }

    public Date(String monthString, int day, int year)
    {
        setDate(monthString, day, year);
    }

    public Date(int year)
    {
        month = "January";
        day = 1;
        this.year = year;
    }

    public Date(Date aDate)
    {
        if (aDate == null)//Not a real date.
        {
             System.out.println("Fatal Error in Date(Date).");
             System.exit(0);
        }

        month = aDate.month;
        day = aDate.day;
        year = aDate.year;
    }

    public void setDate(int monthInt, int day, int year)
    {
        if (dateOK(monthInt, day, year))
        {
            this.month = monthString(monthInt);
            this.day = day;
            this.year = year;
        }
        else
        {
            System.out.println("Fatal Error in setDate(int, int, int)");
            System.exit(0);
        }
    }

    public void setDate(String monthString, int day, int year)
    {
        if (dateOK(monthString, day, year))
        {
            this.month = monthString;
            this.day = day;
            this.year = year;
        }
        else
        {
            System.out.println("Fatal Error in setDate(String,int, int)");
            System.exit(0);
        }
    }

    public void setDate(int year)
    {
        setDate(1, 1, year);
    }

    public void setYear(int year)
    {
        if ( (year < 1000) || (year > 9999) )
        {
            System.out.println("Fatal Error in setYear(int)");
            System.exit(0);
        }
        else
            this.year = year;
    }
    public void setMonth(int monthNumber)
    {
        if ((monthNumber <= 0) || (monthNumber > 12))
        {
            System.out.println("Fatal Error in setMonth(int)");
            System.exit(0);
        }
        else
            month = monthString(monthNumber);
    }

    public void setDay(int day)
    {
        if ((day <= 0) || (day > 31))
        {
            System.out.println("Fatal Error in setDay(int)");
            System.exit(0);
        }
        else
            this.day = day;
    }

    public int getMonth( )
    {
        if (month.equals("January"))
            return 1;
        else if (month.equals("February"))
            return 2;
        else if (month.equalsIgnoreCase("March"))
            return 3;
        else if (month.equalsIgnoreCase("April"))
            return 4;
        else if (month.equalsIgnoreCase("May"))
            return 5;
        else if (month.equals("June"))
            return 6;
        else if (month.equalsIgnoreCase("July"))
            return 7;
        else if (month.equalsIgnoreCase("August"))
            return 8;
        else if (month.equalsIgnoreCase("September"))
            return 9;
        else if (month.equalsIgnoreCase("October"))
            return 10;
        else if (month.equals("November"))
            return 11;
        else if (month.equals("December"))
            return 12;
        else
        {
            System.out.println("Fatal Error in getMonth");
            System.exit(0);
            return 0; //Needed to keep the compiler happy
        }
    }

    public int getDay( )
    {
        return day;
    }

    public int getYear( )
    {
        return year;
    }

    public String toString( )
    {
        return (month + " " + day + ", " + year);
    }
    
    // assertEquals did not use the previous version of equals. edited to override the object method.
    @Override
    public boolean equals(Object obj)// edited: Date otherDate)
    {
    	Date otherDate = (Date) obj; // added
        return ( (month.equals(otherDate.month))
                  && (day == otherDate.day) && (year == otherDate.year) );
    }

    public boolean precedes(Date otherDate)
    {
        return ( (year < otherDate.year) ||
           (year == otherDate.year && getMonth( ) < otherDate.getMonth( )) ||
           (year == otherDate.year && month.equals(otherDate.month)
                                         && day < otherDate.day) );
    }

    public void readInput( )
    {
        boolean tryAgain = true;
        Scanner keyboard = new Scanner(System.in);
        while (tryAgain)
        {
            System.out.println("Enter month, day, and year.");
              System.out.println("Do not use a comma.");
            String monthInput = keyboard.next( );
            int dayInput = keyboard.nextInt( );
            int yearInput = keyboard.nextInt( );
            if (dateOK(monthInput, dayInput, yearInput) )
            {
                setDate(monthInput, dayInput, yearInput);
                tryAgain = false;
            }
            else
                System.out.println("Illegal date. Reenter input.");
         }
    }

    private boolean dateOK(int monthInt, int dayInt, int yearInt)
    {
        return ( (monthInt >= 1) && (monthInt <= 12) &&
                 (dayInt >= 1) && (dayInt <= 31) &&
                 (yearInt >= 1000) && (yearInt <= 9999) );
    }

    private boolean dateOK(String monthString, int dayInt, int yearInt)
    {
        return ( monthOK(monthString) &&
                 (dayInt >= 1) && (dayInt <= 31) &&
                 (yearInt >= 1000) && (yearInt <= 9999) );
    }

    private boolean monthOK(String month)
    {
        return (month.equals("January") || month.equals("February") ||
                month.equals("March") || month.equals("April") ||
                month.equals("May") || month.equals("June") ||
                month.equals("July") || month.equals("August") ||
                month.equals("September") || month.equals("October") ||
                month.equals("November") || month.equals("December") );
    }

    private String monthString(int monthNumber)
    {
        switch (monthNumber)
        {
        case 1:
            return "January";
        case 2:
            return "February";
        case 3:
            return "March";
        case 4:
            return "April";
        case 5:
            return "May";
        case 6:
            return "June";
        case 7:
            return "July";
        case 8:
            return "August";
        case 9:
            return "September";
        case 10:
            return "October";
        case 11:
            return "November";
        case 12:
            return "December";
        default:
            System.out.println("Fatal Error in monthString");
            System.exit(0);
            return "Error"; //to keep the compiler happy
        }
    }
    
    // added for lab: JUnit Simple Design to Test
    public Date addOneDay() {
    	System.out.println("Date.addOneDay(): working on implementation.");
    	if (isLeapYear() && month == "February") {
    		if (day == 29) {
    			month = "March";
    			day = 1;  
    			return this;
    		}
    		else {
    		day += 1;
    		return this;
    		}
    	}
    	if (month == "Janurary" || month == "March" || month == "May" || month == "July" || 
    			month == "August" || month == "October" || month == "December") {
    		if (day < 31) {
    		day += 1;
    		return this;
    		}
    		else {
    			int numMonths = (getMonth() + 1) % 12;
    			if (numMonths == 0) {
    				month = "December";
    				day = 1;
    				return this;
    			}
    			setMonth(numMonths);
    			day = 1;
    			return this;
    		}
    	}
    	if (day < 30) {
    		day += 1;
    		return this;
    	}
    	else {
    		int numMonths = (getMonth() + 1) % 12;
    		setMonth(numMonths);
    		day = 1;
    		return this;
    	}
    }
    
    // helper. added for lab.
    public boolean isLeapYear() {
    	if (year % 100 == 0 && year % 400 == 0) {
    		return true;
    	}
    	if (year % 4 == 0) {
    		return true;
    	}
    	return false;
    }
    
    // notes for lab
    // 31 days: January, March, May, July, August, October, December
    // 30 days: April, June, September, November
    // 28 days: February
    // 29 days: February (leap year)
    // leap year: every year that is exactly divisible by 4.  EXCEPT for years that are exactly divisible by 100.
    //            But if the centurial years are divisible by 400 then those years ARE leap years.
    
    
    public static void main(String[] args) {
        System.out.println("Main in Date.");
        Date tester = new Date();
        System.out.println("tester is "+tester);
        
        // everything below added for the lab for basic testing to implement functions addOneDay() and setDate(String, int, int)
        Date dateA = new Date(7, 14, 1700);  
        Date dateB = new Date(7, 14, 1600); 
        Date dateC = new Date(7, 14, 2024);
        Date dateD = new Date(2, 29, 2024);
        
        System.out.println("is leap year? Expecting: false, actual: " + dateA.isLeapYear());
        System.out.println("is leap year? Expecting: true, actual: " + dateB.isLeapYear());
        System.out.println("is leap year? Expecting: true, actual: " + dateC.isLeapYear());
        
        dateC.addOneDay();
        System.out.println(dateC);
        dateD.addOneDay();
        System.out.println(dateD);
    }
}
