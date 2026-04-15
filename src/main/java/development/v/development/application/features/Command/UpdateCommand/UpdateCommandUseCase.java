package development.v.development.application.features.Command.UpdateCommand;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Command.UpdateCommand.Dtos.UpdateCommandRequestDto;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Command;
import development.v.development.domain.repositories.CommandRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class UpdateCommandUseCase {

    private final CommandRepository commandRepository;

    public UpdateCommandUseCase(CommandRepository commandRepository) {
        this.commandRepository = commandRepository;
    }

    public DataResultDto<Command> execute(Integer id, UpdateCommandRequestDto request) {
        Command existing = commandRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND + " Comanda con ID: " + id));

        if (request.getMesa() != null) {
            existing.setMesa(request.getMesa());
        }
        if (request.getPlaId() != null) {
            existing.setPlaId(request.getPlaId());
        }
        if (request.getComObs() != null) {
            existing.setComObs(request.getComObs());
        }
        if (request.getEstId() != null) {
            existing.setEstId(request.getEstId());
        }

        Command updated = commandRepository.update(existing);
        return DataResultDto.success(updated, Message.SUCCESS);
    }
}

