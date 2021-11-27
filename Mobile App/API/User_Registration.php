<?php
    if($_SERVER['REQUEST_METHOD']== 'POST'){
    include 'DBConfig.php';
        $conn = mysqli_connect($HostName, $HostUser, $HostPass, $DatabaseName);

        //membaca JSON dari user
        $json = file_get_contents('php://input',true);
        $obj = json_decode($json); //berfungsi menerjemahkan json ke php
        //kalau encode mengubah php jadi json

        //get JSON Object
        $nm_dpn = $obj->nm_depan;
        $nm_blkng = $obj -> nm_belakang;
        $jenis_klmn = $obj -> jns_klmn;
        $Tlahir = $obj -> tgl_lahir;
        $nomor = $obj ->no_hp;
        $email = $obj ->email_user;
        $pass = $obj ->password;

        //mengambil data dari tabel user
        $query_check = "select * from user where email_user = '$email'";
        $check = mysqli_fetch_array(mysqli_query($conn, $query_check));
        $json_array = array();
        $response = "";

        if (isset($check)){
            $response = array(
                'code' => 404,
                'status' => 'User has been registered'
            );

        }else{
            $query_insert = "insert into user (nm_depan,nm_belakang, jns_klmn, tgl_lahir, no_hp, email_user, password) values
            ('$nm_dpn', '$nm_blkng', '$jenis_klmn', '$Tlahir', '$nomor', '$email', '$pass')";
            
            if (mysqli_query($conn, $query_insert)) {
                $response = array(
                    'code' => 201,
                    'status' => 'User Registered'
                );
              }  else {
                    $response = array(
                        'code' => 405,
                        'status' => 'Registered Error!'
                    );
                }
        }
        print(json_encode($response));
        mysqli_close($conn);
      } elseif($_SERVER['REQUEST_METHOD'] == 'GET'){
        include 'DBConfig.php';
        $conn = mysqli_connect($HostName, $HostUser, $HostPass, $DatabaseName);
        $query_insert = "select * from user";
        $result = mysqli_query($conn, $query_insert);
        $json_array = array();
        $response = "";

        if (isset($result)) {
            while ($row = mysqli_fetch_assoc($result)) {
                $json_array[] = $row;
            }
            $response = array(
                'code' => 200,
                'status' => 'Successful',
                'user_list' => $json_array
            );   
        } else {
            $response = array(
                'code' => 400,
                'status' => 'Error',
                'user_list' => 0
            );
        }
        print(json_encode($response));
        mysqli_close($conn);
    }


?>