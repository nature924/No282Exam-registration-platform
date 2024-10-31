package com.dao;

import com.entity.XueshengKaoshifenpeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XueshengKaoshifenpeiView;

/**
 * 考试分配 Dao 接口
 *
 * @author 
 */
public interface XueshengKaoshifenpeiDao extends BaseMapper<XueshengKaoshifenpeiEntity> {

   List<XueshengKaoshifenpeiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
