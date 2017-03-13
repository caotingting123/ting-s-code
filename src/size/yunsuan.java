package size;
import java.util.Scanner;
public class yunsuan {
	public static Scanner in=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int s;
	    while(true)
	    {
	    	System.out.println("请输入要进行的运算：");
		    System.out.println("1.整数四则运算：");
		    System.out.println("2.真分数四则运算：");
		    System.out.println("3.退出：");
		    s=in.nextInt();
	    	if(s==1)
	    	{
	    		System.out.println("请输入要生成题目的个数：");
	    		int n=in.nextInt();
	    	    System.out.println("请输入数值范围：");
	    	    int p=in.nextInt();
	    	    int q=in.nextInt();
	    	    System.out.println("是否有括号？ 1:有 2:否");
	    	    int k=in.nextInt();
	    	    if(k==1)
	    	    {
	    	    	parentheses(n,p,q);
	    	    }
	    	    else
	    	    {
	    	    	IntYuan(n,p,q);
	    	    }
	    		continue;
	    	}
	    	if(s==2)
	    	{
	    		System.out.println("请输入要生成题目的个数：");
	    	    int m=in.nextInt();
	    	    for(int j=0;j<m;j++)
	    	    {
	    	    TrueNum();
	    	    }
	    	    continue;
	    	}
	    	if(s==3)
	    	{
	    		break;
	    	}
	    	else
	    	{
	    		System.out.println("输入错误，请重新输入：");
	    		s=in.nextInt();
	    	}
	    }
	    in.close();
	}
	public static void IntYuan(int n,int p,int q)
	{
		int a1=0;
	    int a2=0;
	    int result1;
	    char ch;
	    System.out.print("是否有乘除法？ 1:有 2:否");
	    int c=in.nextInt();
	    System.out.print("加减有无负数？ 1:有 2:否");
	    int f=in.nextInt();
	    System.out.print("除法有无余数？ 1:有 2:否");
	    int y=in.nextInt();
		for(int i=0;i<n;i++) 
		{
			a1=ranNum(a1,p,q);
			a2=ranNum(a2,p,q);
			if(c==1)
			{
				ch=ranChar1();
			}
			else
			{
				ch=ranChar2();
			}
			//当加减不能出现负数时执行此操作
			if(f==2 &&((a1<0||a2<0)||(a1<a2 && ch=='-')))
			{
				i--;
			}
			//当除法不能有余数时执行此操作
			else if(y==2 && ch=='/' && a1%a2!=0)
			{
				i--;
			}
			else
			{
				System.out.print(a1);
				System.out.print(ch);
				System.out.println(a2+"=");
				System.out.print("请输入答案：");
				result1=in.nextInt();
				if(ch=='+'&&(result1==a1+a2))
				{
					
					System.out.println("计算正确！");
				}
				else if(ch=='-'&&(result1==a1-a2))
				{
					System.out.println("计算正确！");
				}
				else if(ch=='*'&&(result1==a1*a2))
				{
					System.out.println("计算正确！");
				}
				else if(ch=='/'&&(result1==a1/a2))
				{
					System.out.println("计算正确！");
				}
				else
				{
					System.out.println("计算错误！");
				}
			}
		 }
	}
	public static void parentheses(int n,int p,int q)//带括号运算
	{
		int num=(int)(Math.random()*11+3);
		int[] a={0,0,0,0,0,0,0,0,0,0};
		for(int i=0;i<n;i++)
		{
			int a1=0;
			a1=ranNum(a1,p,q);
			System.out.print(a1);
			System.out.print(ranChar1()+"(");
			for(int j=0;j<num-4;j++)
			{
				System.out.print(ranNum(a[j],p,q));
				System.out.print(ranChar1());
			}
			System.out.println(ranNum(a[num-3],p,q)+")=");
		}
	}
	public static int ranNum(int a,int b,int c)
	{
		a=(int)(Math.random()*(c-b+1)+b);//随机数值范围为从b到c
		return a;
	}
	public static char ranChar1()
	{
		char[] b={'+','-','*','/'};
		int c=(int)(Math.random()*4);
		return b[c];
	}
	public static char ranChar2()
	{
		char[] b={'+','-'};
		int c=(int)(Math.random()*2);
		return b[c];
	}
	public static void TrueNum()
	{
		int b1,b2,b3,b4;
		b1=(int)(Math.random()*100);
		b2=(int)(Math.random()*100);
		b3=(int)(Math.random()*100);
		b4=(int)(Math.random()*100);
		yuefen(b1,b2);
		yuefen(b3,b4);
			if(b1<b2 && b3<b4)
			{
				System.out.print(b1+"/"+b2);
				System.out.print(ranChar1());
				System.out.println(b3+"/"+b4+"=");
			}
			else
			{
				TrueNum();
			}
	}
	public static void yuefen(int a1,int a2)//约分
	{
		int min=Math.abs(a1)<Math.abs(a2)?Math.abs(a1):Math.abs(a2);
		int yueshu=1;
		for(int i=min;i>=1;i++)
		{
			if(a1/i==0 && a2/i==0)
			{
				yueshu=i;
				break;
			}
		}
		a1/=yueshu;
		a2/=yueshu;
	}
}