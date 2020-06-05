package training.javabdd.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import training.javabdd.bank.customer.Customer;
import training.javabdd.bank.offer.credit.BusinessCreditOffer;
import training.javabdd.bank.offer.credit.CreditOffer;
import training.javabdd.bank.offer.credit.EconomyCreditOffer;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {


    @DisplayName("Given there is an economy credit offer")
    @Nested
    class EconomyCreditOfferTest {

        private CreditOffer economyCreditOffer;
        private Customer mike;
        private Customer john;

        @BeforeEach
        void setUp() {
            economyCreditOffer = new EconomyCreditOffer("1");
            mike = new Customer("Mike", false);
            john = new Customer("John", true);
        }

        @Nested
        @DisplayName("When we have a usual customer")
        class UsualCustomer {
            @Test
            @DisplayName("Then you can add and remove him from an economy credit offer")
            public void testEconomyCreditOfferUsualCustomer() {
                assertAll("Verify all conditions for a usual passenger and an economy credit offer",
                        () -> assertEquals("1", economyCreditOffer.getId()),
                        () -> assertTrue(economyCreditOffer.addCustomer(mike)),
                        () -> assertEquals(1, economyCreditOffer.getCustomersList().size()),
                        () -> assertEquals("Mike", economyCreditOffer.getCustomersList().get(0).getName()),
                        () -> assertTrue(economyCreditOffer.removeCustomer(mike)),
                        () -> assertEquals(0, economyCreditOffer.getCustomersList().size())
                );
            }
        }

        @Nested
        @DisplayName("When we have a VIP customer")
        class VipCustomer {
            @Test
            @DisplayName("Then you can add him but cannot remove him from an economy credit offer")
            public void testEconomyCreditOfferVipCustomer() {
                assertAll("Verify all conditions for a VIP passenger and an economy credit offer",
                        () -> assertEquals("1", economyCreditOffer.getId()),
                        () -> assertTrue(economyCreditOffer.addCustomer(john)),
                        () -> assertEquals(1, economyCreditOffer.getCustomersList().size()),
                        () -> assertEquals("John", economyCreditOffer.getCustomersList().get(0).getName()),
                        () -> assertFalse(economyCreditOffer.removeCustomer(john)),
                        () -> assertEquals(1, economyCreditOffer.getCustomersList().size())
                );
            }
        }
    }


    @DisplayName("Given there is a business credit offer")
    @Nested
    class BusinessCreditOfferTest {
        private CreditOffer businessCreditOffer;
        private Customer mike;
        private Customer john;

        @BeforeEach
        void setUp() {
            businessCreditOffer = new BusinessCreditOffer("2");
            mike = new Customer("Mike", false);
            john = new Customer("John", true);
        }

        @Nested
        @DisplayName("When we have a usual customer")
        class UsualCustomer {

            @Test
            @DisplayName("Then you cannot add or remove him from a business credit offer")
            public void testBusinessCreditOfferUsualCustomer() {
                assertAll("Verify all conditions for a usual passenger and a business credit offer",
                        () -> assertFalse(businessCreditOffer.addCustomer(mike)),
                        () -> assertEquals(0, businessCreditOffer.getCustomersList().size()),
                        () -> assertFalse(businessCreditOffer.removeCustomer(mike)),
                        () -> assertEquals(0, businessCreditOffer.getCustomersList().size())
                );

            }
        }

        @Nested
        @DisplayName("When we have a VIP customer")
        class VipCustomer {
            @Test
            @DisplayName("Then you can add him but cannot remove him from a business credit offer")
            public void testBusinessCreditOfferVipCustomer() {
                assertAll("Verify all conditions for a VIP passenger and a business credit offer",
                        () -> assertTrue(businessCreditOffer.addCustomer(john)),
                        () -> assertEquals(1, businessCreditOffer.getCustomersList().size()),
                        () -> assertFalse(businessCreditOffer.removeCustomer(john)),
                        () -> assertEquals(1, businessCreditOffer.getCustomersList().size())
                );

            }
        }
    }
}
