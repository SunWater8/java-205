package ch08;

public interface Calculator {
	long add(long n1, long n2); //public abstract 가 앞에 모두 생략됨.
	long substract(long n1, long n2);
	long multiply(long n1, long n2);
	double divide(double n1, double n2);
}
