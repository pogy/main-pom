package com.shigu.main4.daifa.utils;

public class BigNumber extends Exception{	
	private String MyNumber;//大数	
	private int SystemNumber;//进制数
	public BigNumber(){
		this("0",10);
	}
    public BigNumber(String MyNumber){
    	this(MyNumber,10);
	}
    public BigNumber(String MyNumber, int SystemNumber){
    	this.MyNumber=MyNumber;
    	this.SystemNumber=SystemNumber;
    	this.Islegal(); 
	}
	public String getMyNumber() {
		return this.MyNumber;
	}
	public void setMyNumber(String myNumber) {
		this.MyNumber = myNumber;
	}
	public int getSystemNumber() {
		return this.SystemNumber;
	}
	public void setSystemNumber(int systemNumber) {
		this.SystemNumber = systemNumber;
	}
    public void Islegal(){//判断该字符串是否合法
    	if(this.MyNumber==null||this.MyNumber.length()==0){//大数为空或大数字符串长度为0
			throw (new  NumberFormatException("错误!大数为空或大数字符串长度为0 "+this.MyNumber));
    	}
    	if(this.SystemNumber<=1||this.SystemNumber>=63){//进制数不合法
			throw (new  NumberFormatException("错误!进制数不合法 "+this.SystemNumber));
    	}
    	if(this.MyNumber.equals("+")||this.MyNumber.equals("-")||this.MyNumber.equals(".")){
    		throw (new  NumberFormatException("错误!大数不合法 "+this.MyNumber));
    	}
    	if(this.MyNumber.equals("+.")||this.MyNumber.equals("-.")){
    		throw (new  NumberFormatException("错误!大数不合法 "+this.MyNumber));
    	}
    	for(int i=0,a,k=-1;i<this.MyNumber.length();i++){
    		a=Chartoint(this.MyNumber.charAt(i));
    		if(i!=0&&(a==-1||a==-2)){
    			throw (new  NumberFormatException("错误!符号位只能在大数首部 "+this.MyNumber.charAt(i)+"("+i+")"));
    		}
    		if(a>=this.SystemNumber||a==-4){
    			throw (new  NumberFormatException("错误!该字符不在该进制合法字符中 "+this.MyNumber.charAt(i)+"("+i+")"));
    		}
    		if(a==-3){
    			if(k==-1){
    				k=i;
    			}else{
    				throw (new  NumberFormatException("错误!出现了第二个小数点 "+this.MyNumber.charAt(i)+"("+i+")"));
    			}
    		}
    	}
    }
    protected static String Add_Positive(String s1,String s2,int n){//自定义两个正数加法运算   	
    	String Ins1=getInteger(s1),Dos1=getDecimal(s1),Ins2=getInteger(s2),Dos2=getDecimal(s2);//分别获取整数部分及小数部分
    	int Inlength=Math.max(Ins1.length(), Ins2.length()),Dolength=Math.max(Dos1.length(), Dos2.length());
    	Ins1=AddToLeft(Ins1,Inlength+1)+AddToRight(Dos1,Dolength);
    	Ins2=AddToLeft(Ins2,Inlength+1)+AddToRight(Dos2,Dolength);
    	String s="";
    	for(int i=Inlength+Dolength,m,y=0;i>=0;i--){
    		m=Chartoint(Ins1.charAt(i))+Chartoint(Ins2.charAt(i))+y;
    		s=Inttochar(m%n)+s;
    		y=m/n;
    	}
    	int pointplace=s.length()-Dolength;
    	s=Format(s.substring(0,pointplace)+"."+s.substring(pointplace),true);  	
    	return s;
    }       
    protected static String Sub_Positive(String s1,String s2,int n){//自定义两个正数减法运算;
    	if(ComparetoString(s1,s2)<0){//如果s1<s2则返回-(s2-s1)
    		return "-"+Sub_Positive(s2,s1,n);
    		
    	}                   
    	String Ins1=getInteger(s1),Dos1=getDecimal(s1),Ins2=getInteger(s2),Dos2=getDecimal(s2);//分别获取整数部分及小数部分
    	int Inlength=Math.max(Ins1.length(), Ins2.length()),Dolength=Math.max(Dos1.length(), Dos2.length());
    	String R=getComplement(new BigNumber(AddToLeft(Ins2,Inlength)+"."+AddToRight(Dos2,Dolength),n)).MyNumber;
    	R=Add_Positive(s1,R,n);
    	s2="0."+AddToLeft("1",Dolength);
    	R=Add_Positive(R,s2,n);
    	return Format(R.substring(1),true); 	
    }
    protected static String Mult_Positive(String s1,String s2,int n){//自定义两个正数乘法运算; 
    	String Ins1=getInteger(s1),Dos1=getDecimal(s1),Ins2=getInteger(s2),Dos2=getDecimal(s2);//分别获取整数部分及小数部分
    	Ins1+=Dos1;
    	Ins2+=Dos2;    	
    	int[]A=new int[Ins1.length()+Ins2.length()-1];
    	for(int i=Ins1.length()-1;i>=0;i--){
    		for(int j=Ins2.length()-1;j>=0;j--){
    			A[i+j]+=Chartoint(Ins1.charAt(i))*Chartoint(Ins2.charAt(j));
    		}
    	}
    	String s="";
    	for(int i=A.length-1;i>=1;i--){
    		s=Inttochar(A[i]%n)+s;
    		A[i-1]+=A[i]/n;
    	}
    	s=Inttochar(A[0]/n)+""+Inttochar(A[0]%n)+s;//特别要注意+""
    	int pointlength=Dos1.length()+Dos2.length();//获取小数点后的位数
    	return Format(s.substring(0,s.length()-pointlength)+"."+s.substring(s.length()-pointlength),true);		
    }   
    protected static String  Division_Positive(String s1, String s2,int n,int f){//自定义两个正数相除(f为小数点后的位数,能被除尽，且小数点后的位数少于f,则直接返回结果);
    	String Ins1=getInteger(s1),Dos1=getDecimal(s1),Ins2=getInteger(s2),Dos2=getDecimal(s2); //分别获取整数部分及小数部分  	
    	int Dolength=Math.max(Dos1.length(), Dos2.length());
    	Ins1+=AddToRight(Dos1,Dolength);
    	Ins2+=AddToRight(Dos2,Dolength);
    	String[]B=new String[n];B[0]="0";
    	for(int i=1;i<n;i++){
    		B[i]=Add_Positive(B[i-1],Ins2,n);//B[i]=Mult_Positive(Ins2,Inttochar(i)+"", n);
    	}
    	int i=Math.min(Ins1.length(), Ins2.length())-2,j;
    	String Ds0="",Ds1=Ins1.substring(0,i);//初始化整数部分余数部分	    	
    	while(true){
    		if(i!=Ins1.length()){
    			if(i<Ins1.length()){
    				Ds1+=Ins1.charAt(i);
    			}else{
    				Ds1+="0";
    				if(Ds1.equals("00")||i-Ins1.length()-1==f){
    					break;
    				}
    			}
    			//下面开始求Ds1/Ins2的整数部分及余数,结果分别赋值为Ds0,Ds1;采用二分查找获取整数部分
    			j=Binary(B,Ds1);
    			Ds0+=Inttochar(j);
				Ds1=Sub_Positive(Ds1,B[j],n);    			
    		}else{
    			Ds0+=".";
    		}
    		i++;
    	}
    	return Format(Ds0,true);  	
    }
    protected static int Binary(String[]A,String key){//二分查找key(数组A已经按从小到大的顺序排好序)
    	int low=0,height=A.length-1,middle,Compare;
		while(low<=height){
			middle=(low+height)/2;
			Compare=ComparetoString(key,A[middle]);
			if(Compare==0){
				return middle;
			}else if(Compare>0){
				low=middle+1;
			}else{
				height=middle-1;
			}
		}
		return height;
    }
    public BigNumber Add(BigNumber b){//自定义加法运算
    	if(this.SystemNumber!=b.SystemNumber){
    		throw (new  NumberFormatException("错误!这两个大数进制数不一致 ("+this.SystemNumber+","+b.SystemNumber+")"));
    	}
    	String s;
    	if(IsPositive(this.MyNumber)&&IsPositive(b.MyNumber)){
    		s=Add_Positive(this.MyNumber,b.MyNumber,this.SystemNumber);
    	}else if(IsPositive(this.MyNumber)&&!IsPositive(b.MyNumber)){
    		s=Sub_Positive(this.MyNumber,Opposite(b.MyNumber),this.SystemNumber);   		
    	}else if(!IsPositive(this.MyNumber)&&IsPositive(b.MyNumber)){    		
    		s=Sub_Positive(b.MyNumber,Opposite(this.MyNumber),this.SystemNumber);
    	}else{
    		s=Add_Positive(Opposite(this.MyNumber),Opposite(b.MyNumber),this.SystemNumber);
    		s=(s.equals("0")?"":"-")+s;
    	}
    	return new BigNumber(s,this.SystemNumber);
    }
    public BigNumber Sub(BigNumber b){//自定义减法运算
    	return this.Add(new BigNumber(Opposite(b.MyNumber),b.SystemNumber));
    }
    public BigNumber Mult(BigNumber b){//自定义乘法运算
    	if(this.SystemNumber!=b.SystemNumber){
    		throw (new  NumberFormatException("错误!这两个大数进制数不一致 ("+this.SystemNumber+","+b.SystemNumber+")"));
    	}
    	String s;
    	if(IsPositive(this.MyNumber)&&IsPositive(b.MyNumber)){
    		s=Mult_Positive(this.MyNumber,b.MyNumber,this.SystemNumber);
    	}else if(IsPositive(this.MyNumber)&&!IsPositive(b.MyNumber)){
    		s=Mult_Positive(this.MyNumber,Opposite(b.MyNumber),this.SystemNumber);   
    		s=(s.equals("0")?"":"-")+s;
    	}else if(!IsPositive(this.MyNumber)&&IsPositive(b.MyNumber)){    		
    		s=Mult_Positive(Opposite(this.MyNumber),b.MyNumber,this.SystemNumber);
    		s=(s.equals("0")?"":"-")+s;
    	}else{
    		s=Mult_Positive(Opposite(this.MyNumber),Opposite(b.MyNumber),this.SystemNumber);    		
    	}
    	return new BigNumber(s,this.SystemNumber);   	
    }
    public BigNumber Division(BigNumber b,int f){//自定义除法运算(f为小数点后的位数,能被除尽,且小数点后的位数少于f,则直接返回精确结果);
    	if(b.toString().equals("-0")||b.toString().equals("0")){
    		throw (new  NumberFormatException("错误!除数不能为零:"+b));
    	}
    	if(this.SystemNumber!=b.SystemNumber){
    		throw (new  NumberFormatException("错误!这两个大数进制数不一致! ("+this.SystemNumber+","+b.SystemNumber+")"));
    	}
    	if(f<0){
    		throw (new  NumberFormatException("错误!小数点后的位数应为非负值!("+f+")"));
    	}
    	String s;
    	if(IsPositive(this.MyNumber)&&IsPositive(b.MyNumber)){
    		s=Division_Positive(this.MyNumber,b.MyNumber,this.SystemNumber,f);
    	}else if(IsPositive(this.MyNumber)&&!IsPositive(b.MyNumber)){
    		s=Division_Positive(this.MyNumber,Opposite(b.MyNumber),this.SystemNumber,f);   
    		s=(s.equals("0")?"":"-")+s;
    	}else if(!IsPositive(this.MyNumber)&&IsPositive(b.MyNumber)){    		
    		s=Division_Positive(Opposite(this.MyNumber),b.MyNumber,this.SystemNumber,f);
    		s=(s.equals("0")?"":"-")+s;
    	}else{
    		s=Division_Positive(Opposite(this.MyNumber),Opposite(b.MyNumber),this.SystemNumber,f);    		
    	}
    	return new BigNumber(s,this.SystemNumber); 
    }
    public BigNumber Division(BigNumber b){//自定义除法运算,默认为保留50位小数(若能被除尽,且小数点后的位数少于50,则直接返回精确结果);
    	return Division(b,50);
    }
    protected static int ComparetoString(String s1,String s2){//判断两个正数的大小s1>s2返回1,s1=s2返回0,s1<s2返回-1
    	String Ins1=getInteger(s1),Dos1=getDecimal(s1),Ins2=getInteger(s2),Dos2=getDecimal(s2);
    	int Dolength=Math.max(Dos1.length(), Dos2.length());
    	Ins1+=AddToRight(Dos1,Dolength);
    	Ins2+=AddToRight(Dos2,Dolength);
    	if(Ins1.length()>Ins2.length()){
    		return 1;
    	}else if(Ins1.length()<Ins2.length()){
    		return -1;
    	}
    	for(int i=0;i<Ins1.length();i++){
    		if(Ins1.charAt(i)>Ins2.charAt(i)){
    			return 1;
    		}else if(Ins1.charAt(i)<Ins2.charAt(i)){
    			return -1;
    		}
    	}
    	return 0;
    }
    public int Compareto(BigNumber b){
    	if(this.SystemNumber!=b.SystemNumber){
    		throw (new  NumberFormatException("错误!这两个大数进制数不一致 ,暂时无法比较("+this.SystemNumber+","+b.SystemNumber+")"));
    	}
    	String s1=Format(this.MyNumber,false),s2=Format(b.MyNumber,false);
    	if(IsPositive(s1)&&IsPositive(s2)){
    		return ComparetoString(s1,s2);//int a=s1.CompareTo(s2); return a!=0?(a>0?1:-1):0;
    	}else if(IsPositive(s1)&&!IsPositive(s2)){
    		return 1;
    	}else if(!IsPositive(s1)&&IsPositive(s2)){
    		return -1;
    	}else{
    		return -ComparetoString(s1.substring(1),s2.substring(1));
    	}
    }
    protected static String Conver1(long n,int R){//将十进制数n转换为R进制数
    	if(R==10){
    		return n+"";
    	}
    	String s="";
    	while(true){
    		s=Inttochar((int)(n%R))+s;
    		n/=R;
    		if(n==0){
    			return s;
    		}
    	}   	
    } 
    /*
     * 将R1进制正整数s转化为R2进制数 
     * (由于Conversion频繁调用该函数,为提高效率,引入两个辅助数组Hex1,Hex2):
     * Hex1[i]是十进制数i转换为R2进制数后的数,0<=i<=R1;Hex2[i]=Hex1[R1]^i,0<=i<=s.length()
     * Hex2[i]是十进制数R1转换为R2进制数后的i次方
     */
    protected static String Conver(String s,int R1,int R2,String[]Hex1,String[]Hex2){
		String Ins="0";//初始化新进制对应的大数
		for(int i=0;i<s.length();i++){  			
			Ins=Add_Positive(Ins,Mult_Positive(Hex1[Chartoint(s.charAt(s.length()-1-i))],Hex2[i],R2),R2); 							 
		}
		return Ins;
    }
    protected static String Conversion(String MyNumber,int R1,int R2,int N,int f){//将R1进制大数MyNumber转换为R2进制的大数(f为小数点后的位数,能被除尽,且小数点后的位数少于f,则直接返回结果),N为将MyNumber分组后每组字符串的长度;
    	if(R2==R1){
    		int a=getDecimal(MyNumber).length()-f;
    		if(a>0){
    			return MyNumber.substring(0,MyNumber.length()-a);
    		}
    		return MyNumber;
    	}
    	if(MyNumber.charAt(0)=='+'||MyNumber.charAt(0)=='-'){
    		char c=MyNumber.charAt(0);
    		return c+Conversion(MyNumber.substring(1),R1,R2,N,f);
    	}
    	String[]Hex1=new String[R1+1];
		for(int i=0;i<=R1;i++){//将0~R1的所有数字转换为R2进制
			Hex1[i]=Conver1(i,R2);
		}
		String[]Hex2=new String[N+1];Hex2[0]="1";
		for(int i=1;i<=N;i++){//求十进制数R1转换为R2进制数后的i次方
			Hex2[i]=Mult_Positive(Hex2[i-1],Hex1[R1],R2);
		}			
    	String Ins1=getInteger(MyNumber),Dos1=getDecimal(MyNumber);//获取整数部分及小数部分		
		/*
		 * 经过计算当转化后的R2进制数只需保留f位小数时,原R1进制数MyNumber只需保留a位
		 * 当MyNumber小数位很多，而f较小时在一定程度上能提高效率
		 */
		int a=(int)Math.ceil(f*Math.log(R2)/Math.log(R1))+1;
		if(a<=Dos1.length()){
			Dos1=Dos1.substring(0,a);
		}
		
		Ins1=AddToLeft(Ins1,Ins1.length()+(N-Ins1.length()%N)%N);//扩充Ins1
		Dos1=AddToRight(Dos1,Dos1.length()+(N-Dos1.length()%N)%N);//扩充Dos1
		String Ins="0",Dos="0",x="1";//new BigNumber(Conver1(R1,R2),R2).Power(N).MyNumber;初始化新进制对应的大数的整数部分及小数部分 ,设置初值及权  	   		   		
		int Count=Math.max(Ins1.length()/N,Dos1.length()/N);//循环次数   
		for(int i=0,i1=Ins1.length()/N,i2=Dos1.length()/N;i<Count;i++){  			
			if(i<i1){
				Ins=Add_Positive(Ins,Mult_Positive(Conver(Ins1.substring(Ins1.length()-(i+1)*N,Ins1.length()-i*N),R1,R2,Hex1,Hex2),x,R2),R2);
			}
			if(i<i2){   				    				   				
				Dos=Add_Positive(Dos,Mult_Positive(Conver(Dos1.substring(Dos1.length()-(i+1)*N,Dos1.length()-i*N),R1,R2,Hex1,Hex2),x,R2),R2);
				if(i==i2-1){
    				Dos=Division_Positive(Dos,Mult_Positive(x,Hex2[N],R2),R2,f);
    			}
			}   
			x=Mult_Positive(x,Hex2[N],R2);
		}
		return Ins+Dos.substring(1);//或Add_Positive(Ins,Dos,R2);   		    	  	
    }
    public BigNumber HexConversion(int R,int N,int f){
    	if(R<=1||R>=63){//进制数不合法
			throw (new  NumberFormatException("错误!进制数不合法 "+this.SystemNumber));
    	}
    	if(N<=0){
    		throw (new  NumberFormatException("错误!每小组的字符串长度不能小于1!("+N+")"));
    	}
    	if(f<0){
    		throw (new  NumberFormatException("错误!小数点后的位数应为非负值!("+f+")"));
    	}
    	return new BigNumber(Conversion(this.MyNumber,this.SystemNumber,R,N,f),R);
    }  
    public BigNumber HexConversion(int R,int f){
    	int N=(int)Math.pow(Math.max(getInteger(this.MyNumber).length(),getDecimal(this.MyNumber).length()),0.6)+1;
    	return HexConversion(R,N,f);
    } 
    public BigNumber HexConversion(int R){
    	return HexConversion(R,50);
    }      
    
    public BigNumber Power(int n,int f){//求a^n,n为十进制整数(f为小数点后的位数,能被除尽,且小数点后的位数少于f,则直接返回结果);
    	if(n<0){
    		return new BigNumber("1",this.SystemNumber).Division(this.Power(-n,f),f);
    	}
    	String s=Conver1(n,2);
		BigNumber r=new BigNumber("1",this.SystemNumber),k=this;
    	for(int i=0;i<s.length();i++){        		
    		if(s.charAt(s.length()-1-i)=='1'){
    			r=r.Mult(k);
    		}
    		k=k.Mult(k);
    	}		
    	return r;    		  	
    }
    public BigNumber Power(int n){//求a^b,b为十进制整数
    	return Power(n,50);
    }
    
    protected static BigNumber getComplement(BigNumber b){//获得 b的每位取反后的大数
    	String s="";
    	char c=b.MyNumber.charAt(0);
    	if(c=='+'||c=='-'||c=='.'){
    		s+=c;
    	}else{
    		s+=Inttochar(b.SystemNumber-1-Chartoint(c));
    	}
    	for(int i=1;i<b.MyNumber.length();i++){
    		c=b.MyNumber.charAt(i);
    		if(c=='.'){
    			s+=c;
    		}else{
    			s+=Inttochar(b.SystemNumber-1-Chartoint(c));
    		}
    	}
    	return new BigNumber(s,b.SystemNumber);
    }
    protected static String AddToLeft(String s,int length){//若s的长度大于或等于length,则直接返回s,否则字符串s左边补零,直到s长度达到length
    	if(s.length()>=length){
    		return s;
    	}
    	while(s.length()<length){
        	s="0000000000"+s;
        }
        return s.substring(s.length()-length,s.length());
    }
    protected static String AddToRight(String s,int length){//若s的长度大于或等于length,则直接返回s,否则字符串s右边补零,直到s长度达到length
    	if(s.length()>=length){
    		return s;
    	}
    	while(s.length()<length){
            s=s+"0000000000";
        }
        return s.substring(0,length);
    }
    protected static String Format(String MyNumber,boolean DealZero){//对于合法的大数,格式化大数为a.b(或-a.b)的形式,若b=0且DealZero为真则返回a(或-a)的形式
    	new BigNumber(MyNumber,62);//若该大数不合法则抛出异常
		String s;
    	if(MyNumber.charAt(0)=='+'||MyNumber.charAt(0)=='-'){
    		s=MyNumber.substring(1);
    	}else{
    		s=MyNumber;
    	}
    	if(getPointPlace(s)==0){
    		s="0"+s;
    	}else if(getPointPlace(s)==s.length()-1){
    		s=s+"0";
    	}else if(getPointPlace(s)==s.length()){
    		s=s+".0";
    	}
    	int Ins=0,Dos=s.length(),pointplace=getPointPlace(s);
    	for(int i=0;i<pointplace-1;i++){
    		if(s.charAt(i)=='0'){
    			Ins++;
    		}else{
    			break;
    		}
    	}   	
    	for(int i=s.length()-1;i>pointplace+1;i--){
    		if(s.charAt(i)=='0'){
    			Dos--;
    		}else{
    			break;
    		}
    	}  	
		s=(MyNumber.charAt(0)=='-'?"-":"")+s.substring(Ins,Dos);
		if(DealZero&&s.substring(s.length()-2).equals(".0")){
			return s.substring(0,s.length()-2);
		}else{
			return s;
		}
	}   
    protected static boolean IsPositive(String MyNumber){//判断该大数是否为正数(负数返回false,0和正数返回true)
    	if(MyNumber.charAt(0)=='-'){
    		return false;
    	}
    	return true;
    }
    protected static int  getPointPlace(String MyNumber){//返回该大数小数点位置
    	for(int i=0;i<MyNumber.length();i++){
    		if(MyNumber.charAt(i)=='.'){
    			return i;
    		}
    	}
    	return MyNumber.length();
    }   
    protected static String Abs(String MyNumber){//返回该大数的绝对值
    	MyNumber=Format(MyNumber,true);
    	return MyNumber.substring(MyNumber.charAt(0)=='-'?1:0);
    }
    protected static String Opposite(String MyNumber){//返回该大数的相反数   	
    	return MyNumber.charAt(0)=='-'?Abs(MyNumber):"-"+Abs(MyNumber);
    }
    protected static String getInteger(String MyNumber){//返回该大数的整数部分     
    	MyNumber=Format(MyNumber,false);
    	return MyNumber.substring(0,getPointPlace(MyNumber));
    }
    protected static String getDecimal(String MyNumber){//返回该大数的小数部分 
    	MyNumber=Format(MyNumber,false);
    	String s=getPointPlace(MyNumber)==MyNumber.length()?"0":MyNumber.substring(getPointPlace(MyNumber)+1);
    	return (MyNumber.charAt(0)=='-'?"-":"")+s;	
	}
    protected static int Chartoint(char c){//字符化为数字
		if(c>='0'&&c<='9'){
			return c-'0';
		}else if(c>='A'&&c<='Z'){
			return c-'A'+10;
		}else if(c>='a'&&c<='z'){
			return c-'a'+36;
		}else if(c=='+'){//正号
			return -1;
		}else if(c=='-'){//负号
			return -2;
		}else if(c=='.'){//小数点
			return -3;
		}else{//其他
			return -4;
		}
	}
    protected static char Inttochar(int n){//数字化为字符
		if(n>=0&&n<=9){//0~9用0~9表示
			return (char)(n+48);
		}else if(n>=10&&n<=35){//10~35用A~Z表示
			return (char)(n+55);
		}else if(n>=36&&n<=61){//36~61用a~z表示
			return (char)(n+61);
		}else{//小于0或大于61的数用'~'表示
			return '~';
		}
	}
	public String toString(){
		return Format(this.MyNumber,true);
	}	
	
	public static void main(String[]args){
		String MyNumber="200000000";
		String MyNumber2="0";
	    int R1=10,R2=23,R3=2;
	    int f=0;
	    BigNumber b=new BigNumber(MyNumber,R1);//10进制
	    BigNumber c=new BigNumber(MyNumber2,R2);//23进制
		long c1=System.currentTimeMillis();
		System.out.println("将"+R1+"进制数"+MyNumber+"转化为"+R2+"进制数并保留"+f+"位小数后去除无效位的结果为:"+b.HexConversion(23, f));
		long c2=System.currentTimeMillis();
		System.out.println("将"+R1+"进制数"+MyNumber+"转化为"+R3+"进制数并保留"+f+"位小数后去除无效位的结果为:"+b.HexConversion(R3, f));
		long c3=System.currentTimeMillis();
		System.out.println("两次转换分别耗时为 "+(c2-c1)+"ms,"+(c3-c2)+"ms");
	}	
}

