<%@ page import="org.example.order.Entity.Order" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2022/11/09
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Naver Pay Home</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<header>
    <jsp:include page="../layout/header.jsp"/>
</header>


<main>
    <div class="sub_sc2" style="min-height:500px;">

        <div class="heading heading3">
            <h3 class="pay_detail"><span class="blind">SHOPPING LIST</span></h3>
        </div>

        <table cellspacing="0" border="1" class="tb_list mgt">
            <caption>주문 목록</caption>

            <colgroup><col width=""><col width="140"><col width="200"><col width="80">
            </colgroup>
            <thead>
                <tr>
                    <th scope="col">상품이름</th>
                    <th scope="col">스토어 이름</th>
                    <th scope="col" class="bg_point">스토어 번호</th>
                    <th scope="col" class="bg_point">진행상태</th>
                    <th scope="col" class="bg_point">구매 일자</th>
                </tr>
            </thead>
            <tbody>

            <%List<Order> orderList = (List<Order>) request.getAttribute("list");
                for (int i = 0; i < orderList.size(); i++)
                {
                    String orderName = orderList.get(i).getOrderName();
                    String storeName = orderList.get(i).getStoreName();
                    String storePhone = orderList.get(i).getStorePhone();
                    String orderStatus = orderList.get(i).getOrderStatus();
                    String orderDate = orderList.get(i).getOrderDate();
                    int paymentID = orderList.get(i).getPaymentID();
            %>
            <tr>
                <td class="ordername">
                    <a href="/naver/pay/shopping/detail/?paymentId=<%=paymentID%>">
                        <em><%=orderName%></em>
                    </a>

                </td>
                <td class="storename">
                    <em class="thm"><%=storeName%></em>
                </td>
                <td class="storephone">
                    <em class="thm"><%=storePhone%></em>
                </td>
                <td class="orderstatus">
                    <em class="thm"><%=orderStatus%></em>
                </td>
                <td class="orderdate">
                    <em class="thm"><%=orderDate%></em>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
        <form action="/naver/pay/search/">
            <a>
                시작일 : <input type="date" name="startDate">
                 ~
                종료일 : <input type="date" name="endDate">
                <button type="submit" name="searchbtn">조회</button>
            </a>
        </form>
    </div>
</main>

<footer class="main__nav__next">
    <jsp:include page="../layout/footer.jsp"/>
</footer>
</body>
</html>