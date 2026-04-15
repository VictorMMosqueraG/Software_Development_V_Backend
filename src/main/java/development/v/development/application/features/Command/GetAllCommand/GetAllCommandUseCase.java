package development.v.development.application.features.Command.GetAllCommand;

import java.util.List;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Command.GetAllCommand.Dtos.GetAllCommandQuery;
import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.Command;
import development.v.development.domain.repositories.CommandRepository;
import development.v.development.domain.responses.PaginatedResultDto;

@Service
public class GetAllCommandUseCase {

    private final CommandRepository commandRepository;

    public GetAllCommandUseCase(CommandRepository commandRepository) {
        this.commandRepository = commandRepository;
    }

    public PaginatedResultDto<List<Command>> execute(GetAllCommandQuery query) {
        EntityFilter filter = new EntityFilter(query)
                .addFilter("mesa", query.getMesa())
                .addFilter("plaId", query.getPlaId())
                .addFilter("estId", query.getEstId());

        return commandRepository.findAllPaginated(filter);
    }
}

