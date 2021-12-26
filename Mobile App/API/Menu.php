<?php
if($_SERVER['REQUEST_METHOD']== 'GET'){
    include 'DBConfig.php';
 //   $catid = isset($_GET["catid"]) ? $_GET["catid"] : "" ;
    // $postid = isset($_GET["postid"]) ? $_GET["postid"] : "" ;
    // $normalprice = isset($_GET["normalprice"]) ? $_GET["normalprice"] : "" ;
    //  $title = isset($_GET["title"]) ? $_GET["title"] : "" ;
    //  $picture = isset($_GET["picture"]) ? $_GET["picture"] : "" ;
    // $content = isset($_GET["content"]) ? $_GET["content"] : "" ;

    $query_insert = "SELECT * FROM menu ";
    $result = mysqli_query($conn, $query_insert);
    $json_array = array();
    $response = "";

    if (isset($result)) {
        while ($row = mysqli_fetch_assoc($result)) {
            $json_array[] = $row;
        }
        $response = $json_array; 
    } else {
        $response = array(
            'status' => 'Error',
            'message' => 'Tidak Dapat Menampilkan Menu',
            'menu_list' => 0
        );
    }
    print(json_encode($response));
    mysqli_close($conn);
}

?>