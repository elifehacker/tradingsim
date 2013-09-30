package test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import model.BlackSchole;
import model.Portfolio;
import order.Order;

import org.junit.Test;

import derivative.Derivative;
import derivative.Option;
import derivative.Stock;


public class DerivativeTest {

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		/*
		System.out.println("test 1");
		Stock s1 = new Stock((float) 5.22, 10, "ABC");
		Stock s2 = new Stock((float) 9.88, 20, "BBC");
		assertEquals(5.22,s1.getPrice(),0.001);
		Portfolio p = new Portfolio(1000);
		Order o1 = new Order(s1, "Long");
		Order o2 = new Order(s2, "Long");

		p.makeOrder(o1);
		p.makeOrder(o2);

		LinkedList<Order> list = p.getOrder();
		int i =0;
		assertEquals(2,list.size());
		System.out.println(list.size());
		for(Order o :list){
			assert(o.getId()==i);
			System.out.println("list content: "+o.getId()+" "+o.getUnderlying().getSymbol());
			i++;
		}
		
		p.purchase(s2);
		System.out.println(list.size());
		assertEquals(1,list.size());
		
		LinkedList<Derivative> dlist = p.getOnhand();
		i = 0;
		for(Derivative d :dlist){
			assert(d.getId()==i);
			System.out.println("dlist content: "+d.getId()+" "+d.getPrice()+" "+d.getSymbol());
			i++;
		}

		System.out.println("credit "+p.getCredit());
		
		LinkedList<Derivative> list2 = new LinkedList<Derivative>();
		list2.add(s1);
		list2.add(s2);
		for(Derivative d :list2){
			if(d instanceof Stock)
			System.out.println("list content: "+d.getClass());
			i++;
		}
	*/	
		
		float newprice = 20;
		float netchange = -5;
		
		Option u = new Option(0, 10, "ABC", "8-12-15", 30, "Put");
		float lastprice = newprice-netchange;
		BlackSchole bs = new BlackSchole();
		bs.updateDate("8-8-14");
		String[] f = {"ABC"};
		bs.setFirms(f);
		double[] v = {0.2};
		bs.setVolatility(v);
		double lastoptionprice = bs.findOptionPrice(u.getSymbol(), u.getType(), lastprice, u.getStrike(), u.getMaturity());
		double nowoptionprice = bs.findOptionPrice(u.getSymbol(), u.getType(), newprice, u.getStrike(), u.getMaturity());
		newprice = (float) nowoptionprice;
		netchange = (float) (nowoptionprice - lastoptionprice);

		System.out.println(lastoptionprice+" "+nowoptionprice);
		System.out.println(newprice+" "+netchange);
	}

}
