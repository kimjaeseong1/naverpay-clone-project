<%--
  Created by IntelliJ IDEA.
  User: zan04
  Date: 2022-11-08
  Time: PM 6:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../messages/showMessages.jsp"%>
<%
    showMessage(request, response, "login", Status.FAIL);
%>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta property="og:type" content="website">
    <meta property="og:title" content="[네이버: 로그인]">
    <meta property="og:description" content="안전한 로그인을 위해 주소창의 URL과 자물쇠 마크를 확인하세요!">
    <meta property="og:image" content="https://ssl.pstatic.net/sstatic/search/common/og_v3.png">
    <meta property="og:image:type" content="image/png">
    <meta property="og:image:width" content="1200">
    <meta property="og:image:height" content="1200">
    <title>네이버 : 로그인</title>
    <style>
        #google {
            font-family: 'Bangers', cursive;
        }

    </style>

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Bangers&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/resources/css/naver.css">
</head>
<body>
<%--<header>--%>
<%--    <jsp:include page="../../layout/header.jsp"/>--%>
<%--</header>--%>
<%--    <main>--%>
<%--        <h1>LOGIN</h1>--%>
<%--        <div>--%>
<%--            <form method="post" action="/members/login">--%>
<%--                <div class="form__list">--%>
<%--                    <label for="USERID">ID:</label>--%>
<%--                    <input type="text" id="USERID" name="USERID" placeholder="아이디를 입력하세요" required/>--%>
<%--                </div>--%>

<%--                <div class="form__list">--%>
<%--                    <label for="USERPWD">PASSWORD</label>--%>
<%--                    <input type="text" id="USERPWD" name="USERPWD" placeholder="비밀번호를 입력하세요" required/>--%>
<%--                </div>--%>

<%--                <div class="checkbox__form">--%>
<%--                    <label for="save">AUTOLOGIN</label>--%>
<%--                    <input id="save" type="checkbox" name="save"/>--%>
<%--                </div>--%>
<%--                <input type="submit" name="submit" value="Submit"/>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </main>--%>

<%--    <footer class="main__nav__next">--%>
<%--        <jsp:include page="../../layout/footer.jsp"/>--%>
<%--    </footer>--%>
<!DOCTYPE html>
<html lang="ko">

<body>
<div id="wrap" class="wrap">
    <header class="header" role="banner" >
        <div class="header_inner">
            <h1 style="color:#32CD32" id='google'><b>NAVERPAY PROJECT</b></h1>
        </div>
    </header>

    <div id="container" class="container">
        <!-- content -->
        <div class="content">
            <div class="login_wrap">
                <ul class="menu_wrap" role="tablist">
                    <li class="menu_item" role="presentation">
                        <!--[주] 탭메뉴 활성화시(=선택시) "on"을 추가해주세요. 접근성: aria-selected는 탭 선택시 true, 미선택시 false로 적용-->
                        <!--[주:접근성] 탭메뉴의 id 값과 탭내용의 aria-controls를 연결하고 있습니다. -->
                        <a href="#none" id="loinid" class="menu_id on" role="tab" aria-selected="true">
                            <span class="menu_text"><span class="text">ID 로그인</span></span>
                        </a>
                    </li>

                    </li>
                </ul>
                <form id="frmNIDLogin" name="frmNIDLogin" target="_top" AUTOCOMPLETE="off"
                      action="/members/login" method="POST">

                    <ul class="panel_wrap">
                        <li class="panel_item" style="display: block;">
                            <div class="panel_inner" role="tabpanel" aria-controls="loinid" style="height:5%; width: 90%">
                                <div class="id_pw_wrap">
                                    <div class="input_row" id="id_line">
                                        <div class="icon_cell" id="id_cell">
                                            <span class="icon_id">
                                                <span class="blind">아이디</span>
                                            </span>
                                        </div>
                                        <input type="text" id="USERid" name="USERID" placeholder="아이디" title="아이디"
                                               class="input_text" maxlength="15"
                                               value="">
                                        <span role="button" class="btn_delete" id="id_clear" style="display: none;">
                                            <span class="icon_delete">
												<span class="blind">삭제</span>
                                            </span>
                                        </span>
                                    </div>
                                    <div class="input_row" id="pw_line">
                                        <div class="icon_cell" id="pw_cell">
                                            <span class="icon_pw">
                                                <span class="blind">비밀번호</span>
                                            </span>
                                        </div>
                                        <input type="password" id="USERPWD" name="USERPWD" placeholder="비밀번호" title="비밀번호"
                                               class="input_text" maxlength="16">
                                        <span role="button" class="btn_delete" id="pw_clear" style="display: none;">
                                            <span class="icon_delete">
                                                <span class="blind">삭제</span>
                                            </span>
                                        </span>
                                    </div>
                                </div>
                                <div class="login_keep_wrap" id="login_keep_wrap">
                                    <div class="keep_check">
                                        <input type="checkbox" id="keep" name="nvlong"
                                               class="input_keep"  value="off">

                                    </div>

                                </div>

                                <div class="login_error_wrap" id="err_empty_id" style="display: none;">
                                    <div class="error_message">
                                        <strong>아이디</strong>를 입력해 주세요.
                                    </div>
                                </div>

                                <div class="login_error_wrap" id="err_empty_pw" style="display: none;">
                                    <div class="error_message">
                                        <strong>비밀번호</strong>를 입력해 주세요.
                                    </div>
                                </div>
                                <div class="login_error_wrap" id="err_common"  style="display:none;">
                                    <div class="error_message"
                                         style="width:90%">

                                    </div>
                                </div>
                                <div class="btn_login_wrap">

                                    <button type="submit" class="btn_login" id="log.login">
                                        <span class="btn_text">로그인</span>
                                    </button>

                                </div>
                            </div>
                        </li>
                    </ul>
                </form>
            </div>

        </div>

    </div>


</div>

</div>

</body>
</html>
</body>
</html>
