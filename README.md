# Shopping-Ecommerce-App-Project
Online shopping App built on Android Studio and Firebase Realtime Database.


Ecommerce App/Shopping App/Smartkart App
This android application is an online shopping app developed by Vijay Joshi (i.e,me),a student of B.Tech 2nd Year Computer Science and Engineering at Indian Institute of Information Technology, Pune.I started developing this app in February 2020 for my self-learning, sheer interest in android development and my project(educational purposes only).



LANGUAGES USED:



1.JAVA


2.XML :FOR LAYOUT

                                                                         
                                                                         
TOOLS AND TECHNOLOGIES USED:



1.ANDROID STUDIO(FOR DEVELOPMENT PURPOSE)


2.FIREBASE REALTIME DATABASE

                                                                   
                                                                   
DESCRIPTION OF EACH ACTIVITY/JAVA FILE:



1.MAIN ACTIVITY:
Welcome screen of the app which shows the app logo and a background for 2 seconds and then proceeds to the next activity.


2.REGLOGCHOICE:
Activity providing choice between user register,user login,admin login,staff login and about section.


3.REGISTER PAGE:
Registers a new customer/user onto the online database after asking their credentials


4.MEMBERREG:
Java file containing constructor to initialize database objects for users and functions to get(return) characteristics(variables) for each object.


5.LOGIN PAGE:
Login screen which logs in registered users.


6.HOME PAGE ACTIVITY:
Home page for customers where they can choose their category of items to shop


7.MENS CLOTHING,8.WOMENS CLOTHING,9.TSHIRTS,10,BOTTOM WEAR,11.SHOES,12.FORMALS,13.BOOKS,14.ELECTRONICS,15.OTHER ITEMS,16.CLOTHING:
Activities for displaying items or subdivisions within the category of respective Activity name.


17.RECYCLER ADAPTER:
Adapter class for displaying items in a recycler view


18.DISPLAY ITEM:
Display selected item from recycler adapter individually


19.PLACE ORDER:
Push ordered item details and customer information into Order database and upload it on Firebase.


20.ORDERS
Java file containing constructor to initialize database objects for placed orders and functions to get(return) characteristics(variables) for each object.


21.ADMIN LOGIN:
Login Page for admin of the organization(app company)


22.ADMIN HOME PAGE:
Home page for admin displaying options for the tasks which he/she wants to perform


23.ADD STOCK
Add stock of each item availaible on the app by updating data on StockReg database


24.STOCKSREG
Java file containing constructor to initialize database objects for items and functions to get(return) characteristics(variables) for each object.


25.ADD STAFF
Add staff(delivery boy) by pushing the details of the staff through an object of StaffReg class onto the Firebase Reatime Database


26.STAFFREG
Java file containing constructor to initialize database objects for staffs and functions to get(return) characteristics(variables) for each object.


27.STAFF LOGIN
Login Page for staffs/delivery boys and then decide whether to show current orders menu or redirect to orders assigned to the staff depending of the current state of the staff.


28.ACCEPT ORDERS
The staff can accept and order to deliver from this activity.The order selected to deliver is added as an object to a new database called DeliverOrder and removed from Orders.This differentiates order which are only ordered to those orders which are ordered and currently under delivery.After this acceptance ,staff is redirected to Current Order Status to finalize/confirm delivery when he delivers the order to customer in personal


29.DELIVER ORDER
Java file containing constructor to initialize database objects for orders currently under delivery and functions to get(return) characteristics(variables) for each object.

30.CURRENT ORDER STATUS
To confirm delivery ,the customer must enter his password when the order is delivered to him by the staff.This deletes the specified order object from DeliverOrder and proves that the order has been successfully delivered to the customer.


31.ABOUT
Activity displaying the details of the developer and link to his social media handles.



THANK YOU FOR READING THE DESCRIPTION OF THIS PROJECT,POINTERS TO FURTHER IMPROVEMENT ARE ALWAYS WELCOME


