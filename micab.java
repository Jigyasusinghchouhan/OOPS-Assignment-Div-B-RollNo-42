import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

class PrintMesg {
    void WelcomeMesg() {
        for (int i = 1; i < 100; i++) {
            System.out.print("*");
        }

        System.out.println();
        System.out.println("WELCOME TO RIDE-SHARING CHARGES ESTIMATOR AND COMPARISON SYSTEM");
        System.out.println();
        System.out.println("Developed by Jigyasu singh, 42");
        System.out.println("OODP101 Object Oriented Desgin And Programming");
        java.util.Date date = new java.util.Date();
        System.out.println(date);

        for (int i = 1; i < 100; i++) {
            System.out.print("*");
        }

    }

}

class information {
    private int DateOfTravel;

    public int getDay() {
        return DateOfTravel;
    }

    public void setDay(int DateOfTravel) {
        this.DateOfTravel = DateOfTravel;
    }

    private int MonthOfTravel;

    public int getMonth() {
        return MonthOfTravel;
    }

    public void setMonth(int MonthOfTravel) {
        this.MonthOfTravel = MonthOfTravel;
    }

    private int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private float ApproximateKilometerTravel;

    public float getKilometers() {
        return ApproximateKilometerTravel;
    }

    public void setKilometers(float ApproximateKilometerTravel) {
        this.ApproximateKilometerTravel = ApproximateKilometerTravel;
    }

    private int time;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    private DayOfWeek dayOfWeek;

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}

class UserDetails extends information {
    Scanner input = new Scanner(System.in);
    String UserName;
    float ApproximateKilometerTravel;
    int MonthOfTravel;
    int DateOfTravel;
    int TimeOfTravel;
    int year = 2021;
    DayOfWeek dayOfWeek;

    void input() {
        System.out.print("Enter your Name: ");
        UserName = input.next();

        System.out.print("Enter your approximate kilometer of travel: ");
        ApproximateKilometerTravel = input.nextFloat();
        this.setKilometers(ApproximateKilometerTravel);

        if (MonthOfTravel <= 12) {
            System.out.print("Month Of Travel: ");
            MonthOfTravel = input.nextInt();
        } else {
            System.out.println("Enter valid Month");
        }
        this.setMonth(MonthOfTravel);

        if (DateOfTravel <= 31) {
            System.out.print("On which date of the month, you wish to travel: ");
            DateOfTravel = input.nextInt();
        } else {
            System.out.println("Enter Valid date");
        }
        this.setDay(DateOfTravel);

        if (TimeOfTravel <= 24.00) {
            System.out.print(
                    "Now enter the time of travel using 24hour clock just like 9.00 for 9am, 13.00 for 1pm, 14.30 for 2:30pm etc: ");
            TimeOfTravel = input.nextInt();
        } else {
            System.out.println("Enter valid Time of hours");
        }
        this.setTime(TimeOfTravel);

        LocalDate localDate = LocalDate.of(year, MonthOfTravel, DateOfTravel);
        dayOfWeek = localDate.getDayOfWeek();
        this.setDayOfWeek(dayOfWeek);

    }

}

class ChargesUnderola extends information {
    double BaseCharges = 5.50;
    double PerKm = 0.75;
    double PeakTimeCharges = 2.50;
    double WeekendTimeCharges = 3.00;
    int TimeOfTravel = this.getTime();
    int MonthOfTravel = this.getMonth();
    float ApproximateKilometerTravel = this.getKilometers();
    DayOfWeek dayOfWeek = this.getDayOfWeek();
    double TotalOfola;

    void display() {
        System.out.println("Your Travel details: Day of the Week on" + this.getDay() + "of the month- "+ Month.of(this.getMonth())+ "is" + this.getDayOfWeek() + "your day of travel does not fall under weekend category");
        if (TimeOfTravel >= 7.00 || TimeOfTravel <= 9.00 || TimeOfTravel >= 16.00 || TimeOfTravel <= 18.00) {
            if (dayOfWeek.toString() == "Saturday" || dayOfWeek.toString() == "Sunday") {
                TotalOfola = BaseCharges + ApproximateKilometerTravel * PerKm + WeekendTimeCharges;
                System.out.println("Time falls into weekend category");
                System.out.println("So the charges will be applied accordingly");
            } else {
                TotalOfola = BaseCharges + ApproximateKilometerTravel * PerKm + PeakTimeCharges;
                System.out.println("Time falls into peaktime category");
                System.out.println("So the charges will be applied accordingly");
            }

        } else {
            TotalOfola = BaseCharges + ApproximateKilometerTravel * PerKm;
        }

        System.out.println("The final charges under company 1 is: " + TotalOfola);
    }
}

class ChargesUnderuber extends information {
    double BaseCharges = 4.50;
    double PerKm = 0.85;
    double PeakTimeCharges = 2.00;
    double WeekendTimeCharges = 2.50;
    int TimeOfTravel = this.getTime();
    float ApproximateKilometerTravel = this.getKilometers();
    DayOfWeek dayOfWeek = this.getDayOfWeek();
    double TotalOfuber;

    void display() {
        System.out
                .println("Your Travel details: Day of the Week on" + this.getDay() + "of the month- "
                        + Month.of(this.getMonth())
                        + "is" + this.getDayOfWeek() + "your day of travel does not fall under weekend category");
        if (TimeOfTravel >= 7.00 || TimeOfTravel <= 9 || TimeOfTravel >= 16.00 || TimeOfTravel <= 18.00) {
            if (dayOfWeek.toString() == "Saturday" || dayOfWeek.toString() == "Sunday") {
                TotalOfuber = BaseCharges + ApproximateKilometerTravel * PerKm + WeekendTimeCharges;
                System.out.println("Time falls into weekend category");
                System.out.println("So the charges will be applied accordingly");
            } else {
                TotalOfuber = BaseCharges + ApproximateKilometerTravel * PerKm + PeakTimeCharges;
                System.out.println("Time does not falls into weekend category");
                System.out.println("So the charges will be applied accordingly");
            }

        } else {
            TotalOfuber = BaseCharges + ApproximateKilometerTravel * PerKm;
        }

        System.out.println("The final charges under company 2 is: " + TotalOfuber);
    }
}

class ChargesUnderrapido extends information {
    double BaseCharges = 6.00;
    double PerKm = 0.95;
    double PeakTimeCharges = 2.60;
    double WeekendTimeCharges = 2.90;
    int TimeOfTravel = this.getTime();
    float ApproximateKilometerTravel = this.getKilometers();
    DayOfWeek dayOfWeek = this.getDayOfWeek();
    double TotalOfrapido;

    void display() {
        System.out
                .println("Your Travel details: Day of the Week on" + this.getDay() + "of the month- "
                        + Month.of(this.getMonth())
                        + "is" + this.getDayOfWeek() + "your day of travel does not fall under weekend category");
        if (TimeOfTravel >= 7.00 || TimeOfTravel <= 9 || TimeOfTravel >= 16.00 || TimeOfTravel <= 18.00) {
            if (dayOfWeek.toString() == "Saturday" || dayOfWeek.toString() == "Sunday") {
                TotalOfrapido = BaseCharges + ApproximateKilometerTravel * PerKm + WeekendTimeCharges;
                System.out.println("Time falls into weekend category");
                System.out.println("So the charges will be applied accordingly");
            } else {
                TotalOfrapido = BaseCharges + ApproximateKilometerTravel * PerKm + PeakTimeCharges;
                System.out.println("Time does not falls into weekend category");
                System.out.println("So the charges will be applied accordingly");
            }

        } else {
            TotalOfrapido = BaseCharges + ApproximateKilometerTravel * PerKm;
        }

        System.out.println("The final charges under company 3 is: " + TotalOfrapido);
    }
}

public class micab {
    public static void main(String[] args) {
        PrintMesg p1 = new PrintMesg();
        p1.WelcomeMesg();
        UserDetails userdetails = new UserDetails();
        ChargesUnderola chargesUnderola = new ChargesUnderola();
        ChargesUnderuber chargesUnderuber = new ChargesUnderuber();
        ChargesUnderrapido chargesUnderrapido = new ChargesUnderrapido();
        information information = new information();
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println();
            System.out.println("1. Enter User Detail");
            System.out.println("2. Display Charges under ola");
            System.out.println("3. Display Charges under uber");
            System.out.println("4. Display Charges rapido");
            System.out.println("5. Show Report");
            System.out.println("6. Exit");
            System.out.print("Enter Your Choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    userdetails.input();
                    break;
                case 2:
                    chargesUnderola.display();
                    break;
                case 3:
                    chargesUnderuber.display();
                    break;
                case 4:
                    chargesUnderrapido.display();
                case 5:
                    break;
                case 6:
                    information.setDay(0);
                    information.setMonth(0);
                    information.setYear(0);
                    information.setKilometers(0);
                    information.setTime(0);
                    information.setDayOfWeek(null);
                    System.out.println("Thank you for using micab Goodbyee!!");
                default:
                    System.out.println("invalid Choice");
            }
        } while (choice != 6);
        input.close();

    }
}
