package development.v.development.application.features.Command.CreateCommand;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Command.CreateCommand.Dtos.CreateCommandRequestDto;
import development.v.development.application.features.Command.CreateCommand.Mappers.CreateCommandMapper;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Command;
import development.v.development.domain.repositories.CommandRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class CreateCommandUseCase {

    private final CommandRepository commandRepository;

    public CreateCommandUseCase(CommandRepository commandRepository) {
        this.commandRepository = commandRepository;
    }

    public DataResultDto<Command> execute(CreateCommandRequestDto request) {
        Command domain = CreateCommandMapper.toDomain(request);
        Command saved = commandRepository.save(domain);
        return DataResultDto.success(saved, Message.CREATED);
    }
}

