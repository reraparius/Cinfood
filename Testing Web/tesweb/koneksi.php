<?php 
$konesi = mysqli_connect("localhost","root","","cinfood");
 if (mysqli_connect_errno()){
	echo "Koneksi database gagal : " . mysqli_connect_error();
}
 
?>