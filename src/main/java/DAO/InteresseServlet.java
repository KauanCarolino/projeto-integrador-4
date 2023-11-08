package DAO;

import java.io.IOException;

import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CarroDao;


public class InteresseServlet<html> extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Colete as informações de interesse do usuário
        String nome = req.getParameter("nome");
        String telefone = req.getParameter("telefone");
        int idCarro = Integer.parseInt(req.getParameter("idCarro"));

        // Verifique se o nome e o telefone do usuário estão vazios
        if (nome.isEmpty()) {
            resp.sendError(400, "O nome do usuário não pode estar vazio");
            return;
        }

        if (telefone.isEmpty()) {
            resp.sendError(400, "O telefone do usuário não pode estar vazio");
            return;
        }
        // Use a classe DAO para inserir as informações de interesse no banco de dados
        CarrosDAO dao = new CarrosDAO(Persistence.createEntityManagerFactory("pu").createEntityManager());
        Carro carro = new Carro();
        carro.setNome(nome);
        carro.setTelefone(telefone);
        carro.setId(idCarro);
        dao.inserir(carro);

        // Atualize a lista de carros para remover o carro que o usuário demonstrou interesse
        CarrosListaServlet.listaCarros();

        // Redirecione o usuário para a página principal
        resp.sendRedirect("index.jsp");
    }
}

// Formulário HTML
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Demonstrar Interesse</title>
</head>
<body>
<form action="interesse.jsp" method="post">
<label for="nome">Nome:</label>
<input type="text" id="nome" name="nome" placeholder="Nome" required />
<br />

<label for="telefone">Telefone:</label>
<input type="text" id="telefone" name="telefone" placeholder="Telefone" required pattern="[0-9]{10}" />
<br />

<input type="hidden" name="idCarro" value="${carro.id}" />
<br />

<input type="submit" value="Demonstrar interesse" />
</form>
</body>
</html>
