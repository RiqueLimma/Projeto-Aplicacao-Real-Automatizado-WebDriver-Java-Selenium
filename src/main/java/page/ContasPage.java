package page;

import core.communs.BasePage;
import org.openqa.selenium.By;


public class ContasPage extends BasePage {

    public void setNome(String nome) {
        escrever("nome", nome);
    }

    public void salvar() {
        clickBy(By.xpath("//button[.='Salvar']"));
    }

    public String obterMensagemSucesso() {
        return obterTextoBy(By.xpath("//div[@class='alert alert-success']"));
    }


    public void clicarAlterarConta(String string) {
        obterCelula("Conta", string, "Ações", "tabelaContas")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
    }

    public String obterMensagemErro() {
        return obterTextoBy(By.xpath("//div[@class='alert alert-danger']"));
    }

    public void clicarExcluirConta(String string) {
        obterCelula("Conta", string, "Ações", "tabelaContas")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
    }
}
