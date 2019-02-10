package org.sid.dao;

import org.sid.entities.Picture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PictureRepository extends JpaRepository<Picture, Long> {
	@Query("select p from Picture p where p.titre like  :x ")
	public Page<Picture> rechercher(@Param("x") String mc,Pageable pageable);

}
