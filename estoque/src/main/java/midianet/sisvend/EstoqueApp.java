package midianet.sisvend;

import lombok.RequiredArgsConstructor;
import midianet.sisvend.core.usecase.LancarEstoqueUsecase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
public class EstoqueApp {

    private final LancarEstoqueUsecase lancarEstoque;
    public static void main(String[] args) {
        SpringApplication.run(EstoqueApp.class, args);
    }

    @PostConstruct
    public void loader(){
        lancarEstoque.execute("EDB576", new LancarEstoqueUsecase.LancarEstoqueIn("Caneta Azul", 200.0));
        lancarEstoque.execute("EDB345", new LancarEstoqueUsecase.LancarEstoqueIn("Lapiseira Polivalente", 200.0));
        lancarEstoque.execute("EDB875", new LancarEstoqueUsecase.LancarEstoqueIn("Caneta Multi Cor", 200.0));
    }

}