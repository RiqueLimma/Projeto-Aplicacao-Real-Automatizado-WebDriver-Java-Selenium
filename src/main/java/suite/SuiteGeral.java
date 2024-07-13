package suite;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import page.LoginPage;
import teste.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({ContaTest.class,
        MovimentacaoTest.class,
        RemoverMovimentacaoContaTest.class,
        SaldoTest.class,
        ResumoTest.class})
public class SuiteGeral {

    private static LoginPage page = new LoginPage();

    @BeforeClass
    public static void resert() {
        page.acessarTelaInicial();
        page.setEmail("luis@luis12");
        page.setSenha("1234");
        page.entrar();

        page.resetar();
    }
}
