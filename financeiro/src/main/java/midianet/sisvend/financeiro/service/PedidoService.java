package midianet.sisvend.financeiro.service;

import lombok.RequiredArgsConstructor;
import midianet.sisvend.financeiro.repository.PedidoRepository;
import midianet.sisvend.model.Pedido;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

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

    public List<Pedido> listRecebidos(){
        return repository.findByRecebidoIsTrue();
    }

    public List<Pedido> list(){
        return repository.findAll();
    }

}
