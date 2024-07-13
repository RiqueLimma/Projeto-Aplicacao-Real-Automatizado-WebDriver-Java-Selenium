package page;

import core.communs.BasePage;
import core.propriedadeSetup.DriverFactory;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static core.propriedadeSetup.DriverFactory.getDriver;

public class LoginPage extends BasePage {


    public void acessarTelaInicial(){
        DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/login");
//        DriverFactory.getDriver().get("http://srbarriga.herokuapp.com");
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void setEmail(String email){
        escrever("email", email);
    }

    public void setSenha(String senha){
        escrever("senha", senha);
    }

    public void entrar(){
        clickBy(By.xpath("//button[.=\"Entrar\"]")) ;
    }

    public void resetMassa(){
        clicklinkText("reset");
    }


    public void logar(String email, String senha) {
        setEmail(email);
        setSenha(senha);
        entrar();
    }

    public void resetar() {
        clicklinkText("reset");
    }

}
