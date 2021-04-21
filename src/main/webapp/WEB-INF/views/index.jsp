<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>mainPage</title>
 <style>
    *{
      list-style: none;
    }
     #login-form, #cancle-btn{
      display: none;
    }
    .header, #jnform{
      display: flex;
    }
    li{
      padding: 10px;
    }
    #join-btn{
      padding-left: 300px;
    }
    #member-id{
    padding-left:500px;
    }
    #jnform input{
    margin-left:10px;
    }
      </style>
    </head>
    <body>
      <header>
        Welcome to English Study Class
        <ul class="header">
          
          <c:if test="${empty sessionScope.member}">
          <li id="join-btn"><a href="/portfolio/member/joinMember">회원가입</a></li>
          <li id="login-form" style="padding: 0px; ">
            <form action="/portfolio/member/login" method="post" id="jnform">
                <span>ID:</span>
                <input type="text" name="MEMBER_EMAIL">
                <span>PassWord:</span>
                <input type="password" name="MEMBER_PW">
                <input type="submit" value="로그인" id="submit-btn">
                <input type="button" value="취소" id="cancle-btn">
             </form>
          </li>
          <li id="login-btn">로그인</li>
          <!-- <li id="cancle-btn"><input type="button"  value="취소"></li> -->
          <li id="find-id">Id 찾기</li>
          <li id="find-pw">Password 찾기</li>
          </c:if>
          <c:if test="${!empty sessionScope.member}">
          <li id="member-id">${member.MEMBER_NICKNAME }</li>
          <li id="logout"><a href="/portfolio/member/logout">로그아웃</a></li>
          <li id="mypage">내정보</li>
          </c:if>
        </ul>
        <hr>
        <ul class="header2 menu-list">
       	  <li>AllBooks</li>
          <li>Newest</li>
          <li>BestView</li>
          <li>Easy</li>
          <li>Nomal</li>
          <li>Hard</li>
          <li></li>
        </ul>
      </header>
      <hr>
    </body>
    <script>
    const joinBtn = document.querySelector('#join-btn');
    const loginBtn = document.querySelector('#login-btn');
    const loginForm = document.querySelector('#login-form');
    const cancleBtn = document.querySelector('#cancle-btn');
    const findId = document.querySelector('#find-id');
    const findPw = document.querySelector('#find-pw');
    const mypage = document.querySelector('#mypage');
    const memberId = document.querySelector('#member-id');
    
    
    loginBtn.addEventListener('click',logbtn);
    function logbtn(){
      joinBtn.style.display = 'none';
      loginForm.style.display = 'block';
      cancleBtn.style.display = 'block';
      // findId.style.display = 'block';
      // findPw.style.display = 'block';
      loginBtn.textContent = '';
    }
    cancleBtn.addEventListener('click',()=>{
      /* location.reload(); */
       joinBtn.style.display = 'block';
      loginForm.style.display = 'none';
      cancleBtn.style.display = 'none';
      // findId.style.display = 'none';
      // findPw.style.display = 'none';
      loginBtn.textContent = '로그인'; 
    });
    
    const AllBooks = document.querySelector('.menu-list>li:nth-child(1)');
    const Newest = document.querySelector('.menu-list>li:nth-child(2)');
    const BestView = document.querySelector('.menu-list>li:nth-child(3)');
    const Easy = document.querySelector('.menu-list>li:nth-child(4)');
    const Nomal = document.querySelector('.menu-list>li:nth-child(5)');
    const Hard = document.querySelector('.menu-list>li:nth-child(6)');
    AllBooks.addEventListener('mouseover',()=>{
      console.log('allbooks');
      AllBooks.textContent = '모든 책보기';
    });
    AllBooks.addEventListener('mouseout',()=>{
      console.log('allbooks');
      AllBooks.textContent = 'AllBooks';
    });

    Newest.addEventListener('mouseover',()=>{
      console.log('allbooks');
      Newest.textContent = '최신 목록';
    });
    Newest.addEventListener('mouseout',()=>{
      console.log('allbooks');
      Newest.textContent = 'Newest';
    });
    BestView.addEventListener('mouseover',()=>{
      console.log('allbooks');
      BestView.textContent = '인기 목록';
    });
    BestView.addEventListener('mouseout',()=>{
      console.log('allbooks');
      BestView.textContent = 'BestView';
    });
    Easy.addEventListener('mouseover',()=>{
      console.log('allbooks');
      Easy.textContent = '난이도 하수';
    });
    Easy.addEventListener('mouseout',()=>{
      console.log('allbooks');
      Easy.textContent = 'Easy';
    });
    Nomal.addEventListener('mouseover',()=>{
      console.log('allbooks');
      Nomal.textContent = '난이도 중수';
    });
    Nomal.addEventListener('mouseout',()=>{
      console.log('allbooks');
      Nomal.textContent = 'Nomal';
    });
    Hard.addEventListener('mouseover',()=>{
      console.log('allbooks');
      Hard.textContent = '난이도 고수';
    });
    Hard.addEventListener('mouseout',()=>{
      console.log('allbooks');
      Hard.textContent = 'Hard';
    });
    </script>
    </html>