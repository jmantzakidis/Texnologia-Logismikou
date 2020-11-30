<?php
$servername="localhost";
$username="username";
$password="password";
$dbname="WORK_SCHEDULE";
$conn= new mysqli($servername,$username,$password,$dbname);
if($conn->connect_error){
	die("Connection failed:" . $conn->connect_error);
}
$sql="CREATE TABLE WORKERS(
WORKER_ID INT(6)UNSIGNED AUTO_INCREMENT PRIMARY KEY,
FIRSTNAME VARCHAR(30) NOT NULL,
LASTNAME VARCHAR(30) NOT NULL,
TELEPHONE_NUMBER VARCHAR(30) NOT NULL,
EMAIL VARCHAR(40) NOT NULL,
USERNAME VARCHAR(30) NOT NULL,
PASSWORD VARCHAR(30) NOT NULL,
SPECIALITY VARCHAR(40) NOT NULL
)";
if($conn->query($sql) == TRUE){
	echo "Table WORKERS created successfully";
}
else{
	echo "Error creating table WORKERS" . $conn->error;
}
$conn->close();
?>
