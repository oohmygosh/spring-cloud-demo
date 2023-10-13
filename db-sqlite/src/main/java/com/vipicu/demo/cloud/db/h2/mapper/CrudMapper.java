package com.vipicu.demo.cloud.db.h2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

/**

 * ----------------------------------------
 * 自定义批量插入 Mapper 继承即可获得批量插入能力
 *
 * @param <T> 实体对象泛型
 * @author oohmygosh
 * @since 2021-10-28
 */
public interface CrudMapper<T> extends BaseMapper<T> {

}
