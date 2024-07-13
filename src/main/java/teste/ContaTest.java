package teste;


import core.communs.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import page.ContasPage;
import page.MenuPage;


public class ContaTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();

    //OBS: site não aceitas nomes iguais
    @Test
    public void test1_inserir1_Conta(){
        menuPage.acessarTelaInserirConta();

        contasPage.setNome("Conta do Teste");
        contasPage.salvar();

        Assert.assertEquals("Conta adicionada com sucesso!", "Conta adicionada com sucesso!");
    }

    @Test
    public void test2_AlterarConta(){
        menuPage.acessarTelaListarConta();

        contasPage.clicarAlterarConta("Conta para alterar");

        contasPage.setNome("Conta alterada");
        contasPage.salvar();

        Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
    }


    @Test
    public void test3_InserirContaMesmoNome(){
        menuPage.acessarTelaInserirConta();

        contasPage.setNome("Conta mesmo nome");
        contasPage.salvar();

        Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
    }
}
