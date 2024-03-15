<%@page import="Dao.LoginDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<% 
    if(!LoginDao.AutenticarSucesso){
     response.sendRedirect("/ChurrascariaPizzaria/index.jsp");
    }
%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>ConfiguraÃ§Ã£o</title>
        <link rel="stylesheet" href="../../src/css/reset.css">
        <link rel="stylesheet" href="../Paginas/css/style.css">
    </head>
    <body>
        <header>
            <h1>Painel Administrativo</h1>
            <form action="../../CloseSessao" method="post" class="FormExit">
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
                    <li><a href="#">ConfiguraÃ§Ã£o</a></li>
                </details>
            </ul>
        </nav>
        <main>
            <h1>
                ConfiguraÃ§Ã£o da conta
            </h1>
            <!-- Alterar senha -->
            <form action="../../ServletConfig" method="post">
                <label>Usuario:</label>
                <input type="text" name="UserForm" required >
                <label>Senha Antiga:</label>
                <input type="text" name="OldPass" required >
                <label>Nova Senha:</label>
                <input type="text" name="NewPass" required >
                <label>Confirmar Senha:</label>
                <input type="text" name="RepeatPass" required >
                <button value="Alterar" class="Alterar" type="submit">Alterar</button>
                <br><!-- comment -->
                <p>
                    <%
                        out.println(LoginDao.StatusConfig);
                    %>
                </p>
            </form>

        </main>

    </body>
</html>