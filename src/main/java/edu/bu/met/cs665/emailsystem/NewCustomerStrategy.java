/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/25/2024
 * File Name: NewCustomerStrategy.java
 * Description:
 * This class is responsible for the methods/attributes of a New Customer email.
 */

package edu.bu.met.cs665.emailsystem;

/**
 * NewCustomerStrategy class represents customer template email for brand-new customers.
 * NewCustomerStrategy implemented 3 methods of EmailStrategy.
 */
public class NewCustomerStrategy implements EmailStrategy {
  private final String firstTimeOffer;

  /**
   * Create a NewCustomerStrategy object using parameter firstTimeOffer.
   *
   * @param firstTimeOffer The offer to give to new customers to encourage new customers.
   */
  public NewCustomerStrategy(String firstTimeOffer) {
    this.firstTimeOffer = firstTimeOffer;
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
    return "Welcome " + customerName + ",";
  }

  /**
   * Generates the email message content for the customer.
   * Method that all customer strategy classes implement to create a tailored email message.
   * Its tailored based on customer type.
   * E.g. here includes new offers.
   *
   * @return String email message and first time offers.
   */
  @Override
  public String generateEmailMessage() {
    return "\nThank you for joining us as new customer! "
        + "We’re excited to introduce you to our services. \nHere is something for your next "
        + "purchase: "  + getFirstTimeOffer();
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
    return "\nThank you, \n" + emailSenderName + ", \n" + emailSenderTitle + "\n" + companyName;
  }

  /**
   * Gets the first-time offer for new customers.
   *
   * @return A string containing the offer message for new customers.
   */
  public String getFirstTimeOffer() {
    return firstTimeOffer;
  }
}

