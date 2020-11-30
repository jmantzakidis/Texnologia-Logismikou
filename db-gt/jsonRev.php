<?php
    //Step No. 1: Connect database with PHP
$connect = mysql_connect("localhost","root","") or die('Database Not Connected. Please Fix the Issue! ' . mysql_error());
    mysql_select_db("work_schedule", $connect);
     
     //Step No. 2: Extracting data from database
    $query = "SELECT * FROM workers";
     $res = mysql_query($query,$connect) or die("Query Not Executed " . mysql_error($connect));
    
     //Step No. 3: Putting the fetched data in Arrays
    $data_array = array();
    while($rows =mysql_fetch_assoc($res))
    {
        $data_array[] = $rows;
    }
     //Step No. 4 and 5: Encoding Array into JSON + Writing data to JSON file
     $fp = fopen('employee.json', 'w');
    //fwrite($fp, json_encode($data_array));
     
     if(!fwrite($fp, json_encode($data_array)))
    {
        die('Error : File Not Opened. ' . mysql_error());
    }
     else{
            echo "Data Retrieved Successully!!!";
     }
     fclose($fp);
 
    mysql_close($connect);
?>