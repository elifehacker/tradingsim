package model;

public class BlackSchole {

	static double volatility [];
	static double current_price [];
	static String date;
	static String firms[];
	
	public void updatePrices(double v[]){
		current_price = v;
	}	
	
	public void updateDate(String v){
		date = v;
	}

	public void setVolatility(double v[]){
		volatility = v;
	}

	public void setFirms(String[] v) {
		// TODO Auto-generated method stub
		firms = v;
	}

	public double findOptionPrice(String tic, String callput, float crt_price, float x_price, String x_date){
		int i;
		for(i = 0; i<firms.length; i++){
			if(firms[i].equals(tic))break;
		}
		double v = volatility[i];

		char t = 'P';
		if(callput.equals("Call")) t = 'C';	

		double timediff = timetilmaturity(date, x_date);
		return BlackScholes(t, crt_price, x_price, 
				timediff, bondyield(timediff), v);
	}
	
	public double findOptionPrice(String tic, String callput, String x_price, String x_date){
    	//System.out.println("BS: tic"+tic+" "+callput+" "+x_price+" "+x_date);

		int i;
		for(i = 0; i<firms.length; i++){
			if(firms[i].equals(tic))break;
		}
		double v = volatility[i];
		//System.out.println("BS: v i are "+v+" "+i);
		if(v==-1)return -1;
		char t = 'P';
		if(callput.equals("Call")) t = 'C';	

		double timediff = timetilmaturity(date, x_date);
		/*
		System.out.println("tic is "+firms[i]);
		System.out.println("v is "+v);
		System.out.println("Type is "+t);
		System.out.println("Time diff is "+timediff);
		System.out.println("Current price is "+current_price[i]);
	*/
		return BlackScholes(t, current_price[i], Double.parseDouble(x_price), 
				timediff, bondyield(timediff), v);
	}
	
	//http://finance.yahoo.com/bonds/composite_bond_rates
	public double bondyield(double diff){
		//System.out.println("---diff is "+diff);
		if(diff>30) return new Double(0.0376);
		if(diff>10) return new Double(0.0273);
		if(diff>5) return new Double(0.0147);
		if(diff>3) return new Double(0.0068);
		if(diff>2) return new Double(0.0033);
		if(diff>0.5) return new Double(0.0002);
		if(diff>0.25) return new Double(0.0001);

		return 0;	
	}
	
	
	public double timetilmaturity(String a, String b){
		
		//System.out.println("BlackSch "+a+" "+b);

		String d1[] = a.split("[-/]");
		String d2[] = b.split("[-/]");
		int integer = Integer.parseInt(d2[2]) - Integer.parseInt(d1[2]);
		int decimal = Integer.parseInt(d2[1]) - Integer.parseInt(d1[1]);
		if(decimal <0){
			integer--;
			decimal+=12;
		}
		
		return integer+(double)decimal/12;
	}
	
	
	
	// The Black and Scholes (1973) Stock option formula

	public double BlackScholes(char CallPutFlag, double S, double X, double T, double r, double v)
	{
		
		if(T<0){
			return -1;
		}
		
		double d1, d2;
	
		d1=(Math.log(S/X)+(r+v*v/2)*T)/(v*Math.sqrt(T));
		d2=d1-v*Math.sqrt(T);
	
		if (CallPutFlag=='C')
		{
			return S*CND(d1)-X*Math.exp(-r*T)*CND(d2);
		}
		else
		{
			return X*Math.exp(-r*T)*CND(-d2)-S*CND(-d1);
		}
	}

	// The cumulative normal distribution function
	public double CND(double X)
	{
		double L, K, w ;
		double a1 = 0.31938153, a2 = -0.356563782, a3 = 1.781477937, a4 = -1.821255978, a5 = 1.330274429;
	
		L = Math.abs(X);
		K = 1.0 / (1.0 + 0.2316419 * L);
		w = 1.0 - 1.0 / Math.sqrt(2.0 * Math.PI) * Math.exp(-L *L / 2) * (a1 * K + a2 * K *K + a3
		* Math.pow(K,3) + a4 * Math.pow(K,4) + a5 * Math.pow(K,5));
	
		if (X < 0.0)
		{
			w= 1.0 - w;
		}
		return w;
	}
	
	private double abs(double a, double b){
		if(a>b){
			return a - b;
		}else{
			return b - a;
		}
	}
	
	public double findImpliedvolatility(char CallPutFlag, double S, double X, double T, double r, 
			double v1, double v2, double target){
		
		double p1 = BlackScholes( CallPutFlag,  S,  X,  T,  r,  v1);
		double p2 = BlackScholes( CallPutFlag,  S,  X,  T,  r,  v2);
		
		double diff = (v2-v1)/2;
		
		//System.out.println("p1 and p2 are "+p1+" "+p2);

		if(target > p1 && target > p2){
			return 0;
		}
		if(target < p1 && target < p2){
			return 0;			
		}
		
		if(target - p1 < 0.001){
			return v1;
		}
		if(p2 - target < 0.001){
			return v2;
		}

		if(target > p1 && target < p2){
			//System.out.println("In range "+p1+" "+p2);

			double a = findImpliedvolatility(CallPutFlag,  S,  X,  T,  r,  v1+diff, v2, target);
			double b = findImpliedvolatility(CallPutFlag,  S,  X,  T,  r,  v1, v2-diff, target);
			
			if(a == 0) return b;
			return a;
		}
		
		
		return 0;		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlackSchole bs = new BlackSchole();
		double price = bs.BlackScholes('C', 23.75, 15.00, 0.5, 0.01, 0.5916);
		System.out.println(price);
		price = bs.BlackScholes('C', 30.14, 15.00, 0.25, 0.01, 0.5762);
		System.out.println(price);
		
		System.out.println("-------");

		double v = bs.findImpliedvolatility('C', 120, 125, 2.33, 0.0068, 0 , 5 , 9.09);//0.0283 -- 10 year gov bond
		System.out.println(v);

		price = bs.BlackScholes('C', 120, 95, 2.33, 0.0068, v);//should be 27.05
		System.out.println(price);

		System.out.println("-------");

		v = bs.findImpliedvolatility('C', 35, 30, 1.33, 0.0033, 0 , 5 , 6.33);//0.0033 -- 2 year gov bond
		System.out.println(v);

		price = bs.BlackScholes('C', 35, 35, 1.33, 0.0033, v);//should be 3.2
		System.out.println(price);	
		
		//System.out.println("-------");

		//System.out.println(BlackSchole.timetilmaturity("8-9-12","8-5-13"));
	
	}


}
