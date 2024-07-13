package teste;

import core.communs.BaseTest;
import core.propriedadeSetup.DriverFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.MenuPage;
import page.ResumoPage;

import java.util.List;

import static core.propriedadeSetup.DriverFactory.getDriver;

public class ResumoTest extends BaseTest {
    private MenuPage menuPage = new MenuPage();
    private ResumoPage resumoPage = new ResumoPage();

    @Test
    public void test1ExcluirMovimentacao(){
        menuPage.acessarTelaResumo();

        resumoPage.excluirMovimentacao();

        Assert.assertEquals("Movimentação removida com sucesso!",
                resumoPage.obterMensagemSucesso());
    }

    @Test
    public void test2ResumoMensal(){
        menuPage.acessarTelaResumo();

        Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());

        resumoPage.selecionaAno("2025");
        resumoPage.buscar();

        try {
            List<WebElement> elementosEncontrados = DriverFactory.getDriver().findElements(
                    By.xpath("//*@id='tabelaExtrato']/tbody/tr"));
            Assert.assertEquals(0, elementosEncontrados.size());
        } catch (Exception e){
            Assert.assertEquals("Seu Barriga - Extrato", resumoPage.retornaTitulo());
        }
    }
}
