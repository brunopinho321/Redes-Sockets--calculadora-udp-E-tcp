package testeredes;

public class Calculadora {
	private static String operando(String st) {
		String oper;
		int pos = st.indexOf(",");
		oper = st.substring(0,pos);
		return oper;
	}
	private static double num1(String st){
		String oper;
		int p = st.indexOf(",");
		int s = st.lastIndexOf(",");
		oper = st.substring(p+1,s);
		double num = Double.parseDouble(oper);
		return num;
	}
	
	private static double num2(String st){
		String oper;
		int p = st.indexOf(",");
		int s = st.lastIndexOf(",");
		oper = st.substring(s+1);
		double num = Double.parseDouble(oper);
		return num;
	}
	
	public static double calcular(String str) {
		str = str.replaceAll(" ","");
		if((operando(str).equalsIgnoreCase("ADD"))) {
			return num1(str) + num2(str);
		}
		else if((operando(str).equalsIgnoreCase("SUB"))){
			return num1(str) - num2(str);
		}
		else if((operando(str).equalsIgnoreCase("MUT"))){
			return num1(str) * num2(str);
		}
		else if((operando(str).equalsIgnoreCase("DIV"))){
			return num1(str) / num2(str);
		}
		return -1;
	}
	
}

