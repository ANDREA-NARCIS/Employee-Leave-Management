# **Employee Leave Management System**

## **📌 Project Overview**
The Employee Leave Management System is a console-based application developed using Java, Hibernate ORM, and Maven.  
It allows employees to apply for leave, managers to approve or reject requests, and provides a complete leave history.

---

## **🚀 Features**
- Apply for Leave  
- Approve Leave  
- Reject Leave  
- View Leave History  
- Menu-driven Console Application  
- Database Integration using Hibernate  

---

## **🛠️ Technologies Used**
- Java  
- Hibernate ORM  
- Maven  
- MySQL  
- VS Code  

---

## **📂 Project Structure**

<img width="370" height="333" alt="image" src="https://github.com/user-attachments/assets/3f81a200-dce1-44e2-ab85-97cf4719f27d" />

---

## **🗄️ Database Configuration**
- Database Name: `leave_db`
- Tables are automatically created using Hibernate (`hbm2ddl.auto=update`)

---

## **⚙️ How to Run the Project**

### **Step 1: Clone Repository**
```bash
git clone https://github.com/ANDREA-NARCIS/Employee-Leave-Management.git

<img width="808" height="434" alt="image" src="https://github.com/user-attachments/assets/9bd3f48b-f47a-40bc-8a81-dfa0590aae83" />

**📋 Functionalities**
1. Apply Leave

Employee can submit a leave request with a reason.

2. Approve/Reject Leave

Manager can approve or reject leave using Leave ID.

3. View Leave History

Displays all leave requests with status.

**🔗 Entity Relationships**
One Manager → Many Employees
One Employee → Many Leave Requests
Each Leave Request → One Employee

**📊 Sample Output**

<img width="340" height="137" alt="image" src="https://github.com/user-attachments/assets/34f44c8d-3eeb-4e15-9776-360374ef4047" />

**🎯 Future Enhancements**
Multiple Employee Support
Login System (Manager/Employee)
Web Interface using Spring Boot
REST API Integration

**👨‍💻 Author**
**Andrea Narcis**


