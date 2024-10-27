/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/22/2024
 * File Name: EmailStrategy.java
 * Description:This interface is responsible for the methods/attributes of an Email Strategy.
 */

package edu.bu.met.cs665.emailsystem;

/**
 * EmailStrategy interface implemented by classes that need to create an email template.
 * EmailStrategy represents the common Strategy Interface of Strategy Pattern.
 * 5 CustomerStrategy classes will implement this interface to create the parts of email.
 */
public interface EmailStrategy {

  /**
   * Method to be implemented to create email greeting e.g. Dear customerName.
   *
   * @param customerName name of each customer, management is addressing the email to.
   */
  String generateGreeting(String customerName);

  /**
   * Method to be implemented to create main message of the email.
   */
  String generateEmailMessage();

  /**
   * Method to be implemented to create email signature/closing lines.
   *
   * @param emailSenderName  name of each management person/team who is sending the email.
   * @param emailSenderTitle what position of each management person/team sending the email.
   * @param companyName      the company of the management people sending the emails to customers.
   */
  String generateEmailSignature(String emailSenderName, String emailSenderTitle,
                                String companyName);

}
