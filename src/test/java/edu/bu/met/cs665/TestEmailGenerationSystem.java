/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/25/2024
 * File Name: TestEmailSystemStrategies.java
 * Description: This class is responsible for testing methods/classes for email template system.
 */

package edu.bu.met.cs665;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import edu.bu.met.cs665.emailsystem.BusinessCustomerStrategy;
import edu.bu.met.cs665.emailsystem.Customer;
import edu.bu.met.cs665.emailsystem.EmailStrategy;

import edu.bu.met.cs665.emailsystem.FrequentCustomerStrategy;
import edu.bu.met.cs665.emailsystem.NewCustomerStrategy;
import edu.bu.met.cs665.emailsystem.ReturningCustomerStrategy;
import edu.bu.met.cs665.emailsystem.VipCustomerStrategy;

/**
 * Junit test for my program
 */

public class TestEmailGenerationSystem {
  public TestEmailGenerationSystem() {
  }

  @Test
  public void testSetEmailStrategy() {
    // Given: A Customer instance with a FrequentCustomerStrategy
    EmailStrategy frequentStrategy = new FrequentCustomerStrategy(20.0);
    Customer customer = new Customer("Lilly", frequentStrategy);
    //Checking the initial strategy
    assertEquals(frequentStrategy, customer.getEmailStrategy());

    // When: customer type Changes so the customer strategy is changed
    EmailStrategy returningStrategy = new ReturningCustomerStrategy(300);
    customer.setEmailStrategy(returningStrategy);

    // Then: Verify strategy change
    assertEquals(returningStrategy, customer.getEmailStrategy());
  }

  @Test
  public void testSendEmail() {
    // Given: A Customer instance with a ReturningCustomerStrategy
    EmailStrategy returningStrategy = new ReturningCustomerStrategy(500);
    Customer customer = new Customer("Jordan", returningStrategy);

    String expectedOutput =
        "Hi Jordan,\n" + "\n" +
            "Thank you for your loyalty! Enjoy exclusive access to our reward program. \n" +
            "You earned 500 loyalty points so far!\n" + "\n" +
            "Best, \nJackie Mattice,\nCustomer Service Manager\nJack-o-lantern Co";

    // When: Sending the email
    String actualOutput = customer.sendEmail("Jackie Mattice",
        "Customer Service Manager", "Jack-o-lantern Co");

    // Then: Check the email is sent properly for returning customers
    assertEquals(expectedOutput, actualOutput);
  }

  @Test
  public void testBusinessCustomerEmailMethods() {
    // Given: A BusinessCustomerStrategy instance
    BusinessCustomerStrategy strategy = new BusinessCustomerStrategy(
        "25% off on bulk orders.");

    // When: Generating a greeting
    String greeting = strategy.generateGreeting("Claire");
    // THen: check the greeting
    assertEquals("Dear Claire,", greeting);

    // When: Checking the expected business promotions
    String promotions = strategy.getBusinessPromotion();
    // Then check the offer
    assertEquals("25% off on bulk orders.", promotions);

    // When: creating a business email message
    String message = strategy.generateEmailMessage();
    // Then check the message
    assertEquals("\nWe are excited to share our latest business promotions " +
        "and partnership opportunities.\nExclusive partnership offer: " + promotions, message);

    // When creating  email signature
    String signature = strategy.generateEmailSignature("Camryn Roads",
        "Business Development Manager", "Core Inc");
    // then check the signature of the email
    assertEquals("\nPlease contact us for any business inquiries. " +
        "\nSincerely, \nCamryn Roads,\nBusiness Development " +
        "Manager\nCore Inc", signature);
  }


  @Test
  public void testNewCustomerEmailMethods() {
    NewCustomerStrategy strategy = new NewCustomerStrategy("Use code " +
        "WELCOME50 for 50% off!");

    // Test greeting for new customers
    String greeting = strategy.generateGreeting("Bobby");
    assertEquals("Welcome Bobby,", greeting);

    // Test email message for new cusotmers
    String message = strategy.generateEmailMessage();
    assertEquals("\nThank you for joining us as new customer! " +
        "We’re excited to introduce you to our services. \n" +
        "Here is something for your next purchase: Use code WELCOME50 for 50% off!", message);

    // Test the new customer email signature
    String signature = strategy.generateEmailSignature("Sarah Smith",
        "Marketing Manager", "Shop Co.");
    assertEquals("\n" + "Thank you, \n" + "Sarah Smith, \n" +
        "Marketing Manager\n" + "Shop Co.", signature);
  }

  @Test
  public void testVipCustomerEmailMethods() {
    VipCustomerStrategy strategy = new VipCustomerStrategy("Exclusive " +
        "Red Carpet Opening next week!");

    // verify the VIP greeting
    String greeting = strategy.generateGreeting("Diana");
    assertEquals("Dear Diana,", greeting);

    // Verify the VIP email message
    String message = strategy.generateEmailMessage();
    assertEquals("\n" + "Thank you for being a VIP customer.As a valued VIP customer, " +
        "we’re offering you exclusive access to our VIP-only events. \nVIP Offer: " +
        "Exclusive Red Carpet Opening next week!", message);

    // Checking the VIP email signature
    String signature = strategy.generateEmailSignature("Michael Johnson",
        "VIP Relations", "Elite Corp");
    assertEquals("We look forward to assisting you with any more personalized service. " +
        "\n" + "Sincerely, \nMichael Johnson, \nVIP Relations\nElite Corp", signature);
  }

}
