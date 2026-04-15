package development.v.development.application.features.Command.GetCommandById;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Command;
import development.v.development.domain.repositories.CommandRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class GetCommandByIdUseCase {

    private final CommandRepository commandRepository;

    public GetCommandByIdUseCase(CommandRepository commandRepository) {
        this.commandRepository = commandRepository;
    }

    public DataResultDto<Command> execute(Integer id) {
        Command command = commandRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND + " Comanda con ID: " + id));

        return DataResultDto.success(command, Message.SUCCESS);
    }
}

