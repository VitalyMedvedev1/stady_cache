package study.dliga.cache.model;

import org.mapstruct.Mapper;
import study.dliga.cache.repository.entity.User;

import java.util.List;

@Mapper(componentModel = "spring", uses = User.class)
public interface UserMapper {

    User userElementToUser(UserElement userElement);

    UserElement userToUserElement(User user);

    List<User> userElementsToUsers(List<UserElement> userElements);

    List<UserElement> usersToUserElements(List<User> users);
}
