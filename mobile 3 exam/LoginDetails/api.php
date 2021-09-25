<?php
define('DB_HOST','localhost');
define('DB_USER','root');
define('DB_PASS','password');
define('DB_NAME','logindetails');
$conn = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);

if (mysqli_connect_errno()) {
    die('Unable to connect to database '. mysqli_connect_erro());
}

$stmt = $conn->prepare("SELECT * FROM users");
$stmt->execute();
$stmt->bind_result($id, $name, $username, $password, $date);
$list = array();

while ($stmt->fetch()) {
    $temp = array();
    $temp['id'] = $id;
    $temp['name'] = $name;
    $temp['username'] = $username;
    $temp['password'] = $password;
    $temp['date'] = $date;

    array_push($list, $temp);
}

echo json_encode($list);
?>