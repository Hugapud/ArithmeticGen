package assignment1_cs;

public class test2 {//测试生成结果
	 public static void main(String []args){
	      carculate mycode = new carculate( "newcode" );
	      int[] aa= {1,1,1,1};
	      mycode.setting(4,1,aa,10);
	      mycode.create();
	      mycode.showme();
	      long[] ansl = new long[mycode.d];//生成模拟用户答案
	      System.arraycopy(mycode.anslist, 0, ansl, 0, mycode.d);
	      ansl[1]=3;
	      analyst any = new analyst(ansl,mycode.d);
	      any.comparer(mycode.anslist);
	      System.out.println(any.Sumscore());
	   }
}
