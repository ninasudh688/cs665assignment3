/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/23/2024
 * File Name: ReturningCustomerStrategy.java
 * Description:
 * This class is responsible for the methods/attributes of a Returning Customer email.
 */

package edu.bu.met.cs665.emailsystem;

/**
 * ReturningCustomerStrategy class represents an email template for  returning customers.
 * It implements 3 methods of EmailStrategy to create personalized returning customer emails.
 */
public class ReturningCustomerStrategy implements EmailStrategy {
  private int loyaltyStatus;

  /**
   * Create a ReturningCustomerStrategy object using the specified loyalty status.
   *
   * @param loyaltyStatus The loyalty points earned by the returning customer.
   */
  public ReturningCustomerStrategy(int loyaltyStatus) {
    this.loyaltyStatus = loyaltyStatus;
  }

  /**
   * Generates a greeting message for the customer.
   * Method that all customer strategy classes implement to create a personalized greeting
   * with the customer's name.
   *
   * @param customerName The name of the customer to be greeted.
   * @return customerName with String greeting message.
   */
  @Override
  public String generateGreeting(String customerName) {
    return "Hi " + customerName + ",";
  }

  /**
   * Generates the email message content for the customer.
   * Method that all customer strategy classes implement to create a tailored email message.
   * Its tailored based on customer type.
   * E.g. here includes loyalty points/rewards offers.
   *
   * @return String email message and loyalty points status.
   */
  @Override
  public String generateEmailMessage() {
    return "\nThank you for your loyalty! Enjoy exclusive access to our reward program. \nYou "
        + "earned " + getLoyaltyStatus() + " loyalty points so far!";
  }

  /**
   * Generates the email signature for the sender.
   * This method provides a format for the email signature,includes sender's name, title,
   * and company name.
   *
   * @param emailSenderName  The name of the person sending the email.
   * @param emailSenderTitle The title of the person sending the email.
   * @param companyName      The name of the company represented by the sender.
   * @return A formatted string representing the closing remark and email signature.
   */
  @Override
  public String generateEmailSignature(String emailSenderName, String emailSenderTitle,
                                       String companyName) {
    return "\nBest, " + "\n" + emailSenderName + ",\n" + emailSenderTitle + "\n" + companyName;
  }

  /**
   * Gets the loyalty status for returning customers to indicates how many loyalty points earned.
   *
   * @return loyaltyStatus =  the loyalty status points as int for the returning customer.
   */
  public int getLoyaltyStatus() {
    return loyaltyStatus;
  }

  /**
   * Setter method for loyalty points Status.
   *
   * @param loyaltyStatus loyalty points for returning customers
   */
  public void setLoyaltyStatus(int loyaltyStatus) {
    this.loyaltyStatus = loyaltyStatus;
  }
}


