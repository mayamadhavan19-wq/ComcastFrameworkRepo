package pratice.datadriventesting;

public class GenerateAlphaNumericRandomdata {
    public static void main(String[] args) {
		int n = 20;
		//choose a character random from this string
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		//create string buffer size of Alphanumeric string
		StringBuilder sb = new StringBuilder(n);
		for(int i=0;i<n;i++) {
			//Generate a random number between 0 to Alphanumeric variable length
			int index = (int)(AlphaNumericString.length()*Math.random());
			//Add character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}
		System.out.println(sb);
	}
}