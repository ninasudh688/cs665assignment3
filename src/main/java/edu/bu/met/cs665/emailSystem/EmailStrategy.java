/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/22/2024
 * File Name: EmailStrategy.java
 * Description:This interface is responsible for the methods/attributes of a Email Strategry.
 */

package edu.bu.met.cs665.emailSystem;

/**
 * EmailStrategy interface implemented by classes that need to
 * EmailStrategy represents the  ____ Interface of Strategy Pattern.
 * E.g.____ class will implement this interface to_____.
 */
public interface EmailStrategy {

  /**
   * Method to be implemented to .
   *
   * @param customer   cus
   */
  void generateEmail(Customer customer);
}
