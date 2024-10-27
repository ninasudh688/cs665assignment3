/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/25/2024
 * File Name: VIPCustomerStrategy.java
 * Description:
 * This class is responsible for the methods/attributes of a VIP Customer email.
 */

package edu.bu.met.cs665.emailsystem;

/**
 * VIPCustomerStrategy class represents customer template email for important customers.
 * VIPCustomerStrategy implemented 3 methods of EmailStrategy.
 */
public class VipCustomerStrategy implements EmailStrategy {

  private final String exclusiveOffer;

  /**
   * Create a VIPCustomerStrategy object using parameter exclusiveOffer.
   *
   * @param exclusiveOffer The offer to give to only important Vip customers.
   */
  public VipCustomerStrategy(String exclusiveOffer) {
    this.exclusiveOffer = exclusiveOffer;
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
   * E.g. here includes exclusive events/offers.
   *
   * @return String email message and exclusive offer.
   */
  @Override
  public String generateEmailMessage() {
    return "\nThank you for being a VIP customer."
        + "As a valued VIP customer, we’re offering you exclusive access to our "
        + "VIP-only events. \nVIP Offer: " + getExclusiveOffers();
  }

  /**
   * Generates the email signature for the sender.
   * This method provides a format for the email signature,includes sender's name, title,
   * and company name.
   *
   * @param emailSenderName The name of the person sending the email.
   * @param emailSenderTitle The title of the person sending the email.
   * @param companyName The name of the company represented by the sender.
   * @return A formatted string representing the closing remark and email signature.
   */
  @Override
  public String generateEmailSignature(String emailSenderName, String emailSenderTitle,
                                       String companyName) {
    return "We look forward to assisting you with any more personalized service. "
        + "\nSincerely, \n" + emailSenderName + ", \n" + emailSenderTitle + "\n" + companyName;
  }

  /**
   * Gets exclusive special events or promotions available  to VIP customers.
   *
   * @return A string containing the exclusive offers message for VIP customers.
   */
  public String getExclusiveOffers() {
    return  exclusiveOffer;
  }
}
