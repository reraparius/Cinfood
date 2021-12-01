<?php

   if($_SERVER['REQUEST_METHOD']=='POST'){
  // echo $_SERVER["DOCUMENT_ROOT"];  // /home1/demonuts/public_html
//including the database connection file
       include_once("DBConfig.php");
       
    $email_user = $_POST['email_user'];
 	$password = $_POST['password'];
 	
     //mengecek username dan password value nya kosong apa tidak
	 if( $email_user == '' || $password == '' ){
	        echo json_encode(array( 
            "status" => "false",
            "message" => "Parameter missing!") );
	 }else{
        //klo username dan password benar maka akan muncul response
	 	$query= "SELECT * FROM user WHERE email_user='$email_user' AND password='$password'";
	        $result= mysqli_query($conn, $query);
		 
	        if(mysqli_num_rows($result) > 0){  
	         $query= "SELECT * FROM user WHERE email_user='$email_user' AND password='$password'";
	                $result= mysqli_query($conn, $query);
		             $emparray = array();
	                     if(mysqli_num_rows($result) > 0){  
	                     while ($row = mysqli_fetch_assoc($result)) {
                                     $emparray[] = $row;
                        }
	                     }
	           echo json_encode(array( 
                   "status" => "true",
                   "message" => "Login successfully!",
                    "data" => $emparray) );

	        }else{ 
	        	echo json_encode(array( 
                "status" => "false",
                "message" => "Invalid username or password!") );
	        }
	         mysqli_close($conn);
	 }
     //kondisis
	} else{
			echo json_encode(array( 
                "status" => "false",
                "message" => "Error occured, please try again!") );
	}
?>