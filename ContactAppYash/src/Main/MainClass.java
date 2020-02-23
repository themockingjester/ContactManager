package Main;

import ContactApp.Contacts;

import java.util.Scanner;
import java.util.regex.Pattern;

import static java.lang.System.exit;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Contacts<Long,String> list = new Contacts<>();
        while(1==1)
        {System.out.println("Welcome to YASH's Contact List App");
        System.out.println("Press 1 to add a new contact");
        System.out.println("Press 2 to view all contacts");
        System.out.println("Press 3 to search for a contact");
        System.out.println("Press 4 for delete a contact");
        System.out.println("Press 5 for exit program ");

        int choice=sc.nextInt();
        switch (choice)
        {
            case 1:


                System.out.println("You have chosen to add a new contact:\nPlease enter the name of the Person");
                sc.nextLine();
                System.out.print("First Name: ");
                String first = sc.nextLine();
                System.out.println("");
                System.out.print("Last Name: ");
                String last = sc.nextLine();
                System.out.println("");

                String input = "y";
                while (input.equals("y"))
                {

                        System.out.print("Contact Number: ");
                        long val=sc.nextLong();
                        String tempvar = Long.toString(val);
                        if(Pattern.matches("[1-9][0-9]{9}?", tempvar)==true)
                        {
                            Long tempvar2 = Long.valueOf(tempvar);
                            list.addForNumbers(tempvar2);
                            System.out.println("");
                            sc.nextLine();
                            System.out.println("Would you like to add another contact number? (y/n): ");
                            input = sc.nextLine();
                        }
                        else
                        {
                            System.out.println("enter correct number next time!!");
                        }

                    //System.out.println("");
                }

                    System.out.print("Email Address: ");
                    String email = sc.nextLine();
                    list.add(first, last, email, list.getHead());
                    //list.addForRecord(first, last, email, list.getHead());
                    list.sort();
                break;
            case 2:
                list.viewAll();
                break;
            case 3:
                sc.nextLine();
                if(list.getHead2()!=null)
                {
                    System.out.println("you could search for a contact from their first names:");
                    list.search(sc.nextLine());
                }
                else
                {
                    System.out.println("you have no contact!!");
                }
                break;
            case 4:
                if(list.getHead2()!=null) {
                    list.delete();
                }
                else
                {
                    System.out.println("You have no contact!!");
                }
                break;

            case 5:
                exit(0);
                break;



        }}

    }
}
