package core.communs;


import core.propriedadeSetup.DriverFactory;
import core.propriedadeSetup.Propriedades;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import page.LoginPage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static core.propriedadeSetup.DriverFactory.getDriver;
import static core.propriedadeSetup.DriverFactory.killDriver;
//import static core.propriedadeSetup.DriverFactory.killDriver;

public class BaseTest {

    @Rule
    public TestName testName = new TestName();
    private LoginPage page = new LoginPage();

    @Before
    public void inicializa() {
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        page.acessarTelaInicial();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        page.setEmail("luis@luis12");
        page.setSenha("1234");
        page.entrar();
        page.resetMassa();
    }
    @After
    public void finaliza() throws IOException {
        TakesScreenshot ss = (TakesScreenshot) getDriver();
        File arquivo = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" +
                File.separator + testName.getMethodName() + ".jpg"));

        if(Propriedades.FECHAR_BROWSER) {
            killDriver();
        }
    }
}
