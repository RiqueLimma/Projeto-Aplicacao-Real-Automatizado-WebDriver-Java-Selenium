package page;

import core.communs.BasePage;

public class MenuPage extends BasePage {

    public void acessarTelaInserirConta() {
        clicklinkText("Contas");
        clicklinkText("Adicionar");
    }

    public void acessarTelaListarConta() {
        clicklinkText("Contas");
        clicklinkText("Listar");
    }

    public void acessarTelaInserirMovimentacao() {
        clicklinkText("Criar Movimentação");
    }

    public void acessarTelaResumo() {
        clicklinkText("Resumo Mensal");
    }
}

