<?php
    $HostName = "localhost";
    $HostUser = "root";
    $HostPass = "";
    $DatabaseName = "cinfood";

    $conn = mysqli_connect($HostName,$HostUser,$HostPass, $DatabaseName);

   // Check connection
    if (mysqli_connect_errno())
      {
      echo "Failed to connect to MySQL: " . mysqli_connect_error();
      }else{  //echo "Connect"; 
    }
?>