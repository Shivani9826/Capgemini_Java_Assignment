package javaproject;

import java.util.Scanner;

class Student {
	private int subjectA, subjectB, subjectC;

	public Student(int subjectA, int subjectB, int subjectC) {
		this.subjectA = subjectA;
		this.subjectB = subjectB;
		this.subjectC = subjectC;
	}

	public int getSubjectA() {
		return subjectA;
	}

	public int getSubjectB() {
		return subjectB;
	}

	public int getSubjectC() {
		return subjectC;
	}
}

class StudentResult {
	public static int studentsTotalMarksInAllSubjects(Student[] students) {
		int totalMarks = 0;
		for (Student student : students) {
			totalMarks += student.getSubjectA() + student.getSubjectB() + student.getSubjectC();
		}
		return totalMarks;
	}

	public static double studentsAverageMarksInAllSubjects(Student[] students) {
		return (double) studentsTotalMarksInAllSubjects(students) / students.length;
	}

	public static int[] subjectWiseMarks(Student[] students, String subjectName) {
		int[] marks = new int[students.length];
		for (int i = 0; i < students.length; i++) {
			if (subjectName.equals("A")) {
				marks[i] = students[i].getSubjectA();
			} else if (subjectName.equals("B")) {
				marks[i] = students[i].getSubjectB();
			} else {
				marks[i] = students[i].getSubjectC();
			}
		}
		return marks;
	}

	public static int subjectTotalByStudents(int[] marks) {
		int total = 0;
		for (int mark : marks) {
			total += mark;
		}
		return total;
	}

	public static double subjectAverageByStudents(int[] marks) {
		return (double) subjectTotalByStudents(marks) / marks.length;
	}
}

public class Assignment1Q9 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Student[] students = new Student[3];
		for (int i = 0; i < 3; i++) {
			System.out.println("Enter marks of Student " + (i + 1) + " in subjects A, B, C:");
			int a = scan.nextInt();
			int b = scan.nextInt();
			int c = scan.nextInt();
			students[i] = new Student(a, b, c);
		}

		System.out.println("Total marks of all students in all subjects: "
				+ StudentResult.studentsTotalMarksInAllSubjects(students));
		System.out.println("Average marks of all students in all subjects: "
				+ StudentResult.studentsAverageMarksInAllSubjects(students));

		System.out.println("Total marks scored by students in subject A: "
				+ StudentResult.subjectTotalByStudents(StudentResult.subjectWiseMarks(students, "A")));
		System.out.println("Average marks scored by students in subject A: "
				+ StudentResult.subjectAverageByStudents(StudentResult.subjectWiseMarks(students, "A")));

		System.out.println("Total marks scored by students in subject B: "
				+ StudentResult.subjectTotalByStudents(StudentResult.subjectWiseMarks(students, "B")));
		System.out.println("Average marks scored by students in subject B: "
				+ StudentResult.subjectAverageByStudents(StudentResult.subjectWiseMarks(students, "B")));

		System.out.println("Total marks scored by students in subject C: "
				+ StudentResult.subjectTotalByStudents(StudentResult.subjectWiseMarks(students, "C")));
		System.out.println("Average marks scored by students in subject C: "
				+ StudentResult.subjectAverageByStudents(StudentResult.subjectWiseMarks(students, "C")));
	}
}