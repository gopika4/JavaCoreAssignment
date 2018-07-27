//@Gopika V
//27-07-2018
//Question:
//Given an integer array, Write a program to find if the array has any triplets. A triplet is a value if it appears 3 consecutive times in the array.
//Include a class UserMainCode with a static method checkTripplets which accepts an integer array. The return type is boolean stating whether its a triplet or not.
//Create a Class Main which would be used to accept the input arrayand call the static method present in UserMainCode.


import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		System.out.println("Enter the total no. of elements: ");
		int n = Integer.parseInt(br.readLine());
		
		if(n<=2)
		{
			System.out.println("Number of elements should be greater than 2");
		}
		else
		{
			int arr[] = new int[n];

			System.out.println("Enter the numbers: ");
			for (int i = 0; i < arr.length; i++) 
			{
				String s = br.readLine();
				int ele = Integer.parseInt(s);
				arr[i] = ele;
			}
			
			UserMainCode.checkTripplets(arr);

		}
	}
}





class UserMainCode {

	public static boolean checkTripplets(int arr[])
	{
		int flag=0;
		for(int i=0;i<arr.length-2;i++)
		{
			if(arr[i]==arr[i+1])
			{
				if(arr[i+1]==arr[i+2])
				{
					flag=1;
				}
			}
		}
		if(flag==1)
		{
			System.out.println("True");
		}
		else
		{
			System.out.println("False");

		}
		return true;
		
	}
}