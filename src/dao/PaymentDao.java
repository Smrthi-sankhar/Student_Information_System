package dao;

import entity.Payment;
import entity.Student;

import java.util.Date;

public interface PaymentDao {
    Student getStudent(Payment payment);
    double getPaymentAmount(Payment payment);
    Date getPaymentDate(Payment payment);
}
