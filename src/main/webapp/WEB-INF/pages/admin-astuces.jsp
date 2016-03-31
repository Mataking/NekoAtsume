<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html dir="ltr" lang="en-US">
    <head>
        
        <meta charset="utf-8">
        <title>Admin - Astuces</title>
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
            <div class="sheet clearfix">
                <div class="layout-wrapper">
                    <div class="content-layout">
                        <div class="content-layout-row">
                            <div class="layout-cell content">
                                <article class="post article">
                                    <div class="postmetadataheader">
                                        <a href="${pageContext.request.contextPath}/admin.html">Admin page</a><br/><br/>
                                        <c:if test="${!empty listeastuce}">
                                            <c:forEach items="${listeastuce}" var="ast">
                                                <tr>
                                                    <c:url var="ImgUrl" value="/resource/img/${ast.nomchat}.png" />
                                                    <td><a href="${ImgUrl}"><img src="${ImgUrl}"></img></a></td>
                                                    <td>${ast.commentaire}</td>
                                                    - commented by <td>${ast.username}</td> - for <td>${ast.nomchat}</td>
                                                    - vote pour : <td>${ast.voteplus}</td> - vote contre : <td>${ast.vote_moins}</td>
                                                    <td><a href = "/supprimerastuce-${ast.idastuce}">Supprimer</a></td>
                                                </tr> <br />
                                            </c:forEach>
                                        </c:if>
                                    </div>
                                </article>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <footer class="footer">
                <div class="footer-inner">

                    <p class="page-footer">
                        <span id="footnote-links">Developpé par : Diamantino - Gaël - Iandry - Kévin.</span>
                    </p>
                </div>
            </footer>
        </div>
    </body>
</html>




