<%@page import="Dao.LoginDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./src/css/reset.css">
        <link rel="stylesheet" href="./src/css/style.css">
        <!-- Fontes -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@200..700&display=swap" rel="stylesheet">
    </head>
    <body>
        <header>
            <h1 class="titulo">Login</h1>
        </header>
        <main>
            <div class="caixa">
                <form action="Sessao" method="get">
                        <label>Login:</label>
                        <input type="text" name="UsuarioLogin" required>
                        <label>Senha:</label>
                        <input type="text" name="UsuarioPassword" required>
                        <br>
                        <button type="submit" value="Login">LOGIN</button>
                        <br>
                        <button type="reset">Limpar Campos</button>
                        <p class="Status">
                            <%
                               out.println(LoginDao.Status);
                            %>
                            
                        </p>
                    </form>
                </div>
                <div class="background"></div>
            
        </main>

    </body>
</html>
