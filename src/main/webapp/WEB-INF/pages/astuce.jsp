<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html dir="ltr" lang="en-US"><head>
        <meta charset="utf-8">
        <title>Toutes les astuces</title>
        <meta name="viewport" content="initial-scale = 1.0, maximum-scale = 1.0, user-scalable = no, width = device-width">

        <link rel="stylesheet" href="/resource/style/style.css" media="screen">
        <link rel="stylesheet" href="/resource/style/style.responsive.css" media="all">


        <script src="/resource/style/jquery.js"></script>
        <script src="/resource/style/script.js"></script>
        <script src="/resource/style/script.responsive.js"></script>



    </head>
    <body>
        <div id="main">
            <header class="header">


                <div class="shapes">

                </div>






            </header>
            <nav class="nav">
                <ul class="hmenu"><li><a href="accueil.html" class="active">Accueil</a></li>
                    <li><a href="chats">Chats</a><ul><li><a href="rare.html">Rares</a></li>
                            <li><a href="communs.html">Communs</a></li></ul></li>
                    <li><a href="astuces">Astuces</a></li>  
                    <li><a href="${pageContext.request.contextPath}/edituser-${pageContext.request.userPrincipal.name}">Edit compte : ${pageContext.request.userPrincipal.name}</a></li>
                    <li><a href="<c:url value="/j_spring_security_logout" />" >Logout</a></li>
            </nav>
            <div class="sheet clearfix">
                <div class="layout-wrapper">
                    <div class="content-layout">
                        <div class="content-layout-row">
                            <div class="layout-cell content"><article class="post article">
                                    <div class="postmetadataheader">

                                        <h2 class="postheader">Toutes les Astuces</h2>

                                        <c:if test="${!empty listeastuce}">
                                            <c:forEach items="${listeastuce}" var="ast">

                                                <tr>

                                                    <c:url var="ImgUrl" value="/resource/img/${ast.nomchat}.png" />
                                                    <td><a href="${ImgUrl}"><img src="${ImgUrl}"></img></a></td>
                                                    <td>${ast.commentaire}</td>
                                                    - commented by <td>${ast.username}</td> - for <td>${ast.nomchat}</td>

                                                    <form:form commandName="voteplus" action="/astuceplus-${ast.idastuce}">
                                                    <input type="submit" value="pour"/> ${ast.voteplus}
                                                </form:form>	
                                                <form:form commandName="votemoins" action="/astucemoins-${ast.idastuce}">
                                                    <input type="submit" value="contre"/> ${ast.vote_moins}
                                                </form:form>
                                                </tr> <br />
                                            </c:forEach>

                                        </c:if>                 





                                    </div>
                                    <div class="postcontent postcontent-0 clearfix"><p><br></p></div>


                                </article></div>

                        </div></div>
                </div>
            </div>
        </div>
    </div>
<footer class="footer">
    <div class="footer-inner">

        <p class="page-footer">
            <span id="footnote-links">Developp� par : Diamantino - Ga�l - Iandry - K�vin.</span>
        </p>
    </div>
</footer>

</div>


</body></html>