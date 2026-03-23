package com.employee.service;

import com.employee.entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class LeaveService {

    // Apply Leave
    public void applyLeave(Employee emp, String reason) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        LeaveRequest leave = new LeaveRequest();
        leave.setReason(reason);
        leave.setStatus("Pending");
        leave.setEmployee(emp);

        session.save(leave);

        tx.commit();
        session.close();
    }

    // Approve / Reject
    public void updateLeaveStatus(int leaveId, String status) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        LeaveRequest leave = session.get(LeaveRequest.class, leaveId);
        leave.setStatus(status);

        tx.commit();
        session.close();
    }

    // Fetch History
    public List<LeaveRequest> getLeaveHistory(int empId) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<LeaveRequest> list = session.createQuery(
                "from LeaveRequest where employee.id = :id", LeaveRequest.class)
                .setParameter("id", empId)
                .list();

        session.close();
        return list;
    }
}