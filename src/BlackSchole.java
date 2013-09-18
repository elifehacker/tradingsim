
public class BlackSchole {

	// The Black and Scholes (1973) Stock option formula

	public static double BlackScholes(char CallPutFlag, double S, double X, double T, double r, double v)
	{
	double d1, d2;

	d1=(Math.log(S/X)+(r+v*v/2)*T)/(v*Math.sqrt(T));
	d2=d1-v*Math.sqrt(T);

	if (CallPutFlag=='c')
	{
	return S*CND(d1)-X*Math.exp(-r*T)*CND(d2);
	}
	else
	{
	return X*Math.exp(-r*T)*CND(-d2)-S*CND(-d1);
	}
	}

	// The cumulative normal distribution function
	public static double CND(double X)
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
	
	private static double abs(double a, double b){
		if(a>b){
			return a - b;
		}else{
			return b - a;
		}
	}
	
	public static double findImpliedvolatility(char CallPutFlag, double S, double X, double T, double r, 
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
		double price = BlackSchole.BlackScholes('c', 23.75, 15.00, 0.5, 0.01, 0.5916);
		System.out.println(price);
		price = BlackSchole.BlackScholes('c', 30.14, 15.00, 0.25, 0.01, 0.5762);
		System.out.println(price);
		
		double v = findImpliedvolatility('c', 120, 125, 0.33, 0.0283, 0 , 5 , 9);//0.0283 -- 10 year gov bond
		System.out.println(v);

		price = BlackSchole.BlackScholes('c', 120, 125, 0.33, 0.0283, 0.3877);
		System.out.println(price);
	}

}
