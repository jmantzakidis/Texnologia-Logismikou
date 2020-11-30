<?php
$servername="localhost";
$username="username";
$password="password";
$conn= new mysqli($servername,$username,$password);
if($conn -> connect_error)
{
	die("Connection failed:" . $conn->connect_error);
}
$sql="CREATE DATABASE WORK_SCHEDULE";
if($conn->query($sql)==TRUE){
	echo "Database WORK_SCHEDULE created successfully";
}
else{
	echo "Error creating database WORK_SCHEDULE" . $conn->error;
}
$conn->close();
?>
