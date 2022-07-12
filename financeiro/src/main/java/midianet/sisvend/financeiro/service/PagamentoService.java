package midianet.sisvend.financeiro.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.financeiro.broker.PagamentoProducer;
import midianet.sisvend.model.Pedido;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PagamentoService {
    private final PagamentoProducer producer;
    private final PedidoService pedidoService;
    public void receber(@NonNull final String pedidoId){
        final var pedido = pedidoService.findById(pedidoId);
        pedido.setRecebido(true);
        pedido.setStatus("Recebido");
        pedidoService.salvar(pedido);
        log.info("\n [Módulo Financeiro]\n Pagamento recebido\n Pedido: {}\n Cliente: {}\n Valor: {}",
                pedido.getId(),
                pedido.getCliente(),
                pedido.getValor());
        producer.send(pedido);

    }

    public List<Pedido> listRecebidos(){
      return pedidoService.listRecebidos();
    }

    public List<Pedido> list(){
        return pedidoService.list();
    }

}
