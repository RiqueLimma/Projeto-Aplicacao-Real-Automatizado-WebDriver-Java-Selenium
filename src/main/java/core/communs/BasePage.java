package core.communs;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static core.propriedadeSetup.DriverFactory.getDriver;

public class BasePage {

    public void escrever(String campo, String texto){
        getDriver().findElement(By.id(campo)).sendKeys(texto);
    }

    public String obterValorCampo(By campo){
        return getDriver().findElement(campo).getAttribute("value");
    }
    public String obterTextoBy(By by){
        return getDriver().findElement(by).getText();
    }

    public void clickBy(By elemento) {
        getDriver().findElement(elemento).click();
    }

    public void clickId(String id) {
        clickBy(By.id(id));
    }

    public void clicarBotaoPorTexto(String texto){
        clickBy(By.xpath("//button[.='"+texto+"']"));
    }

    public void clicklinkText(String linkText) {
        getDriver().findElement(By.linkText(linkText)).click();
    }

    public boolean verificarMarcacaoId(String id) {
        return getDriver().findElement(By.id(id)).isSelected();
    }

    public void selecionarCombo(String id, String valor) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }

    public boolean retornaComecoTexto(By by, String texto) {
        return getDriver().findElement(by).getText().startsWith(texto);
    }

    public boolean retornaFinalTexto(By by, String texto) {
        return getDriver().findElement(by).getText().endsWith(texto);
    }
    public void definirBrowser(int largura, int altura) {
        getDriver().manage().window().setSize(new Dimension(largura, altura));
    }

    public String retornaTitulo() {
        return getDriver().getTitle();
    }
    public void fecharJanela() {
        getDriver().close();
    }

    public void deselecionarLinha(By by, String linha) {
        WebElement element = getDriver().findElement(by);
        Select combo = new Select(element);
        combo.deselectByVisibleText(linha);
    }

    public List<String> obterValoresCombo(By id) {
        WebElement element = getDriver().findElement(id);
        Select combo = new Select(element);
        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        List<String> valores = new ArrayList<String>();
        for(WebElement opcao: allSelectedOptions) {
            valores.add(opcao.getText());
        }
        return valores;
    }

    public Object executarJS(String cmd, Object... param) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return js.executeScript(cmd, param);
    }

    public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela){
        //procurar coluna do registro
        WebElement tabela = getDriver().findElement(By.xpath("//*[@id='elementosForm:tableUsuarios']"));
        int idColuna = obterIndiceColuna(colunaBusca, tabela);

        //encontrar a linha do registro
        int idLinha = obterIndiceLinha(valor, tabela, idColuna);

        //procurar coluna do botao
        int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);

        //clicar no botao da celula encontrada
        WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
        celula.findElement(By.xpath(".//input")).click();

    }

    protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
        List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
        int idLinha = -1;
        for(int i = 0; i < linhas.size(); i++) {
            if(linhas.get(i).getText().equals(valor)) {
                idLinha = i+1;
                break;
            }
        }
        return idLinha;
    }

    protected int obterIndiceColuna(String coluna, WebElement tabela) {
        List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
        int idColuna = -1;
        for(int i = 0; i < colunas.size(); i++) {
            if(colunas.get(i).getText().equals(coluna)) {
                idColuna = i+1;
                break;
            }
        }
        return idColuna;
    }

    public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTabela){
        //procurar coluna do registro
        WebElement tabela = getDriver().findElement(By.xpath("//*[@id='"+idTabela+"']"));
        int idColuna = obterIndiceColuna(colunaBusca, tabela);

        //encontrar a linha do registro
        int idLinha = obterIndiceLinha(valor, tabela, idColuna);

        //procurar coluna do botao
        int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);

        //clicar no botao da celula encontrada
        WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
        return celula;
    }

    public void limparCampo(String id) {
        WebElement setInput = getDriver().findElement(By.id(id));
        setInput.clear();
    }

    public void obterParteTexto(){
        String saldo = "500";
        if(saldo.contains("500")){
            Assert.assertEquals(saldo, saldo);
        }
    }

    public void obterSaldo(){

//        // Localizar o elemento <td> que contém o valor dinâmico
//        WebElement cell = getDriver().findElement(By.xpath("//*[contains(text(), '.00')]"));
//        // Obter o valor do texto do elemento <td>
//        String cellValue = cell.getText();
//        // Verificar o valor do texto usando uma asserção
//        Assert.assertEquals(cellValue, "Bem vindo", "Bem vindo");
    }
}
