package vn.menugo.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.menugo.server.model.Mon;
import vn.menugo.server.repo.MonRepository;

import java.util.List;

@Service
public class MonServices {

    @Autowired
    MonRepository monRepository;


    public List<Mon> findAll() {
        return monRepository.findAll();
    }
}
