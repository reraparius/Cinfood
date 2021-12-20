<?php
require("DBConfig.php");

$response = array();

if($_SERVER['REQUEST_METHOD']=='POST') {

    $id_user = isset($_POST["id_user"]) ? $_POST ["id_user"] : "" ;
      $namaLengkap = isset($_POST["namaLengkap"]) ? $_POST ["namaLengkap"] : "" ;
      $tgl_lahir = isset($_POST["tgl_lahir"]) ? $_POST["tgl_lahir"] : "" ;
      $no_hp = isset($_POST["no_hp"]) ? $_POST["no_hp"] : "" ;
      $alamat = isset($_POST["alamat"]) ? $_POST["alamat"] : "" ;
      $email_user = isset($_POST["email_user"]) ? $_POST["email_user"] : "" ;
      $password = isset($_POST["password"]) ? $_POST["password"] : "" ;
    
      $perintah = "UPDATE user SET namaLengkap = '$namaLengkap',tgl_lahir = '$tgl_lahir', no_hp = '$no_hp', alamat = '$alamat', email_user = '$email_user', password = '$password' WHERE id_user = '$id_user'";

      $eksekusi = mysqli_query($conn, $perintah);
      $cek = mysqli_affected_rows($conn);

      if($cek > 0 ){
          $response["status"] = "true";
          $response["message"] = "Data Berhasil Di Edit";

      }else{
        $response["status"] = "false";
        $response["message"] = "Data Gagal Di Edit";
      }
}else{
    $response["status"] = "false";
    $response["message"] = "Tidak ada post data";
}

echo json_encode($response);
mysqli_close($conn);
?>