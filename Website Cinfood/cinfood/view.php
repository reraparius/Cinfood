<?php
include("config.php");
include("functions.php");
include("uilang.php");

if($_POST['id_transaksi']){

    $id = $_POST['id_transaksi'];
    $sql = "SELECT * FROM `transaksi_android` WHERE id_transaksi = $id";
    $result = mysqli_query($connection, $sql);
    if($result->num_rows){
        $row_view = $result->fetch_assoc();
        ?>
                    <table>
                        <tr><td><p><b>NO</b></p></td>
                            <td><p><b>Nama menu</b>&nbsp;</td>
                            <td><p><b>Jumlah</b>&nbsp;</td>
                            <td><p><b>Total harga</b></td>
                        </tr>    
                        
                        <?php
                        $no = 1;
                        $query_pub = mysqli_query($connection,"SELECT * FROM `dtl_transaksi_android` WHERE id_transaksi = $id");
                        while ($row = mysqli_fetch_assoc($query_pub)){
                            $id_dtl_transaksi = $row["id_dtl_transaksi"];
                            $sql = 'SELECT menu.title FROM menu INNER JOIN dtl_transaksi_android ON menu.id = dtl_transaksi_android.id_menu WHERE dtl_transaksi_android.id_dtl_transaksi = '.$id_dtl_transaksi.'';
                            $query = mysqli_query($connection, $sql) or die( mysqli_error($connection));
                            $getnama = mysqli_fetch_array($query);
                            echo 
                            '<tr><td><p><span>'.$no.'</span></p></td>
                            <td><p><span>'. $getnama['title'] .'</span></td>
                            <td><p><span>'. $row["jumlah"] .'</span></td>
                            <td><p><span>'. $row["tot_harga"] .'</span></td>
                            </tr> ';
                            $no++;
                        }
                        ?>
                        
                    </table>
      
        <?php
    }    
}
?>