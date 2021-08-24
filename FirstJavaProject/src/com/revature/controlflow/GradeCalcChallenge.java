package com.revature.controlflow;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class GradeCalcChallenge {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the total amount of points on the quiz");
		double maxPoints = scan.nextDouble();
		
		System.out.println("Enter the amount of points that were right");
		double score = scan.nextDouble();
		scan.close();
		
		double percentage = getPercentage(maxPoints, score);
		char grade = 0;
		
		if (percentage >= 90 || percentage >= 100) grade = 'A';
		else if (percentage >= 80 || percentage >= 89) grade = 'B';
		else if (percentage >= 70 || percentage >= 79) grade = 'C';
		else if (percentage >= 60 || percentage >= 69) grade = 'D';
		else if (percentage >= 0 || percentage >= 59) grade = 'F';
		
		
		System.out.println("The Student's Letter grade is " + grade + ". That's " + percentage + "% !");
	}
	
	public static double getPercentage(double maxPoints, double score) {
		BigDecimal percent = new BigDecimal((score / maxPoints) * 100);
		DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(0);
        
        return Double.parseDouble(df.format(percent));
	}
}
