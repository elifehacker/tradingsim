package test;

import static org.junit.Assert.*;

import order.LimitOrder;
import order.MarketOrder;
import order.Order;
import order.StopLimitOrder;
import order.StopOrder;

import org.junit.Test;

import derivative.Stock;

import simulation.model.Portfolio;

public class OrderTest {
/*
	@Test
	public void test1() {
		System.out.println("-------Test1-------");
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
	@Test
	public void test2() {
		System.out.println("---------Test2--------");

		Portfolio p = new Portfolio(1000);
		Order o1 = new StopOrder(new Stock((float)7.0, 10, "ABC"), "Long", 7);
		Order o2 = new StopOrder(new Stock((float)8.0, 10, "ABC"), "Long", 8);

		p.makeOrder(o1);
		p.makeOrder(o2);

		p.printAll();
		p.checkOrders(new String[][] {{"ABC", "7.4", "0.5", "9.09", "100"}});
		p.printAll();

		
	}
	
	@Test
	public void test3() {
		System.out.println("---------Test3--------");
		Portfolio p = new Portfolio(1000);
		Order o1 = new StopLimitOrder(new Stock((float)7.0, 10, "ABC"), "Long", 6, 7);
		Order o2 = new StopLimitOrder(new Stock((float)6.5, 10, "ABC"), "Long", 7, (float)6.5);

		p.makeOrder(o1);
		p.makeOrder(o2);

		p.printAll();
		p.checkOrders(new String[][] {{"ABC", "7.4", "0.5", "9.09", "100"}});
		p.printAll();
		
	}

	@Test
	public void test4() {
		System.out.println("-------Test4-------");
		Portfolio p = new Portfolio(1000);
		
		Order o1 = new LimitOrder(new Stock((float)5.0, 10, "ABC"), "Short", 5);
		Order o2 = new LimitOrder(new Stock((float)8.0, 10, "ABC"), "Short", 8);
		p.makeOrder(o1);
		p.makeOrder(o2);
		//{"Symbol","Last","Net Change", "% Change", "Volumn"};
		p.test_purchase(new Stock((float)7.0, 20, "ABC"), 7);
		p.printAll();

		p.checkOrders(new String[][] {{"ABC", "6.6", "0.5", "9.09", "100"}});
		p.printAll();
		
	}
	@Test
	public void test5() {
		System.out.println("---------Test5--------");

		Portfolio p = new Portfolio(1000);
		Order o1 = new StopOrder(new Stock((float)7.0, 30, "ABC"), "Short", 7);
		Order o2 = new StopOrder(new Stock((float)8.0, 10, "ABC"), "Short", 8);

		p.makeOrder(o1);
		p.makeOrder(o2);
		p.test_purchase(new Stock((float)7.0, 20, "ABC"), 7);
		p.test_purchase(new Stock((float)8.0, 20, "ABC"), 8);

		
		p.printAll();
		p.checkOrders(new String[][] {{"ABC", "7.4", "0.5", "9.09", "100"}});
		p.printAll();

		
	}
	
	@Test
	public void test6() {
		System.out.println("---------Test6--------");
		Portfolio p = new Portfolio(1000);
		Order o1 = new StopLimitOrder(new Stock((float)7.0, 10, "ABC"), "Short", 6, 7);
		Order o2 = new StopLimitOrder(new Stock((float)6.5, 10, "ABC"), "Short", 7, (float)6.5);

		p.makeOrder(o1);
		p.makeOrder(o2);
		p.test_purchase(new Stock((float)8.0, 5, "ABC"), 8);
		p.test_purchase(new Stock((float)8.0, 5, "ABC"), 8);

		p.printAll();
		p.checkOrders(new String[][] {{"ABC", "7.4", "0.5", "9.09", "100"}});
		p.printAll();
		
	}*/
	@Test
	public void test7() {
		System.out.println("---------Test7--------");
		Portfolio p = new Portfolio(1000);
		Order o2 = new MarketOrder(new Stock((float)3.5, 10, "ABC"), "Short");
		//Order o1 = new MarketOrder(new Stock((float)3.0, 10, "ABC"), "Long");

		//p.makeOrder(o1);
		p.makeOrder(o2);
		p.test_purchase(new Stock((float)8.0, 5, "ABC"), 8);

		p.printAll();
		p.checkOrders(new String[][] {{"ABC", "6", "0.5", "9.09", "100"}});
		p.printAll();
		
	}
	
}
