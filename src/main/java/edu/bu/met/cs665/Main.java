/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/26/2024
 * File Name: Main.java
 * Description:
 * This class is responsible as Main class to test outside of junits
 */

package edu.bu.met.cs665;


import edu.bu.met.cs665.emailsystem.BusinessCustomerStrategy;
import edu.bu.met.cs665.emailsystem.Customer;
import edu.bu.met.cs665.emailsystem.FrequentCustomerStrategy;
import edu.bu.met.cs665.emailsystem.NewCustomerStrategy;
import edu.bu.met.cs665.emailsystem.ReturningCustomerStrategy;
import edu.bu.met.cs665.emailsystem.VipCustomerStrategy;

/**
 * This is the Main class.
 */
public class Main {

  /**
   * A main method to run examples.
   * You may use this method for development purposes as you start building your
   * assignments/final project.  This could prove convenient to test as you are developing.
   * However, please note that every assignment/final projects requires JUnit tests.
   */
  public static void main(String[] args) {
    System.out.println("MAIN.java TEST message from the Main class");
    System.out.println("---------------------------------------------");

    // Create customers with different strategies.
    Customer customer1 = new Customer("Bob Smith",
        new BusinessCustomerStrategy("20% discount on bulk orders."));
    // Sending emails to each customer.
    System.out.println("Business Customer Email:");
    System.out.println(customer1.sendEmail("William M", "CEO",
        "Tech Corp"));
    System.out.println("---------------------------------------------");
    Customer customer2 = new Customer("Jane Smith", new
        ReturningCustomerStrategy(200));
    System.out.println("\nReturning Customer Email:");
    System.out.println(customer2.sendEmail("Customer Service",
        "Support Team", "Tech Corp"));
    System.out.println("---------------------------------------------");
    Customer customer3 = new Customer("Carol Wilson", new
        FrequentCustomerStrategy(15.0));
    System.out.println("\nFrequent Customer Email:");
    System.out.println(customer3.sendEmail("Sally N",
        "Sales Manager", "Tech Corp"));
    System.out.println("---------------------------------------------");
    Customer customer4 = new Customer("Megan Brown", new
        NewCustomerStrategy("Use code WELCOME10 for 10% off!"));
    System.out.println("\nNew Customer Email:");
    System.out.println(customer4.sendEmail("Wendy T",
        "Marketing Team", "Tech Corp"));
    System.out.println("---------------------------------------------");
    //when customer type changed:
    customer4.setEmailStrategy(new
        ReturningCustomerStrategy(500));
    System.out.println(customer4.sendEmail("Alice",
        "Marketing Manager", "Tech Core  Inc."));
    System.out.println("---------------------------------------------");
    Customer customer5 = new Customer("Diana Russell", new
        VipCustomerStrategy("Exclusive VIP Event next week!"));
    System.out.println("\nVIP Customer Email:");
    System.out.println(customer5.sendEmail("VIP Relations",
        "VIP Manager", "Tech Corp"));


  }

}
