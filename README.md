# payment-gateway 
Spring Boot Application with Razorpay Integration
Description
This project is a web application developed using Spring Boot, integrating the Razorpay payment gateway. The front-end is built with HTML, CSS, and Bootstrap, providing a user-friendly interface for seamless payment processing.

Features
Spring Boot: Backend framework for building the application.
Razorpay Integration: Secure and efficient payment gateway integration using Razorpay REST API.
HTML/CSS/Bootstrap: Responsive and modern front-end design.
REST API: Implementation of RESTful services for payment processing.

Installation
Clone the repository:
git clone [https://github.com/yourusername/your-repo-name.git](https://github.com/Komal305/Razorpay-payment-gateway)


Navigate to the project directory:
cd Razorpay-payment-gateway

Build the project:
mvn clean install

Run the application:
mvn spring-boot:run

Usage
Open your browser and navigate to http://localhost:8080
Follow the instructions on the web interface to make a payment using Razorpay.

REST API Endpoints
Create Order: /create-order (POST) - Creates a new payment order.
Verify Payment: /handle-payment-callback (POST) - Verifies the payment status.

Front-End Implementation
Course Purchase Page: Simple HTML page for selecting a course and paying the fees.
Payment Confirmation Page: Displays payment details, including confirmation status and reference ID.

Test Mode
The application was developed and tested in Razorpay's test mode. All payment transactions were simulated, and the details were successfully recorded and verified on the Razorpay dashboard.

