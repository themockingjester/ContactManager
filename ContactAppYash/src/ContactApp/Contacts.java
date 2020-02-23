package ContactApp;

import ADT.*;

import java.lang.String;
import java.util.*;
import java.util.regex.Pattern;

public class Contacts<E, F> implements PhoneAppInterface<E, F> {
    //head for linkedlist of numbers
    private Node<E> head;
    //head for linkedlist of records
    private Record<F, E> head2;
    //Counter for total number of records
    private int size = 0;

    //Class node class for a particular record
    private static class Node<E> {
        private E num;
        private Node<E> next;

        private Node(E num, Node<E> next) {
            this.num = num;
            this.next = next;
        }

    }

    //node class for records
    private static class Record<F, E> {
        private F FirstName;
        private F LastName;
        private F email;
        private Node<E> number;
        private Record<F, E> next2;

        private Record(F firstName, F lastName, F email, Record<F, E> next2, Node<E> number) {
            this.FirstName = firstName;
            this.LastName = lastName;
            this.email = email;
            this.number = number;
            this.next2 = next2;
        }

    }

    /*
    this method will return the head node for nodes of numbers for a particular record

     */
    public Node<E> getHead() {
        Node<E> temp = head;
        head = null;
        return temp;
    }

    /*
    this method compare the first name for two consequtive records
     */
    public int compare(Object a, Object b) {

        return ((String) a).compareTo((String) b);
    }

    /*
    this method will arrange the record in sorted manner on the basis of first name
     */
    public void sort() {
        if (size > 1) {

            for (int i = 0; i < size; i++) {
                Record<F, E> temp = head2;
                for (int j = 0; j < size; j++) {
                    if (temp.next2 != null) {
                        if (compare((temp.FirstName), (temp.next2).FirstName) > 0) {
                            //swapping values of first names
                            F value = temp.FirstName;
                            temp.FirstName = temp.next2.FirstName;
                            temp.next2.FirstName = value;
                            //swapping values for last name
                            value = temp.LastName;
                            temp.LastName = temp.next2.LastName;
                            temp.next2.LastName = value;
                            //swapping values for email
                            value = temp.email;
                            temp.email = temp.next2.email;
                            temp.next2.email = value;
                            //swapping values for numbers
                            Node<E> value2 = temp.number;
                            temp.number = temp.next2.number;
                            temp.next2.number = value2;
                        }
                        temp = temp.next2;
                    }
                }
            }
        }
    }

    /* method for displaying all the present records

     */
    public void viewAll() {
        if (head2 != null) {
            //here ctr is just a counter which will help us to reach the end of the record linked list
            int ctr = 0;
            System.out.println("--Here are all your contacts--");
            Record<F, E> temp = head2;

            while (temp.next2 != null || ctr < 1) {

                if (temp.next2 == null) {
                    ctr++;
                }

                System.out.println("-------- * -------- * -------- * --------");
                System.out.println("First Name: " + temp.FirstName);
                System.out.println("Last Name: " + temp.LastName);
                Node<E> temp2 = temp.number;
                if (temp2.next != null) {
                    System.out.print("Contact Number(s): ");
                } else {
                    System.out.print("Contact Number: ");
                }
                int ctr2 = 0;
                //here we are displaying the numbers for each record
                while (temp2.next != null || ctr2 < 1) {
                    //we will reach to this if we are at the last number
                    if (temp2.next == null) {
                        ctr2++;
                        System.out.print(temp2.num);
                        break;
                    }
                    System.out.print(temp2.num + ", ");
                    temp2 = temp2.next;

                }
                System.out.println(" ");
                System.out.println("Email address: " + temp.email);
                System.out.println("-------- * -------- * -------- * --------");
                if (ctr < 1) {
                    temp = temp.next2;
                }

            }
        } else {
            System.out.println("you have no contact!!");
        }
    }
        /* this method will return the address of first record

         */
    public Record<F, E> getHead2() {
        return head2;
    }
    /*
    this method will search for a record on the basis of the first name

     */
    public void search(F firstname) {
        if (head2 != null) {    //this if will check whether our record list is empty or not
            int ctr = 0;
            int ctr3 = 0;
            Record<F, E> temp3 = head2;
            while (temp3.next2 != null || ctr3 < 1) {    //this while will count how many records matched
                if (temp3.next2 == null) {
                    ctr3++;
                }
                if ((temp3.FirstName).equals(firstname)) {
                    ctr++;

                }
                if (ctr3 < 1) {
                    temp3 = temp3.next2;
                }

            }
            System.out.println(ctr + " Match found!");
            temp3 = head2;


            if (ctr != 0) {   //on the basis of above while loop if ctr!=0(means we have some matched records) we will going to print matched records
                ctr = 0;
                while (temp3.next2 != null || ctr < 1) {
                    if (temp3.next2 == null) {
                        ctr++;
                    }
                    if ((temp3.FirstName).equals(firstname)) {
                        System.out.println("-------- * -------- * -------- * --------");
                        System.out.println("First Name: " + temp3.FirstName);
                        System.out.println("Last Name: " + temp3.LastName);
                        Node<E> temp2 = temp3.number;
                        if (temp2.next != null) {
                            System.out.print("Contact Number(s): ");
                        } else {
                            System.out.print("Contact Number: ");
                        }
                        int ctr2 = 0;
                        while (temp2.next != null || ctr2 < 1) {
                            if (temp2.next == null) {
                                ctr2++;
                            }
                            System.out.print(temp2.num + ", ");
                            if (ctr2 < 1) {
                                temp2 = temp2.next;
                            }


                        }
                        System.out.println(" ");
                        System.out.println("Email address: " + temp3.email);
                        System.out.println("-------- * -------- * -------- * --------");

                    }
                    if (ctr < 1) {
                        temp3 = temp3.next2;
                    }
                }
            } else {
                System.out.println("NO RESULTS FOUND!");
            }
        } else {
            System.out.println("you have no contact!!");
        }
    }
        /*this method will add a record into the record list

         */
    public boolean add(F first, F last, F email, Object num1) {
        Node<E> num = (Node<E>) num1;
        Record<F, E> temp = head2;
        if (head2 == null) {
            head2 = new Record(first, last, email, null, num);
            size++;
            return true;
        } else {
            Record<F, E> temp2 = head2;
            while (temp2.next2 != null) {
                temp2 = temp2.next2;
            }
            temp2.next2 = new Record(first, last, email, null, num);
            size++;
            return true;
        }
    }
        /*this method will add the numbers in a particular record

         */
    public boolean addForNumbers(E num) {

        if (head == null) {
            head = new Node<>(num, null);
            return true;
        } else {
            Node<E> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node<E>(num, null);
            return true;
        }
        //return false;
    }
    /*this method give the previous record of the current record

     */
    private Record<F, E> getNodeBeforeCurrentForRecords(Record<F, E> temp) {
        Record<F, E> temp2 = head2;
        if (head2 != null) {
            if (head2.next2 != null) {
                while (temp2.next2 != temp) {
                    temp2 = temp2.next2;
                }
                return temp2;
            } else {
                head2 = null;
                return null;
            }
        } else {
            return null;
        }

    }
    /*for removing the first record

     */
    public void removeFirstForRecords() {
        System.out.println(head2.FirstName + " " + head2.LastName + "'s contact deleted from list!");

        head2 = head2.next2;

    }
    /*for removing the last record

     */
    public void removeLastForRecords() {
        Record<F, E> temp = head2;
        while (temp.next2 != null) {
            temp = temp.next2;
        }

        System.out.println(temp.FirstName + " " + temp.LastName + "'s contact deleted from list!");
        if (!head2.equals(temp)) {
            getNodeBeforeCurrentForRecords(temp).next2 = null;
        } else {
            head2 = null;
        }

    }
    /*this is the main delete method which we will use

     */
    public void delete() {

        System.out.println("Here are all your contacts:");
        Record<F, E> temp = head2;
        Scanner sc = new Scanner(System.in);
        int ctr2 = 1;
        int ctr = 0;
        if (head2 != null) {
            while (temp.next2 != null || ctr < 1) {
                if (temp.next2 == null) {
                    ctr++;
                }
                System.out.println(ctr2 + ". " + temp.FirstName + " " + temp.LastName);
                ctr2++;
                if (ctr < 1) {
                    temp = temp.next2;
                }

            }

            System.out.println("Press the number against the contact to delete it: ");
            removeUsingNumberForRecords((sc.nextInt() - 1));

        }

    }
    /*this method will remove the record at the given index

     */

    public void removeUsingNumberForRecords(int index) {
        if (head2 != null) {
            int ctr = 0;

            Record<F, E> temp = head2;
            while (temp.next2 != null) {
                if (ctr == 0 && index == 0) {
                    removeFirstForRecords();
                } else {
                    if (ctr == index) {
                        System.out.println(temp.FirstName + " " + temp.LastName + "'s contact deleted from list!");

                        getNodeBeforeCurrentForRecords(temp).next2 = temp.next2;
                    }
                }
                ctr++;
                temp = temp.next2;

            }

            if (ctr == index) {

                removeLastForRecords();

            }
        }
    }
    /*this method will display all the available numbers for a given record

     */
    public void showForNumbers() {
        Node<E> temp = head;
        while (temp.next != null) {
            System.out.println(temp.num);
            temp = temp.next;
        }
        System.out.println(temp.num);
    }


}
/*thdf hdf h
hfd
h df
df g
 h
 df g f dhg dfgdf
  gfdsf fed fedgrfsh reg4wthgbf bfhg trh t hgfr
  htrh
  trh
  tfrgh fgd
  h fdgh
   fdgh
    srgf hfg
     hstr
      ghfgr h
      sr fghsrfg hs g
      r hgr h
      srt gh
       gfh
       fg h
 */