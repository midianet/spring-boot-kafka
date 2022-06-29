package midianet.sisvend.financeiro.service;

import lombok.RequiredArgsConstructor;
import midianet.sisvend.financeiro.repository.PedidoRepository;
import midianet.sisvend.model.Pedido;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository repository;

    @Transactional
    public void salvar(@NonNull final Pedido pedido){
        repository.save(pedido);
    }

    public Pedido findById(@NonNull final String id){
       return repository.findById(id)
            .orElseThrow( () -> new EntityNotFoundException("Pedido não encontrado!!"));
    }

}
