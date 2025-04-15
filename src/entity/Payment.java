package entity;
import java.time.LocalDate;

public class Payment {
	private int paymentId;
    private int studentId;  // Reference to Student object
    private double amount;
    private LocalDate paymentDate;

    
    //collection relationship
    private Student student;
    
    //getter for this

	public Student getStudent() {
	    return student;
	}
    
    //default constructor
	public Payment() {
		super();
	}

	public Payment(int paymentId, int studentId, double amount, LocalDate paymentDate,Student student) {
		super();
		this.paymentId = paymentId;
		this.studentId = studentId;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.student = student;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", studentId=" + studentId + ", amount=" + amount + ", paymentDate="
				+ paymentDate + "]";
	}	
}

