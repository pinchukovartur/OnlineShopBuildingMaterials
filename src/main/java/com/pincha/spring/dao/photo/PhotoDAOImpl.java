package com.pincha.spring.dao.photo;

import com.pincha.spring.dao.AbstractDao;
import com.pincha.spring.model.Photo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class PhotoDAOImpl extends AbstractDao<Integer, Photo> {
}
