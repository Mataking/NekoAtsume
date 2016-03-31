<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html dir="ltr" lang="en-US">
    <head>
        <meta charset="utf-8">
        <title>Liste des Chats</title>
        <meta name="viewport" content="initial-scale = 1.0, maximum-scale = 1.0, user-scalable = no, width = device-width">

        <!--[if lt IE 9]><script src="https://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
        <link rel="stylesheet" href="/resource/style/style.css" media="screen">
        <!--[if lte IE 7]><link rel="stylesheet" href="style.ie7.css" media="screen" /><![endif]-->
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
                <ul class="hmenu">
                    <li><a href="accueil.html" class="active">Accueil</a></li>
                    <li><a href="chats.html">Chats</a><ul><li><a href="rare.html">Rares</a></li>
                            <li><a href="communs.html">Communs</a></li></ul></li>
                    <li><a href="astuces.html">Astuces</a></li>  
                    <li><a href="${pageContext.request.contextPath}/edituser-${pageContext.request.userPrincipal.name}">Edit compte : ${pageContext.request.userPrincipal.name}</a></li>
                    <li><a href="<c:url value="/j_spring_security_logout" />" >Logout</a></li>
                </ul>
            </nav>
            <div class="sheet clearfix">
                <div class="layout-wrapper">
                    <div class="content-layout">
                        <div class="content-layout-row">
                            <div class="layout-cell content">
                                <article class="post article">
                                    <div class="postmetadataheader">
                                        <form action="chats" method="post">
                                            <br>
                                            <h3>Rechercher :</h3><br><input type="text" name="searchText" /><br/>
                                            <br>
                                            <input type="submit" value="Search"/>
                                            <br>        
                                        </form>
                                        <br>
                                    </div>                                        
                                    <br><br>
                                    <div class="postmetadataheader">
                                        <h2 class="postheader">Liste des chats</h2>
                                        <table style="border: 1px solid; width: 100%; text-align:center">
                                            <thead style = "background:#d3dce3">
                                                <tr>
                                                    <th colspan="1">Photo</th>
                                                    <th>id_chat</th>
                                                    <th>Nom</th>
                                                    <th>Nom Japonais</th>
                                                    <th>Description</th>
                                                    <th>Personnalite</th>
                                                    <th>Niveau</th>
                                                </tr>
                                            </thead>
                                            <tbody style="background:#ccc">
                                                <c:choose>
                                                    <c:when test="${find}">
                                                        <c:url var="ImgUrl" value="/resource/img/${listechat.nom}.png" />
                                                        <tr>
                                                            <td><a href="${ImgUrl}"><img src="${ImgUrl}"></img></a></td>
                                                            <td><c:out value="${listechat.idChat}"/></td>
                                                            <td><a href="/astuce-${listechat.nom}"><c:out value="${listechat.nom }"/></a></td>
                                                            <td><c:out value="${listechat.nomJaponais }"/></td>
                                                            <td><c:out value="${listechat.description }"/></td>
                                                            <td><c:out value="${listechat.personnalite }"/></td>
                                                            <td><c:out value="${listechat.niveau }"/></td>
                                                        </tr>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <c:forEach items="${listechat}" var="liste">
                                                            <c:url var="ImgUrl" value="/resource/img/${liste.nom}.png" />
                                                            <tr>
                                                                <td><a href="${ImgUrl}"><img src="${ImgUrl}"></img></a></td>
                                                                <td><c:out value="${liste.idChat}"/></td>
                                                                <td><a href="/astuce-${liste.nom}"><c:out value="${liste.nom }"/></a></td>
                                                                <td><c:out value="${liste.nomJaponais }"/></td>
                                                                <td><c:out value="${liste.description }"/></td>
                                                                <td><c:out value="${liste.personnalite }"/></td>
                                                                <td><c:out value="${liste.niveau }"/></td>
                                                            </tr>
                                                        </c:forEach>
                                                    </c:otherwise>
                                                </c:choose>
                                                <c:choose>
                                                    <c:when test="${astuce}">
                                                        <c:url var="ImgUrl" value="/resource/img/${chat.nom}.png" />
                                                    <td><a href="${ImgUrl}"><img src="${ImgUrl}"></img></a></td>
                                                    <td><c:out value="${chat.idChat}"/></td>
                                                    <td><c:out value="${chat.nom }"/></td>
                                                    <td><c:out value="${chat.nomJaponais }"/></td>
                                                    <td><c:out value="${chat.description }"/></td>
                                                    <td><c:out value="${chat.personnalite }"/></td>
                                                    <td><c:out value="${chat.niveau }"/></td>
                                                </c:when>
                                            </c:choose> 
                                            </tbody>
                                        </table>
                                        <c:choose>
                                            <c:when test="${find}">
                                                <a href="<c:url value="/chats" />">Voir liste chat</a>
                                            </c:when>
                                        </c:choose> 
                                    </div>
                                    <!-- ****************************ESSAYER AJOUT ASTUCE -->
                                    <br>
                                    <hr width="80%" align="center" style="color: #DCE3EA">
                                    <br>
                                    <div class="postmetadataheader">
                                        <h2 class="postheader">Ajouter une astuce</h2>
                                        <c:choose>
                                            <c:when test="${astuce}">
                                                <form:form commandName="ajout" action="/astuce-${chat.nom}">
                                                    <tr>
                                                        <td><a href="${ImgUrl}"><img src="${ImgUrl}"></img></a></td>
                                                    <br>
                                                    </tr>
                                                    <tr>
                                                        <td><form:input type="hidden" path="chatnom" value="${chat.nom}"/></td>
                                                    </tr>
                                                    <tr>
                                                        <td><form:input type="hidden" path="nameuser" value="${pageContext.request.userPrincipal.name}"/></td>
                                                    </tr>
                                                    <tr>
                                                        <td><form:label path="commentaire">Astuce : </form:label></td>
                                                        <td><form:textarea type="text" path="commentaire" rows="5"/></td>
                                                    </tr>
                                                    <input type="submit" value="Ajouter astuce"/> 
                                                </form:form>	
                                            </c:when>
                                        </c:choose> 
                                    </div>
                                    <br><br><br><br>
                                    <div class="postmetadataheader">

                                        <c:if test="${!empty listastuce}">

                                            <c:forEach items="${listastuce}" var="ast">
                                                <div class="affichageAstuce">
                                                    <div class="headerAstuce">
                                                        <tr>
                                                            Commented by : <td>${ast.username}</td>
                                                    </div>
                                                    <textarea rows="3" disabled <td>${ast.commentaire} </textarea></td>
                                                    <h3>Voter pour cette astuce :</h3>

                                                    <form:form commandName="voteplus" action="/voteplus-${ast.idastuce}">
                                                        <input type="submit" value="+1" style="color: green"/> ${ast.voteplus}
                                                    </form:form>	<br>
                                                    <form:form commandName="votemoins" action="/votemoins-${ast.idastuce}">
                                                        <input type="submit" value="-1" style="color: red"/> ${ast.vote_moins}
                                                    </form:form>
                                                    </tr>

                                                </div>
                                                <br>
                                            </c:forEach>


                                        </c:if>
                                        <!-- *************************FIN AJOUT ASTUCE -->
                                    </div>
                                    <div class="postcontent postcontent-0 clearfix">
                                        <p><br></p>
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