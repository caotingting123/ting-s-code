package size;
import java.util.Scanner;
public class yunsuan {
	public static Scanner in=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int s;
	    while(true)
	    {
	    	System.out.println("������Ҫ���е����㣺");
		    System.out.println("1.�����������㣺");
		    System.out.println("2.������������㣺");
		    System.out.println("3.�˳���");
		    s=in.nextInt();
	    	if(s==1)
	    	{
	    		System.out.println("������Ҫ������Ŀ�ĸ�����");
	    		int n=in.nextInt();
	    	    System.out.println("��������ֵ��Χ��");
	    	    int p=in.nextInt();
	    	    int q=in.nextInt();
	    	    System.out.println("�Ƿ������ţ� 1:�� 2:��");
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
	    		System.out.println("������Ҫ������Ŀ�ĸ�����");
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
	    		System.out.println("����������������룺");
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
	    System.out.print("�Ƿ��г˳����� 1:�� 2:��");
	    int c=in.nextInt();
	    System.out.print("�Ӽ����޸����� 1:�� 2:��");
	    int f=in.nextInt();
	    System.out.print("�������������� 1:�� 2:��");
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
			//���Ӽ����ܳ��ָ���ʱִ�д˲���
			if(f==2 &&((a1<0||a2<0)||(a1<a2 && ch=='-')))
			{
				i--;
			}
			//����������������ʱִ�д˲���
			else if(y==2 && ch=='/' && a1%a2!=0)
			{
				i--;
			}
			else
			{
				System.out.print(a1);
				System.out.print(ch);
				System.out.println(a2+"=");
				System.out.print("������𰸣�");
				result1=in.nextInt();
				if(ch=='+'&&(result1==a1+a2))
				{
					
					System.out.println("������ȷ��");
				}
				else if(ch=='-'&&(result1==a1-a2))
				{
					System.out.println("������ȷ��");
				}
				else if(ch=='*'&&(result1==a1*a2))
				{
					System.out.println("������ȷ��");
				}
				else if(ch=='/'&&(result1==a1/a2))
				{
					System.out.println("������ȷ��");
				}
				else
				{
					System.out.println("�������");
				}
			}
		 }
	}
	public static void parentheses(int n,int p,int q)//����������
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
		a=(int)(Math.random()*(c-b+1)+b);//�����ֵ��ΧΪ��b��c
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
	public static void yuefen(int a1,int a2)//Լ��
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