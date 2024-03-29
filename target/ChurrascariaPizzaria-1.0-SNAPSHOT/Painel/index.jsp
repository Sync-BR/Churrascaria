<%@page import="Dao.LoginDao"%>
<%@page import="Beans.SessaoBeans"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    if (!LoginDao.AutenticarSucesso) {
        response.sendRedirect("/ChurrascariaPizzaria/index.jsp");
    }
%>

<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../src/css/reset.css">
        <link rel="stylesheet" href="./css/style.css">
        <title>Document</title>
    </head>
    <body>
        <header>
            <h1>Painel Administrativo</h1>
            <form action="../CloseSessao" method="post" class="FormExit">
                <label>
                    <Strong>Usuario:</Strong> 
        <% 
          out.println(LoginDao.UsuarioConectado);
       
        %>
                </label>
                <br>
                <button value="Sair" type="submit">Sair</button> 
            </form>
        </header>
        <nav>
            <ul>
                <!-- Nav de pedidos -->
                <details>
                    <summary>
                        <strong>Pedidos</strong>
                    </summary>
                    <li><a href="#">Fila de Pedidos</a></li>
                    <li><a href="#">Gerenciar Pedidos</a></li>
                </details>
                <!-- Nav de relatorio  -->
                <details>
                    <summary>
                        <strong>Relatorio</strong>
                    </summary>
                    <li><a href="#">Historico de pedidos</a></li>
                    <li><a href="#">Relatorio dos pedidos</a></li>+
                </details>
                <!-- Gerenciar contas -->
                <details>
                    <summary>
                        <strong>Gerenciar</strong>
                    </summary>
                    <li><a href="../Painel/Paginas/Config.jsp">ConfiguraÃ§Ã£o</a></li>
                </details>
            </ul>
        </nav>
        <main>


        </main>
    </body>
</html>