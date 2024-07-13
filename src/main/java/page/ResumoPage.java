package page;

import core.communs.BasePage;
import org.openqa.selenium.By;

public class ResumoPage extends BasePage {

    public void excluirMovimentacao(){
        clickBy(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
    }

    public String obterMensagemSucesso(){
        return obterTextoBy(By.xpath("//div[@class='alert alert-success']"));
    }

    public void selecionaAno(String ano){
        selecionarCombo("ano", ano);
    }

    public void buscar(){
        clickBy(By.xpath("//input[@value='Buscar']"));
    }

    public void obterElementoTela() {
        retornaTitulo();
    }

}
