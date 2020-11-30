<?php
    //connect and select the database
     $connect = mysql_connect("localhost","root","") or die('Database Not Connected. Please Fix the Issue! ' . mysql_error());
    mysql_select_db("work_schedule", $connect);
    
     // get the contents of the JSON file 
     $jsonCont = file_get_contents('Employee.json');
    
     //decode JSON data to PHP array
     $content = json_decode($jsonCont, true);
    
     //Fetch the details of workers
     $worker_id = $content['id'];
     $firstname = $content['name'];
     $lastname = $content['surName'];
     $telephone_number = $content['mobile'];
     $email = $content['email'];
     $username = $content['userName'];
     $password = $content['password'];
     $speciality = $content['speciality'];
     
    
    //Insert the fetched Data into Database
    $query = "INSERT INTO workers(worker_id, firstname, lastname, telephone_number, email, username, password, speciality)
    VALUES('$worker_id', '$firstname', '$lastname, '$telephone_number', '$email', '$username', '$password', '$speciality')";
    
     if(!mysql_query($query,$connect))
    {
        die('Error : Query Not Executed. Please Fix the Issue!  ' . mysql_error());
    }
     else{
            echo "Data Inserted Successully!!!";
     }
?> 
