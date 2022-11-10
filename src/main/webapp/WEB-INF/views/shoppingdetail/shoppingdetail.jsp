
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shopping Detail Page</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<header>
    <jsp:include page="../layout/header.jsp"/>
</header>


<main>
    <div class="sub_sc2" style="min-height:500px;">

        <div class="heading heading3">
            <h3 class="pay_detail"><span class="blind">SHOPPING DETAIL</span></h3>
        </div>
        <div class="bx bx_padding vsb">
                결제일자 : <strong>${shoppingDetail.orderDate}</strong>
                결제번호 : <strong>${shoppingDetail.paymentId}</strong>
        </div>

        <table cellspacing="0" border="1" class="tb_list mgt">
            <caption>주문내역</caption>
            <colgroup><col width=""><col width="140"><col width="200">
            </colgroup><thead>
        <tr>
            <th scope="col">상품정보</th>
            <th scope="col">상품금액(수량)</th>
            <th scope="col" class="bg_point">판매자</th>
            <th scope="col" class="bg_point">진행상태</th>
            <th scope="col">결제수단</th>
        </tr>
        </thead>
            <tbody>
            <tr>
                <td class="product">
                    <div>
                        <dl>
                            <dt>
                                <em>${shoppingDetail.orderName}</em>
                            </dt>
                        </dl>
                    </div>
                </td>
                <td class="money">
                    <em class="thm">${shoppingDetail.productPrice}</em>원<br>
                    <span>(${shoppingDetail.orderCount}개)</span>
                </td>
                <td class="seller bg_point">
                    <div class="send">
                        <div class="store">
                            <div class="inner ">
                                <div class="txt_elp">
                                    <p>${shoppingDetail.storeName}</p>
                                </div>
                            </div>
                        </div>
                        <div class="tel">
                            <span>${shoppingDetail.storePhone}</span>
                        </div>
                    </div>
                </td>
                <td class="bg_point state">${shoppingDetail.orderStatus.name()}</td>
                <td >${shoppingDetail.paymentMethod}</td>
            </tr>
            </tbody>
        </table>
        <div class="heading heading2 mgt6">
            <h4>결제금액정보</h4>
        </div>
        <table cellspacing="0" border="1" class="tb_list2 tb_input tb_pg">
            <colgroup><col><col width="360"></colgroup>
            <thead class="blind">
            <tr>
                <th scope="col">결제정보</th>
                <th scope="col">최종 결제금액정보</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td class="btm_line">
                    <table cellspacing="0" border="1" class="tb_input2">
                        <colgroup><col><col></colgroup>
                        <tbody>
                        <tr class="gap3">
                            <th scope="row">총 상품 금액</th>
                            <td class="c_info">${shoppingDetail.productPrice}원 * ${shoppingDetail.orderCount}개
                                <span>${shoppingDetail.productPrice * shoppingDetail.orderCount}원</span>
                            </td>
                        </tr>
                        <tr class="gap3">
                            <th scope="row">배송비</th>
                            <td class="c_info">${shoppingDetail.deliveryPrice}
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </td>
                <td class="amount bg_point">
                        <strong>총 주문금액</strong>
                        <p><em class="thm">${shoppingDetail.totalPrice}</em>원</p>
                </td>
            </tr>
            </tbody>
        </table>
    </div>

    <form action="http://localhost:8080/naver/pay/shopping/delete" method="post">
        <input type="hidden" name="paymentId" value="${shoppingDetail.paymentId}">
        <input type="submit" value="쇼핑 내역 삭제" />
    </form>

</main>

<footer class="main__nav__next">
    <jsp:include page="../layout/footer.jsp"/>
</footer>
</body>
</html>\