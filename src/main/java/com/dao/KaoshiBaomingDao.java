package com.dao;

import com.entity.KaoshiBaomingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KaoshiBaomingView;

/**
 * 监考报名 Dao 接口
 *
 * @author 
 */
public interface KaoshiBaomingDao extends BaseMapper<KaoshiBaomingEntity> {

   List<KaoshiBaomingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
