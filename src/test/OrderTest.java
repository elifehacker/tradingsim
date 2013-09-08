package test;

import static org.junit.Assert.*;

import order.LimitOrder;
import order.Order;

import org.junit.Test;

import derivative.Stock;

import simulation.model.Portfolio;

public class OrderTest {

	@Test
	public void test() {
		
		Portfolio p = new Portfolio(1000);
		
		Order o1 = new LimitOrder(new Stock((float)5.0, 10, "ABC"), "Long", 5);
		Order o2 = new LimitOrder(new Stock((float)7.0, 10, "ABC"), "Long", 7);
		p.makeOrder(o1);
		p.makeOrder(o2);
		p.printAll();
		//{"Symbol","Last","Net Change", "% Change", "Volumn"};
		p.checkOrders(new String[][] {{"ABC", "6", "0.5", "9.09", "100"}});
		p.printAll();
		
	}

}
