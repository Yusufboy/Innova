
public class Q1 {
	public static boolean palatalHarmony(String str) {
		char[] vowels = {'a','e','ý','i','o','ö','u','ü'};
		boolean foundVowel=false,frontVowelFlag=false;
		
		for(int i=0;i<str.length();i++) {
			//Ýf we have already encountered a vowel
			if(foundVowel) {
				//If first vowel in the string is a front vowel
				if(frontVowelFlag) {
					//Checks if current character is a vowel and if it is not a front vowel.
					//If this conditions are true then returns false
					for(int k=0;k<8;k++) {
						if(str.charAt(i) == vowels[k] && k%2 == 0) {
							return false;
						}
					}
				}
				else {
					//Checks if current character is a vowel and if it is not a back vowel.
					//If this conditions are true then returns false
					for(int k=0;k<8;k++) {
						if(str.charAt(i) == vowels[k] && k%2 == 1) {
							return false;
						}
					}
				}
			}
			//If a vowel is not encountered yet
			else {
				for(int k=0;k<8;k++) {
					if(str.charAt(i) == vowels[k]) {
						foundVowel = true;
						//If k is an even number, that means the vowel is a front vowel; otherwise, the vovel is a back vowel
						if(k%2 == 0)
							frontVowelFlag = false;
						else
							frontVowelFlag = true;
					}
				}
			}
		}
		return true;
	}
	
	public static void sundays() {
		/*Total month number from 1.1.1900 to 31.12.2000 is 12*101.
		If we are starting from monday, that means each time the total day number is divisible by 7, we are on a sunday.
		I will use this method to increment total day number and check if that number is divisible by 7.
		To increment this number every month, i will just add the current month's day number to totalDayNum (February's day number every 4th year)*/
		int totalDayNum = 1,totalMonth=12*101;
		
		//Below array keeps the day numbers of each month.
		int[] dayNumbers = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		int year=1900,month=1;
		//I will check each month and decrement the total month number that are left.
		while(totalMonth != 0) {
			if(totalDayNum % 7 == 0)
				System.out.println("1." + month + "." + year);
			
			if(month == 12)
				year++;
			//Increment the total day number by the day number of the month that we passed
			totalDayNum += dayNumbers[month-1];
			
			//If we are in a leap year and we passed february, total day number should be increased by 29
			if(year%4 == 0 && month == 2)
				totalDayNum++;
			//Increment the month
			month = (month%12) + 1;
			
			totalMonth--;
		}
	}
	
	//Basic node class that only has links
	public static class Node{
		Node(){
			right = null;
			left = null;
		}
		
		public Node right;
		public Node left;
	}
	
	//Question 3, finds if there is an anomaly recursively in a tree
	public static boolean findAnomaly(Node root) {
		Node temp,temp1;
		temp = root.left;
		temp1 = root.right;
		//If root has both childs
		if(temp == null || temp1 == null)
			return false;
		//Below ifs check if there is any links that points to same node
		if(temp.right != null && temp1.right != null)
			if(temp.right.equals(temp1.right))
				return true;
		if(temp.right != null && temp1.left != null)
			if(temp.right.equals(temp1.left))
				return true;
		if(temp.left != null && temp1.right != null)
			if(temp.left.equals(temp1.right))
				return true;
		if(temp.left != null && temp1.left != null)
			if(temp.left.equals(temp1.left))
				return true;
		//If couldnt find an anomaly, try again with child nodes
		else
			return findAnomaly(temp) || findAnomaly(temp1);
		return false;
	}
	
	//root has anomaly, root1 doesn't have an anomaly
	static Node root = new Node();
	static Node root1 = new Node();
	
	public static void main(String[] args){
		System.out.println(palatalHarmony("balerin"));
		sundays();
		
		//I created trees below to test 3rd question, trees are what you gave as an example in the image
		Node temp;
		temp = new Node();
		root.left = temp;
		temp = new Node();
		root.right = temp;
		temp = new Node();
		root.left.right = temp;
		root.right.left = temp;
		
		temp = new Node();
		root1.right = temp;
		temp = new Node();
		root1.left = temp;
		temp = new Node();
		root1.right.right = temp;
		temp = new Node();
		root1.right.left = temp;
		temp = new Node();
		root1.right.left.right = temp;
		
		System.out.println(findAnomaly(root));
		System.out.println(findAnomaly(root1));
	}
}
