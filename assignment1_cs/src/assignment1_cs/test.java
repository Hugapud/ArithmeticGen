package assignment1_cs;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class test{//测试字符串转换为运算式的。
	   String ques;
	   public test(String name){
	      System.out.println("name: " + name ); 
	   }
	 
	   public void setAge( String qq ){
	       ques = qq;
	   }
	 
	   public void getAge(){
	       try {
			System.out.println(jse.eval(ques));
		} catch (ScriptException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	       }
	 
	   static ScriptEngine jse= new ScriptEngineManager().getEngineByName("JavaScript");  

	   public static void main(String []args){
	      test mycode = new test( "newcode" );
	      mycode.setAge( "32+6*3/2" );
	     
	      mycode.getAge( );
	   }
	}