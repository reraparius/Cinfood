<?php
//menggunakan Framework PHPUnit
use PHPUnit\Framework\TestCase;

// Class yang akan di TEST.
require_once "Login.php";

// Class untuk run Testing.
class tesweb extends TestCase
{
    //membuat sebuah fungsi
    public function tesweb()
    {
        //class yang akan kita pakai
        $insert = new Login();

        //memasukkan username dan password sesuai yang ada pada database
        $username="raf";
        $password="raf";
        $hasil= $insert->login($username,$password);

        //memeriksa nilai yang dihasilkan dari fungsi apakah sama dengan nilai ekspektasi kita atau tidak.
        //jika benar akan menampilkan berhasil
        $this->assertEquals($hasil,'berhasil');
        echo $hasil;
       

    }
}
