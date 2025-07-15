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

    // edited for the lab: return has been updated to Date and the fatal message has been updated to just return null
    public Date setDate(String monthString, int day, int year)
    {
        if (dateOK(monthString, day, year))
        {
            this.month = monthString;
            this.day = day;
            this.year = year;
            return this;
        }
        else
        {
        	return null;
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
    
    // edited for lab: assertEquals did not use the previous version of equals. edited to override the object method.
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
    
    // edited for lab assignment for Months that have 31 days vs 30 days. Also included leap years.
    private boolean dateOK(String monthString, int dayInt, int yearInt)
    {
        if (!monthOK(monthString) && (yearInt >= 1000) && (yearInt <= 9999)) {
        	return false;
        }
        
        String origMonth = this.month;
        this.month = monthString;
        int monthInInt = getMonth();
        this.month = origMonth;
        int maxDay = daysInMonth(monthInInt, yearInt);
        
        return dayInt >= 1 && dayInt <= maxDay;
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
      int monthInInt = getMonth();
      int maxNumDays = daysInMonth(monthInInt, year);

      if (day < maxNumDays) {
      	day += 1;
      } 
      else {
      	day = 1;
        if (monthInInt == 12) {
        	month = "January";
          year += 1;
          } 
          else {
          	setMonth(monthInInt + 1);  
          }
      	}
      return this;
    }
    
    // added for lab: helper. added for lab to determine leap year.
    private boolean isLeapYear(int year) {
    	if (year % 100 == 0 && year % 400 == 0) {
    		return true;
    	}
    	if (year % 4 == 0) {
    		return true;
    	}
    	return false;
    }
    
    // added for lab: helper. recommended use of an array daysInMonth to simplify changes.
    private int daysInMonth(int month, int year) {
    	// for simplicity index 0 is not used then 1-12 for the corresponding months
    	int febLeapYear = 29;
      int[] daysInMonth = { 0, 31, 28, 31, 30, 31,30, 31, 31, 30, 31, 30, 31 };
      
      if (month == 2 && isLeapYear(year)) {
      	return febLeapYear;
      }
      return daysInMonth[month];
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
    }
}
