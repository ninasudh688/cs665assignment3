/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/23/2024
 * File Name: FrequentCustomerStrategy.java
 * Description:
 * This class is responsible for the methods/attributes of a Frequent Customer email.
 */

package edu.bu.met.cs665.emailsystem;

/**
 * FrequentCustomerStrategy class represents customer template email for frequent/common customers.
 * FrequentCustomerStrategy implemented 3 methods of EmailStrategy.
 */
public class FrequentCustomerStrategy implements EmailStrategy {

  private double discountRate;

  /**
   * Create a FrequentCustomerStrategy object using parameter discountRate.
   *
   * @param discountRate The rate or percent of discount to give to frequent customers.
   */
  public FrequentCustomerStrategy(double discountRate) {
    this.discountRate = discountRate;
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
   * E.g. here includes discounts offers.
   *
   * @return String email message and discount details.
   */
  @Override
  public String generateEmailMessage() {
    return "\nWe appreciate your frequent purchases! Here's a special discount just for you. \n"
        + "Enjoy " + getDiscountRate() + "% off on your next purchase!";
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
    return "\nThanks for purchasing from us recently, " + "\n"
        + emailSenderName + ", \n" + emailSenderTitle + "\n" + companyName;
  }

  /**
   * Gets the discount rate for frequent customers.
   *
   * @return discountRate double is the discount percent for frequent customers.
   */
  public double getDiscountRate() {
    return discountRate;
  }

  /**
   * Setter method for discount rate.
   *
   * @param discountRate discount percentages for frequent customers.
   */
  public void setDiscountRate(double discountRate) {
    this.discountRate = discountRate;
  }
}
