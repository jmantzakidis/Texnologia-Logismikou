<?php
$servername="localhost";
$username="username";
$password="password";
$dbname="WORK_SCHEDULE";
$conn= new mysqli($servername,$username,$password,$dbname);
if($conn->connect_error){
	die("Connection failed:" . $conn->connect_error);
}
$sql="CREATE TABLE ADMINS(
ADMIN_ID INT(6)UNSIGNED AUTO_INCREMENT PRIMARY KEY,
FIRSTNAME VARCHAR(30) NOT NULL,
LASTNAME VARCHAR(30) NOT NULL,
USERNAME VARCHAR(30) NOT NULL,
PASSWORD VARCHAR(30) NOT NULL
)";
if($conn->query($sql) == TRUE){
	echo "Table ADMINS created successfully";
}
else{
	echo "Error creating table ADMINS" . $conn->error;
}
$conn->close();
?>
