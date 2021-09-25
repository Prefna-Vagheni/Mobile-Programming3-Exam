<?php
include('connect.php');

$stmt = $conn->prepare("SELECT id, name, username, password,date FROM users");

$stmt ->execute();
$stmt ->bind_result($id, $name, $username, $password, $date);

$list = array();

while ($stmt -> fetch()) {
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