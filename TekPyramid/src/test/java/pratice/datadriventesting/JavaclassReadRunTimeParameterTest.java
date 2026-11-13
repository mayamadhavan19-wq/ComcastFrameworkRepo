package pratice.datadriventesting;

public class JavaclassReadRunTimeParameterTest {
   public static void main(String[] args) {
	System.out.println(args.length);
	for(String var:args) {
		System.out.println(var);
	}
}
}