package development.v.development.application.features.Command.CreateCommand.Mappers;

import development.v.development.application.features.Command.CreateCommand.Dtos.CreateCommandRequestDto;
import development.v.development.domain.models.Command;

public class CreateCommandMapper {

    public static Command toDomain(CreateCommandRequestDto dto) {
        Command command = new Command();
        command.setMesa(dto.getMesa());
        command.setPlaId(dto.getPlaId());
        command.setComObs(dto.getComObs());
        command.setEstId(dto.getEstId());
        return command;
    }
}

