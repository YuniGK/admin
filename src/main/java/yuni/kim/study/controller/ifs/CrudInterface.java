package yuni.kim.study.controller.ifs;

import yuni.kim.study.model.network.Header;

public interface CrudInterface {

    Header create();

    Header read(Long id);

    Header update();

    Header delete(Long id);

}
