package com.revnomix.revseed.repository;

import com.revnomix.revseed.model.SubMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public interface SubMenuRepository extends JpaRepository<SubMenu, Integer> {
    List<SubMenu> findByMenuId(Integer id);
    SubMenu findByMenuIdAndNameIn(Integer menuId, List<String> name);
}
