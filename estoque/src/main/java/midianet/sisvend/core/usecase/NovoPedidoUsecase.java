package midianet.sisvend.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.core.entity.Pedido;
import midianet.sisvend.infra.database.PedidoRepository;
import midianet.sisvend.infra.exception.BussinesException;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class NovoPedidoUsecase {
    private final PedidoRepository pedidoRepository;

    private final ReservaPedidoUsecase reservarPedido;

    @Transactional
    public void execute(@NonNull final Pedido pedido){
        log.info("\n [Módulo Estoque]\n Pedido recebido: {}",pedido.getId());
        pedido.setStatus(Pedido.Status.RESERVADO);
        pedido.setEntrada(LocalDateTime.now());
        reservarPedido.execute(pedido);
        pedidoRepository.save(pedido);
    }


//    public void sacar(Integer numeroConta, Double valor) {
//        //try{
//            //contaRepository.criarTransacao();
//            final var conta = contaRepository.findByNumero(numeroConta);
//            if(conta == null) throw new BussinesException("Conta não encontrada");
//            if (conta.getSaldo() < valor) throw new BussinesException("Saldo insuficiente");
//            conta.setSaldo(conta.getSaldo() - valor);
//            contaRepository.save(conta);
//            //contaRepository.confirmarTransacao();
//        //}catch(Exception e){
//            //contaRepository.desfazerTransacao();
//        //}finally {
//            //contaRepository.finalizarTransacao();
//        //}
//      }

//      @Transactional
//      public sacar(Integer numeroConta, Double valor) {
//        final var Conta conta = repository.find(numeroConta);
//        if (conta == nulll) "Conta inválida";
//        if (conta.saldo < valor) "saldo Insuficiente"
//        conta.saldo = conta.saldo - valor;
//        repository.save(conta);
//    }

    }
