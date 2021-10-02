import java.util.*;
public class calendar{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter ur choice:");
        System.out.println("1-Month Calendar\n2-Year Calendar");
        int choice=sc.nextInt();
        if(choice==1){
            System.out.print("Enter the month : ");
            int month=sc.nextInt();
            System.out.print("Enter the year : ");
            int year=sc.nextInt();
            calendar.ShowCalendar.MonthCalendar(month,year);
        }
        if(choice==2){
            System.out.print("Enter the Year : ");
            int year=sc.nextInt();
            calendar.ShowCalendar.YearCalendar(year);
        }
        sc.close();
    }
    public static class ShowCalendar{
        static void MonthCalendar(int month,int year){
            String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            int daysInMonth[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            GregorianCalendar calendar = new GregorianCalendar(year,month,1);
            System.out.println("Month = "+months[month]+" , Year = "+year);
            boolean leap=calendar.isLeapYear(year);
            if(leap==true){
                daysInMonth[1]=29;
            }
            calendar.set(Calendar.DATE,1);
            int dayOfFirst = calendar.get(Calendar.DAY_OF_WEEK);
            int weekFirst = calendar.getFirstDayOfWeek();
            int maxDays = daysInMonth[month];
            int diff=dayOfFirst-weekFirst;
            String weeks = "Sun \t Mon \t Tue \t Wed \t Thu \t Fri \t Sat";
            System.out.println(weeks);
            for(int i=0;i<diff;i++){
                System.out.print("\t");
            }
            int weekday=0;
            for (int j=0; j<maxDays; j++) {
                System.out.print(calendar.get(Calendar.DATE)+"\t");
                weekday =calendar.get(Calendar.DAY_OF_WEEK);
                if(weekday>6){
                    System.out.println();
                }
                calendar.add(Calendar.DATE , 1);
            }
            System.out.println();
        }
        public static void YearCalendar(int year){
            String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            int daysInMonth[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            for(int i=0;i<12;i++){
                int month=i;
                System.out.println("\t\t"+months[month]+" "+year);
                GregorianCalendar cal = new GregorianCalendar(year,month,1);
                boolean leap=cal.isLeapYear(year);
                if(leap==true){
                daysInMonth[1]=29;
            }
            cal.set(Calendar.DATE,1);
            int dayOfFirst = cal.get(Calendar.DAY_OF_WEEK);
            int weekFirst = cal.getFirstDayOfWeek();
            int maxDays = daysInMonth[month];
            int diff=dayOfFirst-weekFirst;
            String weeks = "Sun \t Mon \t Tue \t Wed \t Thu \t Fri \t Sat";
            System.out.println(weeks);
            for(int j=0;j<diff;j++){
                System.out.print("\t");
            }
            int weekday=0;
            for (int j=0; j<maxDays; j++) {
                System.out.print(cal.get(Calendar.DATE)+"\t");
                weekday =cal.get(Calendar.DAY_OF_WEEK);
                if(weekday>6){
                    System.out.println();
                }
                cal.add(Calendar.DATE , 1);
            }
            System.out.println();
            }
        }
    }
}