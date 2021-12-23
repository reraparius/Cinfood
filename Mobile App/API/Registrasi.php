<?php

   if($_SERVER['REQUEST_METHOD']=='POST'){

    include_once("DBConfig.php");
    
    $namaLengkap = $_POST['namaLengkap'];
    // $jns_klmn = $_POST['jns_klmn'];
    // $tgl_lahir = $_POST['tgl_lahir'];
    // $no_hp = $_POST['no_hp'];
    $alamat = isset($_POST["alamat"]) ? $_POST["alamat"] : "" ;
    $email_user = $_POST['email_user'];
 	$password = $_POST['password'];
 	
     if($namaLengkap == '' || $alamat == '' || $email_user == '' || $password == ''){
        echo json_encode(array( "status" => "false","message" => "Parameter missing!") );
 }else{
        
        $query= "SELECT * FROM user WHERE email_user='$email_user'";
        $result= mysqli_query($conn, $query);
     
        if(mysqli_num_rows($result) > 0){  
           echo json_encode(array( 
            "status" => "false",
           "message" => "Data pengguna telah terdaftar!") );

        }else{ 
          $query = "INSERT INTO user (namaLengkap,alamat,email_user,password) VALUES ('$namaLengkap','$alamat','$email_user','$password')";
         if(mysqli_query($conn,$query)){
            
             $query= "SELECT * FROM user WHERE email_user='$email_user'";
                     $result= mysqli_query($conn, $query);
                 $emparray = array();
                     if(mysqli_num_rows($result) > 0){  
                     while ($row = mysqli_fetch_assoc($result)) {
                                 $emparray[] = $row;
                               }
                     }
            echo json_encode(array( "status" => "true","message" => "Registrasi Sukses" , "data" => $emparray) );
          }else{
              echo json_encode(array( "status" => "false","message" => "Terjadi eror, Mohon coba lagi!") );
         }
    }
            mysqli_close($conn);
 }
 } else{
        echo json_encode(array( "status" => "false","message" => "Terjadi eror, Mohon coba lagi!") );
}
       
?>