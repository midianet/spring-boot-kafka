package midianet.sisvend.venda;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class VendaApp {

    public static void main(String[] args) {
        SpringApplication.run(VendaApp.class, args);
        log.info("Iniciando o Sistema de Vendas...");
    }

}
