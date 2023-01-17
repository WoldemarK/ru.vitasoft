package ru.vitasoft.ru.vitasoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vitasoft.ru.vitasoft.model.Request;
import ru.vitasoft.ru.vitasoft.model.StatusRequest;
import ru.vitasoft.ru.vitasoft.model.User;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request,Long> {
    Request findByUser(User user);

    List<Request> findAllByStatusRequest(StatusRequest statusRequest);

}
