/**
 * 
 */
package assignment1_cs;

/**
 * @author SuperNote
 *
 */
public class analyst {
	public long[] respond;//储存答案的数组
	public int[] counter;//记录得分的数组
	public int stl=100,d;//步长单次运行步长，题量
	public analyst(long[] res,int vol)//初始化答案数组和题量
	{
		d=vol;
		if(res.length==d)
		{
			respond =new long[d];
			System.arraycopy(res, 0, respond, 0, d);
		}
		//else 可做报错“用户输入答案过多”
	}
	public int comparer (long[] anslist)
	{
		counter=new int[d];
		for (int i=0;i<=(d-1);i++)//for (int i=0;i<=(d-1) && i<stl;i++)可改逐步评卷
		{
			if(respond[i] == anslist[i])
			{
				counter[i]=1;
			}
			else if(respond[i] != anslist[i])
			{
				counter[i]=0;
			}
			//else 
				}
		return 0;
	}
	public double Sumscore()//返回总分的计分器,百分制
	{
		int score = 0;
		for(int i=0;i<=(d-1);i++)
		{
			score+=counter[i];
		}
		score=score*100;
		double f_score=score;
		f_score=f_score/d;
		return f_score;
				}
	}
