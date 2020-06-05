package training.javabdd.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    @Test
    public void testEconomyCreditOfferUsualCustomer() {
        CreditOffer economyCreditOffer = new CreditOffer("1", "Economy");
        Customer mike = new Customer("Mike", false);

        assertEquals("1", economyCreditOffer.getId());
        assertTrue(economyCreditOffer.addCustomer(mike));
        assertEquals(1, economyCreditOffer.getCustomersList().size());
        assertEquals("Mike", economyCreditOffer.getCustomersList().get(0).getName());

        assertTrue(economyCreditOffer.removeCustomer(mike));
        assertEquals(0, economyCreditOffer.getCustomersList().size());
    }

    @Test
    public void testEconomyCreditOfferVipCustomer() {
        CreditOffer economyCreditOffer = new CreditOffer("1", "Economy");
        Customer john = new Customer("John", true);

        assertEquals("1", economyCreditOffer.getId());
        assertTrue(economyCreditOffer.addCustomer(john));
        assertEquals(1, economyCreditOffer.getCustomersList().size());
        assertEquals("John", economyCreditOffer.getCustomersList().get(0).getName());

        assertFalse(economyCreditOffer.removeCustomer(john));
        assertEquals(1, economyCreditOffer.getCustomersList().size());
    }

    @Test
    public void testBusinessCreditOfferUsualCustomer() {
        CreditOffer businessCreditOffer = new CreditOffer("2", "Business");

        Customer mike = new Customer("Mike", false);

        assertFalse(businessCreditOffer.addCustomer(mike));
        assertEquals(0, businessCreditOffer.getCustomersList().size());
        assertFalse(businessCreditOffer.removeCustomer(mike));
        assertEquals(0, businessCreditOffer.getCustomersList().size());

    }

    @Test
    public void testBusinessCreditOfferVipCustomer() {
        CreditOffer businessCreditOffer = new CreditOffer("2", "Business");

        Customer john = new Customer("John", true);

        assertTrue(businessCreditOffer.addCustomer(john));
        assertEquals(1, businessCreditOffer.getCustomersList().size());
        assertFalse(businessCreditOffer.removeCustomer(john));
        assertEquals(1, businessCreditOffer.getCustomersList().size());

    }
}
