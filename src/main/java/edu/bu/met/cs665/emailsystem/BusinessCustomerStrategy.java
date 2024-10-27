/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/22/2024
 * File Name: BusinessCustomerStrategy.java
 * Description:
 * This class is responsible for the methods/attributes of a Business Customer email.
 */

package edu.bu.met.cs665.emailsystem;

/**
 * BusinessCustomerStrategy class represents Business customer template email
 * BusinessCustomerStrategy implemented 3 methods of EmailStrategy.
 */
public class BusinessCustomerStrategy implements EmailStrategy {
  private final String businessPromotion;

  /**
   * Create a BusinessCustomerStrategy object using parameter businessPromotion.
   *
   * @param businessPromotion The business Promotion/offer to share with of prof customer.
   */
  public BusinessCustomerStrategy(String businessPromotion) {
    this.businessPromotion = businessPromotion;
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
    return "Dear " + customerName + ",";
  }

  /**
   * Generates the email message content for the customer.
   * Method that all customer strategy classes implement to create a tailored email message.
   * Its tailored based on customer type.
   * E.g. here includes business promotions/offers.
   *
   * @return String email message and businessPromotion offer.
   */
  @Override
  public String generateEmailMessage() {
    return "\nWe are excited to share our latest business promotions and partnership opportunities."
        + "\n" + "Exclusive partnership offer: " + getBusinessPromotion();
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
    return "\nPlease contact us for any business inquiries. \n"
        + "Sincerely, \n" + emailSenderName + ",\n" + emailSenderTitle + "\n"
        + companyName;
  }


  /**
   * Gets business promotions for business customers segments.
   *
   * @return A string with the exclusive business promotion.
   */
  public String getBusinessPromotion() {
    return businessPromotion;
  }

}
