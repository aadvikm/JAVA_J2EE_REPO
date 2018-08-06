package com.package1;

public class WrapperClassPractice {

	public WrapperClassPractice() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		//Primitive to Wrapper Class
		System.out.println("-----Primitive to Wrapper Class -----");
		byte b=10;
		Byte by =Byte.valueOf(b);
		System.out.println("Byte Value :"+by);
		short s =20;
		Short sh =new Short(s);
		System.out.println("Short Value :"+sh);
		int i=30;
		Integer it =i;//autoboxing
		System.out.println("Integer Value :"+it);
		long l =40;
		Long lo =Long.valueOf(l);
		System.out.println("Long Value :"+lo);
		float f =50.0f;
		Float fl=f;//autoboxing;
		System.out.println("Float Value :"+fl);
		double d =60.0;
		Double du =new Double(d);
		System.out.println("Double Value :"+du);
		char c ='a';
		Character ch =Character.valueOf(c);
		System.out.println("Character Value :"+ch);
		boolean bo=false;
		Boolean bool =new Boolean(bo);
		System.out.println("Boolean Value :"+bool);
		
		//Wrapper to Primitive
		System.out.println("-----  Wrapper Class to Primitive-----");
		Byte bi =10;
		byte bit=bi;//unboxing
		System.out.println("byte Value :"+bit);
		Short shor =20;
		short x =shor.shortValue();
		System.out.println("short Value :"+x);
		Integer ie =30;
		int iet =ie.intValue();
		System.out.println("int Value :"+iet);
		Long g =new Long(40);
		long li =g.longValue();
		System.out.println("long Value :"+li);
		Float fi =50.0f;
		float floa =fi.floatValue();
		System.out.println("float Value :"+floa);
		Double dd =new Double(60);
		double dob =dd;//UnBoxing
		System.out.println("double Value :"+dob);
		Character cx ='A';
		char cz =cx;
		System.out.println("char Value :"+cz);
		Boolean v =true;
		boolean u =v.booleanValue();
		System.out.println("boolean Value :"+u);
		
		//String to Wrapper Class
		System.out.println(" -----String to Wrapper Class-----");
		String str ="40";
		Integer iStr =Integer.valueOf(str);
		System.out.println("Integer Value from String :"+iStr);
		System.out.println(" -----Wrapper Class to String-----");
		Byte m =50;
		String sdf =m.toString();
		System.out.println("String from Byte :"+sdf);
		
		//String to Primitive
		
		System.out.println(" -----String to Primitive-----");
		String str1 ="505";
		int ig =Integer.valueOf(str1);//UnBoxing
		System.out.println("int Value from String :"+ig);
		
		System.out.println(" -----Primitive to String-----");
		short df =45;
		String str2 =String.valueOf(df);
		System.out.println("String from short :"+str2);

		
		
		

	}

}
