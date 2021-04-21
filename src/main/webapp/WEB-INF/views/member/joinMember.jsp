<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>
  <form action="/portfolio/member/joinSave" method="POST" enctype="multipart/form-data">
    <ul>
      <li><img src="" alt="" id="profile-img" style="outline: 1px solid black; width: 200px; height: 200px;"></li>
      <li><label for="">회원 프로필 이미지</label><input type="file" name="file" id="file-img"></li>
      <li><label for="">회원 아이디:</label><input type="text" name="MEMBER_EMAIL"></li>
      <li><label for="">회원 비밀번호:</label><input type="password" name="MEMBER_PW"></li>
      <li><label for="">비밀번호 확인:</label><input type="password"></li>
      <li><label for="">회원 닉네임:</label><input type="text" name="MEMBER_NICKNAME"></li>
      <li><label for="">회원 전화번호:</label><input type="text" name="MEMBER_TEL"></li>
      <li><label for="">회원 성별</label><input type="text" name="MEMBER_GENDER"></li>
      <li><label for="">회원 생일</label><input type="date" name="MEMBER_BIRTH"></li> 
      <li><input type="submit" value="회원가입"></li>
      <li><input type="button" value="가입취소" id="join-cancle"></li>
    </ul>
  </form>
</body>
<script>
let profileImg = document.querySelector('#profile-img');
let fileImg = document.querySelector('#file-img');
profileImg.addEventListener('click',()=>{
 fileImg.click();
 console.log("profileImg");
});

fileImg.addEventListener('change',()=>{
  const url = URL.createObjectURL(fileImg.files[0]);
  profileImg.src = url;
});

const joinCancle = document.querySelector('#join-cancle');
joinCancle.addEventListener('click',()=>{
	console.log("ggg");
	window.history.back();
});
</script>
</html>