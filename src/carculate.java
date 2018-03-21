

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import java.text.DecimalFormat;
import java.util.Random;

public class carculate {
	public int a,b,d;
	public int[] c;
	public String[] queslist;//题干的数组，字符�?
	public long[] anslist;//答案的数组，long�?4个三位数字有可能乘的比较大�??
	public int limit;
	
	public carculate(String name){		
	}

	public void setting(int ge,int wei,int[] fu,int totalnumber) {//输入参数
		a=ge;
		b=wei;
		c=fu;
		d=totalnumber;
		queslist=new String[d];
		anslist=new long[d];
		limit=(1000+(a-2)*(1000)*(int)Math.pow(1000, b));//答案极限�?
	}
	/*
	 * 参数分别�?:ge:运算的数字个数（2�?3�?4�?,int
	 * 		    wei:数字位数(0代表二位数字�?1代表三位数字�?),int
	 * 		    fu:符号数组共有四位，分别表示加减乘除，每一�?0表示不生成该运算�?1表示生成，int
	 * 		    totalnumber：题量，int�?
	 */
	static ScriptEngine jse= new ScriptEngineManager().getEngineByName("JavaScript");  
		
	public void create() {//生成算式和答案并存入queslist，和anslist�?
		int size=a;
		String[] singleques=new String[(size*2-1)];//单个算式�?
		String[] operator={"+","-","*","/"};//选择
		int opeselecter;
		int randomnum;
		int randomchu;
		
		for(int i=0;i<=(d-1);i++) {
			int[] judge=new int[(size*2-1)];//指示器，是否已经分配数字
			for(int j=2*a-3;j>=1;j=j-2) {				
				do{
					Random ran1=new Random();
					opeselecter=ran1.nextInt(4);
				}while(c[opeselecter]==0);
				singleques[j]=operator[opeselecter];
				if(operator[opeselecter]=="/") {//如果是除号，特殊处理
					int bei=1;
					Random ran2=new Random();
					if(b==0) {
						randomchu=ran2.nextInt(49)+1;
					}else {
						randomchu=ran2.nextInt(499)+1;
					}
					if(judge[j+1]==1) {
						j=j+2;
						continue;
						
					}	
					singleques[j+1]=Integer.toString(randomchu);
					judge[j+1]=1;
					do {
						bei++;						
					}while(randomchu*bei<=(100+b*900));
					singleques[j-1]=Integer.toString(randomchu*(ran2.nextInt(bei-2)+2));
					judge[j-1]=1;
				}
			}//运算符生成完�?
			
			for(int k=0;k<=2*(a-1);k=k+2) {
				if(judge[k]==1) {//已经先放了除法的数字则跳�?
					continue;
				}				
				Random ran3=new Random();
				if(b==0) {
					randomnum=ran3.nextInt(99)+1;
				}else {
					randomnum=ran3.nextInt(999)+1;
				}
				singleques[k]=Integer.toString(randomnum);
			}//数字生成完毕
			
			StringBuffer single=new StringBuffer();
			for(int p=0;p<(size*2-1);p++){
				single.append(singleques[p]);
			}//组合成一个题干，string			
			try {
				DecimalFormat df = new DecimalFormat("0");
				
				anslist[i]=Long.valueOf(String.valueOf(df.format(jse.eval(single.toString()))));
			} catch (ScriptException e) {
				// TODO 自动生成�? catch �?
				e.printStackTrace();
			}
			if((anslist[i]<=0)||(anslist[i]>limit)) {
				i--;
				continue;
			}
			queslist[i]=single.toString();
		}
	}
	

	public void showme() {
		for(int i=0;i<d;i++) {
			System.out.println(queslist[i]);
			System.out.println(anslist[i]);
		}
		
	}
	
	
}
