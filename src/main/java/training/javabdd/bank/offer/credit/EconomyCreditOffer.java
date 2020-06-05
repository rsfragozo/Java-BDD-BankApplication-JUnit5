package training.javabdd.bank.offer.credit;

import training.javabdd.bank.customer.Customer;

public class EconomyCreditOffer extends CreditOffer {

	public EconomyCreditOffer(String id) {
		super(id);
	}

	@Override
	public boolean addCustomer(Customer customer) {
		return customersList.add(customer);
	}

	@Override
	public boolean removeCustomer(Customer customer) {
		if (!customer.isVip()) {
			return customersList.remove(customer);
		}
		return false;
	}

}
