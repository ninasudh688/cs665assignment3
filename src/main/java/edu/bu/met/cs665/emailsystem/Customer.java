/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/22/2024
 * File Name: Customer.java
 * Description:This class is responsible for the methods/attributes of a Customer.
 * It represents a customer that receives personal emails based on a specified email strategy.
 */

package edu.bu.met.cs665.emailsystem;

/**
 * This is Customer class which  is responsible for representing a customer in the email system.
 * Customer is type of Context class with Strategy Pattern.
 * It represents customer-specific information and uses an EmailStrategy
 */
public class Customer {
  private final String customerName;
  private EmailStrategy emailStrategy;

  /**
   * Creates a Customer object using name,emailStrategy parameters.
   *
   * @param name          The name of the customer.
   * @param emailStrategy The email strategy to be used for generating emails.
   */
  public Customer(String name, EmailStrategy emailStrategy) {
    this.customerName = name;
    this.emailStrategy = emailStrategy;
  }

  /**
   * Sends a personalized email to the customer
   * It uses email strategy to calling methods representing the 3 parts of an email
   * Then it returns the complete email content.
   *
   * @param emailSenderName  The name of the person sending the email.
   * @param emailSenderTitle The title of the person sending the email.
   * @param companyName      The name of the company represented by the sender.
   * @return  string of greeting, emailMessage , signature
   */
  public String sendEmail(String emailSenderName, String emailSenderTitle, String companyName) {
    String greeting = emailStrategy.generateGreeting(this.customerName);
    String emailMessage = emailStrategy.generateEmailMessage();
    String signature = emailStrategy.generateEmailSignature(emailSenderName, emailSenderTitle,
        companyName);
    return greeting + "\n" + emailMessage + "\n" + signature;
  }

  /**
   * Sets a new email strategy for the customer.
   * e.g. If a new customer becomes a frequent customer etc.
   *
   * @param emailStrategy The new email strategy to be set.
   */
  public void setEmailStrategy(EmailStrategy emailStrategy) {
    this.emailStrategy = emailStrategy;
  }

  /**
   * Gets the name of the customer.
   *
   * @return string name of the customer.
   */
  public String getCustomerName() {
    return customerName;
  }

  /**
   * Gets the current email strategy of the customer.
   *
   * @return EmailStrategy object currently assigned to the customer.
   */
  public EmailStrategy getEmailStrategy() {
    return emailStrategy;
  }

}
