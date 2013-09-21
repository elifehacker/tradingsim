
public class DateCovert {

	
	public static String dateconvert(String date){
		StringBuffer sb = new StringBuffer();
		
		String[] splited = date.split("-");
		if(splited != null){

			sb.append(splited[0]+"/");
			int monthNumber = 0;
			String lower = splited[1].toLowerCase();
			if(lower.equals( "jan")){
	            monthNumber = 1;
	            
	        }else if(lower.equals( "feb")){
	            monthNumber = 2;
	            
	        }else if(lower.equals( "mar")){
	            monthNumber = 3;
	            
	        }else if(lower.equals( "apr")){
	            monthNumber = 4;
	            
	        }else if(lower.equals( "may")){
	            monthNumber = 5;
	            
	        }else if(lower.equals( "jun")){
	            monthNumber = 6;
	            
	        }else if(lower.equals( "jul")){
	            monthNumber = 7;
	            
	        }else if(lower.equals( "aug")){
	            monthNumber = 8;
	            
	        }else if(lower.equals( "sep")){
	            monthNumber = 9;
	            
	        }else if(lower.equals( "oct")){
	            monthNumber = 10;
	            
	        }else if(lower.equals( "nov")){
	            monthNumber = 11;
	            
	        }else if(lower.equals( "dec")){
	            monthNumber = 12;
	            
	        }

			sb.append(lower+"/"+splited[2]);
		}
		return sb.toString();
    }

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
