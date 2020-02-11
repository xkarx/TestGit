import sun.font.TrueTypeFont;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] agrs) throws IOException {

        Bidder b = new Bidder();
        Seller s = new Seller();
        Delivery d = new Delivery();
        Visitor v = new Visitor();
        Admin a = new Admin();
        CustomerCare c = new CustomerCare();




        int ch,ch2;
        Scanner input = new Scanner(System.in);
        while(true) {
        System.out.println("\n1.Bidder\n2.Seller\n3.Delivery\n4.Visitor\n5.Admin\n6.Customer Care\n7.Payment\n8.Exit");
        System.out.print("Enter Choice : ");
        ch = input.nextInt();

        //
            switch (ch) {
                case 1: //bidder
                    System.out.println("\n\t1.Login\n\t2.Register\n\t3.Place Bids\n\t4.Write Complaint\n\t5.Exit");
                    System.out.print("Enter Choice : ");
                    ch2 = input.nextInt();
                    switch (ch2) {

                        case 1:
                            System.out.print("Enter user name : ");
                            String uname = input.next();
                            System.out.print("Enter password : ");
                            String pass = input.next();
                            boolean l = b.login(uname, pass);
                            break;

                        case 2: b.register();
                                break;

                        case 3: b.viewProduct();
                                break;

                        case 4: b.complaint();
                                break;

                        case 5: System.exit(0);
                                break;
                    }
                    break;

                case 2: //seller
                        System.out.println("\n\t1. View Product\n\t2. Add Product\n\t5. Exit");
                        System.out.print("Enter Choice : ");
                        ch2 = input.nextInt();
                         switch (ch2) {
                             case 1:
                                 s.viewProduct();
                                 break;

                             case 2: s.addProduct();
                                 break;

                             case 3: System.exit(0);
                                 break;

                         }
                        break;



                case 3: //delivery
                    System.out.println("\n\t1. View Products to be delivered\n\t2.Exit");
                    System.out.print("Enter Choice : ");
                    ch2 = input.nextInt();
                    switch (ch2) {
                        case 1:
                            d.viewProduct();
                            break;

                        case 2: System.exit(0);
                            break;

                    }
                    break;

                case 4: //visitor
                    while(true) {
                        System.out.println("\n\t1. View Products to be delivered\n\t2. Exit");
                        System.out.print("Enter Choice : ");
                        ch2 = input.nextInt();
                        switch (ch2) {
                            case 1:
                                v.viewProduct();
                                break;

                            case 2:
                                System.exit(0);
                                break;

                        }
                        break;
                    }

                case 5: //Admin
                    System.out.println("\n\t1. View User Details\n\t2. View Products\n\t3. View Complaint\n\t4. Exit");
                    System.out.print("Enter Choice : ");
                    ch2 = input.nextInt();
                    switch (ch2) {

                        case 1:
                            a.viewUserDeatils();
                            break;

                        case 2: a.viewProduct();
                            break;

                        case 3: a.viewComplaint();
                            break;

                        case 4: System.exit(0);
                            break;
                    }
                    break;

                case 6: //Customer Care
                    System.out.println("\n\t1. View Complaints\n\t2. Exit");
                    System.out.print("Enter Choice : ");
                    ch2 = input.nextInt();
                    switch (ch2) {
                        case 1:
                            c.viewComplaint();
                            break;

                        case 2: System.exit(0);
                            break;

                    }
                    break;

                case 7: //Payments
                    System.out.print("You need to login to make payments!\n");
                    System.out.print("Enter user name : ");
                    String uname = input.next();
                    System.out.print("Enter password : ");
                    String pass = input.next();
                    boolean l = b.login(uname, pass);
                    if (l!=true){
                        System.out.print("Authentication Failed : ");
                        break;
                    }

                    System.out.println("\nChoose mode of payment:\n\t1. Debit\n\t2.Internet Banking\n\t3.UPI");
                    System.out.print("Enter Choice : ");
                    ch2 = input.nextInt();
                    switch (ch2) {
                        case 1:
                            System.out.println("Redirecting to Debit Card Payments Page! ");
                            break;

                        case 2:
                            System.out.println("Redirecting to Internet Banking Page! ");
                            break;

                        case 3:
                            System.out.println("Redirecting to UPI Payments Page! ");
                            break;

                        case 4: System.exit(0);
                            break;

                    }
                    break;

                case 8: System.exit(0);

                        break;

                default:
                        System.out.println("Invalid Choice");

                        break;
            }
        }
    }
}

class Bidder{
    int id;
    String name, password, contact, address;

    Scanner input = new Scanner(System.in);
    //login
    public boolean login(String username, String password) throws FileNotFoundException {
        File file=new File("login.txt");
        Scanner sc=new Scanner(file);
        boolean t=true;
        String s="";
        String x[]=new String[4];
        while(sc.hasNextLine())
        {
            s=sc.nextLine();
            x=s.split("\t");
            if(username.equals(x[0])&&password.equals(x[1]))
            {
                t=true;
                System.out.println("Login Successfull.!!!!");

                break;
            }
            else t=false;
        }
        return t;

    }

    //register
    void register() throws IOException {



        System.out.print("Enter id: ");
        id = input.nextInt();
        System.out.print("Enter name: ");
        name = input.next();
        System.out.print("Enter password: ");
        password = input.next();
        System.out.print("Enter contact: ");
        contact = input.next();
        System.out.print("Enter address: ");
        address = input.next();

        File file = new File("bidders.txt");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter br = new BufferedWriter(fr);
        br.write(id+"\t"+name+"\t"+password+"\t"+contact+"\t"+address+"\n");
        br.close();
        fr.close();
        System.out.println("Registration Successfull..!!!!");

        file = new File("login.txt");
        fr = new FileWriter(file, true);
        br = new BufferedWriter(fr);
        br.write(name+"\t"+password+"\n");
        br.close();
        fr.close();

    }

    //view product
    void viewProduct() throws IOException {
        File fi = new File("products.txt");
        Desktop desktop = Desktop.getDesktop();
        if(fi.exists())
            desktop.open(fi);
        //desktop.close();
    }

    //write complaint
    void complaint() throws IOException {
        System.out.print("Enter complaint: ");
        String c = input.nextLine();

        File file = new File("complaint.txt");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter br = new BufferedWriter(fr);
        br.write(c+"\n");
        br.close();
        fr.close();
        System.out.println("Complaint registered!");
    }
}

class Seller{

    Scanner input = new Scanner(System.in);

    int id;
    String name, password, contact, address;

    int pid; String pname;



    void addProduct() throws IOException {

        System.out.print("Enter id: ");
        pid = input.nextInt();

        System.out.print("Enter product name: ");
        pname = input.next();

        File file = new File("products.txt");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter br = new BufferedWriter(fr);
        //br.write(id+"\t"+name+"\t"+password+"\t"+contact+"\t"+address+"\n");
        br.write(pid+"\t"+pname+"\n");
        br.close();
        fr.close();
        System.out.println("Registration Successfull..!!!!");
    }

    void viewProduct() throws IOException {
        File fi = new File("products.txt");
        Desktop desktop = Desktop.getDesktop();
        if(fi.exists())
            desktop.open(fi);
        //desktop.close();
    }

}

class Delivery{

    void viewProduct() throws IOException {
        File fi = new File("products.txt");
        Desktop desktop = Desktop.getDesktop();
        if(fi.exists())
            desktop.open(fi);

    }
}

class Visitor{

    void viewProduct() throws IOException {
        File fi = new File("products.txt");
        Desktop desktop = Desktop.getDesktop();
        if(fi.exists())
            desktop.open(fi);

    }
}

class Admin{

    void viewUserDeatils() throws IOException {
        File fi = new File("bidders.txt");
        Desktop desktop = Desktop.getDesktop();
        if(fi.exists())
            desktop.open(fi);
    }

    void viewProduct() throws IOException {
        File fi = new File("products.txt");
        Desktop desktop = Desktop.getDesktop();
        if(fi.exists())
            desktop.open(fi);
    }

    void viewComplaint() throws IOException {
        File fi = new File("complaint.txt");
        Desktop desktop = Desktop.getDesktop();
        if(fi.exists())
            desktop.open(fi);
    }

}

class CustomerCare{
    void viewComplaint() throws IOException {
        File fi = new File("complaint.txt");
        Desktop desktop = Desktop.getDesktop();
        if(fi.exists())
            desktop.open(fi);
    }

}




































































