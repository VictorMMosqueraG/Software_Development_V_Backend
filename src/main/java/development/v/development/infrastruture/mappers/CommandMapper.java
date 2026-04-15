package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.Command;
import development.v.development.infrastruture.entities.CommandEntity;

public class CommandMapper {

    public static Command toDomain(CommandEntity entity) {
        Command command = new Command();
        command.setComId(entity.getComId());
        command.setMesa(entity.getMesa());
        command.setPlaId(entity.getPlaId());
        command.setComObs(entity.getComObs());
        command.setEstId(entity.getEstId());
        return command;
    }

    public static CommandEntity toEntity(Command command) {
        CommandEntity entity = new CommandEntity();
        entity.setComId(command.getComId());
        entity.setMesa(command.getMesa());
        entity.setPlaId(command.getPlaId());
        entity.setComObs(command.getComObs());
        entity.setEstId(command.getEstId());
        return entity;
    }
}

