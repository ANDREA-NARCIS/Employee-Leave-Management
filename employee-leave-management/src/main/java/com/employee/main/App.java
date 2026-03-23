package com.employee.main;

import com.employee.entity.*;
import com.employee.service.*;

import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LeaveService service = new LeaveService();

        // Create initial Manager + Employee
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Manager m = new Manager();
        m.setName("Manager1");

        Employee e = new Employee();
        e.setName("John");
        e.setManager(m);

        session.persist(m);
        session.persist(e);

        session.getTransaction().commit();
        session.close();

        int choice;

        do {
            System.out.println("\n===== Employee Leave Management =====");
            System.out.println("1. Apply Leave");
            System.out.println("2. Approve Leave");
            System.out.println("3. Reject Leave");
            System.out.println("4. View Leave History");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter reason: ");
                    String reason = sc.nextLine();
                    service.applyLeave(e, reason);
                    System.out.println("✅ Leave Applied");
                    break;

                case 2:
                    System.out.print("Enter Leave ID: ");
                    int approveId = sc.nextInt();
                    service.updateLeaveStatus(approveId, "Approved");
                    System.out.println("✅ Leave Approved");
                    break;

                case 3:
                    System.out.print("Enter Leave ID: ");
                    int rejectId = sc.nextInt();
                    service.updateLeaveStatus(rejectId, "Rejected");
                    System.out.println("❌ Leave Rejected");
                    break;

                case 4:
                    List<LeaveRequest> list = service.getLeaveHistory(e.getId());
                    System.out.println("\n--- Leave History ---");

                    for (LeaveRequest l : list) {
                        System.out.println(
                                "ID: " + l.getId() +
                                " | Reason: " + l.getReason() +
                                " | Status: " + l.getStatus()
                        );
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}